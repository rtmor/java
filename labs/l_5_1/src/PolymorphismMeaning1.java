
public class PolymorphismMeaning1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		doSomething();
		doSomething("Hello World");
		doSomething(8);
		doSomething("Cat", 8);
		doSomething(12, "Dog");
	}
	
	public static void doSomething() {
		System.out.println("I did something");
	}
	
	public static void doSomething(String s) {
		System.out.println("I did something with this string! " + s);
	}
	
	public static void doSomething(int i) {
		System.out.println("I did something with this int! " + i);
	}
	
	public static void doSomething(String s, int i) {
		System.out.println("String first, int second! " + s + " " + i);
	}
	
	public static void doSomething(int i, String s) {
		System.out.println("int first, string second! " + i + " " + s);
	}

}
