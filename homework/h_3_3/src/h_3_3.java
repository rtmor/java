import org.apache.commons.lang3.StringUtils;

/**
 * H.3.3: In this exercise create Left, Right, and Mid static methods. They must
 * be implemented using the same method signature (i.e. parameters and return
 * types) as in the Microsoft.NET framework. See here for definitions. Please be
 * certain to read what each parameter of the method represents and what it is
 * supposed to be return. Reading the definition carefully and thoroughly is the
 * key to success. Note there are TWO different Mid method signatures you must
 * implement, there are FOUR functions in total you must implement (LEFT, RIGHT,
 * MID version 1, MID version 2). YOU MUST READ THE SPECIFICATION CAREFULLY AND
 * THEN IMPLEMENT IT IN JAVA. HINT: Perhaps you could easily use the substring
 * method of strings to finish this lab quickly? Reading for Next Week
 * 
 */
public class h_3_3 {

    public static void main(String[] args) {

        System.out.println(left("This is The String", 5));
        System.out.println(right("This is The String", 5));
        System.out.println(mid1("This is The String", 5));
        System.out.println(mid2("This is The String", 5, 3));

    }

    public static String left(String str, int length) {
        return StringUtils.left(str, length);
        //return str.substring(0, length - 1);
    }

    public static String right(String str, int length) {
        return StringUtils.right(str, length);
        //return str.substring(str.length()-length, str.length());
    }

    public static String mid1(String str, int start) {
        return str.substring(start - 1, str.length());
    }

    public static String mid2(String str, int start, int length) {
        return StringUtils.mid(str, start, length);
        //str = str.substring(start, str.length());
        //return str.substring(0, length);


    }
}