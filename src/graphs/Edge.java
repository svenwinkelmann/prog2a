package graphs;

public class Edge {

    protected int distance;
    // for directed graphs we have a start and end, for undirected we can have e.g. Vertex[] vertices = new Vertex[2];
    protected Vertex start;
    protected Vertex end;
    // this label contains the marker for graph traversal (e.g. VISITED, UNEXPLORED, ...)
    protected int label;

    public Edge(Vertex start, Vertex end, int distance) {
        this.distance = distance;
        this.end = end;
        this.start = start;
    }

    public int getDistance() {
        return this.distance;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String toString() {
        return "" + this.distance + " km";
    }
}
