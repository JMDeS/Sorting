import java.util.Random;

/**
 * Created by JMDeS on 4/22/2016.
 */
public class Driver {

    public static void main(String[] args){
        Driver test = new Driver();
    }

    public Driver() {
        int[] arr = generateIntArray();
        System.out.println("Unsorted:");
        printArray(arr);
        System.out.println();

//        bubbleSort(arr);
//        insertionSort(arr);
//        selectionSort(arr); // TODO: selectionSort not working
//        quickSort(arr);
//        mergeSort(arr);
//        heapSort(arr); // TODO: fix heapsort ( may only work with distinct values )

        System.out.println("Sorted:");
        printArray(arr);
    }


    /*************************************/
    /** O(n^2) class sorting algorithms **/
    /*************************************/

    /** BUBBLE SORT **/
    void bubbleSort(int arr[]){
        int i, j;

        for ( i = arr.length-1 ; i >= 0 ; i--)
            for ( j = 1 ; j <= i ; j++)
                if ( arr[j-1] > arr[j] )
                    swap(arr,j-1,j);
    } // end bubbleSort

    /** INSERTION SORT **/
    void insertionSort(int arr[]){
        int i, j, index;

        for ( i = 1 ; i < arr.length ; i++){
            index = arr[i];
            j = i;
            while ( ( j > 0 ) && ( arr[j-1] > index ) )
                arr[j] = arr[--j];
            arr[j] = index;
        }
    } // end insertionSort

    /** SELECTION SORT **/
    void selectionSort(int arr[]) {
        int i, j, min;
        for ( min=i=0 ; i < arr.length-1 ; i++ , min = i)
            for ( j = i+1 ; j < arr.length ; j++ )
                if ( arr[j] < arr[min] )
                    min = j;
    } // end selectionSort




    /****************************************/
    /** O(nlogn) class sorting algorithms ***/
    /****************************************/

    /** QUICK SORT **/
    void quickSort(int arr[]){
        quickSort(arr,0,arr.length);
    }
    void quickSort(int arr[], int low, int high){
        if ( low < high ) {
            int pivot = partition(arr,low, high);
            quickSort(arr,low,pivot);
            quickSort(arr,pivot+1,high);
        }
    }
    int partition(int arr[], int low, int high){
        int pivot = arr[low];
        int leftBound = low;
        int i;

        for ( i = low+1 ; i < high ; i++ )
            if ( arr[i] < pivot )
                swap(arr, i, ++leftBound);
        swap(arr,low,leftBound);

        return leftBound;
    }


    /** MERGE SORT **/
    void mergeSort(int[] arr) {
        int size = arr.length;

        if (size < 2) return; // check for base case O(1)

        int mid = size / 2; // divide step O(1)
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        for (int i = mid; i < size; i++)
            right[i - mid] = arr[i];

        mergeSort(left);	// conquer steps
        mergeSort(right);	// each of size n/2 so 2T(n/2)

        merge(arr, left, right); // Combine step O(n)
    }
    void merge(int[] arr, int[] left, int[] right ) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize)
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        while (i < leftSize)
            arr[k++] = left[i++];
        while (j < rightSize)
            arr[k++] = right[j++];
    }


    /** HEAP SORT **/
    // left child of i = 2i+1
    // right child of i = 2i + 2
    // NEED TO ADJUST HEAP SORT TO SATISFY: A(0..N)
    void heapSort(int arr[])
    {
        int i, heapSize = arr.length;
        buildHeap(arr);

        for (i = (heapSize / 2)-1; i >= 0; i--)
            heapify(arr, i-1, heapSize);

        for (i = heapSize-1; i >= 1; i--)
        {
            swap(arr, 0, i);
            heapify(arr, 0, i-1);
        }
    }
    void buildHeap(int arr[]){
        for ( int i = arr.length/2 ; i > 1 ; i--)
            heapify(arr, 0, i-1);
    }
    void heapify(int arr[], int current, int heapSize)
    { // iterative implementation of heapify
        int  largestChild, leftChild, rightChild;
        leftChild = 2*current;
        boolean done = false;

        while ((leftChild <= heapSize) && (!done))
        {
            leftChild = 2*current;
            rightChild = 2*current+1;

            if ( leftChild == heapSize )
                largestChild = leftChild;
            else if ( arr[leftChild] > arr[rightChild] )
                largestChild = leftChild;
            else
                largestChild = rightChild;

            if ( arr[current] < arr[largestChild] )
            {
                swap(arr, current, largestChild);
                current = largestChild;
                heapify(arr,current, heapSize-1); //
            }
            else
                done = true;
        }
    }




    /** MISC METHODS **/
    // General swapping method
    void swap(int[] arr, int x, int y){
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    int randomInt(int x) {
        Random rand = new Random();
        int r = rand.nextInt(x)+1; // +1 to exclude 0
        return r;
    }

    void printArray(int[] arr){
        for (int i=0 ; i < arr.length ; i++)
            System.out.print(" "+arr[i]);
    }

    /** TESTING METHODS **/
    int[] generateIntArray() {
        int[] numbers = new int[10];
        for (int i = 0 ; i < numbers.length ; i++)
            numbers[i] = randomInt(10);
        return numbers;
    }
}
