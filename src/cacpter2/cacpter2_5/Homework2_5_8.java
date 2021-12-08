package cacpter2.cacpter2_5;

public class Homework2_5_8 {
    public static void main(String[] args) {
        String[] array = {"a", "d", "u", "d", "a", "t", "c", "b", "c"};
        Node[] nodes = new Homework2_5_8().sort(array);
        for (Node node : nodes) {
            if (node == null) {
                break;
            }
            System.out.println(node.count + "\t" + node.value);
        }
    }

    public Node[] sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                int compare = compare(array[j - 1], array[j]);
                if (compare > 0) {
                    swap(array, j - 1, j);
                }
            }
        }
        Node node[] = new Node[array.length];
        node[0] = new Node(array[0]);
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (compare(array[i - 1], array[i]) != 0) {
                node[++index] = new Node(array[i]);
            } else {
                node[index].count++;
            }
        }
        for (int i = 1; i <= index; i++) {
            for (int j = i; j > 0; j--) {
                if (node[j - 1].count < node[j].count) {
                    swap(node, j - 1, j);
                }
            }
        }
        return node;
    }


    public void swap(Object[] array, int i, int j) {
        Object value = array[i];
        array[i] = array[j];
        array[j] = value;
    }

    public int compare(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            int compare = s1.charAt(i) - s2.charAt(i);
            if (compare > 0) {
                return compare;
            } else if (compare < 0) {
                return compare;
            }
        }
        return s1.length() - s2.length();
    }
}

class Node {
    public String value;
    public int count = 1;

    public Node(String value) {
        this.value = value;
    }
}