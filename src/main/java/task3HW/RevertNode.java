package task3HW;

import static task3HW.Node.*;

public class RevertNode {
    public static void main(String[] args) {
        //node[0] - head
        //node[1] - tail
        Node[] node = new Node[2];

        for (int i = 0; i < 10; i++) {
            node = add(i + 1, node[0], node[1]);
        }


        printAll(node[0]);
        node = revert(node);
        printAll(node[0]);
    }


    /**
     * переворот двухсвязного списка
     *
     * @param node голова + хвост
     * @return голова + хвост
     */
    public static Node[] revert(Node[] node) {
        return revert(node[0], node[1]);
    }

    /**
     * переворот двухсвязного списка
     *
     * @param head голова
     * @param tail хвост
     * @return голова + хвост
     */
    public static Node[] revert(Node head, Node tail) {
        Node curentNode = head;
        while (curentNode != null) {
            Node next = curentNode.next;
            Node previous = curentNode.previous;
            curentNode.next = previous;
            curentNode.previous = next;

            if (previous == null) {
                tail = curentNode;
            }
            if (next == null) {
                head = curentNode;
            }
            curentNode = next;
        }
        return new Node[]{head, tail};
    }

    /**
     * Добавление в список
     *
     * @param value значение
     * @param head  голова
     * @param tail  хвост
     * @return массив из головы и хвоста
     */
    public static Node[] add(int value, Node head, Node tail) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }

        return new Node[]{head, tail};
    }


    /**
     * печать всег списка
     *
     * @param node голова + хвост
     */
    public static void printAll(Node[] node) {
        printAll(node[0]);
    }

    /**
     * печать всего списка
     *
     * @param head голова
     */
    public static void printAll(Node head) {
        Node curentNode = head;
        while (curentNode != null) {
            System.out.println(curentNode);
            curentNode = curentNode.next;
        }
        System.out.println("End");
    }

}
