public class LinkedList {

    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public NodeLinkedList head;

    public LinkedList(){
        this.head = null;
    }

    public NodeLinkedList add(String fileName, NodeLinkedList head){
        NodeLinkedList element = new NodeLinkedList(fileName);
        NodeLinkedList walk;
        if(head == null){
            head = element;
        }
        else {
            walk = head;
            boolean control = true;
            while (walk.next != null){
                if (element.fileName.equals(walk.fileName)) {
                    control = false;
                    break;
                }
                walk = walk.next;
            }
            if(control && !element.fileName.equals(walk.fileName)){
                walk.next = element;
            }
            else {
                walk.frequency = walk.frequency + 1;
            }
        }
        return head;
    }

    public void printList(NodeLinkedList head) {
        NodeLinkedList walk = head;
        while (walk != null) {
            System.out.print(ANSI_GREEN + walk.fileName + ANSI_RESET + "( " + ANSI_BOLD + walk.frequency + ANSI_RESET + " ) ");
            walk = walk.next;
        }
        System.out.println(" -> null");
    }

}