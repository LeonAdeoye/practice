package com.leon;

public interface List<T>
{
        int size();

        void add(T element);

        void remove(T element);

        void set(int index, T element);

        T get(int index);

        boolean isEmpty();

        void clear();

        boolean contains(T element);

        String toString();
}
