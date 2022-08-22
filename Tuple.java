package com.company;

public class Tuple
{
    private String city;
    private LinkedList<Edge> legList;
    public Tuple(String c)
    {
        city = c;
        legList = new LinkedList<>();
    }
    public void addEdge(Edge e)
    {
        legList.add(e);
    }
    public String getCity() {
        return city;
    }
    public LinkedList<Edge> getLegList() {
        return legList;
    }
}
