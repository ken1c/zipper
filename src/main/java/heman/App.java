package heman;

class Node {
    // Node 
    int nodeValue;
    Node rChild;
    Node lChild;

    public Node(int value) {
        this.nodeValue = value;
        rChild = null;
        lChild = null;
    }

}

class BST {
    Node root;
    public BST() {this.root=null;}

    public void Insertion(int num) {
        
        recursiveCases(root,num);
        
        // if (root.nodeValue > current.nodeValue) {
        //     root.lChild = current;
        //     System.out.println(root.lChild.nodeValue);
        // } 
        
        // else if (root.nodeValue < current.nodeValue) {
        //     root.rChild = current;
        //     System.out.println(root.rChild.nodeValue);
        // }
    }

    private Node recursiveCases(Node root, int num) {
            // System.out.println("greater case");
            if (root==null) {
                root = new Node(num);
                System.out.println(root.nodeValue);
            }
            if (num < root.nodeValue) {
                root.lChild = recursiveCases(root.lChild, num);
            } else if (num > root.nodeValue) {
                root.rChild = recursiveCases(root.rChild, num);
            }

            return root;
    }

}

public class App 
{
    public static void main( String[] args )
    {
        BST bst = new BST();
        bst.Insertion(1);
        bst.Insertion(12);
        bst.Insertion(3);
        bst.Insertion(41);
    }
}
