import java.util.Locale;
import java.util.Scanner;

/**
 * H.2.2: Modify program P.2.1 to include dollar signs and digit group commas as
 * appropriate in the output table.
 */

public class h_2_2 {

    public static void main(String[] args) {

        double principal; //
        double rate; // the interest rate
        int term; // the term in months

        // Get user input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the principal: ");
        principal = input.nextDouble();

        System.out.print("Enter the interest as a percent: ");
        rate = input.nextDouble() / 100.0 / 12.0;

        System.out.print("Enter the term in years: ");
        term = input.nextInt() * 12;

        input.close();

        // calculate and print the payment amount
        double payment = principal * ((rate * Math.pow(1 + rate, term)) / (Math.pow(1 + rate, term) - 1.0));
        payment = Math.round(payment * 100.0) / 100.0;

        System.out.printf("The monthly payment is: $%,.2f\n", payment);

        // start the table

        System.out.printf("%6s %12s %12s %12s %12s %12s\n", "Month", "Beginning", "Payment", "Principal", "Interest",
                "Balance");

        int month = 1;
        while (month <= term) {

            double interest = Math.round(principal * rate * 100) / 100.0;

            if (principal + interest < payment) {
                payment = principal + interest;
            }

            double principalpayment = payment - interest;
            double balance = principal - principalpayment;

            System.out.printf(Locale.US, "%,6d $%,12.2f $%,12.2f $%,12.2f $%,12.2f $%,12.2f\n", 
                                                month, 
                                                principal, 
                                                payment, 
                                                principalpayment,
                                                interest, 
                                                balance);
            principal = balance;
            month++;
        }

    }

}