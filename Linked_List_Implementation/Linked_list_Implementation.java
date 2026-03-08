class Node<T>{
    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data){
        this.data = data;
        prev = null;
        next = null;
    }
}

class LinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public void addFirst(T data){
        Node<T> temp = new Node<>(data);

        if(head == null){
            head = tail = temp;
        }else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }

        length++;
    }

    public void addLast(T data){
        Node<T> temp = new Node<>(data);

        if(tail == null){
            head = tail = temp;
        }else{
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }

        length++;
    }

    public void display(){
        Node<T> temp = head;

        System.out.print("Head ==> ");

        while(temp != null){
            System.out.print(temp.data + " ==> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }

        length--;
    }

    public void removeLast(){
        if(tail == null){
            System.out.println("List is empty");
            return;
        }

        if(head == tail){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }

        length--;
    }

    public int size(){
        return length;
    }

    public boolean contains(T data){
        Node<T> temp = head;

        while(temp != null){
            if(temp.data.equals(data)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

public class Linked_list_Implementation{
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);

        ll.display();
    }
}
