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
        for (int i = 1; i < arr.length; i++) {
            //create parent node
            createParent(arr[i-1], arr[i]);
            //delete two children from heap 
            deleteTwoChild();
            //insert new parent into heap
        }
    }

    public void createParent(Node n1, Node n2) {
        n = new Node(n1.frequency+n2.frequency, (char)i); //some garbage charecter
    }

    public void deleteTwoChild() {
        
    }
}

public class App 
{
    public static void main(String[] args) {
        minHeap m = new minHeap(5);
        m.Insertion(m.new Node(10, 'a'));
        m.Insertion(m.new Node(12, 'b'));
        m.Insertion(m.new Node(5, 'c'));
        m.Insertion(m.new Node(3, 'd'));
        m.Insertion(m.new Node(18, 'e'));
        m.PrintHeap();
    }
}
