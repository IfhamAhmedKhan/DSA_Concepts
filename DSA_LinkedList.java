package project;

public class DSA_LinkedList {
    public static void main(String[] args) {
        Drive ll= new Drive();
        ll.head=null;
        ll.head=ll.insert_pos(5, 1, ll.head);
        ll.head=ll.insert_pos(6, 2, ll.head);
        ll.display(ll.head);
        ll.head= ll.delete(1, ll.head);
        System.out.println("After deletion");
        ll.display(ll.head);
        //---------------------------
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(10);
        dll.insertFirst(20);
        dll.insertFirst(30);
        dll.insertLast(5);
        dll.display();
        dll.deleteLast();
        System.out.println("Deleted Node");
        dll.display();
        //----------------------------
        System.out.println("Creating Circular Linked List Object...");
        CircularLinkedList CLL = new CircularLinkedList();
        
        System.out.println("\nAdding Node With Value 1 to End...");
        CLL.addAtEnd(1);
        System.out.println("\nAdding Node With Value 2 to End...");
        CLL.addAtEnd(2);
        System.out.println("\nAdding Node With Value 3 to End...");
        CLL.addAtEnd(3);
        System.out.println("\nAdding Node With Value 4 to End...");
        CLL.addAtEnd(4);
        System.out.println("\nAdding Node With Value 5 to End...");
        CLL.addAtEnd(5);
        System.out.println("\nAdding Node With Value 6 to Beginning...");
        CLL.addAtBeginning(6);

        System.out.print("\nPrint list: ");
        CLL.printList();

        System.out.print("\n\nSize of list: ");
        System.out.print(CLL.size());
        
        System.out.println("\n\nDeleting head/first node from the list...");
        CLL.deleteBeginning();

        System.out.print("\nPrint list: ");
        CLL.printList();
        
        System.out.println("\n\nDeleting Node With Value 5 from the list...");
        CLL.deleteSpecificNode(5);
        
        System.out.print("\nPrint list: ");
        CLL.printList();

        System.out.print("\n\nChecking if 5 is in the list... ");
        System.out.print(CLL.search(5));
        
        System.out.print("\n\nGetting the 4th Node's data: ");
        System.out.print(CLL.getNthNode(4).data);
        
    }
}
//Singly linkedlist
 class Node {
    int data;
    Node next=null;
    Node(int data){
        this.data=data;
        this.next=null;
    }}
class Drive{
    Node head;
    Node insert_pos(int key, int pos, Node head){
    Node temp= new Node(key);
    if(pos==1){
    temp.next=head;
    head=temp;}
    else{
        Node temp1=head;
        for (int i = 1; temp1!=null && i< pos-1; i++) {
            temp1=temp1.next;}
        temp.next=temp1.next;
        temp1.next=temp;
    }
       return head;
    }
   
    Node delete(int pos,Node head){
        Node temp=head;
        if(pos==1){
        head=temp.next;
        }
        else{
        for (int i = 1; temp!=null && i< pos-1; i++) {
            temp=temp.next;}
        temp.next=temp.next.next;
        }
        return head;
    }
void display(Node head){
    Node temp=head;
    while(temp!=null){System.out.println(temp.data+"");
    temp=temp.next;}

}
    }
//--------------------------------
//Doubly linkedlist
class DoublyLinkedList {
    public class ListNode{
        int data;
        ListNode next;
        ListNode previous;
        public ListNode(int data){this.data=data;}
    }
   
    //instance varibles
    ListNode head;
    ListNode tail;
    int length;
   
   //constructor
    public DoublyLinkedList(){
    this.head=null;
    this.tail=null;
    this.length=0;
    }
   
    public boolean isEmpty(){return length==0;}
   
    public int length(){
    return length;
    }
   
    public void insertFirst(int value){
    ListNode New_node=new ListNode(value);
    if(isEmpty()){tail=New_node;}
    else{head.previous=New_node;}
    New_node.next=head;
    head=New_node;
    length++;
    }
   
    public void insertLast(int value){
    ListNode New_node=new ListNode(value);
    if(isEmpty()){head=New_node;}
    else{
    tail.next=New_node;
    New_node.previous=tail;}  
    tail=New_node;
    length++;
    }
   
    public ListNode deleteLast(){
    ListNode temp=tail;
    if(head==tail){
    head=null;
    }else{
    tail.previous.next=null;
    }
    tail=tail.previous;
    temp.previous=null;
    length--;
    return temp;
    }
   
    public void display(){
    if(head==null){
    return;}
    ListNode temp=head;
    while(temp!=null){
    System.out.println(temp.data+",");
    temp=temp.next;
    }
        System.out.println("Null");
   
    }
   
   
}
//-----------------------
//Circular linkedlist
class CircularLinkedList {
    
    public class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public void addAtEnd(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
    }
    
    public void addAtBeginning(int data){
        Node newNode = new Node(data);
        Node temp = head;
        head = newNode;
        tail.next = head;
        head.next = temp;
    }
    
    public void deleteBeginning(){
        Node temp = head;
        head = head.next;
        tail.next = head;
    }

    public boolean search(int data){
        if (head == null){return false;}
        else {
            Node currNode = head;
            while (currNode.next != head){
                if (currNode.data == data){return true;}
                currNode = currNode.next;
            }
        }
        return false;
    }

    public void deleteSpecificNode(int data){
        Node currNode = head;
        if (head == null){return;}
        else {
            while(currNode.next.next != head){
                if (currNode.next.data == data){
                    currNode.next = currNode.next.next;
                    return;
                }
                currNode = currNode.next;
            }
            if(tail.data==data){
                tail = currNode;
                currNode.next = currNode.next.next;
            }
        }
    }
    
    public int size(){
        Node currNode = head; int count = 0;
        while(currNode.next != head){
            currNode = currNode.next;
            count++;
        }
        return ++count;
    }
    
    public Node getNthNode(int N){
        if(head==null){return null;}
        else if(N>size()){return null;}
        Node currNode = head;
        for(int i=1; i<N; i++){currNode = currNode.next;}
        return currNode;
    }

    public void printList(){
        if (head != null){
            Node currNode = head;
            while (currNode.next != head){
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        }
        System.out.print(tail.data);
    }
    
}