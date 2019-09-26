/*
* L.1.2: Print a multiplication times table from 0 to a user entered number (see: https://www.mathsisfun.com/definitions/times-tables.html).  Be sure to include column and row headers so your table is easy to read.
*/

import java.util.Scanner;

public class l_1_2 {

    public static void main(String[] args) {
        int x = 0;

        System.out.print("Enter a value to for multiplication table: ");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        in.close();

        System.out.format("      ");
        for(int i = 0; i<=x;i++ ) {
            System.out.format("%4d",i);
        }
        System.out.println();
        System.out.println("---------------------");

        for(int i = 1 ;i<=x;i++) {
            System.out.format("%4d |",i);
            for(int j=1;j<=x;j++) {
                System.out.format("%4d",i*j);
            }
            System.out.println();
        }
        }

}