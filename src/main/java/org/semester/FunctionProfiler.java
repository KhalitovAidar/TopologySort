package org.semester;

import org.semester.graphClass.Graph;
import org.semester.randomDAGGeneratorClass.RandomDAGGenerator;
import org.semester.topologyInitializerClass.TopologyInitializer;

import java.io.FileWriter;
import java.io.IOException;

public class FunctionProfiler {
    public static void timeAndCountIterations() throws IOException {
        FileWriter writer = new FileWriter("heap.csv");
        TopologyInitializer topologyInitializer = new TopologyInitializer();
        for (int n = 100; n < 10000; n += 100){
            Graph graph = new Graph(RandomDAGGenerator.generate(n));

            long startTime = System.nanoTime();

            topologyInitializer.counter = 0;
            topologyInitializer.initializer(graph, n);

            long count = topologyInitializer.counter;

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            System.out.println(n + "; " + count + "; " + elapsedTime);
        }
    }

    public static void main(String[] args) throws IOException {
        timeAndCountIterations();
    }
}