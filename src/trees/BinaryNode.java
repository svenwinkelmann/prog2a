package trees;

public class BinaryNode {

    public Finisher element;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(Finisher finisher) {
        this.element = finisher;
        this.left = null;
        this.right = null;
    }
}
