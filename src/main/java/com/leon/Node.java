package com.leon;

public class Node <T>
{
    private T data;
    private Node<T> next;
    private Node<T> prev;

    Node(T data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public Node<T> getNext()
    {
        return next;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public Node<T> getPrev()
    {
        return prev;
    }

    public void setPrev(Node<T> prev)
    {
        this.prev = prev;
    }

    @Override
    public String toString()
    {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode()
    {
        return data != null ? data.hashCode() : 0;
    }
}
