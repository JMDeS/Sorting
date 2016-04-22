/**
 * Created by JMDeS on 4/22/2016.
 */
public class Driver {

    public static void main(String[] args){

    }

    /****************************************/
    /** O(nlogn) class sorting algorithms ***/
    /****************************************/

    /** QUICK SORT **/
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
    void mergeSort(int arr[]){

    }

    /** HEAP SORT **/
    void heapSort(int arr[]){

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





    /** MISC METHODS **/
    // General swapping method
    void swap(int[] arr, int x, int y){
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
