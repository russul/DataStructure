package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: graph
 * @date:2018/10/23
 */
public class test {
    public static void main(String[] args) {

        /*邻接矩阵的测试*/
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

        System.out.println("-----------开始深度优先遍历------------");
        matrixNetGraph.dfsTraverse();
        System.out.println("-----------开始广度优先遍历------------");
        matrixNetGraph.hfsTraverse();

/*        TableNetGraph tableNetGraph = new TableNetGraph();
        for (TableNetGraphVertex v:tableNetGraph.getVertexes()
             ) {
            if (v!=null){
                System.out.println(v.getData());
                TableNetGraphEdge firstEdge = v.getFirstEdge();

                    while (firstEdge!=null){
                        System.out.println(firstEdge);
                        firstEdge = firstEdge.getNext();
                    }

            }
        }


        System.out.println("----------开始深度优先遍历------------");
        tableNetGraph.dfsTraverse();*/
//        OrthListNetGraph orthListNetGraph = new OrthListNetGraph();
//        OrthListNetGraphVertex[] vs = orthListNetGraph.getVertexes();
//        System.out.println("------------从十字链表中遍历邻接表信息---------------------");
//        for (OrthListNetGraphVertex v:vs
//             ) {
//            if (v!=null){
//                System.out.println(v.getData());
//                OrthListNetGraphEdge firstOut = v.getFirstOut();
//                while (firstOut!=null){
//                    System.out.println(firstOut);
//                    firstOut = firstOut.getTailNext();
//                }
//            }
//        }
//
//        System.out.println("------------从十字链表中遍历逆邻接表信息---------------------");
//        for (OrthListNetGraphVertex v:vs
//                ) {
//            if (v!=null){
//                System.out.println(v.getData());
//                OrthListNetGraphEdge firstIn = v.getFirstIn();
//                while (firstIn!=null){
//                    System.out.println(firstIn);
//                    firstIn = firstIn.getHeadNext();
//                }
//            }
//        }
    }
}
