public class NodeLinkedList {

    public String fileName;
    public int frequency;
    public NodeLinkedList next;

    public NodeLinkedList(String fileName){
        this.fileName = fileName;
        this.frequency = 1;
        this.next = null;
    }

}
