/**
 * L.5.5: Inheritance and Composition: Examine the code in expression.zip. Fully
 * comment all files with JavaDoc files. Do not modify the file
 * "RunExpression.java" in any way, but add enough classes and code to make the
 * program work correctly. I should be able to build any expression I want when
 * you are finished.
 */

public class RunExpression {

	public static void main(String[] args) {
		
/* 		  Expression two = new Constant(2); 
		  Expression four = new Constant(4);
		  Expression negOne = new Negate(new Constant(1)); Expression sumTwoFour = new
		  Addition(two, four); Expression mult = new Multiplication(sumTwoFour, negOne); Expression exp = new Exponent(mult, 2); Expression res = new
		  Addition(exp, new Constant(1)); */
		

 		Expression four = new Constant(4);
		Expression two = new Constant(2);
		Expression twelve = new Constant(12);
		Subtraction res = new Subtraction(four, two);
		Division res2 = new Division(twelve, four);

		/**
		 * This line should print out: ( ( ( 2 + 4 ) * - 1 ) ^ 2 + 1 ) = 37
		 */
		System.out.println(res + " = " + res.evaluate());
		System.out.println(res2 + " = " + res2.evaluate());
	}
}
