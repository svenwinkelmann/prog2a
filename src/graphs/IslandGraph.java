package graphs;

import acm.program.ConsoleProgram;
import java.util.HashSet;

public class IslandGraph extends ConsoleProgram {

    protected HashSet<Vertex> islands = new HashSet<>();
    protected HashSet<Edge> ferrys = new HashSet<>();

    public void run() {
        setFont("Arial-bold-32");
        println("Welcome to Pirate Island");

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

        // lets plan our journey to steal the treasure
        // remark: we should test if there exists an edge between the vertices...
        Object[] path = { pirateIsland, pirateToTreasure, treasureIsland, treasureToPirate, pirateIsland, pirateToDeath, deathIsland };
        // we can print our path
        for (Object o: path)
            println(o.toString());
    }
}
