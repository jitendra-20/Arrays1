import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(5%10);
        System.out.println("mode: "+35%10);
        int [] arr={1,2,3,4};
        //int [] arr={3, 4, 6};
        Main main= new Main();
       // main.productExceptSelf(arr);
        int [] prefixProduct=new int [arr.length];
        prefixProduct[0]=1;
        int [] sufixProduct=new int [arr.length];
        sufixProduct[arr.length-1]=1;
        System.out.println(arr.length);
        /*for(int i=0;i<arr.length-1;i++){
            prefixProduct[i+1]=prefixProduct[i]*arr[i];
        }*/
        //System.out.println(Arrays.toString(prefixProduct));
        int n=arr.length-1;
        for(int i=n;i>0;i--){
            sufixProduct[i-1]=sufixProduct[i]*arr[i];
        }
        System.out.println(Arrays.toString(sufixProduct));

        //result
        int[] finalArray= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            finalArray[i]=sufixProduct[i]*prefixProduct[i];
        }

        System.out.println(Arrays.toString(finalArray));






    }


}
