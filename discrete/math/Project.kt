package discrete.math

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    //We will store a map of cities so that we can identify them by code later on
    val cityMap: HashMap<Int, String> = HashMap()
    //All vertices in the graph will be stored in this list
    var vertices: ArrayList<Vertex> = ArrayList()


    //First we open the cityNames file using the BufferedReader class
    try {
        val cityNames = File("C:\\Users\\armin\\Desktop\\Discrete Math II\\Project\\cityName.csv")

        val reader = BufferedReader(FileReader(cityNames))

        //We need to skip the first line because it contains column titles, rather than data
        //That's why we call readLine() twice before doing anything else
        var readerLine = reader.readLine()
        readerLine = reader.readLine()

        while (readerLine != null) {
            //Here we split the line of the BufferedReader by commas, which gives us an array of length 2
            val line = readerLine.split(",").toTypedArray()
            //line[0] is the code, while line[1] is the name of the city
            //We have to convert line[0] from String to Int in order to use it
            cityMap[line[0].toInt()] = line[1]
            //We also create a new Vertex, passing the code and name in its constructor
            //An empty list is also passed for the list of neighboring vertices
            vertices.add(Vertex(line[0].toInt(),line[1], arrayListOf()))
            readerLine = reader.readLine()
        }

    } catch (e: Exception) {
        println(e.message)
    }

    //We are sorting the vertices array by code, so that the vertex with the code 1 will be at vertices[0]
    //This makes it easier to properly store neighbors
    vertices.sortBy {it.code}

    //Now we do the same thing with the fromTo file
    try {
        val fromTo = File("C:\\Users\\armin\\Desktop\\Discrete Math II\\Project\\FromTo.csv")

        val reader = BufferedReader(FileReader(fromTo))

        //We skip the first line again
        var readerLine = reader.readLine()
        readerLine = reader.readLine()

        while (readerLine != null) {
            val line = readerLine.split(",").toTypedArray()
            //Here we are adding vertices to the neighbors list
            //We add twice, since the graph is undirected
            //I.e. if the line is 1-2, 2 will get added to 1's neighbors, but 1 will also get added to 2's neighbors
            vertices[line[0].toInt()-1].neighbors.add(vertices[line[1].toInt()-1])
            vertices[line[1].toInt()-1].neighbors.add(vertices[line[0].toInt()-1])
            readerLine = reader.readLine()
        }

    } catch (e: Exception) {
        println(e.message)
    }

    val distances = HashMap<Vertex,Int>()
    val previousVertices = HashMap<Vertex,Vertex>()
    val unvisited: ArrayList<Vertex> = ArrayList(vertices)

    val scanner = Scanner(System.`in`)
    println("Input starting point name: ")
    val sourceName = scanner.nextLine()

    val source = vertices.find {
        it.name == sourceName
    } ?: throw IllegalArgumentException("Invalid starting point provided")

    unvisited.forEach {
        if (it == source){
            distances[it]=0
        }
        else
            distances[it]= Int.MAX_VALUE
    }

    while (unvisited.isNotEmpty()){
        val currentVertex = getClosestVertex(unvisited,distances)
        unvisited.remove(currentVertex)
        currentVertex.neighbors.forEach { neighbor ->
            if(unvisited.contains(neighbor)){
                val newDistance = 1 + distances[currentVertex]!!
                if (distances[neighbor]!! > newDistance){
                    distances[neighbor] = newDistance
                    previousVertices[neighbor] = currentVertex
                }
            }
        }
    }

    /*distances.forEach {
        if (it.value > 0)
            println("${it.key.name} is ${it.value} away from ${source.name}")
        else
            println("${it.key.name} is unreachable from ${source.name}")
    }*/

    println("Input destination point name: ")
    val destinationName = scanner.nextLine()

    val destination = vertices.find {
        it.name == destinationName
    } ?: throw IllegalArgumentException("Invalid destination point provided")


    println("The shortest path between ${source.name} and ${destination.name} is: ")
    try {
        var currentVertex = destination
        print("${currentVertex.name} <- ")
        while (currentVertex != source){
            print("${previousVertices[currentVertex]?.name} <- ")
            currentVertex = previousVertices[currentVertex]!!
        }
        println("\b\b\b\b")
        println("The length of the path is ${distances[destination]}")
    }
    catch (e: Exception){
        println("Cities are not connected")
    }

}

/*fun getClosestVertex(list: ArrayList<Vertex>, distances: HashMap<Vertex,Int>): Vertex{
    var lowest = list[0]
    list.forEach {
        if (distances[it]!! < distances[lowest]!!){
            lowest = it
        }
    }
    return lowest
}
*/
