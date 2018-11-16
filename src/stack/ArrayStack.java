package stack;

import array.Array;

/**
 * 
 * @author Administrator
 * arrayStack所有方法复杂度都为O(1)
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

	Array<E> array;
	
	public ArrayStack(int capacity){
		array = new Array<>(capacity);
	}
	
	public ArrayStack() {
		array = new Array<>();
	}
	
	public int getCapacity(){
		return array.getCapacity();
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		array.addLast(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return array.getLast();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Stack:");
		sb.append("[");
		for(int i = 0; i<array.getSize() -1;i++){
			sb.append(array.get(i));
			if(i != array.getSize() - 1)
				sb.append(",");
		}
		sb.append("] top");
		return sb.toString();
	}
	
	
}
