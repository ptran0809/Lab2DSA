package lab2_v0;

public class MyLinkedList<E> implements MyList<E> {
    private class Node<E>{
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
	
    }
    
    Node<E> element =null;
    int size;

    public MyLinkedList() {
	this.size =0;
    }

    
    @Override
    public void add(int index, E e) {
	if(index>=0 && index < this.size){
	    int c;
	    if(this.size==0){
	       this.element = new Node<E>(e);
	   }
	   else{
	       Node<E> curr = this.element;
	       Node<E> last = null;
	       c=0;
	       while(c!=index){
		  last = curr;
		  curr = curr.getNextE();
		  c++;
	       }
	       last.setNextE(new Node<E>(e));
	       last.getNextE().setNextE(curr);
	       curr = null;
	       this.size++;
	       
	   }
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
	
    }

    @Override
    public void add(E e) {
	Node<E> curr = this.element;
	Node<E> last = null;
	while(curr!=null){
	    last = curr;
	    curr = curr.getNextE();
	}
	if(last==null){
	    this.element = new Node<E>(e);
	    this.size++;
	}
	else{
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
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Object get(int index) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int indexOf(E e) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void remove(int index) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void set(int index, E e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public int size() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public MyList<E> subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public E[] toArray() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void sway(int position1, int position2) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void shift(int position) {
	// TODO Auto-generated method stub
	
    }

}
