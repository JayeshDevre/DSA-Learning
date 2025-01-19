import java.util.Arrays;

public class Sorting {

    // bubble sort also known as sinking sort and exchange sort 
    // It is basically comparing adjacent elements  
    // Time Complexity: Best Case: O(n)      Worst Case: O(n^2)
    public static int [] bubbleSort(int [] arr ){
        Boolean swapped=false;

        for(int i=0;i<arr.length;i++){

            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
                // for already sorted array loop will run for one time only
                if(!swapped){
                    break;
                }
            }
        }
        return arr;
    }

    public static void bubbleSortUsingRecusion(int arr[], int row,int col){
        if(row==0){
            return;
        }

        if(col<row){
            if(arr[col]>arr[col+1]){
                swap(arr, col, col+1);
            }
            bubbleSortUsingRecusion(arr, row, col+1);
        }else{
            bubbleSortUsingRecusion(arr, row-1, 0);
        }
    }

    // Selection sort: O(n^2) best as well as worst case ,   it is used for short lists
    public static int [] selectionSort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            int last=arr.length-i-1;
            int maxIndex=getMax(arr,0,last);
            swap(arr,maxIndex,last);
        }
        return arr;
    }

    public static void selectionSortUsingRecusion(int arr[], int row,int col,int max){
        if(row==0){
            return;
        }
        if(col<row){
            if(arr[col]>arr[max]){
                selectionSortUsingRecusion(arr, row, col+1, col);

            }else{
            selectionSortUsingRecusion(arr, row, col+1,max);
            }
        }else{
            swap(arr, max, col);
            selectionSortUsingRecusion(arr, row-1, 0, 0);
        }
    }

    public static int getMax(int arr[], int start, int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }

    public static void swap(int arr[], int first, int second ){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

    // Insertion Sort: best case O(n), Worst Case: O(n^2)  
    public static int [] insertionSort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    //Cyclic Sort: Very Imp for FAANG   Time complexity:  O(n) best as well as worst case
    // It will work when arr is in range of 1 to n because for this condition the correct index sholud be at index-1 position
    // {3,2,4,5,1} then for 1 the correct position is 0 i.e 1-1 
    public static int[] cyclicSort(int [] arr){
        int i=0;
        while(i<arr.length-1){
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else{
                i++;
            }
        }
        return arr;
    }


    // Merge Sort: it divides array into two parts then sort both arrays and mergge it
    // Time complexity: O(n log n)
    
    public static int [] mergeSortUsingRecursion(int arr[]){
        if(arr.length==1){
            return arr;
        }

        int mid=arr.length/2;
        int []left=mergeSortUsingRecursion(Arrays.copyOfRange(arr, 0, mid));
        int []right=mergeSortUsingRecursion(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }

    public static int [] merge(int [] left, int [] right ){
        int arr[]=new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length&&j<right.length){
            if(left[i]<right[j]){
                arr[k]=left[i];
                i++;
            }else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }

        while(i<left.length){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            arr[k]=right[j];
            j++;
            k++;
        }
        return arr;

    }
 
    public static void main(String[] args) {
        int arr[] ={4,3,2,1};
        // System.out.println(Arrays.toString(bubbleSort(arr)));
        // System.out.println(Arrays.toString(selectionSort(arr)));
        // System.out.println(Arrays.toString(insertionSort(arr)));
        // System.out.println(Arrays.toString(cyclicSort(arr)));
        // System.out.println(Arrays.toString(cyclicSort(arr)));
        // selectionSortUsingRecusion(arr, arr.length-1, 0, 0);
        // System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mergeSortUsingRecursion(arr)));


    }
}
