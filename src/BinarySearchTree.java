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

	// display
	public void Display(Node pointer) {
		if (root == null) {// if root is null then show an error
			System.out.print("\033[3mNo root available\033[0m		   ┇");
			return;
		} // end if

		Queue<Node> queue = new LinkedList<>();
		queue.add(getRoot());

		while (!queue.isEmpty()) {
			Node current = queue.remove();
			System.out.print(current.getKey() + " ▶ ");

			if (current.getLeftChild() != null) {
				queue.add(current.getLeftChild());
			} // end if

			if (current.getRightChild() != null) {
				queue.add(current.getRightChild());
			} // end if
		} // end while
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

}// end class
