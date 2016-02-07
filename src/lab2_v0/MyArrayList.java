package lab2_v0;

public class MyArrayList<E> implements MyList<E> {
    
    private E[] arrayholder;
    private int size;
    private static final int DEFAULT_SIZE = 10;
    
    
    
    @SuppressWarnings("unchecked")
    public MyArrayList(int size) {
	this.size = 0;
	this.arrayholder = (E[])new Object[this.size];
	
    }
    
    public MyArrayList(){
	this(MyArrayList.DEFAULT_SIZE);
	
    }

   

    @Override
    public void add(int index, E e) {
	if(index <= this.size -1 && index >= 0){
	    this.arrayholder[index] = e;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
	
    }

    @Override
    public void add(E e) {
	if(this.size  < this.arrayholder.length){
	    this.arrayholder[size] = e;
	    this.size++;
	}
	else{
	    int newlength = this.arrayholder.length * 2;
	    @SuppressWarnings("unchecked")
	    E[] newArray = (E[])new Object[newlength];
	    for(int i = 0; i< this.arrayholder.length;i++){
		newArray[i] = this.arrayholder[i];
	    }
	    this.arrayholder = newArray;
	    this.arrayholder[this.size] = e;
	    this.size ++;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
	this.arrayholder = (E[])new Object[MyArrayList.DEFAULT_SIZE];
	this.size = 0;
    }

    @Override
    public boolean contains(E e) {
	for(E element: this.arrayholder){
	    if(element.equals(e)){
		return true;
	    }
	}
	return false;
    }

    @Override
    public Object get(int index) {
	// TODO Auto-generated method stub
	if(index <= this.size -1 && index >= 0){
	     return this.arrayholder[index];
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    @Override
    public int indexOf(E e) {
	for(int i = 0; i< this.size;i++){
	    if(this.arrayholder[i].equals(e)){
		return i;
	    }
	}
	return -1;
    }

    @Override
    public boolean isEmpty() {
	if(this.size==0){
	    return true;
	}
	else{
	    return false;
	}
    }

    @Override
    public void remove(int index) {
	if(index <= this.size -1 && index >= 0){
	    for(int i = index;i < this.size-1;i++){
		this.arrayholder[i] = this.arrayholder[i+1];
	    }
	    this.size--;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
	
    }

    @Override
    public void set(int index, E e) {
	if(index <= this.size -1 && index >= 0){
	    this.arrayholder[index] = e;
	}
	else{
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
	if(fromIndex <= this.size -1 && fromIndex >= 0 
		&& toIndex <= this.size -1 && toIndex >= 0
		&& fromIndex < toIndex){
	    int newListSize = toIndex - fromIndex + 1;
	    MyArrayList<E> returnList = new MyArrayList<E>(newListSize);
	    for(int i = fromIndex;i<=toIndex;i++){
		returnList.add(this.arrayholder[i]);
 	    }
	    return returnList;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    @Override
    public E[] toArray() {
	return this.arrayholder;
    }

    @Override
    public void sway(int position1, int position2) {
	if(position1 <= this.size -1 && position1 >= 0 
		&& position2 <= this.size -1 && position2 >= 0
		&& position1 < position2){
	    E temp = this.arrayholder[position1];
	    this.arrayholder[position1] = this.arrayholder[position2];
	    this.arrayholder[position2] = temp;
 	    
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
	
    }

    @Override
    @SuppressWarnings("unchecked")
    public void shift(int position) {
	int toRotate = Math.abs(position)% this.size;
	E[] tempArray = (E[])new Object[toRotate];
	if(position > 0){
	    
	    
	    for(int i= this.size -toRotate;i< this.size;i++){
		tempArray[i -(this.size -toRotate)] = this.arrayholder[i];
	    }
	    for(int i=this.size -1;i>=toRotate;i--){
		this.arrayholder[i] = this.arrayholder[i-toRotate];
	    }
	    for(int i=0;i <tempArray.length;i++){
		this.arrayholder[toRotate - i] = tempArray[i];
	    }
	}
	else if(position < 0){
	    for(int i=0;i< toRotate;i++){
		tempArray[i] = this.arrayholder[i];
	    }
	    for(int i=toRotate;i<this.size;i++){
		this.arrayholder[i-toRotate] = this.arrayholder[i];
	    }
	    for(int i=0;i <tempArray.length;i++){
		this.arrayholder[this.size -toRotate-i] = tempArray[i];
	    }
	    
	}
    }

}
