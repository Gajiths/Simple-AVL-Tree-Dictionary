package dictionary;

public class AvlNode {
	
	
	public Comparable element;
	public AvlNode left;
	public AvlNode right;
	int height;
	String discrption;
		
	
	public AvlNode(Comparable theElement){
		
		this(theElement,null,null,null);
		
	}

	public AvlNode(Comparable theElement, AvlNode lt, AvlNode rt,String dis) {
		this.element = theElement;
		this.left=lt;
		this.right=rt;
		this.height=0;
		this.discrption=dis;
	}
	

}
