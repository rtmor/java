import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * UserInput
 */
public class UserInput {

    Scanner input = new Scanner(System.in);

    /**
     * @return
     * @see java.lang.Object#hashCode()
     */

    public int hashCode() {
        return input.hashCode();
    }

    /**
     * @param action
     * @see java.util.Iterator#forEachRemaining(java.util.function.Consumer)
     */

    public void forEachRemaining(Consumer<? super String> action) {
        input.forEachRemaining(action);
    }

    /**
     * @param obj
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */

    public boolean equals(Object obj) {
        return input.equals(obj);
    }

    /**
     * 
     * @see java.util.Scanner#close()
     */

    public void close() {
        input.close();
    }

    /**
     * @return
     * @see java.util.Scanner#ioException()
     */

    public IOException ioException() {
        return input.ioException();
    }

    /**
     * @return
     * @see java.util.Scanner#delimiter()
     */

    public Pattern delimiter() {
        return input.delimiter();
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#useDelimiter(java.util.regex.Pattern)
     */

    public Scanner useDelimiter(Pattern pattern) {
        return input.useDelimiter(pattern);
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#useDelimiter(java.lang.String)
     */

    public Scanner useDelimiter(String pattern) {
        return input.useDelimiter(pattern);
    }

    /**
     * @return
     * @see java.util.Scanner#locale()
     */

    public Locale locale() {
        return input.locale();
    }

    /**
     * @param locale
     * @return
     * @see java.util.Scanner#useLocale(java.util.Locale)
     */

    public Scanner useLocale(Locale locale) {
        return input.useLocale(locale);
    }

    /**
     * @return
     * @see java.util.Scanner#radix()
     */

    public int radix() {
        return input.radix();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#useRadix(int)
     */

    public Scanner useRadix(int radix) {
        return input.useRadix(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#match()
     */

    public MatchResult match() {
        return input.match();
    }

    /**
     * @return
     * @see java.util.Scanner#toString()
     */

    public String toString() {
        return input.toString();
    }

    /**
     * @return
     * @see java.util.Scanner#hasNext()
     */

    public boolean hasNext() {
        return input.hasNext();
    }

    /**
     * @return
     * @see java.util.Scanner#next()
     */

    public String next() {
        return input.next();
    }

    /**
     * 
     * @see java.util.Scanner#remove()
     */

    public void remove() {
        input.remove();
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#hasNext(java.lang.String)
     */

    public boolean hasNext(String pattern) {
        return input.hasNext(pattern);
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#next(java.lang.String)
     */

    public String next(String pattern) {
        return input.next(pattern);
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#hasNext(java.util.regex.Pattern)
     */

    public boolean hasNext(Pattern pattern) {
        return input.hasNext(pattern);
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#next(java.util.regex.Pattern)
     */

    public String next(Pattern pattern) {
        return input.next(pattern);
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextLine()
     */

    public boolean hasNextLine() {
        return input.hasNextLine();
    }

    /**
     * @return
     * @see java.util.Scanner#nextLine()
     */

    public String nextLine() {
        return input.nextLine();
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#findInLine(java.lang.String)
     */

    public String findInLine(String pattern) {
        return input.findInLine(pattern);
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#findInLine(java.util.regex.Pattern)
     */

    public String findInLine(Pattern pattern) {
        return input.findInLine(pattern);
    }

    /**
     * @param pattern
     * @param horizon
     * @return
     * @see java.util.Scanner#findWithinHorizon(java.lang.String, int)
     */

    public String findWithinHorizon(String pattern, int horizon) {
        return input.findWithinHorizon(pattern, horizon);
    }

    /**
     * @param pattern
     * @param horizon
     * @return
     * @see java.util.Scanner#findWithinHorizon(java.util.regex.Pattern, int)
     */

    public String findWithinHorizon(Pattern pattern, int horizon) {
        return input.findWithinHorizon(pattern, horizon);
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#skip(java.util.regex.Pattern)
     */

    public Scanner skip(Pattern pattern) {
        return input.skip(pattern);
    }

    /**
     * @param pattern
     * @return
     * @see java.util.Scanner#skip(java.lang.String)
     */

    public Scanner skip(String pattern) {
        return input.skip(pattern);
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextBoolean()
     */

    public boolean hasNextBoolean() {
        return input.hasNextBoolean();
    }

    /**
     * @return
     * @see java.util.Scanner#nextBoolean()
     */

    public boolean nextBoolean() {
        return input.nextBoolean();
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextByte()
     */

    public boolean hasNextByte() {
        return input.hasNextByte();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#hasNextByte(int)
     */

    public boolean hasNextByte(int radix) {
        return input.hasNextByte(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#nextByte()
     */

    public byte nextByte() {
        return input.nextByte();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#nextByte(int)
     */

    public byte nextByte(int radix) {
        return input.nextByte(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextShort()
     */

    public boolean hasNextShort() {
        return input.hasNextShort();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#hasNextShort(int)
     */

    public boolean hasNextShort(int radix) {
        return input.hasNextShort(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#nextShort()
     */

    public short nextShort() {
        return input.nextShort();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#nextShort(int)
     */

    public short nextShort(int radix) {
        return input.nextShort(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextInt()
     */

    public boolean hasNextInt() {
        return input.hasNextInt();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#hasNextInt(int)
     */

    public boolean hasNextInt(int radix) {
        return input.hasNextInt(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#nextInt()
     */

    public int nextInt() {
        return input.nextInt();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#nextInt(int)
     */

    public int nextInt(int radix) {
        return input.nextInt(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextLong()
     */

    public boolean hasNextLong() {
        return input.hasNextLong();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#hasNextLong(int)
     */

    public boolean hasNextLong(int radix) {
        return input.hasNextLong(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#nextLong()
     */

    public long nextLong() {
        return input.nextLong();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#nextLong(int)
     */

    public long nextLong(int radix) {
        return input.nextLong(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextFloat()
     */

    public boolean hasNextFloat() {
        return input.hasNextFloat();
    }

    /**
     * @return
     * @see java.util.Scanner#nextFloat()
     */

    public float nextFloat() {
        return input.nextFloat();
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextDouble()
     */

    public boolean hasNextDouble() {
        return input.hasNextDouble();
    }

    /**
     * @return
     * @see java.util.Scanner#nextDouble()
     */

    public double nextDouble() {
        return input.nextDouble();
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextBigInteger()
     */

    public boolean hasNextBigInteger() {
        return input.hasNextBigInteger();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#hasNextBigInteger(int)
     */

    public boolean hasNextBigInteger(int radix) {
        return input.hasNextBigInteger(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#nextBigInteger()
     */

    public BigInteger nextBigInteger() {
        return input.nextBigInteger();
    }

    /**
     * @param radix
     * @return
     * @see java.util.Scanner#nextBigInteger(int)
     */

    public BigInteger nextBigInteger(int radix) {
        return input.nextBigInteger(radix);
    }

    /**
     * @return
     * @see java.util.Scanner#hasNextBigDecimal()
     */

    public boolean hasNextBigDecimal() {
        return input.hasNextBigDecimal();
    }

    /**
     * @return
     * @see java.util.Scanner#nextBigDecimal()
     */

    public BigDecimal nextBigDecimal() {
        return input.nextBigDecimal();
    }

    /**
     * @return
     * @see java.util.Scanner#reset()
     */

    public Scanner reset() {
        return input.reset();
    }

    /**
     * @param input
     */
    public UserInput(Scanner input) {
        this.input = input;
    }

	public UserInput(InputStream in) {
	}

    
}