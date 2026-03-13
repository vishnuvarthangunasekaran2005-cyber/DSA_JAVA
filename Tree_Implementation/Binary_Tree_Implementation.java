class TreeNode<T>{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree<T>{
    private TreeNode<T> root;

    public BinaryTree(){
        root = null;
    }

    public void insert(T data){
        root = insertRec(root, data);
    }

    private TreeNode<T> insertRec(TreeNode<T> node, T data){
        if(node == null){
            return new TreeNode<>(data);
        }
        if(((Comparable<T>)data).compareTo(node.data) < 0){
            node.left = insertRec(node.left, data);
        }else if(((Comparable<T>)data).compareTo(node.data) > 0){
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    public void inorder(){
        System.out.print("Inorder: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode<T> node){
        if(node != null){
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    public void preorder(){
        System.out.print("Preorder: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode<T> node){
        if(node != null){
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public void postorder(){
        System.out.print("Postorder: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode<T> node){
        if(node != null){
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    public boolean search(T data){
        return searchRec(root, data);
    }

    private boolean searchRec(TreeNode<T> node, T data){
        if(node == null) return false;
        if(node.data.equals(data)) return true;
        if(((Comparable<T>)data).compareTo(node.data) < 0){
            return searchRec(node.left, data);
        }
        return searchRec(node.right, data);
    }

    public void delete(T data){
        root = deleteRec(root, data);
    }

    private TreeNode<T> deleteRec(TreeNode<T> node, T data){
        if(node == null) return null;
        
        if(((Comparable<T>)data).compareTo(node.data) < 0){
            node.left = deleteRec(node.left, data);
        }else if(((Comparable<T>)data).compareTo(node.data) > 0){
            node.right = deleteRec(node.right, data);
        }else{
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;
            
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    private T minValue(TreeNode<T> node){
        T min = node.data;
        while(node.left != null){
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    public int height(){
        return heightRec(root);
    }

    private int heightRec(TreeNode<T> node){
        if(node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public int size(){
        return sizeRec(root);
    }

    private int sizeRec(TreeNode<T> node){
        if(node == null) return 0;
        return 1 + sizeRec(node.left) + sizeRec(node.right);
    }
}

public class Binary_Tree_Implementation{
    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        tree.inorder();
        tree.preorder();
        tree.postorder();
        
        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Height: " + tree.height());
        System.out.println("Size: " + tree.size());
        
        tree.delete(30);
        System.out.println("After deleting 30:");
        tree.inorder();
    }
}
