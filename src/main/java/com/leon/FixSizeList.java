package com.leon;

import java.util.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Implement a fixed-size list that stores the N most recent transactions. When full, discard the oldest.
public class FixSizeList {
    private record Transaction(String name, LocalDateTime transactionTime) {
        @Override
        public String toString()
        {
            return name + " at " + transactionTime;
        }
    }
    private List<Transaction> list = new ArrayList<>();
    private Deque<Transaction> linkedList = new LinkedList<>();

    private int maxSize = 3;

    Comparator<Transaction> comparator = (o1, o2) -> {
        if(o1.transactionTime.isBefore(o2.transactionTime))
            return 1;
        if(o2.transactionTime.isBefore(o1.transactionTime))
            return -1;
        return 0;
    };

    public void add(Transaction transaction)
    {
        if(list.size() == maxSize)
        {
            // Optional<Transaction> tran = list.stream().min(Comparator.comparing(Transaction::transactionTime));
            Optional<Transaction> tran = list.stream().max(comparator);
            if(tran.isPresent())
                list.remove(tran.get());
        }
        list.add(transaction);
        System.out.println(list);
    }

    public void add2(Transaction transaction)
    {
        if(linkedList.size() == maxSize)
        {
            linkedList.removeFirst();
        }
        linkedList.addLast(transaction);
        System.out.println(linkedList);
    }

    public static void main(String... args)
    {
        FixSizeList fsl = new FixSizeList();

        for(int i = 0; i < 10; i++)
            fsl.add(new Transaction("tran" + i, LocalDateTime.now().plusSeconds(i)));

        for(int i = 0; i < 10; i++)
            fsl.add2(new Transaction("tran" + i, LocalDateTime.now().plusSeconds(i)));
    }
}
