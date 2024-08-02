public class Main {

  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node tail;
  public static Node head;
  // size
  public static int size = 0;

  public void addNode(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    size++;
  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    newNode.next = null;

    if (head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public void printLL() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public void addOnIndex(int idx, int data) {
    Node newNode = new Node(data);
    Node temp = head;
    int i = 0;
    while (i < idx - 1) {
      temp = temp.next;
      i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
    size++;
  }

  // Remove the LinkedList -> remove first, remove last
  public int removeFirst() {
    int data;
    // If size is 0
    if (size == 0) {
      return -1;
    }

    if (size == 1) {
      data = head.data;
      head = tail = null;
      size--;
      return data;
    }

    data = head.data;
    head = head.next;
    size--;
    return data;
  }

  public int removeLast() {
    // Check if the list is empty
    if (size == 0) {
      return -1;
    }

    // Check if the list has only one node
    if (size == 1) {
      int data = tail.data;
      head = tail = null;
      size--;
      return data;
    }

    // Traverse to the second-to-last node
    Node temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }

    // Remove the last node
    int data = tail.data;
    tail = temp;
    tail.next = null;
    size--;
    return data;
  }

  // Iterative search -> return the index of the data
  public int itrSearch(int key) {
    int i = 0; // key is a data of the node
    Node temp = head;
    while (temp != null) {
      if (temp.data == key) {
        return i;
      }
      temp = temp.next;
      i++;
    }
    return -1;
  }

  // search by recurivelly

  public int recsearch(Node head, int key) {
    if (head == null) {
      return -1;
    }
    if (head.data == key) {
      return 0;
    }
    int idx = recsearch(head.next, key);
    if (idx == -1) {
      return -1;
    }
    return idx + 1;
  }

  // reverse a linkedlist

  public void reverse() {
    Node prev = null;
    Node current = tail = head;
    Node next;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }
  // find and remove the Nth node from the end of the linked list

  public int NthNode(int pos) {
      if (pos <= 0 || pos > size) {
          throw new IllegalArgumentException("Position out of bounds");
      }

      Node temp = head;
      int i = 1;
      while (i < (size - pos)) {
          temp = temp.next;
          i++;
      }

      int data;
      if (pos == size) {
          data = head.data;
          head = head.next;
          if (head == null) {
              tail = null;
          }
      } else {
          data = temp.next.data;
          temp.next = temp.next.next;
          if (temp.next == null) {
              tail = temp;
          }
      }

      size--;
      return data;
  }


  // public void NthNodeFromEnd(int n){

  // //find the middle
  // Node slow = head;
  // Node fast = head;
  // Node temp = head;

  // while(temp != null || temp.next != null){
  // slow = slow.next;
  // fast = fast.next.next;
  // }

  // Node middle = slow;

  // Node prev = null;
  // Node current = tail = middle;
  // Node next;

  // while (current != null) {
  // next = current.next;
  // current.next = prev;
  // prev = current;
  // current = next;
  // }
  // head = prev;

  // }
  // }

  public static void main(String[] args) {
    Main ll = new Main();
    ll.printLL();
    System.out.println("Size: " + size);
    ll.addNode(5);
    ll.addNode(6);
    ll.addNode(7);
    ll.addNode(8);
    ll.addNode(9);
    ll.addNode(9);
    ll.printLL();
    // ll.removeFirst();
    // ll.printLL();
    // ll.removeFirst();
    // ll.printLL();

    // int data = ll.removeLast();
    // System.out.println("Removed Last: " + data);
    // ll.removeLast();
    // int index = ll.itrSearch(6);
    // System.out.println("Index of 6: " + index);
    // ll.printLL();

    int idx = ll.recsearch(head, 8);
    System.out.println(idx);

    System.out.println("Reverse the linkedlist");
    ll.reverse();
    ll.printLL();
    ll.NthNode(2);
    ll.printLL();
    int data = ll.NthNode(3);
    System.out.println(size);
     ll.printLL();
    ll.NthNode(2);
    ll.printLL();
  }
}
