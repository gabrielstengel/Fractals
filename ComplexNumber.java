import java.util.*;

/**
 * @author      Gabe Stengel <gabrielrstengel@gmail.com>
 * @version     2.0
 * @since       2013-11-19
 */
public class ComplexNumber {

	private double a;
	private double b;

	/**
	 * Creates a new ComplexNumber with both real and imaginary components
	 * @param a the real component of the complex number
	 * @param b the imaginary component of the complex number
	 */
	public ComplexNumber(double a, double b){
		this.a = a;
		this.b = b;
	}

	/**
	 * The "default constructor"
	 * Creates a new ComplexNumber without parameters
	 * @param c a ComplexNumber
	 */
	public ComplexNumber(){
		a = 1;
		b = 2;
	}

	/**
	 * The "copy constructor"
	 * Creates a new ComplexNumber from an existing ComplexNumber
	 * @param c a ComplexNumber
	 */
	public ComplexNumber(ComplexNumber c){
		a = c.getReal();
		b = c.getImaginary();
	}

	/**
	 * An "accessor" method
	 * Returns the real component of this ComplexNumber
	 * @return a the private real component of this ComplexNumber
	 */
	public double getReal(){
		return a;
	}

	/**
	 * An "accessor" method
	 * Returns the imaginary component of this ComplexNumber
	 * @return b the private imaginary component of this ComplexNumber
	 */
	public double getImaginary(){
		return b;
	}

	/**
	 * A "to string" method
	 * Returns the string of a number
	 * @return the imaginary number in string form
	 */
	public String toString(){
		String finsh = "";
		if (b == 0)finsh = ""+a;
		else if (b>0)finsh = ""+a+"+"+b+"i";
		else if (b<0) finsh = ""+a+""+b+"i";
		else System.out.println("ERROR");
		return finsh;
	}

	/**
	 * A method that tests equality between complex numbers
	 * Returns if they are equal
	 * @param the complexnumber you are comparing to
	 * @return x a boolean variable
	 */
	public boolean equals(Object o){

		ComplexNumber h = (ComplexNumber)o;
		boolean x = true;
		if (h.getReal()!=a || h.getImaginary()!=b) x = false;
		return x;
	}

	/**
	 * A "math" method
	 * Returns the magnitude of a complex number
	 * @return mag a double variable
	 */
	public double magnitude(){
		double mag = 1;
		mag = Math.sqrt((a*a)+(b*b));
		return mag;
	}

	/**
	 * A "comparison" method
	 * Returns which number is farther from the origin
	 * @param the complexnumber you are comparing to
	 * @return x which is either 1, 0, or -1
	 */
	public int compareTo(ComplexNumber c){
		if (this.magnitude() == c.magnitude())return 0;
		else if (this.magnitude()>c.magnitude())return 1;
		else return -1;

	}

	/**
	 * This is a "math" function
	 * It takes two complex numbers and adds them
	 * @param the complexnumber you are adding
	 * @return the sum of the two complex numbers
	 */
	public ComplexNumber add(ComplexNumber c){
		ComplexNumber n = new ComplexNumber((this.a + c.getReal()), (this.b + c.getImaginary()));
		return n;
	}

	/**
	 * This is a "math" function
	 * It takes two complex numbers and subtracts them
	 * @param the complexnumber you are going to subtract from
	 * @return the difference of the two complex numbers
	 */
	public ComplexNumber subtract(ComplexNumber c){
		ComplexNumber n = new ComplexNumber(this.a - c.getReal(),this.b - c.getImaginary());
		return n;
	}

	/**
	 * This is a "math" function
	 * It takes two complex numbers and multiplies them
	 * @param the complex number you wnat to multiply by
	 * @return the product of the two ComplexNumbers
	 */
	public ComplexNumber multiply(ComplexNumber c){
		ComplexNumber n = new ComplexNumber((this.a * c.getReal())-(this.b * c.getImaginary()), (this.a*c.getImaginary())+(this.b * c.getReal()));
		return n;
	}

	/**
	 * This is a "math" function
	 * It divides one complex number by another
	 * @param the complex number you want to divide by
	 * @return the result of the division of the complex numbers
	 */
	public ComplexNumber divide(ComplexNumber c) {

		if ( c.a == 0 && c.b == 0) {throw new IllegalArgumentException("Do not divide by zero!");}
		else {ComplexNumber n = new ComplexNumber((this.a*c.getReal()+this.b*c.getImaginary())/(c.getReal()*c.getReal()+c.getImaginary()*c.getImaginary()) ,(this.b*c.getReal()-this.a*c.getImaginary())/(c.getReal()*c.getReal()+c.getImaginary()*c.getImaginary()) );
		return n;
		}
	}

	/**
	 * This is a "math" function
	 * It raises a complex number to a certain power
	 * @param the power
	 * @return the result
	 */
	public ComplexNumber pow(int n){
		ComplexNumber r = new ComplexNumber(this.a, this.b);
		for (int i = 0; i < n; i++){
			r = this.multiply(this);
		}
		return r;
	}






	/**
	 * A tester method
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexNumber c1 = new ComplexNumber(2, 3);
		ComplexNumber c2 = new ComplexNumber();
		ComplexNumber c3 = new ComplexNumber(4, -3);
		ComplexNumber c4 = new ComplexNumber(c3);
		String String1 = c1.toString();
		ComplexNumber c1c3 = c1.add(c3);
		ComplexNumber c5 = new ComplexNumber(0, 0);

		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println("c4 = " + c4);
		System.out.println(""+c1+" Equals " + c2 + " ?:");
		System.out.println(c1.equals(c2));
		System.out.println(""+c3+" Equals " + c4 + " ?:");
		System.out.println(c3.equals(c4));
		System.out.println("Magnitude of c1: " + c1.magnitude());
		System.out.println("Add c1 + c3: " + c1 + " + " + c3 + "  = "  + c1c3);
		System.out.println("Subtract c1 - c3: " + c1 + " - " + c3 + "  = "  + c1.subtract(c3));
		System.out.println("Multiplacation c1 * c3: "  + c1 + " * " + c3 + "  = "  + c1.multiply(c3));
		System.out.println("Division c1 / c3: " +  c1 + " / " + c3 + "  = "  + c1.divide(c3));
		System.out.println("Here is c1 to strng: " + String1);
		System.out.println("Comparing c1 to c3: " + c1.compareTo(c3));
		System.out.println("c1 to the power of 2: " + c1.pow(2));
		System.out.println("Dividing c1 by a complex number of 0+0i: " + c1.divide(c5));


	}
}
