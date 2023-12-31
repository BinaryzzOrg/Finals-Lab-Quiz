import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
	// field variables
	private Node root;
	private Scanner sc;

	// root getter setter
	public Node getRoot() {
		return root;
	}// end method

	public void setRoot(Node root) {
		this.root = root;
	}// end method

	// insert
	public Node Insert(Node pointer, int key) {
		if (root == null) {// if current root is null
			// @formatter:off
			System.out.println("\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Error:			   ┇\n" +
							"┇ There is no root created yet.    ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Msg: 				   ┇\n" +
							"┇ \033[3mCreating key as new root...Done!\033[0m ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
			CreateRoot(key);// call create root
			return null;// stop insert method and return nothing
		} // end if

		if (pointer == null) {// insert condition
			pointer = new Node(key);// put the new key to pointer current node
			return pointer;// return the pointer thats added;
		} // end if

		// If the key to be inserted is less than the key of the current root
		if (key < pointer.getKey()) {
			// recursively insert the key into the left subtree of the current root.
			pointer.setLeftChild(Insert(pointer.getLeftChild(), key));

		} else if (key > pointer.getKey()) {// If the key is greater
			pointer.setRightChild(Insert(pointer.getRightChild(), key));// recursively insert it into the right subtree.
		} // end if else
		return pointer; // return the modified root
	}// end of method Node insert

	/*
	 * This is a method for displaying the nodes and printing it consecutively using
	 * Level Order Traversal
	 * 
	 * The Display method performs a level-order traversal of a binary tree starting
	 * from the root, printing the keys of each node. If the tree is empty (no
	 * root), it outputs an error message. Using a queue for efficient traversal,
	 * the method dequeues each node, prints its key, and enqueues its left and
	 * right children if present. The process continues until all nodes have been
	 * processed, resulting in a display of the binary tree's keys in a structured
	 * order.
	 */
	public void Display(Node pointer) {
		// Check if the root of the tree is null
		if (root == null) {
			System.out.print("No root available"); // Print an error message if the root is null
			return;
		} // end if

		Queue<Node> queue = new LinkedList<>(); // Initialize a queue for level-order traversal
		queue.add(getRoot()); // Enqueue the root node to start traversal

		while (!queue.isEmpty()) {
			Node current = queue.remove(); // Dequeue the current node
			System.out.print(current.getKey() + "  > "); // Print the key of the current node

			// Enqueue the left child if it exists
			if (current.getLeftChild() != null) {
				queue.add(current.getLeftChild());
			} // end if

			// Enqueue the right child if it exists
			if (current.getRightChild() != null) {
				queue.add(current.getRightChild());
			} // end if
		} // end while
	} // end method

	// This is a method for displaying the structure of the tree and its edges using
	// level order traversal
	/*
	 * Like the Display() method it uses the same logic, it stores the values of every nodes including null 
	 * values in a queue and printing it. If the node is null it adds a new node that has a value of 0 to the queue
	 * while if the node is not null then it adds the current node in the queue. If the node is null it prints a single 
	 * space length while if the node is not null it prints the value of node. Each printing has a space that is unique in each level,
	 * for example if the true height of the tree is 3, then we have three levels. The bottom level has a two space length 
	 * and multiply it by two in each level upward.
	 * 
	 */
	public void DisplayStructureTree(Node pointer) {
		if (root == null) {
			return;
		} // end if

		Queue<Node> queue = new LinkedList<>();
		queue.add(getRoot());

		int height = 0;
		do {
			int counter = queue.size();// get the size

			if (counter == 0) {// base case
				break;
			}
			// call this method to create spaces and store it in String space
			String space = createSpace(getHeight(root), height, "");

			// call this method to print the arrow lines each level
			printArrowLines(height, counter, queue, space);

			System.out.println();
			while (counter > 0) {
				System.out.print(space);// print the String space
				Node current = queue.remove();

				if (current.getKey() == 0) {// if the node is null
					System.out.print(" ");
				} else {
					System.out.print(current.getKey());
				} // end if else

				// adding the nodes to the queue: if the node is null, add new node that
				// contains 0 value
				if (current.getLeftChild() != null) {
					queue.add(current.getLeftChild());
				} else {
					queue.add(new Node(0));
				} // end if else

				if (current.getRightChild() != null) {
					queue.add(current.getRightChild());
				} else {
					queue.add(new Node(0));
				} // end if else
				counter--;
				System.out.print(space);// print the String space
			} // end while
			System.out.println();
			height++;

		} while (height <= getHeight(root));// base case
	}// end method

	// lca
	/*
	 * The LCA method needs a pointer node, and a node A and B for the method to
	 * find their lowest ancestor. It first check if the pointer is null/if its left
	 * == the key or its right == the key, if the key was found it will instantly
	 * return the node pointer if that value. Now if the key was not found by the
	 * first block of code, the next codes will. Those nodes stores the value for
	 * each side, if no key is found it returns a null and if a key is found it
	 * returns that key.
	 */
	public Node LowestCommonAncestor(Node pointer, Node A, Node B) {
		// check if pointer is null or pointer key is equal to A or B keys
		if (pointer == null || pointer.getKey() == A.getKey() || pointer.getKey() == B.getKey()) {
			return pointer;
		} // end if

		Node tempLeftChild = LowestCommonAncestor(pointer.getLeftChild(), A, B);// store leftChild for checking
		Node tempRightChild = LowestCommonAncestor(pointer.getRightChild(), A, B);// store rightChild for checking

		if (tempLeftChild == null) {// if leftChild is null, return rightChild
			return tempRightChild;

		} else if (tempRightChild == null) {// if rightChild is null, return leftChild
			return tempLeftChild;
		} // end if else

		return pointer;// if both is not null then it is the node that we are trying to find
	}// end method

	// custom methods
	/*
	 * This method just creates a root if called. A key is passed as parameter to
	 * set that key as new node.
	 */
	public void CreateRoot(int key) {
		Node tempNode = new Node(key);
		root = tempNode;
		Main.Display();
	}// end method

	/*
	 * This method checks if the root has no child, meaning the LCA is not possible
	 */
	public boolean IsTreeNotAvailable(Node pointer) {
		return pointer == null || pointer.getLeftChild() == null && pointer.getRightChild() == null;
	}// end method

	// check if the key that is passed in, is available in the tree
	/*
	 * This method checks the tree if it contains the key that is passed in this
	 * method. If no key is found, it returns null if key is found, it returns that
	 * node.
	 */
	public Node IsKeyAvailable(Node pointer, int key) {
		while (key != pointer.getKey()) {
			if (key < pointer.getKey()) {
				pointer = pointer.getLeftChild();
			} else if (key > pointer.getKey()) {
				pointer = pointer.getRightChild();
			} // end if else

			if (pointer == null) {
				return null;
			} // end if
		} // end while

		return pointer;
	}// end method

	/* finding the height of the tree
	 * 
	 * This method uses recursive function to traverse the left child and right child nodes of the tree
	 * Compare which has the highest values between left nodes and right nodes 
	 * and return the value obtained add 1 because we include the root 
	 */
	public int getHeight(Node pointer) {
		if (pointer != null) {
			// compare left height to right height and return the highest number
			return Math.max(getHeight(pointer.getLeftChild()), getHeight(pointer.getRightChild()) + 1); // add 1 in each traversal
		} // end if

		return 0; // if null return 0
	}// end method

	// creating spaces to adjust each printing of nodes and arrow lines for the structure
	/*
	 * This method starts with getting the total number of levels (true height) of the tree.
	 * Think of the bottom level of the the tree has a two space length, 
	 * and every level upward is multiplied by two so that we can create a triangle structure
	 * The parameter height in this method is the determinant on what level we are now in the tree
	 * 
	 */
	public String createSpace(int trueHeight, int height, String spacing) {
		int space = 1;
		// the bottom level of the tree has one space and each level upward is
		// multiplied the space by 2
		for (int i = height; i < trueHeight; i++) {
			space *= 2;
		} // end for

		// add one tab space
		for (int i = 0; i < space; i++) {
			spacing += "	";
		} // end for

		return spacing;
	}// end method

	// printing the arrow lines in each level
	/*
	 * This method starts with getting the node value and determining whether it is left node or right node
	 * 
	 * We can determine whether a node is right or left by thinking that in each level of the tree we have 
	 * an even number nodes including the null/zero values except for the level zero or the root.
	 * With this in mind we can use the counter parameter which is the total number of nodes in 
	 * each level. The counter value decreases as it prints "/" or "\" in the loop. 
	 * Counter parameter has a starting value of even, and each even value is where the left node located and 
	 * every odd value is where the right located in each level.
	 */
	public void printArrowLines(int height, int counter, Queue<Node> queue, String space) {
		if (height != 0) {

			while (counter > 0) {//base case
				Node current = queue.remove();

				if (current.getKey() != 0) {
					if (counter % 2 == 0) {//if counter is even number, it is left, print slash
						System.out.print(space + "/");
					} // end if
					if (counter % 2 != 0) {//if counter is odd number, it is right, print back slash 
						System.out.print(space + "\\");
					} // end if
					System.out.print(space);
				} else { // if the node is equal to zero or null
					System.out.print(space + " ");
					System.out.print(space);
				} // end if else
				queue.add(current);// add the current node back again to the queue
				counter--;

			} // end while
			counter = queue.size();// make the counter go back to its original value
		} // end If
	}// end method
}// end class