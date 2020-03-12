package milestone3;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachineView {
	
	private int promptForInt() {
		Scanner sc = new Scanner (System.in);
		String input = sc.nextLine ();
		return Integer.parseInt(input);
	}
	
	public void printBanner (String title) {
		System.out.println("=========="+title+"==========");
	}
	
	public int getMainMenuChoice() {
		printBanner ("Items");
		System.out.println ("1. Insert Money");
		System.out.println ("2. View Items");
		System.out.println ("3. Return Change");
		return promptForInt();
	}
	
	public int viewItems(List<Item> items) {
		printBanner ("Items");
		int i=0;
		for (i=0; i<items.size(); i++) {
			System.out.println ((i+1)   +items.get(i).getName()+ items.get(i).getCost());
		}
		
		System.out.println (i+1 + "Return to Menu");
		printBanner ("");
		return promptForInt();//selectio
		//no create new item
		//no delete item
		//1. Snickers   1.00
		// make a choice.
		//service layer...
		//add money (BigDecimal money)
		//selectItem (STring itemID)
		//Change  returnChange()
		//Change buyItem()
		//update an item
		
		//unit testing is for dao and service layer
	}
	
	public int viewItem(Item item) {
		printBanner ("View Item");
		System.out.println ("1. Add to Shelf");
		System.out.println ("2. Return to Item");
		System.out.println ("3. View Shelf");
		printBanner ("");
		return promptForInt();
	}
	
	public int addItemtoShelf(Item item) {
		printBanner ("Add to Shelf");
		displayMsg ("How many " +  item.getName() +"do you want to add?");
		printBanner ("");
		return promptForInt();
	
	}
	
	public void displayMsg (String msg) {
		
	}
	
public void displayMsg (String msg, String banner) {
		printBanner (banner);
		System.out.println(msg);
		Scanner sc = new Scanner (System.in);
		System.out.println("Press Enter to Continue...");
		printBanner ("");
		sc.hasNextLine();
	}
	
	public int displayShelfMenu (Map <Item, Integer> shelf) {
		printBanner ("View Cart");
		Set <Item> keys = shelf.keySet();
		for(Item key: keys) {
			Integer qty = shelf.get(key);
			System.out.println(key.getName()+ qty+ " ");
		}
		
		System.out.println ("1. Remove Item");
		System.out.println ("2. Buy Item");
		System.out.println ("3. Return Menu");
		printBanner ("");
		
		return promptForInt();
		
	}
	
	public int displayBuyItemMenu(Map<Item, Integer> shelf) {
		Set <Item> items = shelf.keySet();
		int i=1;
		for (Item item: items) {
			System.out.println ((i+1) + ". "+ item.getName()+ "    "+item.getQuantity()+ "left    "+  "$  " +item.getCost());
			i++;
		}
		System.out.println (i + "Return to cart");
		printBanner ("");
		return promptForInt();
		
	}
	
	public int displayRemoveItemQty(Item item) {
		return 0;
	}
	
	public void displayCheckoutMessage(BigDecimal amount) {
		printBanner ("Payment");
		System.out.println ("You owe..."+ amount);
		System.out.println("Press enter to Continue");
		
		Scanner sc = new Scanner (System.in);
		sc.hasNextLine();
	}
	
}
