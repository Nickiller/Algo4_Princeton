/*STACK:
 *A trivial implementation using array with a fixed capacity.
*/


public class FixedCapacityStackOfStrings {
	private String[] s;
	private int N; // index of the next posotion

	public FixedCapacityStackOfStrings(int capacity){
		s = new String[capacity];
	}

	public boolean isEmpty(){
		return N == 0;
	}

	public void push(String item){
		s[N] = item;
		N++;
	}

	public String pop(){
		String item = S[--N];
		S[N] = null; // free the space for unused items
		return item;
	}


}
