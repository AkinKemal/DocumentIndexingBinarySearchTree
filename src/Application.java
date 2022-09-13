import java.util.Scanner;

public class Application {

    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Operations operations = new Operations();
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        System.out.println(ANSI_PURPLE + ANSI_BOLD + "WELCOME" + ANSI_RESET);
        System.out.println(ANSI_BOLD + "System Starts" + ANSI_RESET);
        System.out.println("Please wait..." + ANSI_PURPLE + " (15-20 sec) " + ANSI_RESET);

        //linkedlist oluşma zamanı
        long startTime = System.currentTimeMillis();
        binarySearchTree = operations.createBinarySearchTree(binarySearchTree);
        long endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime;
        double seconds = (double) estimatedTime / 1000;

        String choice;
        System.out.println("\n" + ANSI_GREEN + ANSI_BOLD + " ✅ " + ANSI_RESET);
        System.out.println("\nSimple Document Retrieval System");
        System.out.println(ANSI_GREEN + seconds + " second" + ANSI_RESET);
        do {
            System.out.println(ANSI_GREEN + "1-" + ANSI_RESET + "Enter a single keyword to list the document(s)(file names)");
            System.out.println(ANSI_GREEN + "2-" + ANSI_RESET + "Print the top 10 words that appeared most frequently");
            System.out.println(ANSI_GREEN + "3-" + ANSI_RESET + "Print the top 10 words that appeared least frequently");
            System.out.println(ANSI_GREEN + "4-" + ANSI_RESET + "Print linked list");
            System.out.println(ANSI_GREEN + "5-" + ANSI_RESET + "Total Word");
            System.out.println(ANSI_GREEN + "6-" + ANSI_RESET + "Total File");
            System.out.println(ANSI_GREEN + "7-" + ANSI_RESET + "Exist");
            System.out.print(ANSI_GREEN + " -> option: " + ANSI_RESET);
            choice = scanner.next();
            design();
            switch (choice) {
                case "1":
                    operations.search(binarySearchTree.root);
                    design();
                    break;
                case "2":
                    operations.mostTop10(binarySearchTree.root);
                    design();
                    break;
                case "3":
                    operations.leastTop10(binarySearchTree.root);
                    design();
                    break;
                case "4":
                    operations.print(binarySearchTree.root);
                    design();
                    break;
                case "5":
                    operations.totalWord(binarySearchTree.root);
                    design();
                    break;
                case "6":
                    operations.totalFile();
                    design();
                    break;
                case "7":
                    System.out.println(ANSI_RED + ANSI_BOLD + "GOODBYE" + ANSI_RESET);
                    System.out.println(ANSI_RED + "Thank you for choosing us" + ANSI_RESET);
                    design();
                    break;
                default:
                    System.out.println("You entered an incorrect value, please try again.(1-7)");
                    break;
            }
        } while (!choice.equals("7"));
    }

    public static void design() {
        System.out.println(ANSI_PURPLE + ANSI_BOLD + "-----------------------------------------------------------------------------------" + ANSI_RESET);
    }

}