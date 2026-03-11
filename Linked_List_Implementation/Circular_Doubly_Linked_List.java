class CircularNode<T>{
    T data;
    CircularNode<T> prev;
    CircularNode<T> next;

    public CircularNode(T data){
        this.data = data;
        prev = null;
        next = null;
    }
}

class CircularDoublyLinkedList<T>{
    private CircularNode<T> head;
    private int length;

    public CircularDoublyLinkedList(){
        head = null;
        length = 0;
    }

    public void addFirst(T data){
        CircularNode<T> temp = new CircularNode<>(data);
        if(head == null){
            head = temp;
            temp.next = temp;
            temp.prev = temp;
        }else{
            CircularNode<T> tail = head.prev;
            temp.next = head;
            temp.prev = tail;
            head.prev = temp;
            tail.next = temp;
            head = temp;
        }
        length++;
    }

    public void addLast(T data){
        CircularNode<T> temp = new CircularNode<>(data);
        if(head == null){
            head = temp;
            temp.next = temp;
            temp.prev = temp;
        }else{
            CircularNode<T> tail = head.prev;
            temp.next = head;
            temp.prev = tail;
            tail.next = temp;
            head.prev = temp;
        }
        length++;
    }

    public void display(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        CircularNode<T> temp = head;
        System.out.print("Head ==> ");
        do{
            System.out.print(temp.data + " ==> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("Head (circular)");
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.next == head){
            head = null;
        }else{
            CircularNode<T> tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        length--;
    }

    public void removeLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.next == head){
            head = null;
        }else{
            CircularNode<T> tail = head.prev;
            CircularNode<T> newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
        }
        length--;
    }

    public int size(){
        return length;
    }

    public boolean contains(T data){
        if(head == null) return false;
        CircularNode<T> temp = head;
        do{
            if(temp.data.equals(data)){
                return true;
            }
            temp = temp.next;
        }while(temp != head);
        return false;
    }

    public void insertPosition(T data, int pos){
        if(pos < 0 || pos > length){
            System.out.println("Invalid position");
            return;
        }
        if(pos == 0){
            addFirst(data);
            return;
        }
        if(pos == length){
            addLast(data);
            return;
        }
        CircularNode<T> newNode = new CircularNode<>(data);
        CircularNode<T> curr = head;
        for(int i = 0; i < pos - 1; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;
        length++;
    }

    public void deletePosition(int pos){
        if(pos < 0 || pos >= length){
            System.out.println("Invalid position");
            return;
        }
        if(pos == 0){
            removeFirst();
            return;
        }
        if(pos == length - 1){
            removeLast();
            return;
        }
        CircularNode<T> temp = head;
        for(int i = 0; i < pos; i++){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        length--;
    }
}

public class Circular_Doubly_Linked_List{
    public static void main(String[] args){
        CircularDoublyLinkedList<Integer> cdll = new CircularDoublyLinkedList<>();
        cdll.addFirst(1);
        cdll.addFirst(2);
        cdll.addFirst(3);
        cdll.addLast(100);
        cdll.insertPosition(50, 2);
        cdll.display();
        System.out.println("Size: " + cdll.size());
        System.out.println("Contains 50: " + cdll.contains(50));
        cdll.deletePosition(2);
        cdll.display();
    }
}
