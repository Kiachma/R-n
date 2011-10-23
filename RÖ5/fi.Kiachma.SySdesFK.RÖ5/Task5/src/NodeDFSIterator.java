package src;

import java.util.Iterator;
import java.util.Stack;

public class NodeDFSIterator implements Iterator<Node> {

	private Node nextnode;
	private Stack<Node> nextNodes;	//stack to keep track of nextNodes
	private Stack<Node> children; //for swapping the children
	private Iterator it;	//to iterate over child elements

	NodeDFSIterator(Node root) {
		nextNodes = new Stack<Node>();
		children = new Stack<Node>(); 
		nextNodes.push(root);
	}

	public Node next() {
		nextnode = nextNodes.pop();		
		it = nextnode.createShallowNodeIterator();	

		while (it.hasNext()) {					
			children.push((Node) it.next());	
		}
		while (!children.empty()) {			
			nextNodes.add(children.pop());		
		}	
		return nextnode;
	}

	public boolean hasNext() {
		if (!nextNodes.empty()){
			return true;
		} else{
			return false;
		}

	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}