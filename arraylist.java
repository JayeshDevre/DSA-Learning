import java.util.*;
public class arraylist {
    public static void main(String[] args) {
        System.out.println("Arraylist");

        Scanner sc =new Scanner(System.in);
// One dimensional arraylist
        ArrayList <Integer> list=new ArrayList<>();

        // for(int i=0;i<5;i++){
        //     list.add(sc.nextInt());
        // }
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);    
        // for(int i=0;i<5;i++){
        //      System.out.print(list.get(i));
        // }
        System.out.println(list);
        list.add(1);
        list.set(0,2);
        System.out.println( list.contains(5));
        System.out.println(list);
        // list.equals(arr);
        System.out.println(list.size());



        // Multi dimensional arraylist


        ArrayList<ArrayList<Integer>> list1= new ArrayList<>();

        for(int i=0;i<3;i++){
            list1.add(new ArrayList());
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                list1.get(i).add(sc.nextInt());
            }
        }
        // System.out.print(list1);
        for (ArrayList<Integer> row : list1) {
            System.out.println(row);
        }
        

    }
}
