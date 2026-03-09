class Queu<T>{
    private T[] arr;
    private int front;
    private int rear;

    public Queu(int size){
        arr = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return (rear + 1) % arr.length == front;
    }

    public boolean isEmpty(){
        return front == -1 ;
    }

    public void add(T data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }

        if(front == -1){
            front = 0;
        }

        rear = (rear + 1) % arr.length;
        arr[rear] = data;
    }

    public T remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        T result = arr[front];
        if(front == rear){
            front = rear = -1;
        }else{
            front = (front + 1) % arr.length;
        }
        return result;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue Empty");
            return;
        }
        int i = front;
        while(true){
            System.out.print(arr[i] + " ");
            if(i == rear) break;
            i = (i + 1) % arr.length;
        }
        System.out.println();
    }
}

public class Circular_Queu_Implementation{
    public static void main(String[] args){
        Queu<Integer> q = new Queu<>(5); // using generics 
        q.add(10);
        q.add(20);
        q.add(30);
        q.display();
        q.remove();
        q.display();
    }
}
