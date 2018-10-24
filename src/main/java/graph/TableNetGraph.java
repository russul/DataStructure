package graph;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 邻接表实现的网图
 * @date:2018/10/24
 */
public class TableNetGraph implements Graph {

    private static final int MAX_VERTEX = 100;

    private TableNetGraphVertex[] vertexes;
    private int numVertexes;           /*当前顶点数*/
    private int numEdges;              /*当前边数*/
    private boolean[] visit;


    public TableNetGraph() {
        vertexes = new TableNetGraphVertex[MAX_VERTEX];
        visit = new boolean[MAX_VERTEX];
        createGraph();
    }

    @Override
    public void createGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入顶点数和边数");
        this.numVertexes = scanner.nextInt();
        this.numEdges = scanner.nextInt();

        /*建立顶点表*/
        System.out.println("请按顺序输入顶点的数据");
        for (int i = 0; i < this.numVertexes; i++) {
            TableNetGraphVertex vertex = new TableNetGraphVertex(scanner.next());
            this.vertexes[i] = vertex;
        }
        /*建立边表*/

        for (int j = 0; j < this.numEdges; j++) {
            System.out.println("请输入边<vi,vj>的顶点下标和权值，格式：vi的下标 vj的下标 权值");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Float weight = scanner.nextFloat();
            TableNetGraphEdge edge = new TableNetGraphEdge(y, weight);
            /*一个头插法将边插入边的链表*/
            edge.setNext(this.vertexes[x].getFirstEdge());
            this.vertexes[x].setFirstEdge(edge);

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

    private void dfs(int i) {
        this.visit[i] = true;
        System.out.println(this.vertexes[i].getData());
        TableNetGraphEdge p = this.vertexes[i].getFirstEdge();
        while (p != null) {
            if (!this.visit[p.getAdjVex()]) {
                dfs(p.getAdjVex());
            }
            p = p.getNext();
        }
    }

    @Override
    public void hfsTraverse() {

        /*初始化标志数组*/
        for (int i = 0; i < this.numVertexes; i++) {
            this.visit[i] = false;
        }

        /*遍历*/
        Queue queue = new ArrayBlockingQueue(MAX_VERTEX);
        int i;                                  /*遍历开始的顶点索引*/
        TableNetGraphEdge p;                    /*用来遍历临界点的指针*/
        for (i = 0; i < this.numVertexes; i++) {      /*如果图是连通的，此循环只执行一次*/
            if (!this.visit[i]) {
                this.visit[i] = true;
                System.out.println(this.vertexes[i].getData());    /*遍历该顶点*/
                queue.add(i);

                while (queue.size() != 0) {
                    i = (Integer) queue.remove();                  /*将该顶点弹出时，紧接着让它的邻接点（下一层顶点）入队列*/
                    p = this.vertexes[i].getFirstEdge();


                    while (p != null) {
                        if (!this.visit[p.getAdjVex()]) {
                            this.visit[p.getAdjVex()] = true;
                            System.out.println(this.vertexes[p.getAdjVex()]); /*遍历该顶点的邻接点（下一层结点）*/
                            queue.add(p.getAdjVex());                       /*让它的邻接点入队列*/
                        }
                    }
                }
            }

        }


    }

    public TableNetGraphVertex[] getVertexes() {
        return vertexes;
    }

    public void setVertexes(TableNetGraphVertex[] vertexes) {
        this.vertexes = vertexes;
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
