package it.unibo.generics.graph;

import java.util.*;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    Map<N, Set<N>> graph = new HashMap<>(); 

    public void addNode(N node) {
        
        if (node != null) {
            graph.put(node, new HashSet<N>()); 
        }

    }

    public void addEdge(N source, N target) {
        
        if (target != null && source != null) {
            graph.get(source).add(target); 
        }

    }

    public Set<N> nodeSet() {
        return graph.keySet(); 
    }

    public Set<N> linkedNodes(N node) {
        return graph.get(node); 
    }

    public List<N> getPath(N source, N target) {
        
        if (source == null || target == null) {
            return null; 
        }

        if (source == target) {
            return new LinkedList<>(Arrays.asList(target)); 
        }
        //BFS
        Queue<N> queue = new LinkedList<>(); 
        Map<N, N> previousNode = new HashMap<>(); 

        queue.add(source); 
        previousNode.put(source, null); 

        while (!queue.isEmpty()) {
            N current = queue.poll(); 

            for (N neighbor: linkedNodes(current)) {
                if (!previousNode.containsKey(neighbor)) {
                    queue.add(neighbor); 
                    previousNode.put(neighbor, current); 

                    if (neighbor.equals(target)) {
                        List<N> path = new LinkedList<>(); 
                        N node = target; 
                        while (node != null) {
                            path.add(0, node); 
                            node = previousNode.get(node); 
                        }
                        return path; 
                    }
                }
            }
        }
        return new LinkedList<>(); 
    }
}

