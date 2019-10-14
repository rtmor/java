import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    /**
     * This won't compile.
     */
//    public void writeList() {
//        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
//
//        for (int i = 0; i < SIZE; i++) {
//            out.println("Value at: " + i + " = " + list.get(i));
//        }
//        out.close();
//    }
    
    /**
     * This one throws the exception up to main to be handled, or crash
     * the program.
     */
    public void writeList2() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
        out.close();
    }
    
    /**
     * This one catches and handles the exception.  This will run, but what
     * if the file wasn't found vs. some other I/O error?
     */
    public void writeList3() {
    	try {
    		PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i));
            }
            out.close();
    	} catch (IOException ex) {
    		// Use the message to get exactly what happened
    		System.out.println("We had a problem: " + ex.getMessage());
    	}
    }
    
    /**
     * This one catches and handles the exception.  This handles the
     * FileNotFoundException differently than others.
     */
    public void writeList4() {
    	try {
    		PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
    		for (int i = 0; i < SIZE; i++) {
    			out.println("Value at: " + i + " = " + list.get(i));
    		}
    		out.close();
    	} catch (FileNotFoundException ex) {
    		// Order is important! Since a FileNotFoundException IS
    		// an IOException!
    		System.out.println("The file wasn't found");
    	} catch (IOException ex) {
    		System.out.println("Some other IO Exception happened");
    	}
    }
    
    /**
     * We can use the finally block to make sure that our PrintWriter was
     * closed properly.
     */
    public void writeList5() {
    	
    	// Note: I had to move it outside so that it will have scope.  I must
    	// also initialize it to null.
    	
    	PrintWriter out = null;
    	try {
    		out = new PrintWriter(new FileWriter("OutFile.txt"));
    		for (int i = 0; i < SIZE; i++) {
    			out.println("Value at: " + i + " = " + list.get(i));
    		}
    		out.close();
    	} catch (FileNotFoundException ex) {
    		// Order is important! Since a FileNotFoundException IS
    		// an IOException!
    		System.out.println("The file wasn't found");
    	} catch (IOException ex) {
    		System.out.println("Some other IO Exception happened");
    	} finally {
    	    if (out != null) { 
    	        System.out.println("Closing PrintWriter");
    	        out.close(); 
    	    } else { 
    	        System.out.println("PrintWriter not open");
    	    } 
    	} 
    }
        
}