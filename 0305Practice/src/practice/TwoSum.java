package practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  //时间和空间复杂度O(n),哈希表的时间复杂度O(1) 大大简化了运算时间
  public static int[] twoSum01(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}

  public static void main(String[] args) {
    int[] test01 = {2, 5, 6, 8, 10};
    int[] result = twoSum01(test01,10);
    for(int i=0; i<result.length; i++){
       System.out.println(result[i]);
    }

  }
}