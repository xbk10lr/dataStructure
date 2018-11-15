package array;
/*
 * 复杂度分析：
 * 
 * public static int sum(int[] nums){
 * 			int sum = 0;
 * 			for(int num: nums)
 * 				sum += num;
 * 			reutrn sum;
 * }
 * 
 * 复杂度：O(n)   n是nums的元素个数 算法和n呈线性关系
 * 实际时间T=c1*n+c2
 * T=1*n*n+o   O(n^2)
 * T=2*n*n+300n+10   O(n^2)
 * 渐进时间复杂度 描述n趋近于无穷的情况
 * O(1)表示时间复杂度与元素的多少没有关系
 * 算法复杂度分析的时候通常关注最糟糕的情况
 * 
 * resize的复杂度分析
 * resize的均摊复杂度是O(1)
 * 
 * 复杂度震荡
 * 出现问题的原因：removeLast时resize过于着急
 * 解决方案：Lazy
 * 
 */
public class Array<E> {
	
	private E[] data;
	
	private int size;
	
	public Array(int capacity){
		data = (E[])new Object[capacity];
		size = 0;
	}
	
	public Array(){
		this(10);
	}
	
	public int getSize(){
		return size;
	}
	
	public int getCapacity(){
		return data.length;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/*
	 * O(1)
	 * 
	 */
	public void addLast(E e){
		add(size, e);
	}
	
	/*
	 * O(n)
	 */
	public void addFirst(E e){
		add(0,e);
	}
	
	/*
	 * O(n/2)=O(n)
	 */
	public void add(int index, E e){
		
		if(index < 0 || index > size)
			throw new IllegalArgumentException();
		
		if(size == data.length)
			resize(2*data.length);
		
		for(int i=size-1;i>=index;i--)
			data[i+1] = data[i];
		data[index] = e;
		size ++;
	}
	
	private void resize(int newCapacity) {
		// TODO Auto-generated method stub
		E[] newData = (E[]) new Object[newCapacity];
		for(int i = 0;i<size;i++)
			newData[i] = data[i];
		data = newData;
	}

	public E get(int index){
		if(index <0 || index >= size)
			throw new IllegalArgumentException();
		return data[index];
	}
	
	public void set(int index, E e){
		if(index <0 || index >= size)
			throw new IllegalArgumentException();
		data[index] = e;
	}
	
	public boolean contains(E e){
		for(int i=0;i<size;i++){
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	
	public int find(E e){
		for(int i=0;i<size;i++){
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}
	
	public E remove(int index){
		if(index <0 || index >= size)
			throw new IllegalArgumentException();
		E rem = data[index];
		for(int i=index+1; i<size; i++)
			data[i-1] = data[i];
		size -- ;
		data[size] = null;
		if(size == data.length / 4 && data.length /2 !=0)
			resize(data.length / 2);
		return rem;
	}
	
	public E removeFirst(){
		return remove(0);
	}
	
	public E removeLast(){
		return remove(size-1);
	}
	
	public void removeElement(E e){
		int index = find(e);
		if(index != -1)
			remove(index);
	}
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("Array: size = "+size+", capacity = "+data.length);
		res.append("\r");
		res.append("[");
		for(int i = 0;i<size;i++){
			res.append(data[i]);
			if(i != size-1)
				res.append(",");
		}
		res.append("]");
		return res.toString();
	}
	
	public E getLast(){
		return get(size -1);
	}
	
	public E getFirst(){
		return get(0);
	}
}
