package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 邻接矩阵的顶点
 * @date:2018/10/23
 */
public class MatrixNetGraphVertex implements Vertex{
    private Object data;

    public MatrixNetGraphVertex(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
