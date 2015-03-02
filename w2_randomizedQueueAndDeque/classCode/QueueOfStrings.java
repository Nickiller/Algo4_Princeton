public abstract class QueueOfStrings{
	QueueOfStrings(){}
	abstract void enqueue(String item);
	abstract String dequeue();
	abstract boolean isEmpty(){};
	abstract int size(){};
}
