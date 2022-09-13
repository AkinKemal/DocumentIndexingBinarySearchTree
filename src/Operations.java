import java.util.Scanner;

public class Operations {

    ReaderFile readerFile = new ReaderFile();
    GetFileNameFilter getFileNameFilter = new GetFileNameFilter();
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    Scanner scanner = new Scanner(System.in);
    int sizeAllDocs;

    public Operations() {

    }

    //createBinarySearchTree
    public BinarySearchTree createBinarySearchTree(BinarySearchTree bst) {
        int i = 0;
        int j = 0;
        String addString = "";
        sizeAllDocs = getFileNameFilter.findFiles("AllDocs");
        for (int k = 1; k <= sizeAllDocs; k++) {
            String temporaryString = readerFile.readerFile(k + ".txt");
            for (i = 0; i < temporaryString.length(); i++) {
                if (temporaryString.charAt(i) != ' ') {
                    break;
                }
            }
            for (j = i; j < temporaryString.length(); j++) {
                if (temporaryString.charAt(j) != ' ') {
                    addString += temporaryString.charAt(j);
                } else if (temporaryString.charAt(j) == ' ' && addString.length() != 0) {
                    bst.root = binarySearchTree.insert(addString, k + ".txt", bst.root);
                    addString = "";
                } else if (j == (temporaryString.length() - 1) && addString.length() != 0) {
                    addString += temporaryString.charAt(j);
                    bst.root = binarySearchTree.insert(addString, k + ".txt", bst.root);
                    addString = "";
                }
            }
        }
        return bst;
    }

    //search
    public void search(NodeBinarySearchTree root) {
        System.out.print("Please enter the word you want to search: ");
        String key = scanner.next();
        binarySearchTree.search(root, key);
    }

    //totalWord
    public void totalWord(NodeBinarySearchTree root) {
        int temporary;
        temporary = binarySearchTree.totalWord(root);
        System.out.println("Total Word Count: " + temporary);
    }

    //mostTop10
    public void mostTop10(NodeBinarySearchTree root) {
        binarySearchTree.mostTop10(root);
    }

    //leastTop10
    public void leastTop10(NodeBinarySearchTree root) {
        binarySearchTree.leastTop10(root);
    }

    //print
    public void print(NodeBinarySearchTree root) {
        binarySearchTree.print(root);
    }

    //totalFile
    public void totalFile() {
        System.out.println("Total File Count: " + sizeAllDocs);
    }

}