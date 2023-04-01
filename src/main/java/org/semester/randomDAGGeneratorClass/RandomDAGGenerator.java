package org.semester.randomDAGGeneratorClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDAGGenerator {
    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> adjList = generateRandomDAG(n);
        return adjList;
    }

    public static List<List<Integer>> generateRandomDAG(int n) {
        Random random = new Random();
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (random.nextBoolean()) {
                    adjList.get(u).add(v);
                } else {
                    adjList.get(v).add(u);
                }
            }
        }

        return adjList;
    }
}