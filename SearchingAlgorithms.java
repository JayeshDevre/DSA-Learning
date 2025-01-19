import java.util.*;
public class SearchingAlgorithms {

    // Linear Search: Time complexity:  best case: O(1),    Worst case: O(n)
    public static int linearSearch(int[] arr, int element){
        if(arr.length==0){
            return -1;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                return i;
            }
        }
        return -1;
    }

    public static boolean linearSearchinString(String s, char c){
        if(s.length()==0){
            return false;
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                return true;
            }
        }
        return false;
    }

    public static int linearSearchUsingRecursion(int [] arr, int target, int index){
        if(index==arr.length-1){
            return -1;
        }

        if(arr[index]==target){
            return index;
        }else{
            return  linearSearchUsingRecursion(arr,target, index+1);
        }
     
    }

    static ArrayList<Integer> list=new ArrayList<>();
    public static void findAllIndexLinearSearchUsingRecursion(int [] arr, int target, int index){
        if(index==arr.length){
            return;
        }

        if(arr[index]==target){
            list.add(index);
        }

         findAllIndexLinearSearchUsingRecursion(arr,target, index+1);
    
     
    }

    // The best program to count number of digits in number
    public static void countNum(int number){
        if(number<0){
            number=number*-1;
        }
        int digits=(int)(Math.log10(number))+1;
        System.out.println("Number of digits in : "+number+" are "+digits);
    }

    //  Binary Search : Time complexity: O(log n),  binary search is applied when sorted array is there or
    //  there is continuous pattern in question

    public static int binarySearch(int arr[], int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    // Order Agnostic Binary Search :  Binary search on ascending as well as descending array or numbers

    public static int orderAgnosticBinarySearch(int arr[], int target) {
        if (arr == null || arr.length == 0) {
            return -1; // Handle empty or null array
        }
    
        int start = 0;
        int end = arr.length - 1;
    
        // Determine if the array is sorted in ascending or descending order
        boolean isAsc = arr[start] <= arr[end];
    
        while (start <= end) {
            int mid = start + (end - start) / 2;
    
            // Check if the mid element is the target
            if (arr[mid] == target) {
                return mid;
            }
    
            if (isAsc) {
                // Ascending order
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Descending order
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1; // Target not found
    }
    
     
    // [1,2,4,5]:    for target 3 ceiling will be 4 
    public static int celingOfNumber(int arr[], int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return arr[mid];
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return arr[start];

    }

    // [1,2,4,5]:    for target 3 floor will be 2  
    public static int floorOfNumber(int arr[], int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return arr[mid];
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return arr[end];

    }

    public static int searchInInfiniteArray(int arr[],int target){
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while (target > arr[end]) {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        
        return infiniteArrayBinarySearch(arr, target, start, end);

    }
    public static int infiniteArrayBinarySearch(int arr[], int target, int start,int end){
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }


    public static int binarySearchUsingRecursion(int arr[], int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }

        if(arr[mid]>target){
            return binarySearchUsingRecursion(arr, target, start,mid-1);
        }
        return binarySearchUsingRecursion(arr, target, mid+1, end);
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int arr[] = {1,2,3,4,2,20,45,67};
        int arr1[] = {67,45,34,5,3,2,1};

        // System.out.println(linearSearch(arr,6));
        // String s="Jayesh";
        // char c='z';
        // System.out.println(linearSearchinString(s, c));
        // countNum(-10020);
        // System.out.println(orderAgnosticBinarySearch(arr,3));
        // System.out.println(orderAgnosticBinarySearch(arr1,3));
        // System.out.println(floorOfNumber(arr, 66));
        // System.out.println(searchInInfiniteArray(arr,65));
        // System.out.println(binarySearchUsingRecursion(arr, 45, 0, arr.length-1));
        findAllIndexLinearSearchUsingRecursion(arr,2, 0);
        System.out.println(list);
        
    }
}
