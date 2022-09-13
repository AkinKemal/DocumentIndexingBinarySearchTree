import java.util.ArrayList;

public class BinarySearchTree {

    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public NodeBinarySearchTree root;
    public LinkedList linkedList = new LinkedList();
    public int totalWord = 0;

    public BinarySearchTree() {
        this.root = null;
    }

    public NodeBinarySearchTree insert(String word, String txtFileName, NodeBinarySearchTree root) {

        if (!contains(word, txtFileName, root)) {
            if (root != null) {
                if (word.compareTo(root.word) < 0) {
                    root.lChild = insert(word, txtFileName, root.lChild);
                } else {
                    root.rChild = insert(word, txtFileName, root.rChild);
                }
            } else {
                root = new NodeBinarySearchTree(word);
                root.head = linkedList.add(txtFileName, root.head);
            }
        }
        return root;
    }

    public void search(NodeBinarySearchTree root, String key) {
        if (root != null) {
            if (root.word.equals(key)) {
                System.out.println(ANSI_GREEN + " ✅ " + ANSI_RESET);
                System.out.println(ANSI_GREEN + root.word + ANSI_RESET);
                System.out.println(ANSI_BG_GREEN + "Frequency: " + ANSI_BOLD + root.frequency + ANSI_RESET);
                linkedList.printList(root.head);
            } else if (key.compareTo(root.word) > 0) {
                search(root.rChild, key);
            } else if (key.compareTo(root.word) < 0) {
                search(root.lChild, key);
            }
        } else {
            errorMessage();
        }
    }

    public int totalWord(NodeBinarySearchTree root) {
        if (root != null) {
            totalWord(root.lChild);
            totalWord += root.frequency;
            totalWord(root.rChild);
        }
        return totalWord;
    }

    public void mostTop10(NodeBinarySearchTree root) {
        ArrayList<NodeBinarySearchTree> arrayList = new ArrayList<>();
        if (root == null) {
            errorMessage();
        } else {
            int counter = 0;
            while (root != null) {
                if (counter >= 10) {
                    break;
                }
                arrayList.add(root);
                root = root.rChild;
                counter++;
            }
            while (root != null) {
                for (int i = 0; i < 10; i++) {
                    if (arrayList.get(i).frequency < root.frequency) {
                        if (!arrayList.contains(root)) {
                            arrayList.set(i, root);
                        }
                        root = root.rChild;
                    }
                }
            }
        }
        arrayList = sortArrayList(arrayList);
        top10Print(arrayList);
    }

    public void leastTop10(NodeBinarySearchTree root) {
        ArrayList<NodeBinarySearchTree> arrayList = new ArrayList<>();
        if (root == null) {
            errorMessage();
        } else {
            int counter = 0;
            while (root != null) {
                if (counter >= 10) {
                    break;
                }
                arrayList.add(root);
                root = root.rChild;
                counter++;
            }
            while (root != null) {
                for (int i = 0; i < 10; i++) {
                    if (arrayList.get(i).frequency > root.frequency) {
                        if (!arrayList.contains(root)) {
                            arrayList.set(i, root);
                        }
                        root = root.lChild;
                    }
                }
            }
        }
        arrayList = sortArrayList(arrayList);
        top10Print(arrayList);
    }

    public ArrayList<NodeBinarySearchTree> sortArrayList(ArrayList<NodeBinarySearchTree> arrayList) {
        int sizeArray = arrayList.size();
        for (int i = 0; i < sizeArray - 1; i++) {
            for (int j = i + 1; j < sizeArray; j++) {
                if (arrayList.get(j).frequency > arrayList.get(i).frequency) {
                    NodeBinarySearchTree temporary = arrayList.get(j);
                    arrayList.set(j, arrayList.get(i));
                    arrayList.set(i, temporary);
                }
            }
        }
        return arrayList;
    }

    public boolean contains(String word, String txtFileName, NodeBinarySearchTree root) {
        NodeBinarySearchTree temporaryNode = root;
        while (temporaryNode != null) {
            int temporaryNumber = word.compareTo(temporaryNode.word);
            if (temporaryNumber == 0) {
                temporaryNode.frequency = temporaryNode.frequency + 1;
                temporaryNode.head = linkedList.add(txtFileName, temporaryNode.head);
                return true;
            } else if (temporaryNumber < 0) {
                temporaryNode = temporaryNode.lChild;
            } else {
                temporaryNode = temporaryNode.rChild;
            }
        }
        return false;
    }

    public boolean isEmpty(NodeBinarySearchTree root) {
        return root == null;
    }

    public void print(NodeBinarySearchTree root) {
        if (root == null) {
            errorMessage();
        } else {
            System.out.println(ANSI_BG_GREEN + ANSI_BOLD + "preOrder:" + ANSI_RESET);
            preOrder(root);
            System.out.println();
            System.out.println(ANSI_BG_GREEN + ANSI_BOLD + "inOrder:" + ANSI_RESET);
            inOrder(root);
            System.out.println();
            System.out.println(ANSI_BG_GREEN + ANSI_BOLD + "postOrder:" + ANSI_RESET);
            postOrder(root);
            System.out.println();
        }
    }

    public void preOrder(NodeBinarySearchTree root) {
        if (root != null) {
            System.out.print(ANSI_GREEN + root.word + ANSI_RESET + "( " + ANSI_BOLD + root.frequency + ANSI_RESET + " ) ");
            preOrder(root.lChild);
            preOrder(root.rChild);
        }
    }

    public void inOrder(NodeBinarySearchTree root) {
        if (root != null) {
            inOrder(root.lChild);
            System.out.print(ANSI_GREEN + root.word + ANSI_RESET + "( " + ANSI_BOLD + root.frequency + ANSI_RESET + " ) ");
            inOrder(root.rChild);
        }
    }

    public void postOrder(NodeBinarySearchTree root) {
        if (root != null) {
            postOrder(root.lChild);
            postOrder(root.rChild);
            System.out.print(ANSI_GREEN + root.word + ANSI_RESET + "( " + ANSI_BOLD + root.frequency + ANSI_RESET + " ) ");
        }
    }

    public void top10Print(ArrayList<NodeBinarySearchTree> arrayList) {
        int counter = 1;
        for (NodeBinarySearchTree i : arrayList) {
            System.out.print(ANSI_PURPLE + counter + ". " + i.word + " -> " + ANSI_RESET);
            System.out.print(ANSI_BOLD + i.frequency + ANSI_RESET + "\n");
            counter++;
        }
    }

    public void errorMessage() {
        System.out.println("EN: " + ANSI_RED + "WARNING! " + ANSI_RESET + "A system error has been detected. Please try again.");
        System.out.println("TR: " + ANSI_RED + "UYARI! " + ANSI_RESET + "Bir sistem hatası algılandı. Lütfen tekrar deneyin.");
    }

}