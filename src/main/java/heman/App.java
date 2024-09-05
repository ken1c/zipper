package heman;

class minHeap {
    int[] arr;
    int i,n, length,currIndex,parIndex;
    minHeap(int length) {
        i=0;
        arr = new int[length];
    }

    public void Insertion(int num) {    
        if (i< arr.length) {

            arr[i]=num;
            currIndex = i;
            i++;

            while (currIndex > 0) {
                parIndex=(currIndex-1)/2;
               if (arr[currIndex] < arr[parIndex]) {
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
            System.out.print(arr[i] + " ");
        }
    }
}

public class App 
{
    public static void main(String[] args) {
        minHeap m = new minHeap(5);
        m.Insertion(6);
        m.Insertion(4);
        m.Insertion(7);
        m.Insertion(2);
        m.Insertion(1);
        m.PrintHeap();
    }
}
