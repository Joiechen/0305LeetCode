package practice;

public class MergeSortedLists {

  // 递归，时间复杂度 O(n+m),空间复杂度 O(n+m)
  public static ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;

    if (l1.val < l2.val) {
      l1.next = mergeTwoLists01(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists01(l1, l2.next);
      return l2;
    }
  }

  // 简化代码
  public static ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null)
      return l2 == null ? l1 : l2;
    ListNode first = (l2.val < l1.val) ? l2 : l1;
    first.next = mergeTwoLists02(first.next, first == l1 ? l2 : l1);
    return first;
  }

  //测试用例
  public static ListNode testCase(int[] test) {
    ListNode head = new ListNode(test[0]);
    ListNode it = head;
    for (int i = 1; i < test.length; i++) {
      it.next = new ListNode(test[i]);
      it = it.next;
    }
    return head;
  }

  public static void main(String[] args) {
    int[] listnode1 = { 1, 3, 5};
    int[] listnode2 = { 1, 2, 4};
    ListNode l1 = testCase(listnode1);
    ListNode l2 = testCase(listnode2);
    System.out.println("testcase1: " + mergeTwoLists02(l1, l2));
  }
}