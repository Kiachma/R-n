package src;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;

import org.junit.Test;

public class NodeTest {

	@Test
	public void test1() {
		Node n1 = new Node();
		Iterator<Node> i = n1.createDFSNodeIterator();
		assertEquals(i.hasNext(), true);
		assertEquals(i.hasNext(), true);
		assertEquals(i.next(), n1);
		assertEquals(i.hasNext(), false);
		assertEquals(i.hasNext(), false);
		System.out.println("test1 OK");
	}

	@Test
	public void test2() {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		n1.addChild(n2);
		n2.addChild(n3);
		n1.addChild(n4);
		n1.addChild(n5);
		Iterator<Node> i = n1.createDFSNodeIterator();
		assertEquals(i.next(), n1);
		assertEquals(i.next(), n2);
		assertEquals(i.next(), n3);
		assertEquals(i.next(), n4);
		assertEquals(i.next(), n5);
		assertEquals(i.hasNext(), false);
		assertEquals(i.hasNext(), false);
		System.out.println("test2 OK");
	}

	@Test
	public void test3() {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		n1.addChild(n2);
		n1.addChild(n3);
		n1.addChild(n4);
		n1.addChild(n5);
		Iterator<Node> i = n1.createDFSNodeIterator();
		assertEquals(i.next(), n1);
		assertEquals(i.next(), n2);
		assertEquals(i.next(), n3);
		assertEquals(i.next(), n4);
		assertEquals(i.next(), n5);
		assertEquals(i.hasNext(), false);
		assertEquals(i.hasNext(), false);
		System.out.println("test3 OK");
	}

	@Test
	public void test4() {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		n1.addChild(n2);
		n2.addChild(n3);
		n2.addChild(n4);
		n2.addChild(n5);
		Iterator<Node> i = n1.createDFSNodeIterator();
		assertEquals(i.next(), n1);
		assertEquals(i.hasNext(), true);
		assertEquals(i.hasNext(), true);
		assertEquals(i.next(), n2);
		assertEquals(i.hasNext(), true);
		assertEquals(i.hasNext(), true);
		assertEquals(i.next(), n3);
		assertEquals(i.hasNext(), true);
		assertEquals(i.hasNext(), true);
		assertEquals(i.next(), n4);
		assertEquals(i.next(), n5);
		assertEquals(i.hasNext(), false);
		System.out.println("test4 OK");
	}

	@Test
	public void test5() {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		n1.addChild(n2);
		n1.addChild(n3);
		Iterator<Node> i = n1.createDFSNodeIterator();
		assertEquals(i.next(), n1);
		assertEquals(i.hasNext(), true);
		assertEquals(i.hasNext(), true);
		assertEquals(i.next(), n2);
		assertEquals(i.hasNext(), true);
		assertEquals(i.hasNext(), true);
		n3.addChild(n4);
		assertEquals(i.next(), n3);
		assertEquals(i.hasNext(), true);
		assertEquals(i.hasNext(), true);
		assertEquals(i.next(), n4);
		assertEquals(i.hasNext(), false);
		System.out.println("test5 OK");
	}

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("NodeTest");
	}
}