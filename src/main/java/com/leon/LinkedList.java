package com.leon;

public class LinkedList<T> implements List<T>
{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void add(T element)
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");

        Node<T> newNode = new Node<>(element);
        if(head != null)
        {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        else
        {
            head = newNode;
            tail = newNode;
        }

        ++size;
    }

    @Override
    public void remove(T element)
    {
        Node<T> current = head;
        while(current != null)
        {
            if(current.getData().equals(element))
            {
                if(current == head)
                    head = current.getNext();
                Node<T> previousItem = current.getPrev();
                Node<T> nextItem = current.getNext();
                size--;
                current.setPrev(null);
                current.setNext(null);
                if(previousItem != null)
                    previousItem.setNext(nextItem);
                if(nextItem != null)
                    nextItem.setPrev(previousItem);
                break;
            }
            current = current.getNext();
        }
    }

    @Override
    public void set(int index, T element)
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");

        if(index >= size || index < 0)
            throw new IllegalArgumentException("Index needs to be greater than or equal to zero and less than the size");

        Node<T> current = head;
        for(int i = 0; i < index; i++)
        {
            current = current.getNext();
        }
        current.setData(element);
    }

    @Override
    public T get(int index)
    {
        if(index >= size || index < 0)
            throw new IllegalArgumentException("Index needs to be greater than or equal to zero and less than the size");

        if(size == 0)
            return null;

        Node<T> current = head;
        for(int i = 0; i < index; i++)
        {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {
        if(size == 0)
            return;

        Node<T> current = head;
        while(current != null)
        {
            Node<T> next = current.getNext();
            current.setPrev(null);
            current.setNext(null);
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T element)
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");

        Node<T> current = head;
        while(current != null)
        {
            if(current.getData().equals(element))
                return true;
            else
                current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("{");
        Node<T> current = head;
        while(current != null)
        {
            Node<T> next = current.getNext();
            builder.append(current.getData());
            if(next != null)
                builder.append(", ");
            current = next;
        }
        builder.append("}");
        return builder.toString();
    }
}
