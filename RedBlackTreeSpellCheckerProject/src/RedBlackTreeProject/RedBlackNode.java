package RedBlackTreeProject;


public class RedBlackNode {
	public static int BLACK = 0;
	public static int RED = 1;
	private RedBlackNode p;
	private RedBlackNode lc;
	private RedBlackNode rc;
	private String data;
	private int color;

	
	
	// constructor
	
	
	public RedBlackNode(String data, int color, RedBlackNode parent, RedBlackNode leftchild, RedBlackNode rightchild ) {
		this.p = parent;
		this.lc = leftchild;
		this.rc = rightchild;
		this.color = color;
		this.data = data;
	}
	

	
	
	//return a string representation of the node
	public String toString(){
		StringBuilder sb = new StringBuilder();
        sb.append("[Data: ").append(this.data).append(", Color: ").
                append(this.color == BLACK ? "Black" : "Red").append(", Parent: ").
                append(this.p.getData()).append(", Left Child: ").
                append(this.lc.getData()).append(", RightChild: ").
                append(this.rc.getData()).append("]");
        return sb.toString();
	}
	
	//method return color
	public int getColor() {
		return this.color;
	}
	
	//return the data in the node
	public String getData(){
		return this.data;
	}
	
	//return the left child of the node
	public RedBlackNode getLc() {
		return this.lc;
	}
	
	//return the right child of the node
	public RedBlackNode getRc() {
		return this.rc;
	}
	
	// return the parent of the node
	public RedBlackNode getP() {
		return this.p;
	}
	
	// set the color of the node
	public void setColor(int color) {
		this.color = color;
	}
	
	// set the data of this node
	public void setData(java.lang.String data) {
		this.data  = data;
	}
	
	// set parent of the node
	public void setP(RedBlackNode p) {
		this.p = p;
	}
	
	// set the left child of the node
	public void setLc(RedBlackNode node) {
		this.lc = node;
	}
	
	// set the right child of the node
	public void setRc(RedBlackNode node) {
		this.rc = node;
	}
	
	
}
