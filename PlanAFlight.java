package com.company;
import java.io.*;
import java.util.*;
public class PlanAFlight
{
   LinkedList<Tuple> adjList = new LinkedList<>();
   boolean foundPath = false;
   public void buildAdjList() throws FileNotFoundException
   {
       File file = new File("graph.txt");
       Scanner fileSC = new Scanner(file);
       int numRows = fileSC.nextInt();
       fileSC.nextLine();
       ArrayList<String> vertexList = new ArrayList<>();
       for (int i = 0; i < numRows; i++)
       {
          String line = fileSC.nextLine();
          String[] lineArr = line.split("\\|");
          if (!vertexList.contains(lineArr[0])) {
              vertexList.add(lineArr[0]);
              Tuple t = new Tuple(lineArr[0]);
              t.addEdge(new Edge(lineArr[0], lineArr[1], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3])));
              adjList.add(t);
          }
          else
          {
              adjList.getTuple(lineArr[0]).addEdge(new Edge(lineArr[0], lineArr[1], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3])));
          }
          if (!vertexList.contains(lineArr[1])) {
               vertexList.add(lineArr[1]);
               Tuple t = new Tuple(lineArr[1]);
               t.addEdge(new Edge(lineArr[1], lineArr[0], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3])));
               adjList.add(t);
          }
          else
          {
               adjList.getTuple(lineArr[1]).addEdge(new Edge(lineArr[1], lineArr[0], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3])));
          }
       }
   }
   public void generateFlightPlans(String origin, String destination, String sortBy)
   {
        foundPath = false;
        Stack<Edge> stack = new Stack<>();
        LinkedList<Edge> flightPlans = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        String[] odArr = {origin, destination};
        int[] time = {0};
        int[] cost = {0};
        generateFPHelper(flightPlans, stack, odArr, origin, time, cost, visited);
   }
   private void generateFPHelper(LinkedList<Edge> fp, Stack<Edge> s, String[] od, String city, int[] time, int[] cost, HashSet<String> visited)
   {
         visited.add(city);
         LinkedList<Edge> edges = adjList.getTuple(city).getLegList();
         boolean executed = false;
         if (!edges.isEmpty()) {
             for (Node<Edge> n = edges.getHead(); n != null; n = n.getNext()) {
                 Edge edge = n.getData();
                 if (!visited.contains(edge.getDestination())) {
                     executed = true;
                     s.push(edge);
                     time[0] += edge.getTime();
                     cost[0] += edge.getCost();
                     if (edge.getDestination().equals(od[1])) {
                         fp.add(new Edge(od[0], od[1], cost[0], time[0]));
                     }
                     generateFPHelper(fp, s, od, edge.getDestination(), time, cost, visited);
                 }
             }
         }
         if (!executed && s.getSize() > 0) {
             Edge e = s.pop();
             time[0] -= e.getTime();
             cost[0] -= e.getCost();
             generateFPHelper(fp, s, od, e.getOrigin(), time, cost, visited);
         }
   }

}
class Stack<T>
{
   private LinkedList<T> stack;
   private int size;
   public Stack()
   {
       stack = new LinkedList<>();
       size = 0;
   }
   public int getSize() {
        return size;
   }
   public void push(T data)
   {
      stack.add(data);
      size++;
   }
   public T pop()
   {
       T popData = stack.getTail().getData();
       stack.delete(stack.getTail().getData());
      size--;
      return popData;
   }
}