package practice;

//leetcode https://leetcode.com/problems/design-circular-deque/
public class CircularDeque {

  //Use 2 points，insert is update current point value, delete is remove point, not change current value

  int[] qeue;
  int front, rear, len;

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public CircularDeque(int k) {
    qeue = new int[k + 1];
    front = 0;
    rear = 0;
    len = k + 1;
  }
  
  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if (isFull()) return false;
    qeue[front] = value;
    front = (front + 1) % len;
    return true;
  }
  
  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
      if (isFull()) return false;
      rear = (rear - 1 + len) % len;
      qeue[rear] = value;
      return true;
  }
  
  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
      if (isEmpty()) return false;
      front = (front - 1 + len) % len;
      return true;
  }
  
  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
      if (isEmpty()) return false;
      rear = (rear + 1) % len;
      return true;
  }
  
  /** Get the front item from the deque. */
  public int getFront() {
      return isEmpty() ? -1 : qeue[(front - 1 + len) % len];
  }
  
  /** Get the last item from the deque. */
  public int getRear() {
    return isEmpty() ? -1 : qeue[rear];  
  }
  
  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return front == rear;   
  }
  
  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
      return (front + 1) % len == rear;
  }


  public static void main(String[] args){
    CircularDeque obj = new CircularDeque(5);
    System.out.println(obj.insertFront(2));
    System.out.println(obj.insertLast(3));
    System.out.println(obj.insertFront(4));
    System.out.println(obj.insertFront(6));
    System.out.println(obj.insertFront(7));
    System.out.println(obj.deleteFront());
    System.out.println(obj.deleteLast());
    System.out.println(obj.getFront());
    System.out.println(obj.getRear());
    System.out.println(obj.isEmpty());
    System.out.println(obj.isFull());
  }
}