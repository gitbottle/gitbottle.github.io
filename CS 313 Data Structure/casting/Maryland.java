package casting;

public class Maryland extends State { 
	Maryland() { } 
	public void printMe() { System.out.println("Read it."); } 
	
	public static void main(String[ ] args) { 
		Region east = new State(); 
		State md = new Maryland(); 
		Object obj = new Place(); 
		Place usa = new Region(); 
		md.printMe(); // Read it
		east.printMe(); //Ship it
		((Place) obj).printMe(); //safe cast because obj is an instance of Place. Buy it
		obj = md; // object now refers to md. 
		((Maryland) obj).printMe(); //safe cast because md is an instance of Maryland Read it
		obj = usa; //obj now refers to usa
		((Place) obj).printMe(); // Box it
		usa = md; 
		((Place) usa).printMe();//Read it
		} 
	} 

	
	
	