package graph;

import java.util.AbstractQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/23
 */
public class MatrixNetGraph implements Graph {

    public static final int MAX_VEX = 100; /*最大的顶点数*/
    public static final float INFINITE = Float.POSITIVE_INFINITY;/*定义无连接的位置的值*/


    private MatrixNetGraphVertex[] vertexes;/*顶点表*/
    private float[][] edges;        /*边数表*/
    private boolean[] visit;       /*顶点是否访问标志*/
    /*用来实现最短路径弗洛伊德算法的两个二维数组*/
    private int[][] pathMatrix;     /*记录前驱顶点的下标*/
    private float[][] shortPathTable;   /*记录各点之间的最短路径*/

    private int numVertexes, numEdges;    /*图中当前的顶点数和边数*/

    public MatrixNetGraph() {
        this.vertexes = new MatrixNetGraphVertex[MAX_VEX];
        this.edges = new float[MAX_VEX][MAX_VEX];
        this.visit = new boolean[MAX_VEX];
//        this.numVertexes = 0;
//        this.numEdges = 0;
    }

    @Override
    public void createGraph() {
        System.out.println("请输入顶点数和边数");
        Scanner scanner1 = new Scanner(System.in);
        this.numVertexes = scanner1.nextInt();
        this.numEdges = scanner1.nextInt();

        System.out.println("请输入顶点的数据");

        for (int i = 0; i < this.numVertexes; i++) {


            this.vertexes[i] = new MatrixNetGraphVertex(scanner1.next());
        }

        /*初始化邻接矩阵*/
        for (int j = 0; j < this.numVertexes; j++) {
            for (int k = 0; k < this.numVertexes; k++) {
                this.edges[j][k] = INFINITE;
            }
        }



        /*给邻接矩阵赋值*/
        for (int j = 0; j < this.numEdges; j++) {
            System.out.println("请输入每条边的权值,格式为：横坐标 纵坐标 权值");
            int x = scanner1.nextInt();
            int y = scanner1.nextInt();
            this.edges[x][y] = scanner1.nextFloat();
            this.edges[y][x] = this.edges[x][y];             /*无向图是对称矩阵*/
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

    /*
     *
     *
     * @author kevin
     * @date 2018/10/24 20:06
     * @param
     * @return
     * @description 邻接矩阵的深度遍历操作
     */

    @Override
    public void dfsTraverse() {
        int i;
        /*给所有的visit初始化为false*/
        for (i = 0; i < this.numVertexes; i++) {
            this.visit[i] = false;
        }

        /*遍历*/
        for (i = 0; i < this.numVertexes; i++) {
            if (!this.visit[i]) {        /*对未访问的顶点调用dfs，若是连通图，只会执行一次*/
                dfs(i);
            }
        }
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/24 20:03
     * @param [i]
     * @return void
     * @description 邻接矩阵的深度优先递归算法（类似于树的前序遍历）
     */
    private void dfs(int i) {

        /*对顶点的具体操作（对应树中的对结点的具体操作）*/
        this.visit[i] = true;
        System.out.println(this.vertexes[i].getData());
        /*对访问的邻接顶点进行递归（对应树中对孩子结点的递归）*/
        for (int j = 0; j < this.numVertexes; j++) {
            if (this.edges[i][j] == 1f && !this.visit[j]) {
                dfs(j);
            }
        }

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/24 21:17
     * @param []
     * @return void
     * @description 广度优先遍历（类似于树中的层序遍历）
     */
    @Override
    public void hfsTraverse() {

        /*初始化标志数组*/
        for (int i = 0; i < this.numVertexes; i++) {
            this.visit[i] = false;
        }

        /*遍历*/
        Queue queue = new ArrayBlockingQueue(MAX_VEX);
        int i;
        int j;
        for (i = 0; i < this.numVertexes; i++) {      /*如果图是连通的，此循环只执行一次*/
            if (!this.visit[i]) {
                this.visit[i] = true;
                System.out.println(this.vertexes[i].getData());    /*遍历该顶点*/
                queue.add(i);

                while (queue.size() != 0) {
                    i = (Integer) queue.remove();                  /*将该顶点弹出时，紧接着让它的邻接点（下一层顶点）入队列*/
                    for (j = 0; j < this.numVertexes; j++) {
                        if (this.edges[i][j] == 1.0f && !this.visit[j]) {
                            this.visit[j] = true;
                            System.out.println(this.vertexes[j].getData());  /*遍历该顶点的邻接点（下一层结点）*/
                            queue.add(j);                                    /*让它的邻接点入队列*/
                        }
                    }
                }
            }

        }

    }


    public void shortestPath_Floyd() {
        int v, w, k;
        this.pathMatrix = new int[MAX_VEX][MAX_VEX];
        this.shortPathTable = new float[MAX_VEX][MAX_VEX];
        /*初始化两个矩阵*/
        for (v = 0; v < this.numVertexes; v++) {
            for (w = 0; w < this.numVertexes; w++) {
                this.pathMatrix[v][w] = w;
                    if(v==w){
                        this.shortPathTable[v][w] = 0;
                    }else {
                        this.shortPathTable[v][w] = this.edges[v][w];
                    }



            }
        }

        /*选取不同的前驱顶点对两个矩阵进行更新*/
        for (k = 0; k < this.numVertexes; k++) {

            for (v = 0; v < this.numVertexes; v++) {
                for (w = 0; w < this.numVertexes; w++) {
                    if (this.shortPathTable[v][w] > this.shortPathTable[v][k] + this.shortPathTable[k][w]) {
                        this.shortPathTable[v][w] = this.shortPathTable[v][k] + this.shortPathTable[k][w];
                        this.pathMatrix[v][w] = this.pathMatrix[v][k];
                    }
                }
            }
            System.out.println("--------------" + "D" + k + "-------------");
            for (v = 0; v < this.numVertexes; v++) {
                for (w = 0; w < this.numVertexes; w++) {
                    System.out.print(this.shortPathTable[v][w] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------" + "P" + k + "-------------");
            for (v = 0; v < this.numVertexes; v++) {
                for (w = 0; w < this.numVertexes; w++) {
                    System.out.print(this.pathMatrix[v][w]+ " ");
                }
                System.out.println();
            }
        }

    }



    public MatrixNetGraphVertex[] getVertexes() {
        return vertexes;
    }

    public void setVertexes(MatrixNetGraphVertex[] vertexes) {
        this.vertexes = vertexes;
    }

    public float[][] getEdges() {
        return edges;
    }

    public void setEdges(float[][] edges) {
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
