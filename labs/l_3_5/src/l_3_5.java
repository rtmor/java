/**
 * L.3.5: In this exercise create Print and Join static methods for integer
 * arrays. The Print method should use System.out to print a comma separated
 * list of values in the array. The Join method should take in a second
 * parameter, a string, and return a string that is the elements of the array
 * separated by the second parameter. Perhaps you could use your Join method to
 * easily accomplish the Print method? See this link for "Join" signature in the
 * Microsoft.NET framework. Neither method should get input from the user, that
 * should be done OUTSIDE of your method (i.e. in main). Your methods should be
 * provided only the integer arrays as parameters.
 */
public class l_3_5 {

    public static void main(String[] args) {

        int numberArray[] = {5,12,52,235,2,3,123,52,5,77,64,125,23,634,55,21,32};

        // send numberArray to Print() method
        Print(numberArray);

        // send numberArray and random string to separate and print
        System.out.println(Join(numberArray, "_|_"));

    }

    // print array parameter as string separated by commas
    public static void Print(int[] intInput) {

        System.out.println(Join(intInput, ","));
    }

    // join array parameter as string separated by provided string argument
    public static String Join(int[] intInput, String separator) {

        String joinString = "";

        for (int i = 0; i < (intInput.length - 1); i++) {

            if (i != 0) {
                joinString += separator + intInput[i];
            } else {
                joinString += intInput[i];
            }

        }

        return joinString;

    }
}