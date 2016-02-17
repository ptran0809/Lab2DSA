package lab2_v0;

public interface MyList<E> {
	public void add(int index, E e);

	public void add(E e);

	public void clear();

	public boolean contains(E e);

	public E get(int index);

	public int indexOf(E e);

	public boolean isEmpty();

	public void remove(int index);
	
	public void remove(Object e);

	public void set(int index, E e);

	public int size();

	public MyList<E> subList(int fromIndex, int toIndex) throws CloneNotSupportedException;

	public E[] toArray() throws CloneNotSupportedException;

	public void sway(int position1, int position2);

	public void shift(int position) throws CloneNotSupportedException;
	
	public String toString();
}
