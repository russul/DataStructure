package graph;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/23
 */
public interface Graph {
    void createGraph();
    void destroyGraph();
    int locateVex(Vertex v);
    Object getVex(Vertex v);
    void putVex(Object value,Vertex v);
    Vertex firstAdjVex(Vertex v);
    Vertex nextAdjVex(Vertex v,Vertex loc);
    void insertVex(Vertex vertex);
    void deleteVex(Vertex vertex);
    void insertArc(Vertex v, Vertex w);
    void deleteArc(Vertex v,Vertex w);
    void dfsTraverse();
    void hfsTraverse();
}
