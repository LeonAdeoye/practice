package com.leon;

public enum DaysOfWeek
{
    MONDAY("Monday", 0),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 1),
    THURSDAY("Thursday", 3),
    FRIDAY("Friday", 5),
    SATURDAY("Saturday", 20),
    SUNDAY("Sunday", 10);

    private final String dayName;
    private final int ranking;

    DaysOfWeek(String dayName, int ranking)
    {
        this.dayName = dayName;
        this.ranking = ranking;
    }

    public String getDayName()
    {
        return dayName;
    }

    public int getRanking()
    {
        return ranking;
    }
}
