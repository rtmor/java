/**
 * L.2.6 Write a program which will compute the minors of a 3 x 3 square matrix
 * (see Wikipedia). The math is demonstrated under the heading "First minors".
 * Your program should not accept user input, you should hard code your input
 * within your program at the top so that it can be easily changed in-between
 * runs. The input should be represented as a 2-dimensional array of doubles.
 * Your program should output each minor one at a time on new lines. Note: A
 * minor is a single integer, it is not another matrix. How many minors should
 * there be? Ideally you should write your program within a method (aka
 * function) and then give the input array as a parameter but we haven't learned
 * methods yet. Please feel free to try anyway.
 */
public class l_2_6 {

    public static void getMinors(int[][] square, int mI, int mJ) {

        int[][] min_matrix = new int[2][2];
        int xi = 0;
        int xy = 0;


        for (int i=0; i<=2; i++) {
            if (i != mI) {
                for (int j = 0; j<=2; j++) {
                    if (j != mJ) {
                       min_matrix[xi][xy] = square[i][j]; 
                       if (xy == 1) {
                           xi++;
                           xy = 0;
                       } else {
                           xy++;
                       }
                    } 
                }
            }
        }

        System.out.printf("[%d,%d]\n[%d,%d]\n", min_matrix[0][0], min_matrix[0][1], min_matrix[1][0], min_matrix[1][1]);
        System.out.println(min_matrix[0][0] * min_matrix[1][1] - min_matrix[0][1] * min_matrix[1][0]);
        System.out.println();

    }
    public static void main(String[] args) {

        int sq_matrix[][] = {{1,4,7},
                             {3,0,5},
                            {-1,9,11}};
        //(0,0),(0,1),(0,2)
        //(1,0),(1,1),(1,2)
        //(2,0),(2,1),(2,2)
     
        System.out.println("List of First Minors");
        for(int i = 0; i <=2;i++) {
            for(int j = 0; j <=2; j++) {
                getMinors(sq_matrix, i, j);
            }
        }
    }
}
