package g13c.cw1.zd6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] tab = new Random().ints(10, 100, 1000).toArray();
        System.out.print("Generated array: ");
        printArray(tab);
        System.out.print("Sorted array: ");
        printArray(sort(tab));
    }

    private static int[] sort(int[] arg){
        int temp;

        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = 0; j < arg.length - 1; j++) {
                if (arg[j] > arg[j + 1]) {
                    temp = arg[j];
                    arg[j] = arg[j + 1];
                    arg[j + 1] = temp;
                }
            }
        }
        return arg;
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i] + (i==arr.length-1?"":", "));
        }
        System.out.println("]");
    }
}
