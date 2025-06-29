package com.leon;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

// Given a list of (city, temperature) readings, return the average temperature per city.
public class TemperatureAvg
{
    private record City(String city, double temperature) {}
    City[] cities = {new City("London", 19.0), new City("London", 11.0), new City("Liverpool", 16)};

    public void calculate()
    {
        Map<String, List<City>> citiesMap = Stream.of(cities).collect(Collectors.groupingBy(City::city));
        // Calculation via values
        citiesMap.values().forEach(cities -> System.out.println(cities.get(0).city + ": " + cities.stream().collect(Collectors.summarizingDouble(City::temperature)).getAverage()));
        // Calculation via keys
        citiesMap.keySet().forEach(city -> System.out.println(city + ": " + citiesMap.get(city).stream().collect(Collectors.summarizingDouble(City::temperature)).getAverage()));
        // Calculation via averagingDouble
        Map<String, Double> avgTemps = Stream.of(cities).collect(Collectors.groupingBy(City::city,Collectors.averagingDouble(City::temperature)));
        avgTemps.forEach((city, avg) -> System.out.println(city + ": " + avg));
    }

    public static void main(String... args)
    {
        TemperatureAvg ta = new TemperatureAvg();
        ta.calculate();
    }
}
