public class NodeBinarySearchTree {

    public String word;
    public int frequency;
    public NodeBinarySearchTree rChild;
    public NodeBinarySearchTree lChild;
    public NodeLinkedList head;

    public NodeBinarySearchTree(String word) {
        this.word = word;
        this.frequency = 1;
        this.rChild = null;
        this.lChild = null;
        this.head = null;
    }

}
