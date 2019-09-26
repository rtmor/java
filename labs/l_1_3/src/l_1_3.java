/*
* L.1.3: Prompt the user for the radius of a circle.  Using Math.PI to calculate, print the circumference of the circle, the area of the circle, and the X,Y coordinate of the center of the circle if the circle is tangent to both the X and Y axes and resides in the first quadrant.  All numbers should be rounded to two digits after the decimal (you might want to format output using printf). 
*/

import java.util.Scanner;

public class l_1_3 {

    public static void main(String[] args) {
        double radius;
        System.out.print("Enter value of circle radius: ");
        Scanner in = new Scanner(System.in);
        radius = in.nextInt();
        in.close();

        double circumference = (2 * Math.PI * radius);
        double area = (Math.PI * Math.pow(radius, 2));

        System.out.format("Circle Radius = %.2f \n", radius);
        System.out.format("Circumference of circle = %.2f \n", circumference);
        System.out.format("Area of circle = %.2f \n", area);
        System.out.format("Coordinates of origin = (%.2f,%.2f)", radius, radius);

    }
}