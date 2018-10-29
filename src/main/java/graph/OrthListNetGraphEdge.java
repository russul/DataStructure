package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/24
 */
public class OrthListNetGraphEdge implements Edge{

    private int tailVex;     /*起点的顶点下标*/
    private int headVex;     /*终点的顶点下标*/
    private Float weight;    /*权值*/
    private OrthListNetGraphEdge headNext;   /*终点相同的下一条边*/
    private OrthListNetGraphEdge tailNext;   /*起点相同的下一条边*/

    public OrthListNetGraphEdge(int tailVex, int headVex, Float weight) {
        this.tailVex = tailVex;
        this.headVex = headVex;
        this.weight = weight;
        this.headNext = null;
        this.tailNext = null;
    }


    public int getTailVex() {
        return tailVex;
    }

    public void setTailVex(int tailVex) {
        this.tailVex = tailVex;
    }

    public int getHeadVex() {
        return headVex;
    }

    public void setHeadVex(int headVex) {
        this.headVex = headVex;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public OrthListNetGraphEdge getHeadNext() {
        return headNext;
    }

    public void setHeadNext(OrthListNetGraphEdge headNext) {
        this.headNext = headNext;
    }

    public OrthListNetGraphEdge getTailNext() {
        return tailNext;
    }

    public void setTailNext(OrthListNetGraphEdge tailNext) {
        this.tailNext = tailNext;
    }

    @Override
    public String toString() {
        return "OrthListNetGraphEdge{" +
                "tailVex=" + tailVex +
                ", headVex=" + headVex +
                ", weight=" + weight +
                '}';
    }
}
