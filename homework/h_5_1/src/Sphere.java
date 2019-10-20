import java.math.RoundingMode;

/**
 * Sphere
 */
public class Sphere extends ThreeDimensionalShape {


    
    /** 
     * @param height
     * @param width
     * @param length
     * @param shapeName
     * @return 
     */
    public Sphere(double height, double width, double length, String shapeName) {
        super(height, width, length, shapeName);
    }

    
    /** 
     * @return double
     */
    public double getArea() {
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(4 * Math.PI * Math.pow(getLength()/2, 2)));
    }
    
    
    /** 
     * @return double
     */
    public double getVolume() {
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format((4.0 / 3.0) * Math.PI * Math.pow(getLength()/2, 3)));
    }

    
    /** 
     * @return String
     */
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Sphere: [diameter=" + getWidth() + " radius=" + getWidth() / 2 +
               " area=" + getArea() + " volume=" + getVolume() + "]";
    }

}