package trees;

public class BinaryTree {

    /**
     * A binary tree has one left and one right subtree. While adding finishers we
     * sort the tree based on the finishing time of the finisher.
     * @param node current node
     * @param finisher data element
     * @return the current node
     */
    public BinaryNode addFinisher(BinaryNode node, Finisher finisher) {
        if (node == null) {  // Base case
            return new BinaryNode(finisher);
        }

        if (node.element.time > finisher.time)
            node.left = addFinisher(node.left, finisher);  // recursive case for left subtree
        else  // for identical finishing times we sort the values in the right tree
            node.right = addFinisher(node.right, finisher);  // recursive case for right subtree

        return node;
    }

    /**
     * In order traversal gives us a sorted output :)
     * @param node start node. We can print subtrees, too.
     */
    public void printResultTable(BinaryNode node) {
        if (node.left != null)  // base case
            printResultTable(node.left);  // recursive case for left subtree
        System.out.println("" + node.element.time + ": " + node.element.name);
        if (node.right != null)
            printResultTable(node.right);  // recursive case for right subtree
    }

    // test method
    public static void main(String[] args) {
        // let's start the snail race: https://www.youtube.com/watch?v=zbEeeJmYoAk&ab_channel=SkySports
        BinaryTree snailRaceResults = new BinaryTree();
        BinaryNode root = null;

        Finisher snail1 = new Finisher("Hubert", 34.1f);
        root = snailRaceResults.addFinisher(root, snail1);
        snailRaceResults.addFinisher(root, new Finisher("Linda", 54.2f));
        snailRaceResults.addFinisher(root, new Finisher("Sam", 36.1f));
        snailRaceResults.addFinisher(root, new Finisher("Frank", 25.0f));
        snailRaceResults.addFinisher(root, new Finisher("Peter", 86.5f));
        snailRaceResults.addFinisher(root, new Finisher("Paul", 74.3f));
        snailRaceResults.addFinisher(root, new Finisher("Vera", 95.3f));
        snailRaceResults.addFinisher(root, new Finisher("Lina", 47.4f));
        snailRaceResults.addFinisher(root, new Finisher("Hans", 185.6f));
        snailRaceResults.addFinisher(root, new Finisher("Klaus", 55.4f));
        snailRaceResults.addFinisher(root, new Finisher("Max", 23.3f));
        snailRaceResults.addFinisher(root, new Finisher("Moritz", 63.6f));
        snailRaceResults.addFinisher(root, new Finisher("Ina", 452.4f));

        snailRaceResults.printResultTable(root);
    }
}
