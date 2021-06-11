import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // int[][] intervals = {{7,10}, {2,4}};
        //int[][] intervals = {{10,30}, {5,10}, {15,20}};
        int [][] intervals=  {{1, 3}, {4, 6}, {8, 10}, {15, 18}};



        Solution obj= new Solution();
        System.out.println(obj.canAttendMeetings(intervals));
    }



}

class Solution{

    public boolean canAttendMeetings(int[][] intervals) {
        System.out.println(Arrays.deepToString(intervals));
        Arrays.sort(intervals,(i1,i2)-> i1[0]- i2[0]);
        System.out.println(Arrays.deepToString(intervals));

        for(int row=0;row<intervals.length -1;row++){
            if(intervals[row][1] > intervals[row+1][0]) {
                return false;
            }
        }
        return true;


    }


}