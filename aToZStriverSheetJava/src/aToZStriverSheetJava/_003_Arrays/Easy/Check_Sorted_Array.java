package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2

public class Check_Sorted_Array {
    public boolean check(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return true;
        }

        int cntBreak = 0;
        for(int i=0; i<n; i++){
            if(nums[(i+1)%n] < nums[i]){
                cntBreak++;
            }
            if(cntBreak > 1){
                return false;
            }
        }
        return true;
    }
}
