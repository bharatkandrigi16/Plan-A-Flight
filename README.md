# Plan-A-Flight
Given cost and time data of routes, calculate possible flight plans from city A to city B and rank them based on time/cost efficiency.

The Main class instantiates an object from the PlanAFlight class which implements a method, buildAdjlist(), to build an adjacency list holding a graph representation of 
the "graph.txt" file and another method, generateFlightPlans(), to iterate through the adjancency list from the starting to the final point of the graph
using a backtracking algorithm. The Main class also serves to provide input for the getFlightPlans() method with the "flight_plans.txt" file.

The user-created LinkedList class implements most of the important features of the LinkedList class but focuses functionality on ease of use of the supporting classes
through methods such as getEdge() and getTuple().

The supporting classes include Tuple, Edge, and Stack.

The Tuple class is meant to represent a city and the list of next possible destinations from that city.

