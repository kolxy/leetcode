package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class Lc0001TwoSum implements LcTemplate {
    @Override
    public void run() {
        int[] param1 = new int[] {1,2,3,4,5,6,7};
        int param2 = 9;
        System.out.println(Arrays.toString(twoSum(param1, param2)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target-nums[i], i);
            }
        }
        return new int[] {};
    }
}
