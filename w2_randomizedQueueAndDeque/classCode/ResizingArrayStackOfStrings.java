public class ResizingArrayStackOfStrings {
	private String[1] s;
	private int N; // index of the next posotion

	public boolean isEmpty(){
		return N == 0;
	}

	public void push(String item){
		if (N == s.length)
			resize(2 * s.length); //when stack is full, double its size
		s[N] = item;
		N++;
	}

	public String pop(){
		String item = S[--N];
		S[N] = null; //free the space for unused items
		if (N > 0 && N == s.length / 4)
			resize(0.5 * s.length); //when stack is one-quarter full, halve its size
		return item;
	}

	private void resize(int capacity){
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = s[i];
		s = copy;
	}

}
