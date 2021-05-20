public class linkedList<T> {
	private Node<T> root;
	
	public linkedList(Node<T> root) {
		this.root = root;
	}

	public linkedList() {
		this.root = null;
	}
	
	private boolean isEmpty() {
		return root == null;
	}
	//inserts as a root if empty otherwise inserts as a child if the parent is not null
	public void insert(T data, Node<T> parent ) {
		Node<T> childTemp = new Node<T>(data, parent);
		if (isEmpty())  
			root = childTemp;
		else {
			if (parent == null)
				System.err.println(data + " must have a parent since it's not the root");
			else
				parent.setChildren(childTemp); 
		}
	}
	
	//gives the height/distance of the node from root
	private int height(Node<T> currentNode) {
		int height = 0;
		while (currentNode.getParent() != null) { 
			currentNode = currentNode.getParent();
			height++;
		}
		return height;
	}
	//algorithm to design and print the tree which is used in output()
	private void printAlgorithm(Node<T> rootNode) {
		for (int i = 0; i <= height(rootNode); i++)
			System.out.print("--");
		System.out.println(rootNode.getData());
		for (int i = 0; i < rootNode.getChildren().size(); i++) {
			if (rootNode.getChildren().size() != 0) 
				printAlgorithm(rootNode.getChildren().get(i));
			else
				break;
		}	
	}
	//called and uses print algorithm 
	public void output() {
		Node<T> tempRoot = root;
		if (tempRoot == null) {
			System.err.println("Tree is empty, please enter an element");
		}
		else
			printAlgorithm(tempRoot);
	}
	
	//this node stores the ancestor found temporary and returns it in searchfor method
	private Node<T> ancestorFound;
	// method looks for the data in each node and stores it in ancestorFound variable 
	private void searchAlgorithm(Node<T> currentNode,T data) {
		if (String.valueOf(currentNode.getData()).equalsIgnoreCase( String.valueOf(data))) {
			ancestorFound = currentNode;
		}
		for (int i = 0; i < currentNode.getChildren().size(); i++) {
			if (currentNode.getChildren().size() == 0) 
				break;
			searchAlgorithm(currentNode.getChildren().get(i),data);
		}
	}
	//uses searchAlgorithm to find the ancestor node
	public Node<T> SearchFor(T ancestor) {
		Node<T> temp = root;
		searchAlgorithm(temp, ancestor);
		if (String.valueOf(ancestorFound.getData()).equals(String.valueOf(ancestor)))
			return ancestorFound;
		else
			return null;
	}
	//deleting a node
	public void deleteNode(T ancestor) {
		Node<T> temp = root;
		searchAlgorithm(temp, ancestor);
		
		if (String.valueOf(ancestorFound.getData()).equals(String.valueOf(ancestor))) {
			ancestorFound.getParent().getChildren().remove(
					ancestorFound.getParent().getChildren().indexOf(
							ancestorFound));
		}
		else
			System.err.println("Node Not found");
		
	}
}
