import java.util.Scanner;

/**
 * L.2.1 Theater Ticket System. A small ten seat theater would like a program to
 * reserve tickets. The theater has two rows of five seats. Each row is referred
 * to by number (1 or 2) and each seat in the row is refered to by letter (A, B,
 * C, D, and E). The system should ask the user for the row they prefer, if that
 * row is full then the system should ask them if they would like to use the
 * other row, if they say no the program should state that the next show is
 * tomorrow. Upon selecting a row, the program should present the user with a
 * choice of available seats in the row. If the user finds those choices
 * acceptable and selects a seat the program should print the "ticket" (i.e.
 * "You have booked seat 2C"). If the user does not find those choices
 * acceptable the user should be able to return to the row selection. If only
 * one seat is available in a row the program should ask the user if that seat
 * is acceptable. If the user says no, then the program should return to the row
 * selection. The program terminates when all seats are full.
 */
public class l_2_1 {

    public static void main(String[] args) {

        // 10 seats starting with empty
        boolean[][] seats = new boolean[2][5];

        while (thereAreSeats(seats)) {

            // main algorithm works in 0 and 1
            int row = getRowTheyPrefer();

            if (rowIsFull(row, seats)) {

                if (wantsOtherRow(row)) {

                    row = notRow(row);
                } else {
                    seeYouLater();
                    continue;
                }
            } else {

                int seat = showAvailableSeats(row, seats);

                if (seat == -1) {
                    seeYouLater();
                } else {
                    bookSeat(row, seat, seats);
                }

            }
        }

    }

    private static void bookSeat(int row, int seat, boolean[][] seats) {
        seats[row][seat] = true;
        System.out.println("You have booked seat " + (row+1) + "" + (char)(seat+65));
    }

    private static int  showAvailableSeats(int row, boolean[][] seats) {
        System.out.println("The available seats: ");

        for(int i =0; i <seats[row].length; i++) {
            if (seats[row][i] == false) {
                System.out.print((char)(65+i) + " ");
            }
        }
        System.out.println();

        System.out.print("Enter a seat choice or Z to return: ");

        Scanner input = new Scanner(System.in);
        String s = input.next();
        input.close();
        char selection = s.charAt(0);

        if (selection == 'Z') {
            return -1;
        } else {
            return selection -65;
        }
    }

    private static void seeYouLater() {
        System.out.println("The next show is tomorrow!");
    }

    private static int notRow(int row) {
        return row == 0 ? 1 : 0;
    }

    private static boolean wantsOtherRow(int row) {
        System.out.println("Row "+ (row+1) + " is full. Would you like row " 
                            + (notRow(row)+1) + "? Y/N: "); 
        Scanner input = new Scanner(System.in);
        String s = input.next();
        input.close();
        return s.substring(0, 1).equalsIgnoreCase("Y");
    }

    private static boolean rowIsFull(int row, boolean[][] seats) {
        for (int i = 0; i < seats[row].length; i++) {
            if (seats[row][i] == false) {
                return false;
            }
        }
        return true;
    }

    private static int getRowTheyPrefer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which row would you like (1 or 2)?: ");
        int row = input.nextInt();
        input.close();
        return row - 1;
    }

    private static boolean thereAreSeats(boolean[][] seats) {
        return !rowIsFull(0, seats) || !rowIsFull(1, seats);
    }

}