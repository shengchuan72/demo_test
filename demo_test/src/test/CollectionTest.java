package test;

import java.util.ArrayList;
// 冲突解决了吗
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class CollectionTest {

	public static void main(String args[]){
		
		HashMap map = new HashMap();
		// fjdish谁知道呢！！
		Hashtable table = new Hashtable();
		
		HashSet set = new HashSet();
		set.add("123");
		set.add("123");
		set.add("123");
		TreeSet tree = new TreeSet();
		tree.add("adf");
		tree.add("aaset");
		tree.headSet("add");
		System.out.println("tree"+ tree);
		ArrayList list = new ArrayList();
		
		LinkedList<Integer> linked = new LinkedList<Integer>();
		linked.add(0, 1);
		linked.add(0, 2);
		linked.add(0, 3);
		linked.offer(6);
		linked.offer(null);
		linked.offer(null);
		linked.offer(8);
		linked.add(7);
		System.out.println(linked);
		System.out.println(linked.peek());
		System.out.println(linked.peek());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked);
		
		Stack stack = new Stack();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		Object peek = stack.peek();
		System.out.println(peek);
		System.out.println(peek);
		System.out.println(peek);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		MyStack myStack = new MyStack();
		myStack.push(321);
		myStack.push(21);
		myStack.push(1);
		System.out.println();
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.peek());
		System.out.println(myStack.empty());
		myStack.empty();
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}

class MyStack{
	private Stack a = new Stack();
	
	public Object pop() {
		if(!empty()){
			
			return a.pop();
		}
		return null;
	}
	
	public Object push(Object o) {
		return a.push(o);
	}
	
	public Object peek() {
		return a.peek();
	}
	
	public boolean empty() {
		return a.empty();
	}
}
