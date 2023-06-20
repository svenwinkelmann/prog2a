package generics;

import java.util.LinkedList;
import java.util.List;

/**
 * In this class, we build up a data structure called tree. Therefore, we implement a simple
 * data structure Node, which has a parent and 0 to n children.
 * Usually a node of a tree consists of:
 *  - a parent / ancestor of type Node
 *  - a data element (in this case a string, could be an int, boolean, or any complex data)
 *  - 0 to n children of type Node
 */
public class Node<T> {

    protected Node<T> parent;
    protected T element;
    protected List<Node<T>> children;

    /**
     * The constructur initializes the children list and the data element
     * @param name data element to save in the Node
     */
    public Node(T name) {
        this.element = name;
        // we use a linked list, but it could also be an ArrayList or any other list data structure
        this.children = new LinkedList<>();
    }

    /**
     * Adds a child node to this node and references the parent correctly.
     * Till now we have an unordered tree.
     * @param child The node to add.
     */
    public void addChild(Node<T> child) {
        // the interesting part is that parent and children are nodes => 'this' is a node :)
        child.parent = this;
        this.children.add(child);
    }

    /**
     * A root node does not have a parent
     * @return true in case it is a root node, false otherwise
     */
    public boolean isRoot() {
        return this.parent == null;
    }

    /**
     * An internal node has a parent and at least one child
     * @return true in case it is an internal node, false otherwise
     */
    public boolean isInternal() {
        return this.parent != null && this.children.size() > 0;
    }

    /**
     * An external node (also called leaf node) does not have children
     * @return true in case it is an external node, false otherwise
     */
    public boolean isExternal() {
        return this.children.size() == 0;
    }

    /**
     * Each node has a data element, which is returned by this function.
     * We could make the instance variable public, but this is not a good
     * programming style ;-).
     * @return the data element
     */
    public T getElement() {
        return this.element;
    }

    public Node<T> getParent() {
        return  this.parent;
    }

    public List<Node<T>> getChildren() {
        return this.children;
    }

    /**
     * Removes a child node. Be careful as the whole subtree of the child is removed, too.
     * We cannot save any child after removing its parent, because we do not have any
     * reference to it (except we save it before). And if there is no reference to an
     * instance, the Java garbage collector removes the instance.
     * @param node the node to remove
     */
    public void removeChild(Node<T> node) {
        this.children.remove(node);
    }

    public String toString() {
        return this.element.toString();
    }

    // Testing method
    public static void main(String[] args) {
        // We build our tree:
        Node<String> root = new Node<String>("Adam");
        Node<String> node1 = new Node<String>("Abel");
        root.addChild(node1);
        Node<String> node2 = new Node<String>("Cain");
        root.addChild(node2);
        node2.addChild(new Node<String>("Citha"));
        node2.addChild(new Node<String>("Maac"));

        // We implement testing methods, to make sure our implementation works
        // Usually this is done with a testing framework, e.g. jUnit
        System.out.println("Children of Adam (getChildren): " + root.getChildren());
        System.out.println("Parent of Cain (getParent): " + node2.getParent());
        System.out.println("Is Adam root (isRoot): " + root.isRoot());
        System.out.println("Is Cain internal (isInternal): " + node2.isInternal());
        System.out.println("Is Cain external (isExternal): " + node2.isExternal());
        System.out.println("Data element of Cain (getElement): " + node2.getElement());
        root.removeChild(node2);
        System.out.println("Removed cain (removeChild): " + root.getChildren() + "\n");

        // We can use the same implementation just with another data element type:
        Person hans = new Person("Hans","h@th.de", 45);
        Node<Person> root_person = new Node<Person>(hans);
        Person child1 = new Person("Elfride", "e@th.de", 12);
        root_person.addChild(new Node<Person>(child1));
        Person child2 = new Person("Frieda", "f@th.de", 10);
        root_person.addChild(new Node<Person>(child2));
        System.out.println("Children of " + hans.toString());
        for(Node<Person> n: root_person.getChildren())
            System.out.println(n.toString());
    }
}
