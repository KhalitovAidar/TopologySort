package org.semester.graphClass;

import java.util.List;

public class Graph {
    // Список списков для представления списка смежности
    public List<List<Integer>> adjList;

    // Конструктор
    public Graph(List<List<Integer>> adjList)
    {
        this.adjList = adjList;
    }
}