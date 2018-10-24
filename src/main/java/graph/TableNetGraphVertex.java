package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 邻接表的顶点
 * @date:2018/10/24
 */
public class TableNetGraphVertex implements Vertex {

    private Object data;
    private TableNetGraphEdge firstEdge;


    public TableNetGraphVertex(Object data) {
        this.data = data;
        this.firstEdge = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public TableNetGraphEdge getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(TableNetGraphEdge firstEdge) {
        this.firstEdge = firstEdge;
    }


    @Override
    public String toString() {
        return "TableNetGraphVertex{" +
                "data=" + data +
                ", firstEdge=" + firstEdge +
                '}';
    }
}
