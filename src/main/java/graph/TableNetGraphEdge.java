package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 邻接表结点
 * @date:2018/10/24
 */
public class TableNetGraphEdge {

    private int adjVex;/*邻接点域*/
    private Float weight; /*权值*/
    private TableNetGraphEdge next;/*下一个邻接点*/


    public TableNetGraphEdge(int adjVex, Float weight) {
        this.adjVex = adjVex;
        this.weight = weight;
        this.next = null;
    }

    public int getAdjVex() {
        return adjVex;
    }

    public void setAdjVex(int adjVex) {
        this.adjVex = adjVex;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public TableNetGraphEdge getNext() {
        return next;
    }

    public void setNext(TableNetGraphEdge next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "TableNetGraphEdge{" +
                "adjVex=" + adjVex +
                ", weight=" + weight +
                '}';
    }
}
