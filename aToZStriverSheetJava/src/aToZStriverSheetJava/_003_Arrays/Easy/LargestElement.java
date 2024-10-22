package aToZStriverSheetJava._003_Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestElement {

    public static int findMaxEle(List<Integer> nums, int n){
        if(n == 1){
            return nums.get(0);
        }
        return Math.max(nums.get(n-1), findMaxEle(nums, n-1));
    }

    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 2));

//        method 1 - collections
//        System.out.println(Collections.max(nums));

//        method 2- sort
//        Collections.sort(nums);
//        System.out.println(nums.get(nums.size()-1));

//        method - 3 - for loop
//        int max = nums.get(0);
//        for (int i=1; i<nums.size(); i++){
//            if(nums.get(i) > max){
//                max = nums.get(i);
//            }
//        }
//        System.out.println("Max - " + max);

//        method 4 - recursion
        int maxRec = findMaxEle(nums, nums.size());
        System.out.print(maxRec);

    }
}
