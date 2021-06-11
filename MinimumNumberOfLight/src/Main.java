public class Main {
    public static void main(String[] args) {
        //int[] arr3 = {0, 0, 1, 0, 1, 0, 0};
        //int[] arr3={0, 0, 1, 1, 1, 0, 0, 1};
        int[] arr3={0, 0, 0, 1, 0};
        int B = 3;
        Solution solution = new Solution();
       int res= solution.minimumsLight(arr3,B);
        System.out.println("result: "+res);

    }
}

class Solution{

    int  minimumsLight(int[] nums, int B){

        int len = nums.length;
        System.out.println("len: "+len);
        int i=0;
        int count=0;
        while(i<len) {
            int reach = i + (B -1);
            System.out.println("reach: "+ reach);
            if(reach >= len)
            {
                reach = len - 1;
                //return count;

            }
            System.out.println("after reach: "+reach);

            int j = reach;
            boolean flag = false;
            while(j > i - B + 1 && j>=0) {
                if(nums[j] == 1)
                {
                    count++;
                    flag = true;
                    break;
                }
                j--;
                System.out.println("j: "+j);
            }
            if(!flag) {
                System.out.println(-1);
                return -1;
            }


           // i = j + (B-1) ;
            System.out.println("prev i: " +i );
            i=j+(B-1)+1;
            System.out.println("next i: and J:  "+i + " jjjj: " +j);
        }
        System.out.println(count);
        return count;
    }

}