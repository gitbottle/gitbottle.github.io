package milestone3;

public class VendingMachineController {
	private VendingMachineView view;
	
	public VendingMachineController (VendingMachineView view) {
		this.view = view;
	}
	
	public void run() {
		while(true) {
			MainMenu choice= MainMenu.values()[view.getMainMenuChoice()-1];
			switch(choice) {
				case Unknown: //view items
					break;
				case ViewItems:
					break;
					
				case ViewShelf:
					break;
					
			}
		}
	}
}
