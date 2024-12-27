package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://leetcode.com/problems/asteroid-collision/description/

public class Asteroid_Collision {

    public int[] asteroidCollision(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>(); // Use Deque instead of Stack

        for (int num : nums) {
            if (num > 0) {
                // Positive asteroid moves to the right, no collision possible
                st.push(num);
            } else {
                // Negative asteroid moving to the left
                while (!st.isEmpty() && st.peek() > 0) {
                    // Collision: Compare absolute values
                    if (Math.abs(st.peek()) < Math.abs(num)) {
                        st.pop(); // Left asteroid destroys top of stack
                    } else if (Math.abs(st.peek()) == Math.abs(num)) {
                        st.pop(); // Both asteroids destroy each other
                        num = 0; // Mark current asteroid as destroyed
                        break;
                    } else {
                        // Right asteroid is bigger, current asteroid is destroyed
                        num = 0;
                        break;
                    }
                }

                if (num != 0) {
                    // Current asteroid survived all collisions
                    st.push(num);
                }
            }
        }

        // Convert stack to result array
        int[] result = new int[st.size()];
        int i = st.size() - 1;
        for (int asteroid : st) {
            result[i--] = asteroid;
        }

        return result;
    }


}
