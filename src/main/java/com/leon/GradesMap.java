package com.leon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Given a list of (studentId, subject, grade) entries, build a nested map: Map<String, Map<String, Double>>.
public class GradesMap {
    private record StudentGrade(String studentId, String subject, Double grade) {};

    public static void main(String... args)
    {
        List<StudentGrade> studentGrades = Arrays.asList(new StudentGrade("horatio", "math", 90.0), new StudentGrade("Harper", "maths", 95.8), new StudentGrade("Leon", "Spanish", 75.0), new StudentGrade("Horatio", "French", 89.0));
        Map<String, Map<String, Double>> map = studentGrades.stream().collect(Collectors.groupingBy(StudentGrade::studentId, Collectors.toMap(StudentGrade::subject, StudentGrade::grade)));
        map.forEach((key, value) -> System.out.println("student: " + key + " has grade: " + value));
    }
}
