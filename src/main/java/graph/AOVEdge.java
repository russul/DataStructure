package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 和邻接表的边结构一致
 * @date:2018/10/29
 */
public class AOVEdge  implements Edge{

    private int adjVex;/*邻接点域*/
    private Float weight; /*权值*/
    private AOVEdge next;/*下一个邻接点*/


    public AOVEdge(int adjVex, Float weight) {
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



    @Override
    public String toString() {
        return "AOVEdge{" +
                "adjVex=" + adjVex +
                ", weight=" + weight +
                '}';
    }

    public AOVEdge getNext() {
        return next;
    }

    public void setNext(AOVEdge next) {
        this.next = next;
    }
}
