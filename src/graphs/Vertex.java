package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Vertex {

    // this is the data element of our vertex, can be any data type, complex ones too
    protected String name;
    // this label contains the marker for graph traversal (e.g. VISITED, UNEXPLORED, ...)
    protected int label;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLabel() {
        return this.label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String toString() {
        return this.name;
    }
}
