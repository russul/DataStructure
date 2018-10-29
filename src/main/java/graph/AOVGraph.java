package graph;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/29
 */
public class AOVGraph implements Graph {

    public static final int MAX_VEX = 100;
    private AOVVertex[] vexes;
    private int numVertexes;
    private int numEdges;
    /*定义三个成员变量充当关键路径算法的全局变量*/
    private float[] etv;    /*事件的最早发生时间*/
    private float[] ltv;  /*事件的最晚发生时间*/
    private Stack stack;   /*用来存储拓扑序列的栈*/

    public AOVGraph() {
        this.vexes = new AOVVertex[MAX_VEX];
        createGraph();
    }

    @Override
    public void createGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入顶点数和边数");
        this.numVertexes = scanner.nextInt();
        this.numEdges = scanner.nextInt();

        /*建立顶点表*/
        System.out.println("请按顺序输入顶点的入度值和数据，格式：数据 入度值");
        for (int i = 0; i < this.numVertexes; i++) {

            String data = scanner.next();
            int in = scanner.nextInt();
            AOVVertex vertex = new AOVVertex(data, in);
            this.vexes[i] = vertex;
        }
        /*建立边表*/
        System.out.println("请输入边<vi,vj>的顶点下标和权值，格式：vi的下标 vj的下标 权值");
        for (int j = 0; j < this.numEdges; j++) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Float weight = scanner.nextFloat();
            AOVEdge edge = new AOVEdge(y, weight);
            /*一个头插法将边插入边的链表*/
            edge.setNext(this.vexes[x].getFirstEdge());
            this.vexes[x].setFirstEdge(edge);

        }
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/29 16:39
     * @param []
     * @return java.lang.String
     * @description
     */
    public String topologicalSort() {
//        int top = 0;/*用于指示栈指针的下标*/
        int count = 0;/*用于统计输出顶点的个数*/
        Stack<Integer> stack = new Stack<Integer>();/*建栈存入入度为0的顶点*/
        for (int i = 0; i < this.numVertexes; i++) {
            if (this.vexes[i].getIn() == 0) {
                stack.push(i);     /*将入度为0的顶点入栈*/
//                top++;
            }
        }


        while (stack.size() != 0) {
            int getTop = stack.pop();
//            top--;
            System.out.println(this.vexes[getTop].getData());
            count++;
            /*获取该顶点的所有邻接点*/
            for (AOVEdge e = this.vexes[getTop].getFirstEdge(); e != null; e = e.getNext()) {
                int k = e.getAdjVex();
                int adjIn = this.vexes[k].getIn();
                this.vexes[k].setIn(--adjIn);

                if (0 == adjIn) {
                    stack.push(k);

                }
            }
        }

        if (count < this.numVertexes) {
            System.out.println("ERROR");
            return "ERROR";

        } else {
            System.out.println("OK");
            return "OK";
        }
    }

    public String topologicalSort2() {
        this.etv = new float[MAX_VEX];
        this.ltv = new float[MAX_VEX];
        this.stack = new Stack();
//        int top = 0;/*用于指示栈指针的下标*/
        int count = 0;/*用于统计输出顶点的个数*/
        Stack<Integer> stack = new Stack<Integer>();/*建栈存入入度为0的顶点*/
        for (int i = 0; i < this.numVertexes; i++) {
            if (this.vexes[i].getIn() == 0) {
                stack.push(i);     /*将入度为0的顶点入栈*/
//                top++;

            }
        }

        /*对etv进行初始化*/
        for (int i = 0; i < this.numVertexes; i++) {
            this.etv[i] = 0;
        }


        while (stack.size() != 0) {
            int getTop = stack.pop();
//            top--;
            this.stack.push(getTop);    /*将弹出的顶点序号压入拓扑序列的栈中*/
            count++;

            /*寻找该顶点的所有出边（以该顶点为弧尾的弧）*/
            for (AOVEdge e = this.vexes[getTop].getFirstEdge(); e != null; e = e.getNext()) {
                int k = e.getAdjVex();
                int adjIn = this.vexes[k].getIn();
                this.vexes[k].setIn(--adjIn);
                /*将去除各个邻接点上因为有该顶点消失而将入度分别减一，入栈*/
                if (0 == adjIn) {
                    stack.push(k);

                }
                /*更新各邻接点表示事件的最早发生时间*/
                if ((this.etv[getTop] + e.getWeight()) > this.etv[k]) {
                    this.etv[k] = this.etv[getTop] + e.getWeight();
                }
            }
        }

        if (count < this.numVertexes) {

            return "ERROR";

        } else {

            return "OK";
        }
    }


    public void criticalPath() {

        topologicalSort2();
        float[] ltv = new float[MAX_VEX];
        /*初始化事件的最晚发生时间*/
        for (int i = 0; i < this.numVertexes; i++) {
            ltv[i] = this.etv[this.numVertexes - 1];
        }

        /*计算ltv*/
        while (this.stack.size() != 0) {
            int getTop = (Integer) this.stack.pop();
            for (AOVEdge e = this.vexes[getTop].getFirstEdge(); e != null; e = e.getNext()) {
                int k = e.getAdjVex();
                if (ltv[k] - e.getWeight() < ltv[getTop]) {
                    ltv[getTop] = ltv[k] - e.getWeight();
                }
            }
        }

        /*计算ete和lte以及关键活动*/
        for (int i = 0; i < this.numVertexes; i++) {
            for (AOVEdge e = this.vexes[i].getFirstEdge(); e != null; e = e.getNext()) {
                int k = e.getAdjVex();
                float ete = this.etv[i];
                float lte = ltv[k] - e.getWeight();
                if (ete == lte) {
                    System.out.println("<" + this.vexes[i].getData() + "," + this.vexes[k].getData() + ">" + " " + "length:" + e.getWeight());
                }
            }
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
}
