import java.io.Serializable;
import java.util.*;

/**
 * Created by Birthright on 01.05.2015.
 */
public class Graph implements Serializable {

    private int V;
    private int E = 0;

    public int getV() {
        return V;
    }

    private ArrayList<SuperNode> nodes = new ArrayList<>();
    private Set<Edge> set = new TreeSet<>();

    public ArrayList<SuperNode> getAdjecencyLists() {
        return nodes;
    }

    public Graph(int v, int e, ArrayList<SuperNode> nodes) {
        V = v;
        E = e;
        this.nodes = nodes;
    }

    public Graph(int V, int E) {
        if (V < 0) throw new IllegalArgumentException();
        if (E < 0) throw new IllegalArgumentException();
        if (E > (V * (V - 1) / 2)) throw new IllegalArgumentException("Слишком много ребер");
        this.V = V;
        Random random = new Random();
        for (int i = 0; i < V; i++) {
            nodes.add(new SuperNode());
            nodes.get(i).setValue(i);
        }
        while (this.E < E) {
            int head = random.nextInt(V - 1);
            int end = random.nextInt(V - 1);
            Edge e = new Edge(head, end);
            if ((head != end) && !set.contains(e)) {
                set.add(e);
                this.addEdge(head, end);
            }
        }

    }

    private void addEdge(int head, int end) {
        E++;
        ArrayList<SuperNode> high = nodes.get(head).getRelatedNodes();
        high.add(nodes.get(end));
        ArrayList<SuperNode> low = nodes.get(end).getRelatedNodes();
        low.add(nodes.get(head));
    }

