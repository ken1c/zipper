package heman;

class minHeap {
    static Node[] arr;
    int i,length,currIndex,parIndex;
    Node n;
    
    minHeap(int length) {
        i=0;
        arr = new Node[length];
    }
    //Nested class -> for representing Node as seperate class to distinguish
    class Node {
        int frequency;
        char charecter;
        Node rChild,lChild;

        Node(int frequency, char charecter) {
            this.frequency=frequency;
            this.charecter = charecter;
            this.rChild = null;
            this.lChild = null;
        }
    }

    public void Insertion(Node node) {    
        if (i< arr.length) {

            arr[i]=node;
            currIndex = i;
            i++;

            while (currIndex > 0) {
                parIndex=(currIndex-1)/2;
               if (arr[currIndex].frequency < arr[parIndex].frequency) {
                    n = arr[currIndex];
                    arr[currIndex] = arr[parIndex];
                    arr[parIndex] = n;

                    currIndex = parIndex;
               } else {
                break;
               }
            }
        }
    }

    public void PrintHeap() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].frequency + " ");
        }
    }

    public void huffmanTree() {
        if (i==1) {
            return;
        }
        Node left = extractMin();
        Node right = extractMin();
        Node par = new Node(left.frequency+right.frequency, '\0');

        par.lChild = left;
        par.rChild = right;

        Insertion(par);
        huffmanTree();
    }

    public Node extractMin() {
        
        return n;
    }
}

public class App 
{
    public static void main(String[] args) {
        minHeap m = new minHeap(6);
        m.Insertion(m.new Node(13, 'a'));
        m.Insertion(m.new Node(12, 'b'));
        m.Insertion(m.new Node(5, 'c'));
        m.Insertion(m.new Node(9, 'd'));
        m.Insertion(m.new Node(16, 'e'));
        m.Insertion(m.new Node(45, 'e'));
        m.PrintHeap();
        m.huffmanTree();
        // m.PrintHeap();
    }
}
