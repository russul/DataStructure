package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 边集数组的边结构
 * @date:2018/10/29
 */
public class EdgeArrayEdge implements Edge{

    private int begin;      /*弧尾*/
    private int end;         /*弧头*/
    private float weight;    /*权值*/

    public EdgeArrayEdge(int begin, int end, float weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