    public ArrayList<Edge> getEdgesList() {
        ArrayList<Edge> x = new ArrayList<>();
        for (Edge a : set) {
            x.add(a);
        }
        return x;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        s.append(V).append(" вершин, ").append(E).append(" ребер ").append(newLine);
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (SuperNode w : nodes.get(v).getRelatedNodes()) {
                s.append(w.getValue()).append(" ");
            }
            s.append(newLine);
        }
        return s.toString();
    }


    public int[][] getIncidenceMatrix() {
        int[][] matrix = new int[V][E];
        for (int i = 0; i < V; i++) {
            int j = 0;
            for (Edge x : set) {
                if (x.contains(i)) {
                    matrix[i][j] = 1;
                }
                j++;
            }
        }

        return matrix;
    }

    public int[][] getAdjecencyMatrix() {
        int[][] matrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (SuperNode x : nodes.get(i).getRelatedNodes()) {
                matrix[i][x.getValue()] = 1;
            }

        }
        return matrix;
    }

    public static ArrayList<Edge> fromIncidenceToEdgeList(int[][] matrix) {
        ArrayList<Edge> edgeArrayList = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            Edge edge = new Edge();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    if (edge.getV() == -1) {
                        edge.setV(j);
                    } else {
                        edge.setW(j);
                        break;
                    }
                }
            }
            edgeArrayList.add(edge);
        }
        return edgeArrayList;
    }

    public static ArrayList<SuperNode> fromIncidenceToAdjecencyLists(int[][] matrix) {
        ArrayList<SuperNode> superNodeArrayList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            superNodeArrayList.add(new SuperNode());
            superNodeArrayList.get(i).setValue(i);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            Edge edge = new Edge();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    if (edge.getV() == -1) {
                        edge.setV(j);
                    } else {
                        edge.setW(j);
                        break;
                    }
                }
            }
            ArrayList<SuperNode> high = superNodeArrayList.get(edge.getV()).getRelatedNodes();
            high.add(superNodeArrayList.get(edge.getW()));
            ArrayList<SuperNode> low = superNodeArrayList.get(edge.getW()).getRelatedNodes();
            low.add(superNodeArrayList.get(edge.getV()));
        }
        return superNodeArrayList;
    }

    public static int[][] fromIncidenceToAdjecencyMatrix(int[][] matrix) {
        int[][] adjecencyMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            Edge edge = new Edge();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    if (edge.getV() == -1) {
                        edge.setV(j);
                    } else {
                        edge.setW(j);
                        break;
                    }
                }
            }
            adjecencyMatrix[edge.getV()][edge.getW()] = 1;
            adjecencyMatrix[edge.getW()][edge.getV()] = 1;
        }
        return adjecencyMatrix;
    }

    public static ArrayList<Edge> fromAdjecencyMatrixToEdgeList(int[][] matrix) {
        ArrayList<Edge> edgeArrayList = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = k; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    edgeArrayList.add(new Edge(i, j));
                }
            }
            k++;
        }
        return edgeArrayList;
    }

    public static ArrayList<SuperNode> fromAdjecencyMatrixToAdjecencyLists(int matrix[][]) {
        ArrayList<SuperNode> superNodeArrayList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            superNodeArrayList.add(new SuperNode());
            superNodeArrayList.get(i).setValue(i);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    ArrayList<SuperNode> arrayList = superNodeArrayList.get(i).getRelatedNodes();
                    arrayList.add(superNodeArrayList.get(j));
                }
            }
        }
        return superNodeArrayList;
    }

    public static int[][] fromAdjecencyToIncidenceMatrix(int matrix[][]) {
        int v = 0;
        int k = 0;
        for (int[] aMatrix : matrix) {
            for (int j = k; j < matrix.length; j++) {
                if (aMatrix[j] == 1) {
                    v++;
                }
            }
            k++;
        }
        int[][] incidenceMatrix = new int[matrix.length][v];
        for (int i = k = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    incidenceMatrix[i][k] = incidenceMatrix[j][k] = 1;
                    k++;
                }

            }
        }
        return incidenceMatrix;
    }

    public static ArrayList<Edge> fromAdjecencyListsToEdgeList(ArrayList<SuperNode> superNodeArrayList) {
        Collections.sort(superNodeArrayList);
        for (SuperNode x5 : superNodeArrayList) {
            Collections.sort(x5.getRelatedNodes());
        }
        ArrayList<Edge> edgeArrayList = new ArrayList<>();
        Set<Edge> set = new HashSet<>();
        for (SuperNode x : superNodeArrayList) {
            for (SuperNode x1 : x.getRelatedNodes()) {
                Edge edge = new Edge(x.getValue(), x1.getValue());
                if (!set.contains(edge)) {
                    edgeArrayList.add(edge);
                    set.add(edge);
                }
            }
        }
        return edgeArrayList;
    }

    public static int[][] fromAdjecencyListsToIncidenceMatrix(ArrayList<SuperNode> superNodeArrayList) {
        int x = 0;
        Collections.sort(superNodeArrayList);
        for (SuperNode x5 : superNodeArrayList) {
            Collections.sort(x5.getRelatedNodes());
        }
        System.out.println(superNodeArrayList);
        for (SuperNode x1 : superNodeArrayList) {
            x += x1.getRelatedNodes().size();
        }
        int[][] incidenceMatrix = new int[superNodeArrayList.size()][x / 2];
        Set<Edge> set = new HashSet<>();
        int k = 0;
        for (SuperNode x1 : superNodeArrayList) {
            for (SuperNode x2 : x1.getRelatedNodes()) {
                Edge edge = new Edge(x1.getValue(), x2.getValue());
                if (!set.contains(edge)) {
                    set.add(edge);
                    incidenceMatrix[edge.getV()][k] = incidenceMatrix[edge.getW()][k] = 1;

                    k++;
                }
            }
        }
        return incidenceMatrix;
    }

    public static int[][] fromAdjecencyListsToAdjecencyMatrix(ArrayList<SuperNode> superNodeArrayList) {
        int[][] adjecencyMatrix = new int[superNodeArrayList.size()][superNodeArrayList.size()];
        for (SuperNode x1 : superNodeArrayList) {
            for (SuperNode x2 : x1.getRelatedNodes()) {
                adjecencyMatrix[x1.getValue()][x2.getValue()] = 1;
            }
        }
        return adjecencyMatrix;
    }

    public static ArrayList<SuperNode> fromEdgeListToAdjecencyLists(ArrayList<Edge> edgeArrayList) {
        ArrayList<SuperNode> superNodeArrayList = new ArrayList<>();
        int max = 0;
        for (Edge x : edgeArrayList) {
            int k;
            if ((k = Math.max(x.getV(), x.getW())) > max) {
                max = k;
            }
        }
        for (int i = 0; i <= max; i++) {
            superNodeArrayList.add(new SuperNode());
            superNodeArrayList.get(i).setValue(i);
        }
        for (Edge edge : edgeArrayList) {
            ArrayList<SuperNode> high = superNodeArrayList.get(edge.getV()).getRelatedNodes();
            high.add(superNodeArrayList.get(edge.getW()));
            ArrayList<SuperNode> low = superNodeArrayList.get(edge.getW()).getRelatedNodes();
            low.add(superNodeArrayList.get(edge.getV()));
        }
        return superNodeArrayList;
    }

    public static int[][] fromEdgeListToIncidenceMatrix(ArrayList<Edge> edgeArrayList) {
        int max = 0;
        for (Edge x : edgeArrayList) {
            int k;
            if ((k = Math.max(x.getV(), x.getW())) > max) {
                max = k;
            }
        }
        int[][] incidenceMatrix = new int[max + 1][edgeArrayList.size()];
        int k = 0;
        for (Edge x : edgeArrayList) {
            incidenceMatrix[x.getV()][k] = incidenceMatrix[x.getW()][k] = 1;
            k++;
        }
        return incidenceMatrix;
    }

    public static int[][] fromEdgeListToAdjecencyMatrix(ArrayList<Edge> edgeArrayList) {
        int max = 0;
        for (Edge x : edgeArrayList) {
            int k;
            if ((k = Math.max(x.getV(), x.getW())) > max) {
                max = k;
            }
        }
        int[][] adjecencyMatrix = new int[max + 1][max + 1];
        for (Edge x : edgeArrayList) {
            adjecencyMatrix[x.getV()][x.getW()] = adjecencyMatrix[x.getW()][x.getV()] = 1;
        }
        return adjecencyMatrix;
    }

    public static void main(String[] args) {
        Graph s = new Graph(10, 7);
        System.out.println("Матрица смежности:");
        int[][] a1 = s.getAdjecencyMatrix();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(a1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        ArrayList<Edge> x = s.getEdgesList();
        System.out.println("Ребра - " + x);
        System.out.println();
        System.out.println("Матрица инцидентности");
        int[][] a = s.getIncidenceMatrix();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Список смежности");
        ArrayList<SuperNode> adjecencyLists = s.getAdjecencyLists();
        adjecencyLists.forEach(System.out::println);

    }
}
