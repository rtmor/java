import java.text.DecimalFormat;

/**
 * ThreeDimensionalShape
 */
public abstract class ThreeDimensionalShape implements Shape {

    private double height;
    private double length;
    private double width;
    private String name;
    DecimalFormat df = new DecimalFormat("#.###");

    /**
     * 
     * @param height
     * @param width
     * @param length
     * @param shapeName
     */
    public ThreeDimensionalShape(double height, double width, double length, String shapeName) {
        setHeight(height);
        setWidth(width);
        setLength(length);
        setShapeName(shapeName);
    }


    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
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
     * @return String
     */
    @Override
    public String getShapeName() {
        return name;
    }

    
    /** 
     * @param shapeName
     */
    @Override
    public void setShapeName(String shapeName) {
        this.name = shapeName;
    }

    
    /** 
     * @param toString(
     * @return double
     */
    public abstract double getArea();

    
    /** 
     * @param toString(
     * @return double
     */
    public abstract double getVolume();

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return getShapeName() + ": [height=" + height + ", length=" + length +  ", width=" + width + ", area=" + getArea() + ", volume=" + getVolume() +  "]";
    }


}