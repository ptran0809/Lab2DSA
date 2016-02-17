package lab2_v0;

public class MyLinkedList<E extends copyable> implements MyList<E> {
	private class Node<E extends copyable> implements copyable {
		E e;
		Node<E> nextE = null;

		private Node(E e) {
			this.e = e;
		}

		private E getE() {
			return e;
		}

		private void setE(E e) {
			this.e = e;
		}

		private Node<E> getNextE() {
			return nextE;
		}

		private void setNextE(Node<E> nextE) {
			this.nextE = nextE;
		}

		public boolean equals(Node<E> e) {
			return this.getE().equals(e.getE());
		}

		public boolean isContain(E e) {
			return this.getE().equals(e);
		}

		@SuppressWarnings("unchecked")
		public Node<E> copy() throws CloneNotSupportedException {
			return new Node<E>((E) this.e.copy());
		}
		public String toString(){
			return this.e.toString();
		}

	}

	Node<E> element = null;
	int size;

	public MyLinkedList() {
		this.size = 0;
	}

	@Override
	public void add(int index, E e) {
		if (index >= 0 && index < this.size) {
			int c;
			if (this.size == 0) {
				this.element = new Node<E>(e);
			} else {
				Node<E> curr = this.element;
				Node<E> last = null;
				c = 0;
				while (c != index) {
					last = curr;
					curr = curr.getNextE();
					c++;
				}
				last.setNextE(new Node<E>(e));
				last.getNextE().setNextE(curr);
				curr = null;
				this.size++;

			}
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public void add(E e) {
		Node<E> curr = this.element;
		Node<E> last = null;
		while (curr != null) {
			last = curr;
			curr = curr.getNextE();
		}
		if (last == null) {
			this.element = new Node<E>(e);
			this.size++;
		} else {
			last.setNextE(new Node<E>(e));
			this.size++;
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(E e) {
		Node<E> curr = this.element;
		while (curr != null) {
			if (curr.isContain(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		Node<E> curr = this.element;
		if (index >= 0 && index < this.size) {
			return this.getNode(index).getE();
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	private Node<E> getNode(int index) {
		Node<E> curr = this.element;
		if (index >= 0 && index < this.size) {
			for (int i = 0; i < index; i++) {
				curr = curr.getNextE();
			}
			return curr;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		Node<E> curr = this.element;
		for (int i = 0; i < this.size; i++) {
			if (curr.isContain(e)) {
				return i;
			}
			curr = curr.getNextE();
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return (this.element == null);
	}

	@Override
	public void remove(int index) {
		Node<E> curr = this.element;
		Node<E> last = null;
		if (index >= 0 && index < this.size) {
			for (int i = 0; i < index; i++) {
				last = curr;
				curr = curr.getNextE();
			}
			last.setNextE(curr.getNextE());
			curr.nextE = null;
			curr = null;
			this.size--;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void set(int index, E e) {
		Node<E> curr = this.element;
		if (index >= 0 && index < this.size) {
			for (int i = 0; i < index; i++) {
				curr = curr.getNextE();
			}
			curr.setE(e);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public MyList<E> subList(int fromIndex, int toIndex) throws CloneNotSupportedException {
		MyLinkedList<E> newList = new MyLinkedList<E>();
		Node<E> newCurr = null;
		Node<E> curr = this.element;
		Node<E> last = this.element;
		if (fromIndex <= this.size - 1 && fromIndex >= 0 && toIndex <= this.size - 1 && toIndex >= 0
				&& fromIndex < toIndex) {
			for (int i = 0; i < toIndex; i++)
				try {
					{
						if (i == fromIndex) {
							newList.element = new Node<E>((E) curr.getE().copy());
							newCurr = newList.element;
						} else if (i > fromIndex) {
							newCurr.setNextE(new Node<E>((E) curr.getE().copy()));
							newCurr = newCurr.getNextE();
						}
						curr = curr.nextE;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
			throw new IndexOutOfBoundsException();
		}
		return newList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() throws CloneNotSupportedException {
		E[] array = (E[]) new Object[this.size];
		Node<E> curr = this.element;
		for (int i = 0; i < this.size; i++) {
			array[i] = (E) curr.getE().copy();
			curr = curr.nextE;
		}
		return array;
	}

	@Override
	public void sway(int position1, int position2) {
		Node<E> curr = this.element;
		Node<E> temp = null;
		Node<E> e1 = null;
		Node<E> e2 = null;
		int smallP, bigP;
		if (position1 <= this.size - 1 && position1 >= 0 && position2 <= this.size - 1 && position2 >= 0) {
			if (position1 < position2) {
				smallP = position1;
				bigP = position2;
			} else if (position1 > position2) {
				smallP = position2;
				bigP = position1;
			} else {
				return;
			}
			for (int i = 0; i <= bigP; i++) {
				if (i == (smallP - 1)) {
					e1 = curr;
				}
				if (i == bigP - 1) {
					e2 = curr;
				}
				curr = curr.nextE;
			}
			temp = e1.nextE;
			e1.nextE = e2.nextE;
			e2.nextE = temp;
			temp = temp.nextE;
			e2.nextE.nextE = e1.nextE.nextE;
			e1.nextE.nextE = temp;

		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public void shift(int position) throws CloneNotSupportedException {
		int toRotate = Math.abs(position) % this.size;

		Node<E> temp;
		Node<E> prev = null;
		Node<E> curr = this.element;
		if (position > 0) {
			System.out.println(this.size - toRotate);
			System.out.println("+++++++++++++++++++++++++=");
			for (int i = 0; i < this.size - toRotate-1; i++) {
				System.out.println(i);
				System.out.println(curr);
				curr = curr.nextE;
				
			}
			System.out.println("++++++++++++++++++++"+toRotate);
			temp = curr.nextE;
			curr.nextE = null;
			prev = curr;
			curr = temp;
			while (curr!= null) {
				prev = curr;
				curr = curr.nextE;
			}
			prev.nextE = this.element;
			this.element = temp;
		} else if (position < 0) {
			for (int i = 0; i < toRotate; i++) {
				curr = curr.nextE;
			}
			temp = curr.nextE;
			curr.nextE = null;
			curr = temp;
			while (curr!= null) {
				curr = curr.nextE;
			}
			curr.nextE = this.reverse(this.element);
			this.element = temp;
		}

	}

	private Node<E> reverse(Node<E> e) throws CloneNotSupportedException {
		Node<E> curr = e;
		Node<E> reverse = curr.copy();
		Node<E> temp = null;
		while (curr.nextE != null) {
			temp = curr.nextE;
			temp.setNextE(reverse);
			reverse = temp;
			curr = curr.nextE;
		}
		return reverse;

	}

	@Override
	public void remove(Object e) {
		this.remove(this.indexOf((E) e));
		
	}

}
