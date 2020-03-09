package practice;

//leetcode https://leetcode-cn.com/problems/rotate-array/
public class RotateArray {

  /***
   * 旋转K次，时间复杂度O(k*n),空间复杂度O(1)
   * @param nums
   * @param k
   */
  public static int[] rotate01(int[] nums, int k) {
    int temp, previous;
    for (int i = 0; i < k; i++) {
      previous = nums[nums.length - 1];
      for (int j = 0;j < nums.length; j++) {
        temp = nums[j];
        nums[j] = previous;
        previous = temp;
      }
    }
    return nums;
  }

  /***
   * 环状替换，时间复杂度O(n),空间复杂度O(1)
   * @param nums
   * @param k
   */
  public static int[] rotate02(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int current = start;
      int prev = nums[start];
      do {
        int next = (current + k) % nums.length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
    return nums;
  }

  /***
   * 使用额外的数组，时间复杂度O(n),空间复杂度O(n)
   * @param nums
   * @param k
   */
  public static int[] rotate03(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i<nums.length; i++) {
      a[(i+k) % nums.length] = nums[i];
    }
    for (int i = 0;i<nums.length; i++) {
      nums[i] = a[i];
    }
    return nums;
  }


  public static void main(String[] args) throws Exception {
    int[] testnums1 = {9,8,7,6,5,3,4,3,2,1};
    int[] res1 = rotate01(testnums1,3);
    int[] res2 = rotate02(testnums1,3);
    int[] res3 = rotate03(testnums1,3);
    for (int i = 0; i < testnums1.length; i++) {
        System.out.println(res1[i]);
        System.out.println(res2[i]);
        System.out.println(res3[i]);
    }
  
  }
}