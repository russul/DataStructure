package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 拓扑排序的顶点结构
 * @date:2018/10/29
 */
public class AOVVertex implements Vertex {

    private int in;     /*入度值*/
    private Object data;   /*数据域*/
    private AOVEdge firstEdge;  /*第一个出边*/

    public AOVVertex(Object data) {
    }

    public AOVVertex(Object data, int in) {
        this.in = in;
        this.data = data;
        this.firstEdge = null;
    }


    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public AOVEdge getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(AOVEdge firstEdge) {
        this.firstEdge = firstEdge;
    }
}
