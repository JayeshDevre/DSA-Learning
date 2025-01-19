import java.util.*;

public class Pratice{

        static void swap(int arr[], int index1, int index2){

            int temp=arr[index1];
            arr[index1]=arr[index2];
            arr[index2]=temp;

        }

        static void reverse(int arr[]){
            int start=0;
            int end=arr.length-1;
            while(start<end){
                swap(arr,start,end);
                start++;
                end--;
            }
        }

        static Boolean palindrom(String str){
            for(int i=0;i<str.length()/2;i++){
                char start=str.charAt(i);
                char end= str.charAt(str.length()-1-i);
                if(start!=end){
                    return false;
                }
            }
            return true;
        }

        static int fibbonacci(int num){
            if(num==0 || num==1){
                return num;
            }
            return fibbonacci(num-1)+fibbonacci(num-2);
        }

        // print 1 to n
        public static int countzero(int n){
            return printNum(n, 0);
        }
        public static int printNum(int n,int count){
            if(n==0){
                return count;
            }
            int rem=n%10;
            if(rem==0){
                return printNum(n/10, count=count+1);
            }
            
            return printNum(n/10,count);
        }

        public static void pattern(int row,int col){
            if(row==0){
                return;
            }
            if(col<row){
                System.out.print("*");
                pattern(row, col+1);
                
            }else{
                System.out.println();
                pattern(row-1,0);
                
            }
        }

      


        

        public static void main(String args[]){
            int [] arr={4,3,2,1};
        // Scanner sc=new Scanner(System.in);
        // int n=12304;
       
        // int n2= countzero(30300000);
        // System.out.println(n2);
        // pattern(4, 0);
        System.out.println(Arrays.toString(arr));
      
       
    

 }
}
