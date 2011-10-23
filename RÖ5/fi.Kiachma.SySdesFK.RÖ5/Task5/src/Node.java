package src;

import java.util.ArrayList;
import java.util.Iterator;

public class Node {
	private ArrayList<Node> nodes;

	public Node() {
		nodes = new ArrayList<Node>();
	}

	public void addChild(Node n) {
		assert(n != this);
		assert(nodes.contains(n) == false);
		nodes.add(n);
	}

	public void removeChild(int i) {
		assert(i >= 0);
		assert(i < nodes.size());
		nodes.remove(i);
	}

	public int childCount() {
		return nodes.size();
	}

	public Iterator createShallowNodeIterator() {
		return nodes.iterator();
	}

	public Iterator<Node> createDFSNodeIterator() {
		return new NodeDFSIterator(this);
	}

}
