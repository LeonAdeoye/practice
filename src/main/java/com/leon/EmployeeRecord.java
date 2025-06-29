package com.leon;

import java.util.Comparator;

public record EmployeeRecord (String name, int age) implements Comparable<EmployeeRecord>
{
    // Compact constructor syntax.
    public EmployeeRecord
    {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    @Override
    public int compareTo(EmployeeRecord other)
    {
        return this.name.compareTo(other.name);
    }

    public static Comparator<EmployeeRecord> ageComparator()
    {
        return Comparator.comparingInt(EmployeeRecord::age);
    }

    public static Comparator<EmployeeRecord> nameComparator = new Comparator<EmployeeRecord>()
    {
        @Override
        public int compare(EmployeeRecord o1, EmployeeRecord o2)
        {
            return o1.name.compareTo(o2.name);
        }
    };
}


