package graphs;

public class Edge {

    protected int distance;
    protected Vertex start;
    protected Vertex end;

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

    public String toString() {
        return "You traveled " + this.distance + " km";
    }
}
