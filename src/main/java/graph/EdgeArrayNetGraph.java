package graph;

import tree.HuffmanNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/29
 */
public class EdgeArrayNetGraph implements Graph {

    public static final int MAX_VEX = 100;
//    public static final float  INFINITY = Float.POSITIVE_INFINITY;


    private EdgeArrayVertex[] vexes;
    private EdgeArrayEdge[] edges;

    private int numVertexes;
    private int numEdges;


    public EdgeArrayNetGraph() {
        this.vexes = new EdgeArrayVertex[MAX_VEX];
        this.edges = new EdgeArrayEdge[MAX_VEX * MAX_VEX];
        createGraph();
    }

    @Override
    public void createGraph() {

        System.out.println("请输入顶点数和边数");
        Scanner scanner1 = new Scanner(System.in);
        this.numVertexes = scanner1.nextInt();
        this.numEdges = scanner1.nextInt();

        System.out.println("请输入顶点的数据");

        for (int i = 0; i < this.numVertexes; i++) {


            this.vexes[i] = new EdgeArrayVertex(scanner1.next());
        }





        /*给边集数组赋值*/
        for (int j = 0; j < this.numEdges; j++) {
            System.out.println("请输入每条边的权值,格式为：起始位置（弧尾） 结束位置（弧头） 权值");
            int x = scanner1.nextInt();
            int y = scanner1.nextInt();
            float weight = scanner1.nextFloat();
            this.edges[j] = new EdgeArrayEdge(x, y, weight);
        }


    }

    @Override
    public void destroyGraph() {

    }

    @Override
    public int locateVex(Vertex v) {
        return 0;
    }

    @Override
    public Object getVex(Vertex v) {
        return null;
    }

    @Override
    public void putVex(Object value, Vertex v) {

    }

    @Override
    public Vertex firstAdjVex(Vertex v) {
        return null;
    }

    @Override
    public Vertex nextAdjVex(Vertex v, Vertex loc) {
        return null;
    }

    @Override
    public void insertVex(Vertex vertex) {

    }

    @Override
    public void deleteVex(Vertex vertex) {

    }

    @Override
    public void insertArc(Vertex v, Vertex w) {

    }

    @Override
    public void deleteArc(Vertex v, Vertex w) {

    }

    @Override
    public void dfsTraverse() {

    }

    @Override
    public void hfsTraverse() {

    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/29 14:21
     * @param
     * @return
     * @description 最小生成树的Kruskal算法
     */

    public void miniSpanTree_Kruskal() {
        int[] parent = new int[MAX_VEX];   /*定义数组来判断边和边是否形成环路*/
        /*将边按照权值有小到大排列*/
        bubbleSort(this.edges);
        for (int i = 0; i < this.numVertexes; i++) {
            parent[i] = 0;
        }
        for (int i = 0; i < this.numEdges; i++) {
            int n = find(parent, this.edges[i].getBegin());
            int m = find(parent, this.edges[i].getEnd());
            if (n != m) {
                parent[n] = m;
                System.out.println("(" + this.edges[i].getBegin() + "," + this.edges[i].getEnd() + ")");
            }
        }
    }

    private int find(int[] parent, int f) {
        while (parent[f] > 0) {
            f = parent[f];
        }
        return f;
    }

    private void bubbleSort(EdgeArrayEdge[] edges) {
        List edgeList = new ArrayList();
        for (EdgeArrayEdge e : edges
                ) {
            if (e != null) {
                edgeList.add(e);
            }

        }
        bubbleSort(edgeList);
        for (int i = 0; i < edgeList.size(); i++) {
            edges[i] = (EdgeArrayEdge) edgeList.get(i);
        }

    }

    private void bubbleSort(List<EdgeArrayEdge> edgeList) {
        for (int j = edgeList.size() - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (edgeList.get(i).getWeight() > edgeList.get(i + 1).getWeight()) {

                    /*List的add(int index,E element)在列表的指定位置插入指定元素（可选操作）。
                    将当前处于该位置的元素（如果有的话）和所有后续元素向右移动（在其索引中加 1）。 */
                    edgeList.add(i, edgeList.get(i + 1));
                    /*List的remove(int index)移除列表中指定位置的元素（可选操作）。
                    将所有的后续元素向左移动（将其索引减 1）。返回从列表中移除的元素。
                    所以这里删除i+2处的元素*/
                    edgeList.remove(i + 2);
                    /*这两行代码就可以完成元素位置的替换*/

                }
            }
        }

    }

    public EdgeArrayVertex[] getVexes() {
        return vexes;
    }

    public void setVexes(EdgeArrayVertex[] vexes) {
        this.vexes = vexes;
    }

    public EdgeArrayEdge[] getEdges() {
        return edges;
    }

    public void setEdges(EdgeArrayEdge[] edges) {
        this.edges = edges;
    }

    public int getNumVertexes() {
        return numVertexes;
    }

    public void setNumVertexes(int numVertexes) {
        this.numVertexes = numVertexes;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }
}
