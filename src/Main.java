import java.util.Scanner;

public class Main {

	// field variables
	private static Scanner sc;
	private static BinarySearchTree bst = new BinarySearchTree();

	public static void main(String[] args) {
		MenuScreen();
	}// end main

	// methods
	public static void MenuScreen() {
		sc = new Scanner(System.in);

		PrintMenuChoices();

		switch (OperationMenu()) {
		case 1:// insert
			System.out.print("Enter Element To Insert 》 ");
			bst.Insert(bst.getRoot(), OperationMenu());
			break;
		case 2:// Display
			Display();
			break;
		case 3:// Lowest Common Ancestor

			if (bst.IsTreeNotAvailable(bst.getRoot())) {// check if a tree is available
			// @formatter:off
			System.out.println("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Error:			   	  ┇\n" +
								"┇ There is no tree available yet.  	  ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Msg: 				   	  ┇\n" +
								"┇ 	\033[3mPlease create a tree first.\033[0m 	  ┇\n" +
								"┇ \033[3m(Tree: 1 Root 1 leftChild 1 rightChild)\033[0m ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
				break;
			} // end if

			// If there is a tree available, then run the LCA code below
			// @formatter:off
			System.out.print("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ LCA:			    		  ┇\n" +
								"┇ Please put values to Node A and Node B. ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Input: \n" +
								"┇ Node A 》 ");
			// @formatter:on
			Node A = new Node(sc.nextInt());// get value for node A

			System.out.print("┇ Node B 》 ");
			Node B = new Node(sc.nextInt());// get value for node B
			System.out.println("⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");

			bst.LowestCommonAncestor(bst.getRoot(), A, B);// call LCA method to get the LCA
			break;
		case 4:// exit
			System.out.println("「Exiting now...」");
			System.exit(0);
			break;
		default:
			// @formatter:off
			System.out.println("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Error:			    ┇\n" +
								"┇ Input is not a valid Menu choice. ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Msg: 				    ┇\n" +
								"┇ \033[3mPlease enter only 1 to 4 as input\033[0m	┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
			break;
		}// end switch
		MenuScreen();// loop MenuScreen
	}// end method

	public static int OperationMenu() {// basically scans and returns the user input
		sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			int key = sc.nextInt();
			return key;
		} // end if
		// @formatter:off
			System.out.println("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Error:			    ┇\n" +
								"┇ Input is not an integer value.    ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Msg: 				    ┇\n" +
								"┇ \033[3mPlease enter integer/s input only\033[0m	┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
		PrintMenuChoices();
		return OperationMenu();
	}// end method

	public static void Display() {
		// @formatter:off
			System.out.print("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Display:			   ┇\n" +
								"┇ Binary Search Tree    	   ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" + 
								"┇ Output: ");
			// @formatter:on
		bst.Display(bst.getRoot());
		System.out.println("\n⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
	}// end method

	public static void PrintMenuChoices() {
		//@formatter:off
		System.out.print("" + 
						"━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Insert	┃\n" +
						"┃ 【 2 】 Display	┃\n" + 
						"┃ 【 3 】 LCA 	┃\n" +
						"┃ 【 4 】 Exit 	┃\n" + 
						"━━━━━━━━━━━━━━━━━\n" + 
						"》 ");
		//@formatter:on
	}// end method

}// end class
