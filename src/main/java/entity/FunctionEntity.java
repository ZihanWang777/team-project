package entity;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.function.Predicate.not;

/*
one type of target entity: function. Contains a unique parameter function that stores the function

 */
public class FunctionEntity extends TargetEntity{
    private String function;
    private Style style;
    private static final Set<String> BRACKET = Set.of("(", ")");
    private static final Set<String> DIGIT = Set.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
    private static final Set<String> CONSTANT = Set.of("x", "pi", "e");
    private static final Set<String> NONFUNCTIONS = Set.of("+", "-", "*", "/", "^", "!");
    private static final Set<String> FUNCTIONS = Set.of("sin", "cos", "tan", "csc", "sec", "cot", "arcsin",
    "arccos", "arctan", "arccsc", "arcsec", "arccot", "sqrt", "ln", "log", "abs");

    public FunctionEntity(String name, String solid, String color, String function) {
        super(name, solid, color);
        if (isFunctionLegal(function)) {
            this.function = function;
        }
        else {
            throw new IllegalArgumentException("your function is invalid");
        }
    }

    /*
    This helper method cut function into desired pieces
     */
    private ArrayList<String> modify(String function) {
        int i = 0;
        ArrayList<String> result = new ArrayList<>();
        if (function.isEmpty()) {
            return result;
        }
        while (i < function.length()) {
            // if the i-index char in the function is a digit
            //check if the number contains more than one <.>
            if (DIGIT.contains(String.valueOf(function.charAt(i)))) {
                int dotCount = 0;
                int originalValue = i;
                // if: there is less than 2 dots, i still inside function index, belongs to either digit or a dot...
                while (i < function.length() && dotCount < 2
                        && (DIGIT.contains(String.valueOf(function.charAt(i))) || function.charAt(i) == '.')) {
                    if (function.charAt(i) == '.') {
                        dotCount++;
                    }
                    if (dotCount == 2) {
                        throw new IllegalArgumentException("you have more than one dot in your number.");
                    }
                    i++;
                }
                result.add(function.substring(originalValue, i));
            }
            // if i-index value is a sign
            // check if two sign are connected
            // a sign beside <!> is at the last index of input function.
            // signs also need to check if the earlier digit is a left parenthesis beside <->
            else if (NONFUNCTIONS.contains(String.valueOf(function.charAt(i)))) {
                if (i == function.length() - 1 && function.charAt(i) != '!') {
                    throw new IllegalArgumentException("you ended the function with a sign");
                }
                else if (function.charAt(i) != '-' && (i == 0 || function.charAt(i) == '(')){
                    throw new IllegalArgumentException("you have a invalid sign.");
                }
                else if (i + 1 < function.length() && NONFUNCTIONS.contains(String.valueOf(function.charAt(i + 1)))
                && function.charAt(i) != '!') {
                    throw new IllegalArgumentException("you have two continuous signs");
                }
                result.add(function.substring(i, i + 1));
                i++;
            }
            else if (function.charAt(i) == '(') {
                int leftParen = i;
                i = findMatchingParen(function, i);
                if (i == function.length()) {
                    throw new IllegalArgumentException("you don't have a right parenthesis.");
                }
                else {
                    result.add(function.substring(leftParen, i + 1));
                    i = i + 1;
                }
            }
            else if (function.charAt(i) == ')') {
                throw new IllegalArgumentException("you don't have a left parenthesis.");
            }
            // if i-index char in the function is a letter, I need to differentiate constant vs function
            else if (Character.isAlphabetic(function.charAt(i))) {
                int originalValue = i;
                i = i + 1;
                while (i < function.length() && Character.isLetter(function.charAt(i))) {
                    i = i + 1;
                }
                if (i == function.length()) {
                    result.add(function.substring(originalValue));
                }
                else {
                    result.add(function.substring(originalValue, i));
                }

            }
            else {
                throw new IllegalArgumentException("you have invalid input.");
            }
        }
        return result;
    }

    // Returns the index of the ')' that matches the '(' at leftParen,
// or function.length() if it is never closed.
    private int findMatchingParen(String function, int leftParen) {
        int depth = 0;
        int i = leftParen;               // start ON the '(' so it counts as depth 1
        while (i < function.length()) {
            if (function.charAt(i) == '(') {
                depth = depth + 1;
            }
            else if (function.charAt(i) == ')') {
                depth = depth - 1;
            }
            if (depth == 0) {
                return i;
            }
            i++;
        }
        return function.length();
    }
    /*
    The primary helper for the constructor.
    check if the function input is legal. If not return false
    - variable <wordBank> is a static data that stores every possible sign, function, letter that
    is allowed.
    letter/constant: x, pi, e
    sign: +, -, *, ^, /, ()
    function: sin, cos, tan, csc, sec, cot, and their arc form......
     */
    private boolean isFunctionLegal(String function) {
        if (function.isEmpty()) {
            return false;
        }
        ArrayList<String> modifiedFunction = modify(function);
        for (int k = 0; k < modifiedFunction.size(); k++) {
            String element = modifiedFunction.get(k);
            // base case of recursion, digits and signs are automatically passed since they are checked in modify.
            if (Character.isAlphabetic(element.charAt(0))) {
                if (!CONSTANT.contains(element) && !FUNCTIONS.contains(element)) {
                    return false;
                }
            }
            // check if every function element is followed by a bracket element
            if (FUNCTIONS.contains(element)) {
                boolean isLast = k == modifiedFunction.size() - 1;
                if (isLast || !modifiedFunction.get(k + 1).startsWith("(")) {
                    return false;
                }
            }
            // recursion if meet a bracket.
            if (element.charAt(0) == '(') {
                if (!isFunctionLegal(element.substring(1, element.length() - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getFunction() {
        return this.function;
    }
}
