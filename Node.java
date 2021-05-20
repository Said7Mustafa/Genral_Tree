import java.util.ArrayList;

public class Node<T> {
	private T data;
	private Node<T> parent;
	private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
	
	public Node(T data, Node<T> person) {
		super();
		this.data = data;
		this.parent  = person;
		
	}
	public Node() {
		super();
		this.data = null;
		this.parent = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getParent() {
		return parent;
	}
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	public ArrayList<Node<T>> getChildren() {
		return children;
	}
	public void setChildren( Node<T> child) {
		this.children.add(child);
	}
}
