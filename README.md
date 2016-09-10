# FindRouteInGraph
Given a directed graph, find out whether there is a route between two nodes

public static boolean search(Graph g, Vertex start, Vertex end)

set g.getVertices() all Vertex.visited as false

check Vertex start first;

Use LinkedList<Vertex>  as a queue, q.add(start), then while q is not empty, removeFirst, check all the edges.to

if(!w.visited)compare w==end, return true, or w.visited=true, q.add(w)

We could also use DFS, it is easier to implement, but BFS is useful to find the shorted path

