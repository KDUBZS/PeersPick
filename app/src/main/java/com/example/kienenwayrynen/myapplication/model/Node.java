package com.example.kienenwayrynen.myapplication.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public int x, y, id;
    //First Integer is Id of another node, and second Integer is the weight
    public Map<Integer,Integer> connections;

    public Node predecessor;
    public int cost;

    public Node(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        connections = new HashMap<>();
    }
}
