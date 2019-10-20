import java.text.DecimalFormat;

/**
 * TwoDimensionalShape
 */
public class TwoDimensionalShape implements Shape {

    private double length;
    private double width;
    private String name;
    DecimalFormat df = new DecimalFormat("#.###");

    /**
     * @param length
     * @param width
     */
    public TwoDimensionalShape(double length, double width, String shapeName) {
        setLength(length);
        setWidth(width);
        setShapeName(shapeName);
    }

    
    /** 
     * @return String
     */
    @Override
    public String getShapeName() {
        return name;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    
    /** 
     * @return double
     */
    public double getArea() {
        return this.getLength() * this.getWidth();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return getShapeName() + ": [length=" + length + ", width=" + width + ", area=" + getArea() + "]";
    }

    
    /** 
     * @param shapeName
     */
    @Override
    public void setShapeName(String shapeName) {
        this.name = shapeName;
    }

}