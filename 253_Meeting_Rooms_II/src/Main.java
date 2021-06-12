import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

       // int[][] intervals={{0,30},{5,10},{15,20}};

        //int[][] intervals={{7,10},{2,4}};
        int [][] intervals={{0,30},{5,10},{15,20}, {21,25}, {0,15}};
        Solution solution= new Solution();
        System.out.println("Result: "+solution.minMeetingRooms(intervals));


    }
}

class Solution{

   public int minMeetingRooms(int[][] intervals){
       if(intervals.length==0){
           return 0;
       }
       //Arrays.sort(intervals,(i1,i2)->i1[0]-i2[0]);
       Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
       System.out.println(Arrays.deepToString(intervals));
       PriorityQueue<Integer> queue = new PriorityQueue<>();
       //{0,30},{5,10},{15,20}, {21,25}, {0,15}
       for(int row=0;row<intervals.length;row++){
           if(row==0){
               queue.add(intervals[row][1]);
           }else{
               Integer endTime=queue.peek();
               if(intervals[row][0]<endTime){
                   queue.add(intervals[row][1]);
               }else{
                   queue.remove();
                   queue.add(intervals[row][1]);
               }
           }
       }
       System.out.println("=========");
       System.out.println(queue);
       System.out.println("=========");
       System.out.println(queue.size());
       return queue.size();
   }

}
