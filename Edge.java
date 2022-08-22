package com.company;

public class Edge
{
    private String origin, destination;
    private int cost;
    private int time;
    public Edge(String o, String d, int co, int t)
    {
        origin = o;
        destination = d;
        cost = co;
        time = t;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public int getTime() {
        return time;
    }
}