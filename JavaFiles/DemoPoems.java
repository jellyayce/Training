import java.util.Scanner;
public class DemoPoems {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is the title for your Couplet? ");
		Couplet c = new Couplet(sc.nextLine()); // uses the scanned String as an argument in instantiating the Couplet class
		System.out.print("What is the title for your Limerick? ");
		Limerick l = new Limerick(sc.nextLine()); // uses the scanned String as an argument in instantiating the limerick class
		System.out.print("What is the title for your Haiku? ");
		Haiku h = new Haiku(sc.nextLine()); // uses the scanned String as an argument in instantiating the Haiku class
		System.out.println();
		
		c.display(); // calls the display method of the Couplet Class
		l.display(); // calls the display method of the Limerick Class
		h.display(); // calls the display method of the Haiku Class
	}
}
//written by CABANSAG, JAYCEE KENT on SEPTEMBER 13, 2024

