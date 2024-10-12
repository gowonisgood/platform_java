package Java_platform.Inheritance_polymorphism.PatterGenerator0507;

public class PatternGenerator {
    private int numOfLines;
    private PatternDrawer drawer;

    public PatternGenerator(int numOfLines, PatternDrawer drawer) {
        this.numOfLines = numOfLines;
        this.drawer = drawer;
    }

    public String generate() {
        return drawer.drawPattern(numOfLines);
    }
}
