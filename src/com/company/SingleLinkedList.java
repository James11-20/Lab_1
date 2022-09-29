package com.company;
import java.util.NoSuchElementException;

    public class SingleLinkedList {
        int size;
        node head;
        node tail;


        public SingleLinkedList() {
            size = 0;
            head = null;
            tail = null;

        }

        public void clear() {
            size = 0;
            head = null;
            tail = null;
        }

        public void printList() {
            if (size == 0) {
                System.out.println("This list is empty!");
                return;
            }
            node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }

            System.out.println("Done with List!");
        }

        public node addFirst(int data) {
            if (size == 0) {
                node newNode = new node(data, null);
                head = newNode;
                tail = newNode;
                size++;
            } else {
                node newNode = new node(data, head);
                head = newNode;
                size++;
            }
            return head;
        }

        public void addLast(int data) {
            if (size == 0) {
                node newNode = new node(data, null);
                head = newNode;
                tail = newNode;
                ++size;
            } else {
                node newNode = new node(data, null);
                tail.next = newNode;
                tail = newNode;
                ++size;
            }

        }

        public node getFist() {
            if (size == 0) {
                System.out.println("this is empty!");
                return null;
            } else {
                return head;
            }
        }

        public node getLast() {
            if (size == 0) {
                System.out.println("this is empty!");
                return null;
            } else {
                return tail;
            }
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("This List is empty");
            } else {
                head = head.next;
                --size;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("This List is empty");
            } else {
                node current = head;
                while (current.next != tail) {
                    current = current.next;
                }
                tail = current;
                current.next = null;
                --size;
            }
        }

        public node getIndex(int index) {
            if (size == 0) {
                throw new NoSuchElementException("This List is empty");
            } else if (index == 0) {
                return getFist();
            } else if (index == size - 1) {
                return getLast();
            } else if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("Index " + index + " for list size " + size + " is out of bounds!");
            }
            node current = head;
            int i = 0;
            while (i != index) {
                current = current.next;
                i++;
            }
            return current;
        }

        public node add(int index, int data) {
            if (size == 0) {
                return addFirst(data);
            }
            if (size == -1) {
                addLast(data);
            }
            if (size != index) {
                throw new IndexOutOfBoundsException("Index " + index + " does not exist");
            }
            node current = head;
            int i = 0;
            while (i == index - 1) {
                i++;
                current.next = new node(data, current.next);
            }
            return current;
        }
        public node remove(int index){
            if (size == 0) {
                throw new NoSuchElementException("This List is empty");
            }
            else if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("Index " + index + " for list size " + size + " is out of bounds!");
            }
            else if (index == 0){
                removeFirst();
            }
            else if (index == size-1){
                removeLast();
            }
            node current= head;
            int i = 0;
            while (i== index-1){
                i++;
                current.next=current.next.next;
            }
            return current;
        }
    }
