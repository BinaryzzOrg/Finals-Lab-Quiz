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

		System.out.print(PrintMenuChoices());

		switch (GetUserInput(PrintMenuChoices())) {// ask for user input while passing in the menu choices printing
		case 1:// insert
			System.out.print("Enter An Integer Element To Insert 》 ");
			bst.Insert(bst.getRoot(), GetUserInput("Enter An Integer Element To Insert 》 "));
			break;
		case 2:// Display
			Display();
			break;
		case 3:// Lowest Common Ancestor
			LCA();
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

	public static void LCA() {// method to operate the LCA
		if (bst.IsTreeNotAvailable(bst.getRoot())) {// check if a tree is available
			// @formatter:off
			System.out.println("\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Error:			   	  ┇\n" +
							"┇ There is no tree available yet.  	  ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Msg: 				   	  ┇\n" +
							"┇      \033[3mPlease create a tree first.\033[0m 	  ┇\n" +
							"┇ \033[3m(Tree:Root and leftChild or rightChild)\033[0m ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
			return;// return if no tree is available
		} // end if

		// If there is a tree available, then run the LCA code below
		System.out.print(PrintLCA_Menu());
		Node A = LCA_NodeCheck(PrintLCA_Menu(), "A", 0);// checks if input is valid and is available on tree

		System.out.print(PrintLCA_Menu() + A.getKey() + "\n┇ Node B 》 ");
		Node B = LCA_NodeCheck(PrintLCA_Menu() + A.getKey() + "\n┇ Node B 》 ", "B", A.getKey());

		Node LCA = bst.LowestCommonAncestor(bst.getRoot(), A, B);// call LCA method to get the LCA
		// @formatter:off
			System.out.print("" +
							"┇ Output: \n" +
							"┇ LCA: " + LCA.getKey() + "\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
	}// end method

	// check if node is on tree and can be put on node A or B
	public static Node LCA_NodeCheck(String prompt, String nodeOf, int nodeAValue) {
		Node node = new Node(GetUserInput(prompt));// gets user input and checks if valid
		if (bst.IsKeyAvailable(bst.getRoot(), node.getKey()) != null) {// checks user the key if its on the tree
			return node;// if it is, return this node
		} // end if

		// if key is valid but not available on the tree, run code below
		// @formatter:off
			System.out.print("\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Error:			   	     ┇\n" +
							"┇ Value of node "+ nodeOf +" was not found. 	     ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Msg: 				   	     ┇\n" +
							"┇ \033[3mThe value/s of the tree are the following:\033[0m ┇\n" +
							"┇ ");
								bst.Display(bst.getRoot());//display available nodes on the tree
			System.out.println("\n⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
		// @formatter:on

		if (nodeOf == "A") {// checks if node A is the one using the method
			System.out.print(PrintLCA_Menu());
		} else {// else, its node B
			System.out.print(PrintLCA_Menu() + nodeAValue + "\n┇ Node B 》 ");
		} // end if else

		return LCA_NodeCheck(prompt, nodeOf, nodeAValue);// recursive call this method to ask user again
	}// end method

	public static int GetUserInput(String prompt) {// basically scans and returns the user input
		sc = new Scanner(System.in);

		if (sc.hasNextInt()) {// check if input is integer
			int key = sc.nextInt();// store it in key if it is
			return key;// return that value
		} // end if

		// If user tried to enter non integer input, this code below runs
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
		System.out.print(prompt);// ask user again for input
		return GetUserInput(prompt);// call this method again to get the next user input
	}// end method

	public static void Display() {// displays the nodes in the tree
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

	public static String PrintLCA_Menu() {// for menu looks only
		// @formatter:off
		String menuAsString = "\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ LCA:			    		  ┇\n" +
							"┇ Please put values to Node A and Node B. ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Input: \n" +
							"┇ Node A 》 ";
		// @formatter:on
		return menuAsString;
	}// end method

	public static String PrintMenuChoices() {// for menu looks only
		//@formatter:off
		String menuAsString = "" + 
						"━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Insert	┃\n" +
						"┃ 【 2 】 Display	┃\n" + 
						"┃ 【 3 】 LCA 	┃\n" +
						"┃ 【 4 】 Exit 	┃\n" + 
						"━━━━━━━━━━━━━━━━━\n" + 
						"》 ";
		//@formatter:on
		return menuAsString;
	}// end method
}// end class
