package com.example.kienenwayrynen.myapplication.model;

import android.graphics.Path;
import android.graphics.Point;
import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Graph {
    List<Node> nodes;
    int idtracker = 0;

    public Graph (InputStream stream){
        Scanner scanner = null;
        try {
            scanner = new Scanner(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        nodes = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] args = line.split(",");
            Node temp = new Node(Integer.valueOf(args[1]), Integer.valueOf(args[2]), Integer.valueOf(args[0]));
            if (idtracker < temp.id) {
                idtracker = temp.id+1;
            }
            for (int i = 3; i<args.length; i++) {
                temp.connections.put(Integer.valueOf(args[i]),0);
            }
            nodes.add(temp);
        }

        for (Node i : nodes) {
            for (int id : i.connections.keySet()) {
                Node other = getNode(Integer.valueOf(id));
                int weight = (int) Math.sqrt(Math.pow((double) Math.abs(other.x - i.x), 2.0) + Math.pow((double) Math.abs(other.y - i.y), 2.0));
                i.connections.put(id, weight);
            }
        }

        Log.e("GRAPH", "Grph size: " + nodes.size());
    }
    public List<Point> findPath(int start, int end, int xInset, int yInset, float scaleX, float scaleY){
        Node startNode = getNode(start);
        Node endNode = getNode(end);

        for (Node i : nodes) {
            i.cost = Integer.MAX_VALUE;
            i.predecessor = null;
        }

        List<Node> toBeConsidered = new ArrayList<>();
        List<Integer> alreadyConsidered = new ArrayList<>();

        startNode.cost = 0;
        toBeConsidered.add(startNode);

        while (!toBeConsidered.isEmpty()) {
            Node current = getLeastCost(toBeConsidered);
            Log.d("LOOP", current.id + "");

            if (current.id == endNode.id) {
                return getPath(current, xInset, yInset, scaleX, scaleY);
            }

            toBeConsidered.remove(current);

            for (int id : current.connections.keySet()) {
                    Node connection = getNode(id);
                    int weight = current.connections.get(id);

                   /* if (connection.hasStairs ) {
                        if (user cant do stairs) {
                            skip this node;
                        } else {
                            weight + stairs
                        }
                    }*/

                    int totalCost = current.cost + weight;
                    if (totalCost < connection.cost) {
                        connection.cost = totalCost;
                        connection.predecessor = current;
                    }
                    if (!alreadyConsidered.contains(connection.id)) {
                        toBeConsidered.add(connection);
                    }

            }

            alreadyConsidered.add(current.id);
        }

        return null;
    }

    public List<Point> getPath(Node node, int xInset, int yInset, float scaleX, float scaleY) {
        System.out.println("Creating path");
        List<Point> path = new ArrayList<>();
        Node parent = node;
        while (parent != null) {
            System.out.println("adding to path:" + parent.x * scaleX + "  " + parent.y * scaleY);
            path.add(new Point(xInset + ((int)(parent.x * scaleX)),  yInset+ ((int)(parent.y * scaleY))));
            parent = parent.predecessor;
        }
        return path;
    }

    public Node getLeastCost(List<Node> nodes) {
        int min = Integer.MAX_VALUE;
        Node minNode = null;
        for (Node i : nodes) {
            if (i.cost < min) {
                min = i.cost;
                minNode = i;
            }
        }
        return minNode;
    }

    public Node getNode(int id){
        for (Node node: nodes){
            if (node.id == id) {
                return node;
            }
        }
        return null;
    }

}

