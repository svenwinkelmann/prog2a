package graphs;

import acm.program.ConsoleProgram;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class IslandGraph extends ConsoleProgram {

    protected HashSet<Vertex> islands = new HashSet<>();
    protected HashSet<Edge> ferrys = new HashSet<>();

    public static final int UNEXPLORED = 0;
    public static final int VISITED = 1;
    public static final int DISCOVERY = 2;
    public static final int BACK = 3;

    public List<Edge> outgoingEdges(Vertex v) {
        List<Edge> ret = new LinkedList<>();
        for(Edge e: this.ferrys)
            if (e.start == v)
                ret.add(e);
        return ret;
    }

    // we move recursively from the given vertex v with all the edges to the next vertices, till there
    // is no further outgoing edge
    public void travelling(Vertex v) {
        List<Edge> edges = this.outgoingEdges(v);
        //if (edges.size() == 0)  // base case: this works for a tree, but not for a graph with cycles
        if (edges.size() == 0 || v.getLabel() != UNEXPLORED)  // base case
            return;
        println("Travelling: " + v);
        v.setLabel(VISITED);
        for (Edge e: edges) {
            if (e.getLabel() == UNEXPLORED) {
                e.setLabel(DISCOVERY);
                travelling(e.end);  // recursive case
            }
            else {
                e.setLabel(BACK);
            }
        }
    }

    public void dfs(Vertex v) {
        // we set all vertices to UNEXPLORED
        for(Vertex u: this.islands)
            u.setLabel(UNEXPLORED);
        // we set all edges to UNEXPLORED
        for(Edge e: this.ferrys)
            e.setLabel(UNEXPLORED);
        travelling(v);
    }


    public void run() {
        setFont("Arial-bold-32");
        println("Welcome to Pirate Island\n");

        // first, we create the islands
        Vertex pirateIsland = new Vertex("Pirate Island");
        islands.add(pirateIsland);
        Vertex treasureIsland = new Vertex("Treasure Island");
        islands.add(treasureIsland);
        Vertex deathIsland = new Vertex("Island of Death");
        islands.add(deathIsland);

        // second, we connect them with ferry lines (directed graph)
        Edge pirateToTreasure = new Edge(pirateIsland, treasureIsland, 440);
        ferrys.add(pirateToTreasure);
        Edge pirateToDeath = new Edge(pirateIsland, deathIsland, 30);
        ferrys.add(pirateToDeath);
        Edge treasureToPirate = new Edge(treasureIsland, pirateIsland, 890);
        ferrys.add(treasureToPirate);
        Edge deathToDeath = new Edge(deathIsland, deathIsland, 10);
        ferrys.add(deathToDeath);

        // lets plan our journey to steal the treasure
        // remark: we should test if there exists an edge between the vertices...
        Object[] path = { pirateIsland, pirateToTreasure, treasureIsland, treasureToPirate, pirateIsland, pirateToDeath, deathIsland };
        // we can print our path
        for(Object o: path)
            println(o.toString());

        println("------");

        // edges which start at pirateIsland
        for(Edge e: this.outgoingEdges(pirateIsland))
            println("Edge from " + e.start + " to " + e.end + " (" + e + ")");

        println("------");

        travelling(pirateIsland);

        println("------");

        // cycles are a problem while traversal of a graph, thus we set markers
        dfs(pirateIsland);

        // is the graph connected (labels are still set from our depth-first search)?
        boolean connected = true;
        for(Vertex v: this.islands)
            if (v.getLabel() != VISITED) {
                connected = false;
                break;
            }
        println("Graph is " + ((connected) ? "" : "not") + " connected.");
    }
}
