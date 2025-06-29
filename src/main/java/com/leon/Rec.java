package com.leon;

import java.util.Arrays;

public class Rec
{
    public static void main(String[] args)
    {
        var employee = new EmployeeRecord("John Doe", 30); // Can infer type
        System.out.println("Employee Name: " + employee.name());
        try
        {
            EmployeeRecord invalidEmployee = new EmployeeRecord("Invalid employee", -5);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        var employees = new EmployeeRecord[]{
            new EmployeeRecord("Alice", 25),
            new EmployeeRecord("Bob", 30),
            new EmployeeRecord("Charlie", 20)
        };

        Arrays.sort(employees, EmployeeRecord.ageComparator());
        System.out.println("Employees sorted by age: " + Arrays.toString(employees));
        Arrays.sort(employees);
        System.out.println("Employees sorted by name: " + Arrays.toString(employees));
        Arrays.sort(employees, EmployeeRecord.nameComparator);
        System.out.println("Employees sorted by name using comparator: " + Arrays.toString(employees));

        DaysOfWeek day = DaysOfWeek.MONDAY;
        for(DaysOfWeek d : DaysOfWeek.values())
            System.out.println("Day: " + d + ", Ranking: " + d.getRanking());
    }
}
