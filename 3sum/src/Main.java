import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Demo d= new Demo();
        List<List<Integer> >list = new ArrayList<>();
        int[] nums = {-1,0,1,2,-1,-4};
       // list=d.threeSum(nums,0);
       // System.out.println(list);

        list=d.threeSum1(nums,0);
        System.out.println(list);

    }
}

class Demo{
    Set<List<Integer>> set= new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
            int j=i+1;
            int k= nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target) set.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if (sum>target) k--;
                else j++;

            }

        }

        return new ArrayList(set);

    }

    public List<List<Integer>> threeSum1(int[] nums, int target) {

        for(int i=0;i< nums.length-2;i++){
               int newTarget=target-nums[i];
               twoSum(nums,i+1,newTarget ,nums[i]);

            }



        return new ArrayList(set);

    }
    public void twoSum(int[] nums, int j,int target, int i){
        Map<Integer, Integer> map= new HashMap<>();
        for(;j<nums.length;j++){
            if(map.containsKey(target-nums[j])){
                Integer[] arr={map.get(target-nums[j]), nums[j] , i};
                Arrays.sort(arr);
                set.add(Arrays.asList(arr));
            }else{
                map.put(nums[j],nums[j]);
            }
        }
    }
}