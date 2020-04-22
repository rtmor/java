import java.util.stream.IntStream;

/**
 * E.10.1: The "Fizz-Buzz test": This is an interview question designed to help
 * filter out the 99.5% of programming job candidates who can't actually
 * program. The text of the programming assignment is as follows:
 * 
 * Write a program that prints the numbers from 1 to 100. But for multiples of
 * three print "Fizz" instead of the number and for the multiples of five print
 * "Buzz". For numbers which are multiples of both three and five print
 * "FizzBuzz". Since I expect more from you than any old answer I'd like you to
 * solve this problem using the modulus operator no more than twice. You also
 * cannot nest an IF inside of another IF.
 */
public class e_10_1 {

    public static void main(String[] args) {

        IntStream.range(1, 101)
                 .mapToObj(i -> i % 3 == 0 
                    ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") 
                    : (i % 5 == 0 ? "Buzz" : i))
                 .forEach(System.out::println);
    }
}