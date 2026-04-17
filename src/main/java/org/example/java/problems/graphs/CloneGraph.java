package org.example.java.problems.graphs;
/*
133. Clone Graph

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Solution :
Create a map of visited elements, to store the nodes that we have already visited.
Use recursion to make the deep copy of a node
Use a for loop inside the recursive method to traverse through the each neighbouring node of node
Keep track of visited elements by putting it in the map.
In case if a node is already there in the visited map return the neighbour from node and add it to the copy's neighbour.
In case if a node is not there we need to call the recursive method to make a deep copy of the neighbour node.
Once copy is created add the node to the neighbour list of copy's node.

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String args[]){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors = List.of(new Node[]{two, four});
        two.neighbors = List.of(new Node[]{one, three});
        three.neighbors = List.of(new Node[]{two, four});
        four.neighbors = List.of(new Node[]{one, three});



        cloneGraph(one);
    }

    public static Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        return recursionGraph(node,visited);
    }

    public static Node recursionGraph(Node node, Map<Node,Node> visited){
        Node copy = new Node(node.val);
        visited.put(node, copy);
        for(Node neighbors : node.neighbors){
            if(visited.containsKey(neighbors)){
                copy.neighbors.add(visited.get(neighbors));
            }else{
                Node copyNeighbour = recursionGraph(neighbors,visited);
                copy.neighbors.add(copyNeighbour);
            }
        }
        return copy;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}
