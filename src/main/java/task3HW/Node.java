package task3HW;

public class Node {
    int value;
    Node next;
    Node previous;

    @Override
    public String toString() {
        return "value = " + value;
    }

    public static void add(int value, Node head, Node tail){
        Node node = new Node();
        node.value = value;

        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }

    }


    public static void printAll(Node head, Node tail) {
        Node curentNode = head;
        while (curentNode != null){
            System.out.println(curentNode);
            curentNode = curentNode.next;
        }
        System.out.println("End");
    }
}
