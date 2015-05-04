import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Birthright on 03.05.2015.
 */
public class Task25b {
    public static void backTracking(Graph graph, int color, int start) {
        if (start == graph.getV()) {
            System.out.println("Great");

        } else {
            SuperNode superNode = graph.getAdjecencyLists().get(start);
            boolean check = true;
            for (SuperNode x : superNode.getRelatedNodes()) {
                if (x.color == color) {
                    check = false;
                    break;
                }
            }
            if (check) {
                superNode.color = color;
                backTracking(graph, 0, start + 1);
            } else {
                backTracking(graph, color + 1, start);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Кол-во вершин");
        int V = sc.nextInt();
        System.out.println("Кол-во ребер");
        int E = sc.nextInt();
        ArrayList<SuperNode> superNodeArrayList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            superNodeArrayList.add(new SuperNode());
            superNodeArrayList.get(i).setValue(i);
        }
        for (int i = 0; i < E; i++) {
            System.out.print("Ввод ребра ");
            Edge edge = new Edge(sc.nextInt(), sc.nextInt());
            ArrayList<SuperNode> high = superNodeArrayList.get(edge.getV()).getRelatedNodes();
            high.add(superNodeArrayList.get(edge.getW()));
            ArrayList<SuperNode> low = superNodeArrayList.get(edge.getW()).getRelatedNodes();
            low.add(superNodeArrayList.get(edge.getV()));
        }
        Graph graph = new Graph(V, E, superNodeArrayList);
        backTracking(graph, 0, 0);
    }
}
