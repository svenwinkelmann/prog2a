package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Vertex {

    // this is the data element of our vertex, can be any data type, complex ones too
    protected String name;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
