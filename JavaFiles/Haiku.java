
public class Haiku extends Poem{
	private String title;
	
	public Haiku(String t) {
		super("Haiku",3);
		title = t;
	}
	public String getTitle() {
		return title;
	}
	public void display() {
		System.out.println("The NAME of the Poem is: "+getName());
		System.out.println("A "+ getName()+" has "+getLines()+" LINES.");
		System.out.println("Its TITLE is "+getTitle()+"\n");
	}
}
//written by CABANSAG, JAYCEE KENT on SEPTEMBER 13, 2024
