package stack;

/**
 * 系统栈
 * 解决计算机领域子过程以及子逻辑的调用
 * @author Administrator
 *
 * @param <E>
 */
public interface Stack<E> {
	
	int getSize();
	boolean isEmpty();
	void push(E e);
	E pop();
	E peek();
	
}
