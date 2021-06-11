import javafx.util.Pair;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //List<Integer> ls= new ArrayList<>();
        //Map<Integer,List<Integer>> map= new HashMap<>();
        //List<Integer> values = new ArrayList<>();
        //values.add(5);
       // map.put(0,new ArrayList<Integer>().add(6));
        //System.out.println(map.get(0));
        //System.exit(1);

       //int [] nums={10,5,7,1,2,5,3}; //k15
        //int [] nums={3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1}; //k5
        int [] nums={2,4,-2,3,-1,3,-2,4}; // k5
     //  int [] nums={3, 2, 4, -2, 3, -1, 3, -2, 4}; //k5


        Demo demo= new Demo();
        System.out.println(demo.subarraySum(nums,5));
        demo.subarraySumwithCountAndIndex(nums,5);

    }


}
class Demo{
    List<ArrayList<String>> listofLists= new ArrayList<ArrayList<String>>();
    public int subarraySum(int[] nums, int k) {
        int result=0;
        int sum=0;
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                result+=map.get(sum-k);
                //map.put(sum,map.getOrDefault(sum,0)+1);
            }
            map.put(sum,map.getOrDefault(sum,0) +1);

        }
        System.out.println("print map");
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println("Keys: "+entry.getKey() + " value: "+entry.getValue());
        }
      return result;
    }

  /*  public void subarraySum1(int[] nums, int k) {
        List<ArrayList<String>> listofList=new ArrayList<ArrayList<String>>();
        int result=0;
        int sum=0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                ArrayList<String> list= new ArrayList<>();

               // result+=map.get(sum-k);
                //map.put(sum,map.getOrDefault(sum,0)+1);
            }
            map.put(sum,map.getOrDefault(sum,0) +1);

        }
        System.out.println("print map");
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println("Keys: "+entry.getKey() + " value: "+entry.getValue());
        }
        return result;
    }*/

    public void subarraySumwithCountAndIndex(int[] nums, int k) {
        int result=0;
        int sum=0;
        List<List<Integer>> list = new ArrayList<>();
        //Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
       // Set<Pair<Integer, Integer>>  set new HashSet<>();

        map.put(0,Arrays.asList(-1));
        for(int i=0;i<nums.length;i++){
            List<Integer> ls = new ArrayList<>();

            sum+=nums[i];
            if(map.containsKey(sum-k)){
                int index;
                ls=map.get(sum-k);
                 if(ls.size()==1){
                     index=ls.get(0);
                     list.add(Arrays.asList(index+1,i));

                 }else{
                    for(int j=0;j<ls.size();j++){
                        int index1=ls.get(j);
                        list.add(Arrays.asList(index1+1,i));
                    }
                 }
               //Result res +=map.get(sum-k);

            }

            List<Integer> values= new ArrayList<>();

            if(map.containsKey(sum))    {
                values=map.get(sum);
                values.add(i);

            }else{
                values.add(i);
            }
            map.put(sum,values);

        }
        //print the list
        //System.out.println(map);
        System.out.println("total count: "+list.size());
        System.out.println(list);

    }

}

