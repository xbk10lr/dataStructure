package stack;

/**
 * ϵͳջ
 * �������������ӹ����Լ����߼��ĵ���
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
