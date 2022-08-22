package com.company;

public class LinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    int size;
    public LinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    public LinkedList(T data)
    {
        head = tail = new Node<>(data);
        size = 1;
    }
    public int getSize()
    {
        return size;
    }
    public Node<T> getHead()
    {
        return head;
    }
    public Node<T> getTail()
    {
        return tail;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public Tuple getTuple(String city)
    {
        Node<Tuple> h = (Node<Tuple>) head;
        while (h != null)
        {
            if ((h.getData()).getCity().equals(city))
            {
                return h.getData();
            }
            h = h.getNext();
        }
        return null;
    }
    public Edge getEdge(String origin)
    {
        Node<Edge> h = (Node<Edge>) head;
        while (h != null)
        {
            if (((h.getData()).getOrigin().equals(origin)))
            {
                return h.getData();
            }
            h = h.getNext();
        }
        return null;
    }
    public void add(T data)
    {
        if (head == null)
        {
            head = tail = new Node<>(data);
        }
        else
        {
            Node<T> h = head;
            while (h.getNext() != null)
            {
                h = h.getNext();
            }
            Node<T> newNode = new Node<>(data);
            h.setNext(newNode);
            h.getNext().setPrev(h);
            tail = h.getNext();
        }
        size++;
    }
    public void delete(T data)
    {
        if (head != null) {
            if (size == 1) {
                if (head.getData().equals(data)) {
                    head = tail = null;
                }
            } else {
                if (head.getData().equals(data)) {
                    head = head.getNext();
                    head.getNext().setPrev(head);
                    head.setPrev(null);
                    size--;
                    return;
                }
                if (tail.getData().equals(data)) {
                    tail = tail.getPrev();
                    tail.getPrev().setNext(tail);
                    tail.setNext(null);
                    size--;
                    return;
                }
                Node<T> h = head;
                while (h.getNext() != null) {
                    if (h.getNext().getData().equals(data)) {
                        if (h.getNext().getNext() != null) {
                            h.setNext(h.getNext().getNext());
                            h.getNext().setPrev(h);
                        }
                        break;
                    }
                    h = h.getNext();
                }
            }
        }
        size--;
    }
    public String toString()
    {
        String s = "";
        Node<T> h = head;
        s += h.getData() +" ";
        while (h.getNext() != null)
        {
            s += h.getNext().getData() +" ";
            h = h.getNext();
        }
        return s;
    }
}
class Node<T>
{
    private T data;
    Node<T> next;
    Node<T> prev;
    public Node(T data)
    {
        this.data = data;
        next = null;
        prev = null;
    }
    public T getData()
    {
        return data;
    }
    public Node<T> getNext()
    {
        return next;
    }
    public Node<T> getPrev()
    {
        return prev;
    }
    public void setNext(Node<T> node)
    {
        next = node;
    }
    public void setPrev(Node<T> node)
    {
        prev = node;
    }
}
