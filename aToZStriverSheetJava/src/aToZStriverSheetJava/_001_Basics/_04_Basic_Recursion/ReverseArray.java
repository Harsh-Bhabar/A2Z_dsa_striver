package aToZStriverSheetJava._001_Basics._04_Basic_Recursion;

import java.util.ArrayList;

public class ReverseArray {

    public static ArrayList<Integer> reverseArrayType1(ArrayList<Integer> arr, int ind, ArrayList<Integer> rev){
        if(ind < 0){
            return rev;
        }else {
            rev.add(arr.get(ind));
            return reverseArrayType1(arr, ind-1, rev);
        }
    }

    public static void reverseArrayType2(int[] nums, int start, int end){
        if(start >= end){
            return;
        }else{
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            reverseArrayType2(nums, start+1, end-1);
        }
    }

    public static void main(String[] args){
//        Type - 1
//        ArrayList<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.add(4);
//        nums.add(5);
//        ArrayList<Integer> revs = reverseArrayType1(nums, nums.size()-1, new ArrayList<>());
//        System.out.println(revs);

//         Type - 2

        int[] nums = {1, 2, 3, 4, 5};
        reverseArrayType2(nums, 0, nums.length-1);
        for(int x: nums){
            System.out.print(x);
        }

    }
}
