package Collections;


import java.util.LinkedList;

class Node {

    int val;
    char charval;
    Node next;

    public Node(int val) {
        this.val = val;
    }


}

public class LinkList {

    Node root;



    public LinkList(Node root) {
        this.root = root;
    }


    public void addNode(Node newNode){

        Node current = root;
        while(current.next!=null){
            current= current.next;
        }
        current.next = newNode;

    }

    public  boolean deleteNode(int val){

        Node pre=null;
        Node current=root;
        while(current!=null)
        {
            if(current.val==val){

                if(pre==null)
                {
                   root = root.next;
                   return true;
                }
                else {
                    pre.next = current.next;
                    return true;
                }

            }
        pre = current;
        current=current.next;
        }
        return false;


    }

    // Reverse the linked List
    public Node reverseLinkedList(Node root){



        return null;
    }

    public void printList(){
        Node current = root;

        while(current!=null){
            System.out.println(current.val+"  ");
            current=current.next;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(3);

        LinkList ll = new LinkList(root);

        ll.addNode(new Node(5));

        ll.addNode(new Node(7));

        ll.addNode( new Node(11));

            ll.printList();

        System.out.println(" After Delete " + 5);

            ll.deleteNode(5);

            ll.printList();
            //

        LinkedList<String> ll1 = new LinkedList();






    }



}
