package entity;

// This Class and its subclass will transfer user input into useful input data structure.
//
// @para solid: It is a solid line if the value is true, it is a dashed line if the value is false

public abstract class TargetEntity {
    private Style style;

    public TargetEntity(String name, boolean solid, String color) {
        this.style = new Style(name, solid, color);
    }

    public Style getStyle() {
        return style;
    }
}
