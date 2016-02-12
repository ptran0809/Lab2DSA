package lab2_v0;

public class MyCircularLinkedList<E> implements MyList<E> {
	
	private class Node {
		private E item;
		private Node next;
		
		public Node(E item, Node next) {
			this.item = item;
			this.next = next;
		}
		public Node(E e) {
			this.item = item;
		}
		public E getItem() {
			return item;
		}
		public void setItem(E e) {
			item = e;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node n) {
			next = n;
		}
		public boolean equals(Node n) {
			if(n.getItem() == item && n.getNext() == next) {
				return true;
			}
			else {
				return false;
			}
		}
	}	
	
	private int numItems;
	private Node head = null;
	private Node tail = null;
	private Node curr = null;
	private Node prev = null;
	
	public MyCircularLinkedList() {
		tail.setNext(head);
		head.setNext(tail);
		curr = head;
		prev = tail;
	}

	public void add(E e) {
		if(head != null && (head.getNext() == null || head.getNext().equals(tail))) {
			Node n = new Node(e);
			n.setNext(tail);
			head.setNext(n);
			curr = n;
			prev = head;
		}
		if(head == null) {
			head = new Node(e);
			curr = head;
		}
		else {
			Node newNode = new Node(e);
			newNode.setNext(curr);
			prev.setNext(newNode);
		}
		numItems++;
	}
	
	public void add(int index, E e) {
		Node n = new Node(e);
		curr = head;
		prev = tail;
		for(int i = 0; i < index; i++) {
			if(curr.getNext() == null || curr.getNext().equals(tail)) {
				curr.setNext(n);
				n.setNext(tail);
				return;
			}
			curr = curr.getNext();
			prev = prev.getNext();
		}
		prev.setNext(n);
		n.setNext(curr);
		numItems++;
	}
	
	
	public void clear() {
		head = null;
		tail = null;
		while(curr.getNext() != null) {
			prev = curr;
			curr = curr.getNext();
			prev = null;
		}
		if(curr.getNext() == null) {
			curr = null;
		}
	}
    
	
    public boolean contains(E e) {
		curr = head;
		prev = tail;
		while(!curr.getNext().equals(head)) {
			if(curr.getItem() == e || prev.getItem() == e) {
				return true;
			}
			else {
				curr = curr.getNext();
				prev = prev.getNext();
			}
		}
		return false;
    }
    
	public Object get(int index) {
    	curr = head;
    	prev = tail;
    	for(int i = 0; i < index; i++) {
    		if(curr.getNext() == null || curr.getNext().equals(head)) {
    			throw new IndexOutOfBoundsException();
    		}
    		prev = curr;
    		curr = curr.getNext();
    	}
    	return (Object)curr;
    }
    
	
    public int indexOf(E e) {
    	curr = head;
    	prev = tail;
    	int index = 0;
    	while(!curr.getNext().equals(head)) {
    		if(curr.getItem() == e) {
    			return index;
    		}
    		index++;
    		prev = curr;
    		curr = curr.getNext();
    	}
    	return -1;
    }
    
    public boolean isEmpty() {
    	if(numItems == 0) {
    		return true;
    	}
    	return false;
    }
    
    @SuppressWarnings("unchecked")
    public void remove(int index) {    	
    	if(index > 0) {
    		prev = (Node)get(index - 1);
    		curr = (Node)get(index);
    	}
    	if(index == 0) {
    		head = head.getNext();
    		return;
    	}
    	prev.setNext(curr.getNext());
    	curr.setNext(null);
    	curr = null;
    	curr = prev.getNext();
    	numItems--;
    }
    
	@SuppressWarnings("unchecked")
    public void set(int index,E e) {
    	if(index > 0) {
    		curr = (Node)get(index);
    		curr.setItem(e);
    	}
    	if(index == 0) {
    		head.setItem(e);
    		return;
    	}
    }
    
	public int size() {
		return numItems;		
	}
    
	@Override
    public MyList<E> subList(int fromIndex,int toIndex) {
    	if(fromIndex <= size() - 1 && fromIndex >=0
    		&& toIndex <= size() - 1 && toIndex >= 0
    		&& fromIndex < toIndex) {
    		MyCircularLinkedList<E> subList = new MyCircularLinkedList<E>();
    		
    	}
	}
    
	@Override
    public E[] toArray() {
    	return this.arrayHolder;
    }
    
	@Override
    public void sway(int position1, int position2) {
    	if(position1 <= this.size - 1 && position1 >= 0
    		&& position2 <= this.size - 1 && position2 >= 0
    		&& position1 < position2) {
    		E temp = this.arrayHolder[position1];
    		this.arrayHolder[position1] = this.arrayHolder[position2];
    		this.arrayHolder[position2] = temp;
    	}
    	else {
    		throw new IndexOutOfBoundsException();
    	}
    }
    
	@Override
	@SuppressWarnings("unchecked")
    public void shift(int position) {
		int toRotate = Math.abs(position)%this.size;
		E[] tempArray = (E[])new Object[toRotate];
		if(position > 0) {
			for(int i = this.size - toRotate; i < this.size; i ++) {
				tempArray[i - (this.size - toRotate)] = this.arrayHolder[i];
			}
			for(int i = this.size - 1; i >= toRotate; i--) {
				this.arrayHolder[i] = this.arrayHolder[i - toRotate];
			    }
			for(int i = 0; i < tempArray.length; i++){
				this.arrayHolder[toRotate - i] = tempArray[i];
			    }			
		}
		else if(position < 0) {
			for(int i = 0; i < toRotate; i++){
				tempArray[i] = this.arrayHolder[i];
			    }
			for(int i = toRotate; i < this.size; i++){
				this.arrayHolder[i - toRotate] = this.arrayHolder[i];
			    }
			for(int i = 0; i < tempArray.length; i++){
				this.arrayHolder[this.size - toRotate - i] = tempArray[i];
			    }
		}
    	
    }
}
