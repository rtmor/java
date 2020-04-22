import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * L.12.1: Create a console program that allows the use of a simple Affine
 * Cipher. For simplicity your program should only allow lowercase letters.
 * 
 * The affine cipher work as such:
 * 
 * Let's say our plain text is "t" and the key we select is 5 and 9 (there are
 * two parts). The two parts of the key are called the multiplier (the first
 * part) and the shift (the second part). The only valid multipliers are 1, 3,
 * 5, 7, 9, 11, 15, 17, 19, 21, 23, and 25.
 * 
 * 1) What position in the alphabet is "t"? 19
 * 
 * 2) Plug 19 into the mathematical function 5x + 9 (this is derived from the
 * keys). 104 is the result.
 * 
 * 3) Divide 104 by 26 and take the remainder after division (modulus). 0 is the
 * result.
 * 
 * 4) The cipher text is the zeroth letter of the alphabet: "a".
 * 
 * Transform each letter of the string in this manner. Spaces should in the
 * input should be put in the same position in the output.
 * 
 * Ask the user for a string. Then ask the user if they would like to encrypt or
 * decrypt the string. Then ask the user for the two parts of the key. Finally
 * run the appropriate decrypt or encrypt algorithm to obtain the correct
 * plaintext or ciphertext.
 * 
 * I'll leave the decryption algorithm as an exercise to you. To decrypt you
 * will need to determine the multiplicative modulo inverse of your multiplier
 * mod 26. Since there are a finite number of valid multipliers you can hardcode
 * your values. This article may help you.
 */
public class l_12_1 {

    public static void main(String[] args) {

        String clearText;
        int multiplier;
        int shift;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Affine Cipher Text: ");
        clearText = scanner.nextLine();

        System.out.print("Enter Multiplier Valid Multiplers Include: 1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, and 25): ");
        multiplier = scanner.nextInt();

        System.out.print("Enter Multipler: ");
        shift = scanner.nextInt();

        System.out.print("Encryption (e) or Decryption (d): ");

        switch (scanner.next()) {
        case "e":
            encrypt(clearText, multiplier, shift);
            break;
        case "d":
            decrypt(clearText, multiplier, shift);
            break;
        default:
            System.out.println("Illegal Choice");
            break;
        }
    }

    static void encrypt(String clearText, int multiplier, int shift) {
        clearText.chars()
                 .mapToObj(i -> (int) i)
                 .map(i -> i - 97)
                 .map(i -> i * multiplier)
                 .map(i -> i + shift)
                 .map(i -> i % 26)
                 .map(i -> i + 97)
                 .forEach(i -> System.out.print((char) (0 + i)));
    }

    static void decrypt(String dirtyText, int multiplier, int shift) {

        OptionalInt inverse = 
        IntStream.range(0, 26)
                 .filter(i -> i * multiplier % 26 == 1)
                 .findFirst();

        dirtyText.chars()
                 .mapToObj(i -> (int) i)
                 .map(i -> i - 97)
                 .map(i -> i - shift)
                 .map(i -> i * inverse.getAsInt())
                 .map(i -> i % 26)
                 .map(i -> i + 97)
                 .forEach(i -> System.out.print((char) (0 + i)));
    }
}
