package heman;

class minHeap {
    static Node[] arr;
    int i, length, currIndex, parIndex;
    int smallest, left, right;
    Node n;
    
    minHeap(int length) {
        i = 0;
        arr = new Node[length];
    }
    
    // Nested class for representing Node
    class Node {
        int frequency;
        char charecter;
        Node rChild, lChild;

        Node(int frequency, char charecter) {
            this.frequency = frequency;
            this.charecter = charecter;
            this.rChild = null;
            this.lChild = null;
        }
    }

    public void Insertion(Node node) {    
        if (i < arr.length) {
            arr[i] = node;
            currIndex = i;
            i++;

            // Heapify up to maintain min-heap property
            while (currIndex > 0) {
                parIndex = (currIndex - 1) / 2;
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
        for (int j = 0; j < i; j++) {
            System.out.print(arr[j].frequency + " ");
        }
        System.out.println();
    }

    public void huffmanTree() {
        // Build the Huffman Tree
        while (i > 1) {  // While there's more than one node
            Node left = miniMum();  // Extract minimum
            Node right = miniMum();  // Extract second minimum
            
            // Create new internal node
            Node parent = new Node(left.frequency + right.frequency, '\0');
            parent.lChild = left;
            parent.rChild = right;

            Insertion(parent);  // Insert the parent node back into the heap
        }
    }

    public Node miniMum() {
        // Extract minimum element (root of the heap)
        Node min = arr[0];
        arr[0] = arr[--i];  // Replace root with the last element
        heapifyDown(0);  // Restore heap property
        return min;
    }

    public void heapifyDown(int index) {
        smallest = index;
        left = 2 * index + 1;
        right = 2 * index + 2;

        // Check if left child exists and is smaller
        if (left < i && arr[left].frequency < arr[smallest].frequency) {
            smallest = left;
        }

        // Check if right child exists and is smaller
        if (right < i && arr[right].frequency < arr[smallest].frequency) {
            smallest = right;
        }

        // Swap and continue heapifying if needed
        if (smallest != index) {
            Node temp = arr[smallest];
            arr[smallest] = arr[index];
            arr[index] = temp;
            heapifyDown(smallest);
        }
    }

    public void printCodes(Node root, String code) {
        if (root == null) {
            return;
        }
    
        // If it's a leaf node, print the character and its code
        if (root.lChild == null && root.rChild == null) {
            System.out.println(root.charecter + ": " + code);
            return;
        }
    
        // Recur for left child with '0' and right child with '1'
        printCodes(root.lChild, code + "0");
        printCodes(root.rChild, code + "1");
    }
}

public class App {
    public static void main(String[] args) {
        minHeap m = new minHeap(6);
        m.Insertion(m.new Node(13, 'a'));
        m.Insertion(m.new Node(12, 'b'));
        m.Insertion(m.new Node(5, 'c'));
        m.Insertion(m.new Node(9, 'd'));
        m.Insertion(m.new Node(16, 'e'));
        m.Insertion(m.new Node(45, 'f'));
        
        // Build the Huffman Tree
        m.huffmanTree();
        
        // Print Huffman Codes from the root of the Huffman tree
        m.printCodes(m.miniMum(), "");
    }
}