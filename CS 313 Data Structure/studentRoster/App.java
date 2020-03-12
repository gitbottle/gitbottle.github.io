package studentRoster;

public class App {
	public static void main (String [] args) {
		UserID myIo= new UserIOConsoleImpl ();
		ClassRosterView myView = new ClassRosterView(myIo);
		ClassRosterDao myDao= new ClassRosterDaoFileImpl();
		ClassRosterController controller = new ClassRosterController (myDao, myView);
		controller.run();
	}
}
