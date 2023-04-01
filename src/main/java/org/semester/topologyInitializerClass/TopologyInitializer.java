package org.semester.topologyInitializerClass;

import org.semester.graphClass.Graph;

import java.util.Arrays;

public class TopologyInitializer {

    public static long counter = 0;

    public static int DFS(Graph graph, int v, boolean[] discovered,
                          int[] departure, int time)
    {
        // помечаем текущий узел как обнаруженный
        discovered[v] = true;

        // устанавливаем время прибытия вершины `v`
        time++;

        // делаем для каждого ребра (v, u)
        for (int u: graph.adjList.get(v))
        {
            ++counter;
            // если `u` еще не обнаружен
            if (!discovered[u]) {
                ++counter;
                time = DFS(graph, u, discovered, departure, time);
            }
        }

        // готов к возврату
        // устанавливаем время отправления вершины `v`
        departure[time] = v;
        time++;

        return time;
    }

    // Функция для выполнения топологической сортировки заданной DAG
    public static void doTopologicalSort(Graph graph, int n)
    {
        // departure[] сохраняет номер вершины, используя время отправления в качестве индекса
        int[] departure = new int[2*n];
        Arrays.fill(departure, -1);

        /* Если бы мы сделали наоборот, т.е. заполнили бы массив
           со временем отправления, используя номер вершины в качестве индекса, мы бы
           нужно отсортировать позже */

        // чтобы отслеживать, открыта вершина или нет
        boolean[] discovered = new boolean[n];
        int time = 0;

        // выполняем поиск в глубину на всех неоткрытых вершинах
        for (int i = 0; i < n; i++)
        {
            ++counter;
            if (!discovered[i]) {
                ++counter;
                time = DFS(graph, i, discovered, departure, time);
            }
        }

        // Печатаем вершины в порядке их убывания
        // время отправления в DFS, т.е. в топологическом порядке
        for (int i = 2*n - 1; i >= 0; i--)
        {
            ++counter;
            if (departure[i] != -1) {
                ++counter;
            }
        }
    }

    public static void initializer(Graph graph, int n)
    {
        // выполняем топологическую сортировку
        doTopologicalSort(graph, n);
    }
}