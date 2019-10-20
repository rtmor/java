import java.math.RoundingMode;

/**
 * Circle
 */
public class Circle extends TwoDimensionalShape {

    /** 
     * @param length
     * @param width
     * @param shapeName
     * @return 
     */
    public Circle(double length, double width, String shapeName) {
        super(length, width, shapeName);
    }

    
    /** 
     * @return double
     */
    @Override
    public double getArea() {
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(Math.PI * Math.pow(this.getWidth()/2, 2.0)));
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Circle [diameter=" + getWidth() + " radius=" + getWidth() / 2 + " area=" + getArea() + "]";
    }
}