package practice;

import java.util.Arrays;

public class MergeSortedArray {

  //取nums1的m长度和nums2的n长度，合并为一个Array
  //排序新的Array
  //时间复杂度 O((n+m)log(n+m)),空间复杂度O(1)
  public static void merge01(int[] nums1, int m, int[] nums2, int n) {

    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);

  }

  //双指针
  //时间复杂度：O(n+m),空间复杂度：O(1)
  public static void merge02(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;
    
    int p = m + n - 1;

    while ((p1 >= 0) && (p2 >= 0))
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
      System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
  }

  public static void main(String[] args) throws Exception {
    int[] testnums1 = {1,2,3,0,0,0};
    int[] testnums2 = {2,5,6};
    merge01(testnums1,3,testnums2,3);
    merge02(testnums1,3,testnums2,3);
  }
}