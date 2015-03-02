public class LinkedGenericStack<Item>{
	private Node first = null;
	private class Node{
		Item item;
		Node next;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		System.out.println("push:"+item);
	}

	Item pop(){
		Item item = first.item;
		first = first.next;
		return item;
	}

	public void printStack(){
		Node tmp = new Node();
		tmp = first;
		while (tmp != null) {
			System.out.println(tmp.item);
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		String[] str = {"one","two","three"};
		LinkedGenericStack<String> stack = new LinkedGenericStack<String>();
		stack.push(str[0]);
		stack.push(str[1]);
		stack.push(str[2]);
		stack.printStack();
	}
}
