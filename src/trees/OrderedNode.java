package trees;

import java.util.Collections;

public class OrderedNode extends Node {

    public OrderedNode(String element)
    {
        super(element);
    }

    /**
     * An ordered tree means, it's children are in an order (e.g. number, alphabetical, ..)
     * @param child The node to add.
     */
    @Override
    public void addChild(Node child) {
        if (this.children.size() == 0)
            this.children.add(child);
        else {
            int oldListSize = this.children.size();
            for (int index = 0; index <= oldListSize; index++) {
                if (index == this.children.size())  // no next element in list
                    this.children.add(child);
                else if (this.children.get(index).getElement().compareTo(child.getElement()) > 0) {
                    this.children.add(index, child);
                    break;
                }
            }
        }
        child.parent = this;
    }

    /**
     * Print this node before its children.
     */
    public void preOrderTraversal() {
        System.out.println(this.element);

        for(Node child: this.children)  // base case (children.size() == 0)
            ((OrderedNode) child).preOrderTraversal();  // recursive case
    }

    /**
     * Print the children and then this node.
     */
    public void postOrderTraversal() {
        for(Node child: this.children)  // base case (children.size() == 0)
            ((OrderedNode) child).postOrderTraversal();  // recursive case

        System.out.println(this.element);
    }

    /**
     * Print all nodes on one level of the tree.
     * @param level The level to print out
     */
    public void levelOrder(int level) {
        if (level == 1)
            System.out.println(this.element);
        else if (level > 1)
            for(Node child: this.children)
                ((OrderedNode) child).levelOrder(level - 1);
    }

    // Testing method
    public static void main(String[] args) {
        // We build up our tree:
        OrderedNode root = new OrderedNode("Adam");
        OrderedNode node1 = new OrderedNode("Abel");
        root.addChild(node1);
        OrderedNode node2 = new OrderedNode("Cain");
        root.addChild(node2);
        root.addChild(new OrderedNode("Bert"));
        node2.addChild(new OrderedNode("Citha"));
        node2.addChild(new OrderedNode("Maac"));

        // We implement testing methods, to make sure our implementation works
        // Usually this is done with a testing framework, e.g. jUnit
        System.out.println("Children of Adam (getChildren): " + root.getChildren());
        System.out.println("Parent of Cain (getParent): " + node2.getParent());
        System.out.println("Is Adam root (isRoot): " + root.isRoot());
        System.out.println("Is Cain internal (isInternal): " + node2.isInternal());
        System.out.println("Is Cain external (isExternal): " + node2.isExternal());
        System.out.println("Data element of Cain (getElement): " + node2.getElement());
        //root.removeChild(node2);
        //System.out.println("Removed cain (removeChild): " + root.getChildren());

        System.out.println("\nPre-Order Traversal: ");
        root.preOrderTraversal();

        System.out.println("\nPost-Order Traversal: ");
        root.postOrderTraversal();

        System.out.println("\nLevel-Order Traversal: ");
        for (int height = 1; height <= 3; height++)
            root.levelOrder(height);
    }
}
