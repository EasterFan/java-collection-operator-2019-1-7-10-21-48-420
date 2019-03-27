package com.thoughtworks.collection;


public class SingleLinkList<T> implements SingleLink<T> {
   private Node<T> header;
   private Node<T> tail;
   private int length;

    public SingleLinkList() {
        this.header = null;
        this.tail = null;
    }


    @Override
    public T getHeaderData() {
        return header.getData();
    }

    @Override
    public T getTailData() {
        return tail.getData();
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public boolean deleteFirst() {
        if (this.length == 0){
            return false;
        }else {
            Node<T> temp = this.header.getNext();
            this.header = temp;
            this.header.setNext(temp.getNext());
            this.length--;
            return true;
        }
    }

    @Override
    public boolean deleteLast() {
        if (this.length == 0) {
            return false;
        } else {
            Node pNode = this.header;
            for (int i=0;i<this.length-2;i++) {
                pNode = pNode.getNext();
            }
            pNode.setNext(null);
            this.length--;
            return true;
        }
    }

    @Override
    public void addHeadPointer(T item) {
        Node<T> node = new Node<>(item);
        node.setNext(this.header);
        this.header = node;
        this.length++;
        if (length == 1) {
            this.tail = this.header;
        }
    }

    @Override
    public void addTailPointer(T item) {
        Node<T> node = new Node<>(item);
        if (this.tail == null) {
            this.tail = node;
            this.tail.setNext(null);
            this.header = this.tail;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.length++;
    }

    @Override
    public T getNode(int index) {
        if (index>=0 && index<this.length) {
            Node<T> pNode = this.header;
            for (int i=0;i<index;i++) {
                pNode = pNode.getNext();
            }
            return pNode.getData();
        }
        return null;
    }
}
