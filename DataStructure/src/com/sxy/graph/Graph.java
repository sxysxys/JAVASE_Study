package com.sxy.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图结构
 */
public class Graph {
    private ArrayList<String> vertexList;  //存储顶点集合
    private int[][] edges;  //存储图对应的邻接矩阵
    private int numOfEdges;  //表示边的数目
    private boolean[] isVisited;  //判断顶点数组是否被访问过

    public Graph(int n){  //创建几个顶点
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        numOfEdges=0;
        isVisited=new boolean[n];
    }

    /**
     * 得到第一个邻接点的下标
     * 从上到下遍历，找到就返回此时的下标，不然返回-1
     * @param index
     * @return
     */
    public int getFirstNor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点，找下一个
     * @return
     */
    public int getNextNor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 对联通图进行dfs
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited,int i){
        System.out.println(getByIndex(i)+"->");  //输出节点对应的值
        //将此节点置为以访问
        isVisited[i]=true;
        int w = getFirstNor(i); //返回0下一个连接的点的下标
        while (w!=-1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w=getNextNor(i,w);
        }
    }

    /**
     * 对所有节点进行遍历，使用于存在非联通图的情况。
     */
    public void dfs(){
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
//对一个节点进行广度优先遍历
    public void bfs(boolean[] isVisited,int i){
        int u; //表示队列头节点的对应下标
        int w; //第一个邻接节点w
        LinkedList linkedList = new LinkedList();  //模拟队列
        System.out.println(getByIndex(i)+"->");
        isVisited[i]=true;
        linkedList.addLast(i);
        while (!linkedList.isEmpty()){
            u = (Integer)linkedList.removeFirst();
            w=getFirstNor(u);
            while (w!=-1){
                if (!isVisited[w]){
                    System.out.println(getByIndex(w)+"->");
                    isVisited[w]=true;
                    linkedList.addLast(w);
                }
                w=getNextNor(u,w);
            }
        }
    }

    //遍历所有的节点，进行广度优先搜索
    public void bfs(){
        for (int i = 0; i < getVertexList(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    /**
     * 插入节点
     * @param ver
     */
    public void insertVer(String ver){
        vertexList.add(ver);
    }

    /**
     * 表示哪两条边进行相连
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    /**
     * 得到边的数目
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

//得到顶点的数目
    public int getVertexList() {
        return vertexList.size();
    }
//通过索引找对应元素
    public String getByIndex(int i){
        return vertexList.get(i);
    }
//返回权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
