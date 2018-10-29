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
                if (v == w) {
                    this.shortPathTable[v][w] = 0;
                } else {
                    this.shortPathTable[v][w] = this.edges[v][w];
                }


            }
        }

        /*选取不同的前驱顶点对两个矩阵进行更新*/
        for (k = 0; k < this.numVertexes; k++) {

            for (v = 0; v < this.numVertexes; v++) {
                for (w = 0; w < this.numVertexes; w++) {
                    if (this.shortPathTable[v][w] > this.shortPathTable[v][k] + this.shortPathTable[k][w]) {    //核心代码三个循环嵌套
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
                    System.out.print(this.pathMatrix[v][w] + " ");
                }
                System.out.println();
            }
        }

    }


    public void shortestPath_Dijkstra(int v0) {
        int k = 0;
        boolean[] flag = new boolean[MAX_VEX];    //标志数值，标志顶点是否被纳入最短路径了
        int[] pathArc = new int[MAX_VEX];         /*记录定点的前驱定点*/
        float[] shortPathTable = new float[MAX_VEX];/*该顶点到各个顶点的最短路径*/
        for (int v = 0; v < this.numVertexes; v++) {    //初始化
            flag[v] = false;
            shortPathTable[v] = this.edges[v0][v];
            pathArc[v] = 0;
        }
//        for (int v=0;v<this.numVertexes;v++){
//            this.edges[v][v] = 0;
//        }

        shortPathTable[v0] = 0;                //给源点初始化
        flag[0] = true;
        for (int v = 1; v < this.numVertexes; v++) {       //这里v从1开始是因为自己到自己最短路径不用求

            float min = INFINITE;
            for (int w = 0; w < this.numVertexes; w++) {
                if (!flag[w] && shortPathTable[w] < min) {   //寻找离v0最近的顶点
                    k = w;
                    min = shortPathTable[w];              //w顶点离v0更近，更新值
                }
            }

            flag[k] = true;                               //将目前找到的最近的顶点置为1

            for (int w = 0; w < this.numVertexes; w++) {        //修正当前最短路径及距离
                if (!flag[w] && ((min + this.edges[k][w]) < shortPathTable[w])) {
                    shortPathTable[w] = min + this.edges[k][w];
                    pathArc[w] = k;
                }
            }

            System.out.println("---------------------------------");
            for (int i = 0; i < this.numVertexes; i++) {
                System.out.print(flag[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < this.numVertexes; i++) {
                System.out.print(shortPathTable[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < this.numVertexes; i++) {
                System.out.print(pathArc[i] + " ");
            }
        }
    }

    public void miniSpanTree_Prim() {
        int[] adjVex = new int[MAX_VEX];   /*保留相关顶点下标*/
        float[] lowCost = new float[MAX_VEX];  /*保留相关顶点间边的权值*/

        /*初始化，从第一个顶点开始，初始化第一个权值为0，代表v0已经加入生成树中*/
        lowCost[0] = 0;/*初始化第一个权值为0（lowCost=0），代表v0已经加入生成树中*/
        adjVex[0] = 0;/*初始化第一个顶点下标是0*/

        for (int i = 0; i < this.numVertexes; i++) {
            adjVex[i] = 0;                      /*初始化都是v0的下标*/
            lowCost[i] = this.edges[0][i];       /*初始化为与v0有边的权值*/
        }

        /*开始寻找生成树*/
        for (int i = 1; i < this.numVertexes; i++) {
            float min = INFINITE;
            int j = 1, k = 0;
            while (j < this.numVertexes) {
                if (lowCost[j] < min && lowCost[j] != 0) {
                    min = lowCost[j];             /*让当前权值成为最小值*/
                    k = j;                         /*将最小值的下标存入k（此时k为弧头）*/
                }
                j++;
            }
            System.out.println("(" + adjVex[k] + "," + k + ")");   /*所以这里的k,adjVex[k]就是当前权值一条最小的边*/

            lowCost[k] = 0;                  /*将找到的顶点lowCost赋值为0，代表该顶点已经纳入最小生成树，并不在参与后续最小权值的比较*/

            for (j = 1; j < this.numVertexes; j++) {
                if (lowCost[j] != 0 && this.edges[k][j] < lowCost[j]) {
                    lowCost[j] = this.edges[k][j];                      /* 此时再寻找以k为弧尾的边的权值的较小值加入lowCost*/
                    adjVex[j] = k;
                }
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
