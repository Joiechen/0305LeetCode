package practice;

public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
  }

  public String toString(){
    String res = "";
    ListNode n = this;
    while(n!=null){
        res += n.val+" -> ";
        n = n.next;
    }
    res += "end";
    return res;
}
}