public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 10000;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts; //current number of vertices
    private int nTree;  //number of vertices in tree
    private int currentVert;    //current vertex

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];

        nVerts = 0;
        nTree = 0;

        for(int j = 0; j < MAX_VERTS; j++) {
            for(int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
    }

    public void addVertex(String label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }


}
