package queue;

import array.Array;

/**
 * ArrayQueue����dequeue�������������Ӷ�ΪO(1)
 * dequeue���Ӷ�ΪO(n)
 * @author Administrator
 * �������
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
	
	private Array<E> array;
	
	public ArrayQueue() {
		array = new Array<>();
	}
	
	public  ArrayQueue(int capacity){
		array = new Array<>(capacity);
	}
	
	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	public E dequeue() {
		return array.removeFirst();
	}


	@Override
	public E getFront() {
		return array.getFirst();
	}

	public int getCapacity(){
		return array.getCapacity();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: ");
		sb.append("front [");
		for(int i=0;i<array.getSize()-1;i++){
			sb.append(array.get(i));
			if(i != array.getSize() - 1)
				sb.append(",");
		}
		sb.append("] tail");
		
		return sb.toString();
	}
}
