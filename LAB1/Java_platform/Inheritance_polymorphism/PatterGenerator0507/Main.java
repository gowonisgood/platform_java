package Java_platform.Inheritance_polymorphism.PatterGenerator0507;

public class Main {
    public static void main(String[] args) {
        PatternGenerator bowTiePattern = new PatternGenerator(9, new BowTieDrawer());
        System.out.print(bowTiePattern.generate());
        System.out.println();

        PatternGenerator isoscelesPattern = new PatternGenerator(5, new IsoscelesDrawer());
        System.out.print(isoscelesPattern.generate());
        System.out.println();

        PatternGenerator eulerPattern = new PatternGenerator(5, new PascalsTriangleDrawer());
        System.out.print(eulerPattern.generate());
    }
}
