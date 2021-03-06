package Arithmetic.Day07.prim;

import java.util.Arrays;

public class MinTree
{
   //创建图的邻接矩阵

    /**
     *
     * @param graph 图对象
     * @param verxs  图对应的顶点个数
     * @param  data  图中各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char data[],int[][] weight)
    {
        int i ,j;
        for (i = 0;i < verxs;i++)//顶点
        {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++)
            {
                graph.weight[i][j] = weight[i][j];//邻接矩阵初始化
            }
        }
    }
    //显示图的邻接矩阵
    public void showGraph(MGraph graph)
    {
        for (int[] link : graph.weight)
        {
            System.out.println(Arrays.toString(link));
        }
    }

    //prim 算法，得到最小生成树
    /**
     *
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成 'A'->0, 'B'->1
     */
     public void prim(MGraph graph,int v)
    {
        //visited[] 标记节点(顶点)是否被访问过
        int[] visited = new int[graph.verxs];
        for (int  i = 0;i < graph.verxs;i++)
        {
            visited[i] = 0;
        }
        //把当前这个节点标记为已访问
         visited[v] = 1;
         //h1 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将minWeight 初始成一个大数，后面在遍历过程中，会被替换
        //第一层循环即要找多少遍
        for (int k = 1;k < graph.verxs;k++)//因为有grap.verxs个顶点，Prim算法结束后，有graph.verxs-1条边
        {
            for (int i = 0; i < graph.verxs;i++)//遍历已访问过的节点
            {
                for (int j =0;j < graph.verxs;j++)//遍历没有访问过的节点
                {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight)
                    {
                        //替换minWeight(寻找已经访问过的节点和未访问过的节点间的权值最小的边
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条最小边
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值"+minWeight);
            //将这个当前节点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值10000
            minWeight = 10000;
        }
    }
}
