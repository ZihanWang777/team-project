package entity;

public class Style {
    private String color;
    private String solid;
    private String name;

    public Style(String n, String s, String c) {
        this.color = c;
        this.solid = s;
        this.name = n;
    }

    public String getColor() {
        return this.color;
    }

    public String getSolid() {
        return solid;
    }

    public String getName() {
        return name;
    }
}
