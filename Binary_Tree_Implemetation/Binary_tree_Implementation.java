import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        left =  null;
        right = null;
    }
}

class BT{
    Node root;
    public BT(){
        root = null;
    }
    public void insert(int val){
        Node newnode = new Node(val);
        if(root == null){
            root = newnode;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node temp = null;
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.left == null){
                temp.left  = newnode;
                return;
            }else{
                q.offer(temp.left);
            }
            
            if(temp.right == null){
                temp.right  = newnode;
                return;
            }else{
                q.offer(temp.right);
            }
        }
    }
    public void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public int maxDeapth(Node root){
        if(root == null){
            return 0;
        }
        int l = maxDeapth(root.left);
        int r = maxDeapth(root.right);
        return Math.max(l,r)+1;
    }
    public int maxNoOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int l = maxNoOfNodes(root.right);
        int r = maxNoOfNodes(root.left);
        
        return l+r+1;
    }
    public void LevelOrder(){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node temp = null;
        while(!q.isEmpty()){
            temp = q.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                q.offer(temp.left);
            }
            if(temp.right != null){
                q.offer(temp.right);
            }
        }
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void delete(int key){
    if(root == null){
        return;
    }

    if(root.left == null && root.right == null){
        if(root.data == key){
            root = null;
        }
        return;
    }

    Queue<Node> q = new LinkedList<>();
    q.offer(root);

    Node temp = null;
    Node keyNode = null;

    while(!q.isEmpty()){
        temp = q.poll();

        if(temp.data == key){
            keyNode = temp;
        }

        if(temp.left != null){
            q.offer(temp.left);
        }

        if(temp.right != null){
            q.offer(temp.right);
        }
    }

        if(keyNode != null){
        int x = temp.data;     
        deleteDeepest(root,temp);
        keyNode.data = x;
        }
    }
    public void deleteDeepest(Node root, Node delNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                }
                q.add(temp.left);
            }

            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                }
                q.add(temp.right);
            }
        }
    }
}
public class Binary_tree_Implementation
{
	public static void main(String[] args) {
	    BT tree = new BT(); // implementation of binary tree;
	    tree.insert(1);
	    tree.insert(2);
	    tree.insert(3);
	    tree.insert(4);
	    tree.insert(5);
	    tree.delete(3);
	    tree.inorder(tree.root);
	}
}