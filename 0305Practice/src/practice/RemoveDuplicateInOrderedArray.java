package practice;

//leetcode https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicateInOrderedArray {

  /**
   * 快慢双指针，时间复杂度O(n),空间复杂度O(1)
   * @param nums
   * @return
   */
  public static int removeDuplicates01(int[] nums) {
    if (nums.length==0)
    {
       return 0;
    }

    int i = 0;
      for (int j=1; j<nums.length; j++) {
        if (nums[j]!=nums[i]) {
          i++;
          nums[i] = nums[j];
        }
    }
    return i + 1;
  }

  /**
   * 遍历数组，空间复杂度O(1),时间复杂度O(n),不对，当出现多次重复数组时，会出现计算错误
   */
  public static int removeDuplicates02(int[] nums) {
    if (nums.length == 0)
    {
       return 0;
    }

    int count = 1;
    int index = 0;
    for (int i = 0; i < nums.length-1; i++)
    {
      if (nums[i] == nums[i+1]) {
        continue;
      } else {
        index++;
        nums[index] = nums[i+1];
        count++;
      }
    }
    return count;
  }
    
    public static void main(String[] args) throws Exception {
      int[] testNums01 = {1,1,2,3};
      int[] testNums02 = {-1,1,2,2,3};
      int[] testNums03 = {-1,1,1,2,3,3,5};
      System.out.println(removeDuplicates01(testNums01));
      System.out.println(removeDuplicates01(testNums02));
      System.out.println(removeDuplicates01(testNums03));

      System.out.println(removeDuplicates02(testNums01));
      System.out.println(removeDuplicates02(testNums02));
      System.out.println(removeDuplicates02(testNums03));
    }
}