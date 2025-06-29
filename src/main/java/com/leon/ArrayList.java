package com.leon;

public class ArrayList<T> implements List<T>
{
    private int size = 0;
    private int capacity = 0;
    private T[] array;

    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity)
    {
        capacity = initialCapacity;
        array = (T[]) new Object[initialCapacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList()
    {
        capacity = 10;
        array = (T[]) new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element)
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");

        if(size == capacity)
        {
            capacity = capacity * 2;
            T[] newArray = (T[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size++] = element;
    }

    @Override
    public void remove(T element)
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");

        for(int i = 0; i < size; i++)
        {
            if(array[i].equals(element))
            {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[--size] = null;
                break;
            }
        }
    }

    @Override
    public void set(int index, T element)
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Index cannot be less than zero or greater than size");

        array[index] = element;
    }

    @Override
    public T get(int index)
    {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Index cannot be less than zero or greater than size");

        return array[index];
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {
        int localSize = size;
        size = 0;
        for(int i = 0; i < localSize; i++)
            array[i] = null;
    }

    @Override
    public boolean contains(Object element)
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");

        for(int i = 0; i < size; i++)
        {
            if(array[i].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("{");
        for(int i = 0; i < size; i++)
        {
            builder.append(array[i]);
            if(i < size - 1)
                builder.append(", ");
        }
        builder.append("}");
        return builder.toString();
    }
}
