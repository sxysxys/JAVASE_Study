package com.sxy.graph;

import java.util.Arrays;

/**
 * 图
 */
public class GraphDemo {
    public static void main(String[] args) {
        int n = 5;
        String[] vertexVal={"A","B","C","D","E"};  //创建要添加的节点
        Graph graph = new Graph(n); //创建图对象
        for (int i=0;i<vertexVal.length;i++) {
            graph.insertVer(vertexVal[i]);
        }
        //添加边
        //a-b a-c b-c b-d b-e
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        //显示
        graph.showGraph();
//        graph.dfs();
        graph.bfs();
    }
}

