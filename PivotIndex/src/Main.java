import sun.jvm.hotspot.gc_implementation.parallelScavenge.PSYoungGen;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       // int[] nums={1, 7, 3, 6, 5, 6};
        //suffix    27   20   17   11 6    0
        //int[] nums={1,2,3};
        //int [] nums={2,1,-1};
        //int [] nums={-1,-1,0,1,1,0};
        int[] nums={-2,0,-2,0,-2,-2,8,5};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.usingSuffixAndPrefix(nums));

    }
}

class PivotIndex{

    public int pivotIndex(int[] nums) {
        if(nums==null || nums.length==0) {
            return -1;
        }
        int totalSum=0;
        for(int i=0;i< nums.length;i++){
            totalSum+=nums[i];
        }
        //diff=totalsum-nums[i]-currentSum
        //if currentsum==diff, then we found the pivot index
        int currentSum=0;
        for(int i=0;i< nums.length;i++){
            System.out.println("index: "+i);
            int diff=totalSum-nums[i] -currentSum;
            System.out.println("diff: "+diff);
            System.out.println("CS: "+currentSum);
            if(diff==currentSum){
                return i;
            }else{
                currentSum=currentSum+nums[i];

            }

        }

      return -1;
    }

    public int usingSuffixAndPrefix(int[] nums) {
        if(nums==null || nums.length==0) {
            return -1;
        }
        int[] suffixArr= new int[nums.length];
        int currentSuffixSum=0;
        for(int i=nums.length-1;i>=0 ;i--){
            suffixArr[i]=currentSuffixSum;
            currentSuffixSum+=nums[i];
        }
        System.out.println(Arrays.toString(suffixArr));
        int currentPrefixSum=0;
        for(int i=0;i<nums.length;i++){

            //if prefix summ==suffixSum, then that's the pivot point
            if(currentPrefixSum==suffixArr[i]){
                //this will be pivot point
                return i;
            }else{
                currentPrefixSum+=nums[i];
            }
        }
        return -1;
    }
}
