import java.util.ArrayList;
import java.util.List;

/**
 * H.5.1: Create a class hierarchy that represents shapes. It should have the
 * following classes: Shape, Two Dimensional Shape, Three Dimensional Shape,
 * Square, Circle, Cube, Rectangular Prism, and Sphere. Cube should inherit from
 * Rectangular Prism. The two dimensional shapes should include methods to
 * calculate Area. The three dimensional shapes should include methods to
 * calculate surface area and volume. Use as little methods as possible (total,
 * across all classes) to accomplish this, think about what logic should be
 * written at which level of the hierarchy and what can be shared. Write an
 * appropriate main to test your classes and demonstrate functionality.
 */
public class h_5_1 {

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
       
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(4, 4, "Square"));
        shapes.add(new Cube(4, 4, 4, "Cube"));
        shapes.add(new Circle(4, 4, "Circle"));
        shapes.add(new RectangularPrism(3, 4, 5, "Rectangular Prism"));
        shapes.add(new Sphere(4, 4, 4, "Sphere"));

        System.out.println();

        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }

}