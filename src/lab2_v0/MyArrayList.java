package lab2_v0;

import java.lang.reflect.Array;

public class MyArrayList<E extends copyable> implements MyList<E> {

	private Object[] arrayholder;
	private int size;
	private static final int DEFAULT_SIZE = 16;

	@SuppressWarnings("unchecked")
	public MyArrayList(int max_size) {
		this.size = 0;
		this.arrayholder = new Object[max_size];
	}

	public MyArrayList() {
		this(MyArrayList.DEFAULT_SIZE);

	}

	@Override
	public void add(int index, E e) {
		if (index <= this.size - 1 && index >= 0) {
			this.doShiftRight(index, 1);
			this.arrayholder[index] = e;
			this.size++;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	
	private void increaseMaxSize(){
		int newlength = this.arrayholder.length * 2;
		Object[] newArray = new Object[newlength];
		for (int i = 0; i < this.arrayholder.length; i++) {
			newArray[i] =  this.arrayholder[i];
		}
		this.arrayholder = newArray;
	}
	private void decreaseMaxSize(){
		int newlength = this.arrayholder.length / 2;
		Object[] newArray = new Object[newlength];
		for (int i = 0; i < this.size; i++) {
			newArray[i] =  this.arrayholder[i];
		}
		this.arrayholder = newArray;
	}
	
	@Override
	public void add(E e) {

		if (this.size < this.arrayholder.length) {

			this.arrayholder[size] = e;
			this.size++;
		} else {
			this.increaseMaxSize();
			this.arrayholder[this.size] = e;
			this.size++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.arrayholder = (E[]) new Object[MyArrayList.DEFAULT_SIZE];
		this.size = 0;
	}

	@Override
	public boolean contains(E e) {
		for (Object element : this.arrayholder) {
			if (element.equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index <= this.size - 1 && index >= 0) {
			return (E) this.arrayholder[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(E e) {
		for (int i = 0; i < this.size; i++) {
			if (this.arrayholder[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void remove(int index) {
		if (index <= this.size - 1 && index >= 0) {
			this.doShiftLeft(index, 1);
			this.arrayholder[this.size - 1] = null;
			this.size--;
			if(this.size < this.arrayholder.length/2){
				this.decreaseMaxSize();
			}
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public void set(int index, E e) {
		if (index <= this.size - 1 && index >= 0) {
			this.arrayholder[index] = e;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public MyList<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex <= this.size - 1 && fromIndex >= 0 && toIndex <= this.size - 1 && toIndex >= 0
				&& fromIndex < toIndex) {
			int newListSize = toIndex - fromIndex + 1;
			MyArrayList<E> returnList = new MyArrayList<E>(newListSize);
			for (int i = fromIndex; i <= toIndex; i++) {
				returnList.add((E) this.arrayholder[i]);
			}
			return returnList;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public E[] toArray() {
		return (E[]) this.arrayholder;
	}

	@Override
	public void sway(int position1, int position2) {
		if (position1 <= this.size - 1 && position1 >= 0 && position2 <= this.size - 1 && position2 >= 0
				&& position1 < position2) {
			E temp = (E) this.arrayholder[position1];
			this.arrayholder[position1] = this.arrayholder[position2];
			this.arrayholder[position2] = temp;

		} else {
			throw new IndexOutOfBoundsException();
		}

	}
	
	private void doShiftRight(int startIndex,int position){
		if((this.size + position)>this.arrayholder.length){
			this.increaseMaxSize();
		}
		for(int i = this.size;i>startIndex;i--){
			this.arrayholder[i] = this.arrayholder[i-1];
		}
		
	}
	private void doShiftLeft(int startIndex,int position){
		if((this.size - position)>this.arrayholder.length/2){
			this.decreaseMaxSize();
		}
		for(int i = startIndex;i<this.size;i++){
			this.arrayholder[i] = this.arrayholder[i+1];
		}
		
	}
	@Override
	@SuppressWarnings("unchecked")
	public void shift(int position) {
		int toRotate = Math.abs(position) % this.size;
		Object[] tempArray = new Object[toRotate];
		if (position > 0) {

			for (int i = this.size - toRotate; i < this.size; i++) {
				tempArray[i - (this.size - toRotate)] = (E) this.arrayholder[i];
			}
			for (int i = this.size - 1; i >= toRotate; i--) {
				this.arrayholder[i] = this.arrayholder[i - toRotate];
			}
			for (int i = 0; i < tempArray.length; i++) {
				this.arrayholder[toRotate - i-1] = tempArray[i];
			}
		} else if (position < 0) {
			for (int i = 0; i < toRotate; i++) {
				tempArray[i] = (E) this.arrayholder[i];
			}
			for (int i = toRotate; i < this.size; i++) {
				this.arrayholder[i - toRotate] = this.arrayholder[i];
			}
			for (int i = 0; i < tempArray.length; i++) {
				this.arrayholder[this.size - i-1] = tempArray[tempArray.length-1-i];
			}

		}
	}

	@Override
	public void remove(Object e) {
		this.remove(this.indexOf((E) e));
		this.size--;
		if(this.size < this.arrayholder.length/2){
			this.decreaseMaxSize();
		}
	}
	
	public String toString(){
		String s="";
		for(int i=0;i<this.size;i++){
			s = s+this.get(i).toString()+"\n";
		}
		return s;
	}
}
