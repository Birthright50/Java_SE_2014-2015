package DZ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Birthright on 19.04.2015.
 */
public class Task22a {
    static LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("in.txt"));
        while (scanner.hasNext()) {
            String notTerminals[] = scanner.nextLine().split(" ");
            String transitions[] = notTerminals[1].split("\\|");
            ArrayList<String> list = new ArrayList<>();
            Collections.addAll(list, transitions);
            map.put(notTerminals[0], list);
        }
        SuperBooperNode bob = new SuperBooperNode(map.entrySet().iterator().next().getKey(), null, null);
        SuperBooperTree tree = new SuperBooperTree(bob);
        int n = sc.nextInt();
        buildChildren(tree.getRoot(), n);
        print(tree.getRoot());
    }

    public static void print(SuperBooperNode node) {
        SuperBooperNode s = node;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
        while (s != null) {
            s = s.getSon();
            print(s);
        }
    }

    public static void buildChildren(SuperBooperNode node, int n) {
        if (n == 0) {
            return;
        }
        for (Map.Entry<String, ArrayList<String>> elem : map.entrySet()) {
            if (node.getValue().contains(elem.getKey())) {
                for (int index = node.getValue().indexOf(elem.getKey()); index >= 0; index = node.getValue().indexOf(elem.getKey(), index + 1)) {
                    for (String listElem : elem.getValue()) {
                        SuperBooperNode superNode = new SuperBooperNode(node.getValue().substring(0, index) + listElem + node.getValue().substring(index + elem.getKey().length()),
                                null, null);
                        if (node.getSon() != null) {
                            superNode.setNext(node.getSon());
                            node.setSon(superNode);
                        } else {
                            node.setSon(superNode);
                        }
                        buildChildren(superNode, n - 1);
                    }
                }
            }
        }

    }
}
