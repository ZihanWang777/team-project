package entity;

public class Style {
    private String color;
    private boolean solid;
    private String name;

    public Style(String n, boolean s, String c) {
        this.color = c;
        this.solid = s;
        this.name = n;
    }

    public String getColor() {
        return this.color;
    }

    public boolean isSolid() {
        return solid;
    }

    public String getName() {
        return name;
    }
}
