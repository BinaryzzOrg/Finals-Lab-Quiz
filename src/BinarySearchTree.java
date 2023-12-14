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
			// call this method to print the spaces
			String list = createSpace(getHeight(root), height, "");

			// call this method to print the arrow lines each level
			printArrowLines(height, counter, queue, list);

			System.out.println();
			while (counter > 0) {
				System.out.print(list);// print the space
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
				System.out.print(list);// print the space
			} // end while
			System.out.println();
			height++;

		} while (height <= getHeight(root));// base case
	}// end method

	// lca
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
	public void CreateRoot(int key) {
		sc = new Scanner(System.in);// create sc
		Node tempNode = new Node(key);// create tempNode to store key value
		root = tempNode;// set tempNode as root
		Main.Display();// display new root
	}// end method

	// check if root is null and doesn't have left or right child
	public boolean IsTreeNotAvailable(Node pointer) {
		return pointer == null || pointer.getLeftChild() == null && pointer.getRightChild() == null;
	}// end method

	// check if the key that is passed in, is available in the tree
	public Node IsKeyAvailable(Node pointer, int key) {
		while (key != pointer.getKey()) {// goes until key is found on the tree or pointer reaches null
			if (key < pointer.getKey()) {// if key thats passed in is lessthan than pointer key
				pointer = pointer.getLeftChild();// go to left
			} else if (key > pointer.getKey()) {// else if key is greater than pointer key
				pointer = pointer.getRightChild();// go to right
			} // end if else

			if (pointer == null) {// if pointer reaches null
				return null;// it means, the key that was passed in was not found
			} // end if
		} // end while

		return pointer;// returns the key thats found
	}// end method

	// get the height of the tree
	public int getHeight(Node node) {
		if (node != null) {
			// compare left height to right height and return the highest number + 1
			return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()) + 1);
		} // end if

		return 0; // if null return 0
	}// end method

	// creating spaces to adjust each printing of nodes
	public String createSpace(int trueHeight, int height, String spacing) {
		int space = 1;
		// the bottom level of the tree has one space and each level upward is
		// multiplied the space by 2
		for (int i = height; i < trueHeight; i++) {
			space *= 2;
		} // end for

		// add space
		for (int i = 0; i < space; i++) {
			spacing += "	";
		} // end for

		// make the space go back to its original value
		for (int i = height; i < trueHeight; i++) {
			space /= 2;
		} // end for

		return spacing;
	}// end method

	// printing the arrow lines in each level
	public void printArrowLines(int height, int counter, Queue<Node> queue, String list) {
		if (height != 0) {
			int index = 0;

			while (counter > 0) {// base case
				index++;
				Node current = queue.remove();

				if (current.getKey() != 0) {
					if (index % 2 != 0) {// if the node is left child
						System.out.print(list + "/");
					} // end if
					if (index % 2 == 0) {// if the node is right child
						System.out.print(list + "\\");
					} // end if
					System.out.print(list);
				} else { // if the node is equal to zero or null
					System.out.print(list + " ");
					System.out.print(list);
				} // end if else
				queue.add(current);// add the current node back again to the queue
				counter--;

			} // end while
			counter = queue.size();// make the counter go back to its original value
		} // end If
	}// end method
}// end class