class node{
    int data;
    node next;
    node prev;

    public node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}
class linkedlist{
    private int size;
    private node head;
    private node tail;

    public linkedlist(){
        size = 0;
        head = null;
        tail = null;
    }

    public void addFirst(int data){
        node temp = new node(data);
        if(size == 0){
            head = tail = temp;
            tail.next = head;
            head.prev = tail;
            size++;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = head.prev;
        head.prev = tail;
        tail.next = head;
        size++;
    }
    public void addLast(int data){
        node temp = new node(data);
        if(size == 0){
            head = tail = temp;
            tail.next = head;
            head.prev = tail;
            size++;
            return;
        }
        tail.next = temp;
        temp.prev = tail;
        tail = tail.next;
        tail.next = head;
        head.prev = tail;
        size++;
    }
    public void display(){
        node temp = head;
        if(temp == null){
            System.out.print("List is empty");
            return;
        }
        System.out.print("Head == ");
        do{
            System.out.print(temp.data+" == >");
            temp = temp.next;
        }while( temp != head);
        System.out.print("tail ");
    }
    public void removeFirst(){
        if(size == 0){
            System.out.println("List is Empty");
            return;
        }
        if(size == 1 ){
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
    }
    public void removeLast(){
        if(size == 0){
            System.out.print("List is empty");
            return;
        }
        if(size == 1){
            head = tail  = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
    }
    public boolean contains(int data){
        node temp = head;
        if(head == null){
            System.out.print("List is empty");
            return false;
        }
        do{
            if(temp.data == data){
                return true;
            }
            temp = temp.next;
        }while(temp !=  head);
        return false;
    }
    public int size(){
        return size;
    }
    public void insertPosition(int pos, int data){
        if(pos < 0 || pos > size){
            System.out.println("Invalid position");
            return;
        }
        if(pos == 0){
            addFirst(data);
            return;
        }
        if(pos == size){
            addLast(data);
            return;
        }
        node temp = head;
        node newnode = new node(data);
        for(int i = 0;i<pos-1;i++){
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next.prev = newnode;
        temp.next = newnode;
        newnode.prev = temp;
        size++;
    }
    public void deletePosition(int pos){
        if(pos < 0 || pos >= size){
            System.out.println("Invalid Position");
            return;
        }
        if(pos == 0){
            removeFirst();
            return;
        }
        if(pos == size-1){
            removeLast();
            return;
        }
        node temp = head;
        for(int i =0;i<pos;i++){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev  = temp.prev;
        size--;
    }
}
public class Circular_Doublylinked_list{
    public static void main(String [] args){
        linkedlist ll = new linkedlist();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.display();
        
    }
}