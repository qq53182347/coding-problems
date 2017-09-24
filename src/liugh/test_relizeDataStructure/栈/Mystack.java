package liugh.test_relizeDataStructure.栈;

import java.util.Arrays;

public class Mystack<T> {
	private int capacity=0;
	private int index=0;
	private Object [] elements;
	private  int DUFUAL_CAPACITY=5;
	private int size=0;
	
	public Mystack(){
		this.capacity=DUFUAL_CAPACITY;
		this.elements=new Object[capacity];
	}
	
	public Boolean isEmtype(){
		return this.size==0;
	}

	//查看栈顶元素
	public T peek(){
		return (T)this.elements[index-1];
	}
	//弹出栈顶元素
	public T pop(){
		this.index--;
		T object = (T)elements[index];
		this.elements[index]=null;
		this.size--;
		return object;
	}
	public int size(){
		return this.size;
	}
	public void add(T t){
		if(this.size<this.capacity){
			this.size++;
			this.elements[index]=t;
			this.index++;
		}else{
			this.capacity=this.capacity+this.DUFUAL_CAPACITY;
			this.size++;
			Object [] temp = new Object[capacity];
			System.arraycopy(this.elements, 0, temp, 0, elements.length);
			temp[index++]=t;
			Arrays.fill(elements, null);
			this.elements=temp;
		}
		
	}

	@Override
	public String toString() {
		return "Mystack [elements=" + Arrays.toString(elements) + "]";
	}
	
}
