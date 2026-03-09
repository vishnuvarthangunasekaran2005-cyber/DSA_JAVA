class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
}
class linklist{
    private Node head;
    private Node tail;
    private int size;
    public linklist(){
        head = null;
        tail = null;
        size = 0;
    }
    public void addFirst(int data){
        Node temp = new Node(data);
        if(head == null){
            head = tail = temp;
        }else{
            temp.next = head;
            head = temp;
        }
        size++;
    }
    public void addLast(int data){
        Node temp = new Node(data);
        if(tail == null){
            head = tail = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    public void removeFirst(){
        if(head == null){
            System.out.print("List is empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        head = head.next;
        size--;
    }
    public void removeLast(){
        if(tail == null){
            System.out.println("List is Empty");
            return;
        }
        if(head.next == null){
            head = tail = null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
    }
    public void display(){
        Node temp = head;
        System.out.print("Head ==> ");
        while(temp != null){
            System.out.print(temp.data+" ==> ");
            temp = temp.next;
        }
        System.out.print(" tail");
    }
    public void insertposition(int data,int pos){
        if(pos <0 || pos > size){
            System.out.println("Invalid position");
            return;
        }
        if(pos == size){
            addLast(data);
            return;
        }
        if(pos == 0){
            addFirst(data);
            return;
        }
        Node temp = head;
        Node newNode = new Node(data);
        for(int i=0;i<pos-1;i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }
    public void deletePosition(int pos){
        if(pos < 0 || pos >= size){
            System.out.println("Invalid Position");
        }
        if(pos == 0){
            removeFirst();
            return;
        }
        if(pos == size-1){
            removeLast();
            return;
        }
        Node temp = head;
        for(int i = 0;temp != null && i<pos-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
    public void reverse(){
        Node prev = null;
        Node curr = null ;
        Node nn = head;
        while(nn != null){
            prev = curr;
            curr = nn;
            nn = nn.next;
            curr.next = prev;
        }
        head = curr;
    }
}
public class singly_Link_List_implementation {
    public static void main(String [] args){
        linklist li = new linklist();
        li.addFirst(100);
        li.addLast(200);
        li.addLast(300);
        li.addLast(400);
        li.reverse();
        li.display();
    }
}
