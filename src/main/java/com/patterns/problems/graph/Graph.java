package com.patterns.problems.graph;

import java.util.*;

public class Graph {
    static HashMap<String, ArrayList<String>> adjList = new HashMap<>();


    public static boolean addVertex(String vertex){
       if ( adjList.get(vertex) == null) {
           adjList.put(vertex, new ArrayList<>());
           return true;
       }
       return false;
    }

    public static boolean addEdge(String vertex1, String vertex2){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;

    }

    public boolean removeEdge(String vertex1, String vertex2 ){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public static boolean removeVertex(String vertex){


       if (adjList.get(vertex) != null) {
            for ( String items : adjList.get(vertex)) {
                adjList.get(items).remove(vertex);
            }
            adjList.remove(vertex);
            return true;
        }
       return false;

    }

    public static void printGraph() {
        System.out.println(adjList);
    }

    public static void main(String[] args) {
        int[] items2 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        List<Integer> newList = Arrays.asList(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);

        addVertex("A");
        addVertex("B");
        addVertex("C");
        addEdge("A","B");
        addEdge("A","C");
        addEdge("B","C");
        removeVertex("C");
        printGraph();
    }
    }
