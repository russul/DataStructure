package graph;

import org.junit.Test;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/23
 */
public class MatrixNetGraphTest {

    @Test
    public void createGraph() {

        /*Junit无法使用Scanner,在test中主方法中测试了*/
        MatrixNetGraph matrixNetGraph = new MatrixNetGraph();
        matrixNetGraph.createGraph();
        MatrixNetGraphVertex[] netGraphVertices = matrixNetGraph.getVertexes();
        float[][] edges = matrixNetGraph.getEdges();
        for (MatrixNetGraphVertex nv : netGraphVertices
                ) {
            if (nv != null) {
                System.out.println(nv.getData());
            }

        }
        for (int i = 0; i < matrixNetGraph.getNumVertexes(); i++) {
            for (int j = 0; j < matrixNetGraph.getNumVertexes(); j++) {
                System.out.println(edges[i][j]);
            }
        }


    }

    @Test
    public void destroyGraph() {
    }

    @Test
    public void locateVex() {
    }

    @Test
    public void getVex() {
    }

    @Test
    public void putVex() {
    }

    @Test
    public void firstAdjVex() {
    }

    @Test
    public void nextAdjVex() {
    }

    @Test
    public void insertVex() {
    }

    @Test
    public void deleteVex() {
    }

    @Test
    public void insertArc() {
    }

    @Test
    public void deleteArc() {
    }

    @Test
    public void dfsTraverse() {
    }

    @Test
    public void hfsTraverse() {
    }
}