package ru.geekbrains.java.homeworks;

public class TwoLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = head;

        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            newNode.prev = null;
            head = newNode;
        }
        size++;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = head;

        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;

        }
        size++;

    }

    public void addByIndex(int index, String data) {
        if (index > size) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, size));
        }

        if (index == 0) {
            if (head == null) {
                head = new Node(data);
                tail = head;

            } else {
                Node newNode = new Node(data);
                newNode.setNext(head);
                newNode.prev = null;
                head = newNode;
            }
            size++;
            return;
        }

        int currentIndex = 1;
        Node current = head.getNext();

        while (currentIndex != index) {
            current = current.getNext();
            currentIndex++;
        }

        if (current == null) {
            addLast(data);
        } else {
            Node newNode = new Node(current.getPrev(), data, current);
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }
        size++;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void removeFirst() {
        if (!isEmpty()) {
            Node temp = head;

            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            System.out.println(temp.toString() + " is popped from the list");
            size--;
        }
    }

    public void removeLast() {
        Node temp = tail;

        if (!isEmpty()) {

            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
        System.out.println(temp.toString() + " is popped from the list");
        size--;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "TwoLinkedList{" +
                "head=" + head +
                '}';
    }


    private static class Node {
        private Node prev;
        private String data;
        private Node next;


        public Node(String data) {
            prev = null;
            this.data = data;
            next = null;
        }

        public Node(Node prev, String data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public void displayNode() {
            System.out.print(data + " ");
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    //", prev=" + prev +
                    '}';
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }


}
