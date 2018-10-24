package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 十字链表的顶点
 * @date:2018/10/24
 */
public class OrthListNetGraphVertex implements Vertex {
    private Object data;                   /*该顶点数据域*/
    private OrthListNetGraphEdge firstIn;  /*该顶点的第一个入边结点*/
    private OrthListNetGraphEdge firstOut;  /*该顶点第一个出边结点*/

    public OrthListNetGraphVertex(Object data) {
        this.data = data;
        this.firstIn = null;
        this.firstOut = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OrthListNetGraphEdge getFirstIn() {
        return firstIn;
    }

    public void setFirstIn(OrthListNetGraphEdge firstIn) {
        this.firstIn = firstIn;
    }

    public OrthListNetGraphEdge getFirstOut() {
        return firstOut;
    }

    public void setFirstOut(OrthListNetGraphEdge firstOut) {
        this.firstOut = firstOut;
    }
}
