package discrete.math

import java.util.*

// Prim's Algorithm in Java


internal class PGraph {
    fun prim(G: Array<IntArray>, V: Int) {
        val infinity = 9999999

        // create a array to track selected vertex
        // selected will become true otherwise false
        val selected = BooleanArray(V)

        // set selected false initially
        Arrays.fill(selected, false)

        // set number of edge to 0
        var noEdge: Int = 0 // number of edge

        // the number of egde in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in
        // graph

        // choose 0th vertex and make it true
        selected[0] = true

        // print for edge and weight
        println("Edge : Weight")
        while (noEdge < V - 1) {
            // For every vertex in the set S, find the all adjacent vertices
            // , calculate the distance from the vertex selected at step 1.
            // if the vertex is already in the set S, discard it otherwise
            // choose another vertex nearest to selected vertex at step 1.
            var min = infinity
            var x = 0 // row number
            var y = 0 // col number
            for (i in 0 until V) {
                if (selected[i]) {
                    for (j in 0 until V) {
                        // not in selected and there is an edge
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j]
                                x = i
                                y = j
                            }
                        }
                    }
                }
            }
            println(x.toString() + " - " + y + " :  " + G[x][y])
            selected[y] = true
            noEdge++
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val g = PGraph()

            // number of vertices in graph
            val vertices = 5

            // create a 2d array of size 5x5
            // for adjacency matrix to represent graph
            val graph = arrayOf(
                    intArrayOf(0, 9, 75, 0, 0),
                    intArrayOf(9, 0, 95, 19, 42),
                    intArrayOf(75, 95, 0, 51, 66),
                    intArrayOf(0, 19, 51, 0, 31),
                    intArrayOf(0, 42, 66, 31, 0)
            )
            g.prim(graph, vertices)
        }
    }
}