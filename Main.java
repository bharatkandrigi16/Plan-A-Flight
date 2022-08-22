package com.company;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        PlanAFlight planAFlight = new PlanAFlight();
        File file = new File("flight_plans.txt");
        Scanner fileSC = new Scanner(file);
        planAFlight.buildAdjList();
        int numRows = fileSC.nextInt();
        fileSC.nextLine();
        for (int i = 0; i < numRows; i++)
        {
            String line = fileSC.nextLine();
            String[] arr = line.split("\\|");
            planAFlight.generateFlightPlans(arr[0], arr[1], arr[2]);
        }
    }
}
