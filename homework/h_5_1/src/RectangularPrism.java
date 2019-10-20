/**
 * RectangularPrism
 */
public class RectangularPrism extends ThreeDimensionalShape {



    
    /** 
     * @param height
     * @param width
     * @param length
     * @param shapeName
     * @return 
     */
    public RectangularPrism(double height, double width, double length, String shapeName) {
        super(height, width, length, shapeName);
    }

    
    /** 
     * @return double
     */
    public double getArea() {

        return (2 * this.getLength() * this.getWidth()) + 
              (2 * this.getWidth() * this.getHeight()) +
              (2 * this.getLength() * this.getHeight());
    }

    
    /** 
     * @return double
     */
    public double getVolume() {
        return (this.getHeight() * this.getLength() * this.getWidth());
    }

}