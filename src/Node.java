
public class Node {
	// field variables
	private int key;
	private Node leftChild;
	private Node rightChild;

	public Node(int key) {
		this.key = key;
		this.leftChild = null;
		this.rightChild = null;
	}// end constructor

	public int getKey() {
		return key;
	}// end method

	public void setKey(int key) {
		this.key = key;
	}// end method

	public Node getLeftChild() {
		return leftChild;
	}// end method

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}// end method

	public Node getRightChild() {
		return rightChild;
	}// end method

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}// end method

}// end class