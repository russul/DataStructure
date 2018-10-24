package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/24
 */
public class OrthListNetGraph implements Graph {


    public static final int MAX_VERTEX = 100;
    private OrthListNetGraphVertex[] vertexes;   /*顶点表*/
    private int numVertexes;           /*当前顶点数*/
    private int numEdges;              /*当前边数*/


    public OrthListNetGraph() {
        this.vertexes = new OrthListNetGraphVertex[MAX_VERTEX];
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
        for (int i=0;i<this.numVertexes;i++){
            OrthListNetGraphVertex vertex = new OrthListNetGraphVertex(scanner.next());
            this.vertexes[i] = vertex;
        }

        /*建立边表*/
        for (int j=0;j<this.numEdges;j++){
            System.out.println("请输入边<vi,vj>的顶点下标和权值，格式：vi的下标 vj的下标 权值");
            int x  = scanner.nextInt();
            int y = scanner.nextInt();
            Float weight = scanner.nextFloat();

            /*建立边结点*/
            OrthListNetGraphEdge edge = new OrthListNetGraphEdge(x,y,weight);
            edge.setWeight(weight);
            /*对于起点来说，插入的是出边*/
            /*头插法插入为出边*/
            edge.setTailNext(this.vertexes[x].getFirstOut());
            this.vertexes[x].setFirstOut(edge);
            /*对于终点来说，插入的是入边*/
            /*头插法插入为入边*/
            edge.setHeadNext(this.vertexes[y].getFirstIn());
            this.vertexes[y].setFirstIn(edge);


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

    public OrthListNetGraphVertex[] getVertexes() {
        return vertexes;
    }

    public void setVertexes(OrthListNetGraphVertex[] vertexes) {
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
