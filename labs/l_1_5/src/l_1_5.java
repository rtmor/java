import java.util.Scanner;

/**
 * L.1.5.: Prompt the user for three integers representing the sides of a
 * rectangular prism. Draw three rectangles of asterisks representing a top,
 * side, and front view of the prism labeled accordingly (which is which is up
 * to you). Calculate and print the total surface area and volume of the
 * rectangle.
 */
public class l_1_5 {

    public static void main(String[] args) {

        int height, length, width;
        double area, volume;

        System.out.print("Enter dimension of rectangular prism - (Height Length Width): ");
        Scanner in = new Scanner(System.in);
        height = in.nextInt();
        length = in.nextInt();
        width  = in.nextInt();
        in.close();

        area = 2 * ((width * length) + (height * length) * (height * width));
        volume = (width * height * length);

        // Front
        System.out.println("\nDimensions from Front");
        printView(height, length);

        // Top
        System.out.println("Dimensions from Top");
        printView(width, length);

        // Side
        System.out.println("Dimensions from Side");
        printView(height, width);

        System.out.format("Area of Rectangular Prism: %.1f\n" + 
                          "Volume of Recatangular Prism: %.1f", 
                          area, volume); 

    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public static String repeat(int count) {
        return repeat(count, " ");
    }

    public static void printView(int height, int width) {

        System.out.println();

        for (int j = 1; j <= height; j++) {
            if (j == 1 || j == height) {
                System.out.println(repeat(width, "*  "));
            } else {
                System.out.println("*  " + repeat(width - 2, "   ") + "*");
            }
        }
        System.out.println();
    }
}