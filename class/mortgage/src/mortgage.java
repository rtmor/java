import java.util.Scanner;

/**
 * P.2.1 Formatted Mortgage Amortization Table. Print a well-formatted mortgage
 * amortization table when the user enters mortgage amount, interest rate, and
 * loan duration in years. Also show the monthly payment.
 */
public class mortgage {

    public static void main(String[] args) {

        // mortgage values
        double principle, rate;
        int term;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the principle: ");
        principle = input.nextDouble();

        System.out.print("Enter the interest as a percent: ");
        rate = input.nextDouble() / 100.0 / 12.0;

        System.out.print("Enter the term in years: ");
        term = input.nextInt() * 12;
        input.close();

        double payment = principle * ((rate * Math.pow(1 + rate, term)) / (Math.pow(1 + rate, term) - 1));

        payment = Math.round(payment * 100.0) / 100;

        System.out.printf("Monthly payment is %.2f\n", payment);
        
        System.out.printf("%6s %12s %12s %12s %12s %12s\n", "Month",
                                                          "Beginning",
                                                          "Payment",
                                                          "Principle",
                                                          "Interest",
                                                          "Balance");
        for(int month=1; month<=term;month++) {

            double interest = Math.round(principle * rate * 100) / 100;

            if (month == term) {
                payment = interest + principle;
            }

            double principlepayment = payment - interest;
            double balance = principle - principlepayment;

            System.out.printf("%6d %12.2f %12.2f %12.2f %12.2f %12.2f\n", month,
                                                                          principle,
                                                                          payment,
                                                                          principlepayment,
                                                                          interest,
                                                                          balance);
            principle = balance;
        }
        
    }
}