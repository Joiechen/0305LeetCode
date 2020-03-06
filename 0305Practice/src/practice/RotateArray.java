package practice;

public class RotateArray{

  /***
   * 旋转K次，时间复杂度N(k*n),空间复杂度O(1)
   * @param nums
   * @param k
   */
  public static int[] rotate01(int[] nums, int k){
    int temp, previous;
    for(int i = 0; i < k; i++){
      previous = nums[nums.length - 1];
      for(int j = 0;j < nums.length; j++){
        temp = nums[j];
        nums[j] = previous;
        previous = temp;
      }
    }
    return nums;
  }

  public static void main(String[] args) throws Exception {
    int[] testnums1 = {9,8,7,6,5,3,4,3,2,1};
    int[] res1 = rotate01(testnums1,3);
    for(int i=0;i<testnums1.length;i++){
        System.out.println(res1[i]);
    }
  
  }
}