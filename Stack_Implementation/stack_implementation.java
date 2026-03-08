class stack<T>{
    private T [] arr;
    private int top;

    public stack(int  size){
        arr = (T[])new Object[size];
        top  = -1;
    }
    
    public boolean isFull(){
        return top == arr.length-1;
    }
    public void push(T val){
        if(isFull()){
            return;
        }
        top++;
        arr[top] = val;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public T pop(){
        if(isEmpty()){
            return null;
        }
       return arr[top--];
    }
    public void display(){
        for(int i = top;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
    }
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return arr[top];
    }
    public int size(){
        if(isEmpty()){
            return -1;
        }
        return top+1;
    }
}
public class stack_implementation
{
	public static void main(String[] args) {
		stack<String> st = new stack(5); // using generics
		st.push("vishnu");
		st.push("mahe");
		st.push("deepak");
		System.out.print(st.peek());
		System.out.println();
		st.display();
	}
}