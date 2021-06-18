package discrete.math

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.system.exitProcess



/*
This is the class that will hold our vertices
It has a code, which is the number we identify the city with
Name is the name of the city
Neighbors is the list of all vertices our original vertex is connected to
This array will be filled while reading the fromTo file
 */
data class Vertex(
        var code: Int,
        var name: String = "",
        var neighbors: ArrayList<Vertex>
){
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vertex

        if (code != other.code) return false
        if (name != other.name) return false
        if (neighbors != other.neighbors) return false

        return true
    }
}

//We will store a map of cities so that we can identify them by code later on
val cityMap: HashMap<Int, String> = HashMap()
//All vertices in the graph will be stored in this list
var vertices: ArrayList<Vertex> = ArrayList()

fun findShortestPath(source: Vertex, destination: Vertex){
    //We will store distances of all vertices from the source into a hashmap
    val distances = HashMap<Vertex,Int>()
    //previousVertices basically stores the best previous step for each vertex. Using this, we can print out the entire path
    val previousVertices = HashMap<Vertex,Vertex>()
    //All vertices are unvisited at first, so we pass the vertices array as an argument
    val unvisited: ArrayList<Vertex> = ArrayList(vertices)

    //We set the distance of the source from itself to 0, and distances of all the others to Int.MAX_VALUE
    unvisited.forEach {
        if (it == source){
            distances[it]=0
        }
        else
            distances[it]= Int.MAX_VALUE
    }

    //Main loop for Dijkstra's algorithm
    while (unvisited.isNotEmpty()){
        //We get the vertex with the smallest known distance from the unvisited list, using a utility function "getClosestVertex"
        val currentVertex = getClosestVertex(unvisited,distances)
        //We immediately remove the particular vertex from the visited list
        unvisited.remove(currentVertex)
        //Now we loop over its neighbors
        currentVertex.neighbors.forEach { neighbor ->
            //Since we only want to check unvisited neighbors, we need this if statement first
            if(unvisited.contains(neighbor)){
                //We calculate the new distance, which is just the distance of the current vertex + 1 for the neighbor
                val newDistance = 1 + distances[currentVertex]!!
                //The !! is an operator, assertNotNull. It has to be there because of the way Kotlin's hashmaps work
                //Now we check if the distance we calculated is smaller than the already known distance of the neighbor we are examining
                if (distances[neighbor]!! > newDistance){
                    //If it is, we update the distance
                    distances[neighbor] = newDistance
                    //We also associate the previous vertex of the neighbor to the current vertex (for printing the path later)
                    previousVertices[neighbor] = currentVertex
                }
                //If the distance is larger, just skip it
            }
        }
    }
    //Now that the algorithm is done, we print out our results.
    println("The shortest path between ${source.name} and ${destination.name} is: ")
    /*
    We need to wrap the path printing in a try-catch block because (apparently) british cities are not connected to the
    mainland, which can cause a NullPointerException. When this happens, the program says the cities are not connected
     */
    try {
        //We go backwards, from the destination to start, we print the previous vertex from the hashmap we created for this purpose
        var currentVertex = destination
        print("${currentVertex.name} <- ")
        while (currentVertex != source){
            print("${previousVertices[currentVertex]?.name} <- ")
            currentVertex = previousVertices[currentVertex]!!
        }
        //This erases the extra arrow that gets printed
        println("\b\b\b\b")
        //And finally we get the length shown as well
        println("The length of the path is ${distances[destination]}\n")
    }
    catch (e: Exception){
        println("Cities are not connected")
    }
}

/*
This is the utility function we use in the shortest path method
It just finds the next vertex with the lowest known distance and returns it
 */
fun getClosestVertex(list: ArrayList<Vertex>, distances: HashMap<Vertex,Int>): Vertex{
    var lowest = list[0]
    list.forEach {
        if (distances[it]!! < distances[lowest]!!){
            lowest = it
        }
    }
    return lowest
}

fun main() {
    //We will read the two files in the main method, since we don't want to repeat that for every pair of cities
    //First we open the cityNames file using the BufferedReader class
    try {
        val cityNames = File("C:\\Users\\armin\\Desktop\\Discrete Math II\\Project\\data\\cityName.csv")

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
        val fromTo = File("C:\\Users\\armin\\Desktop\\Discrete Math II\\Project\\data\\FromTo.csv")

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

    println("Welcome to the Shortest Path Finder. These are the available cities: ")
    vertices.forEach {
        //We will print out all available cities along with their numeric code, for the user's convenience
        println("${it.code}. ${it.name}")
    }

    println("To quit the program, enter \"Quit\" as the starting point")
    while (true){
        println("**********************")
        //INPUT OF STARTING POINT
        val scanner = Scanner(System.`in`)
        println("Input starting point name: ")
        val sourceName = scanner.nextLine()

        //Here, the program allows any variation of the word "Quit"
        //If it only allowed "Quit", it would throw an exception for "quit"
        if (sourceName.equals("Quit", ignoreCase = true)){
            println("Thank you for using our services! Exiting..")
            exitProcess(0)
        }

        //Now that we collected the user's input, we use Kotlin's built-in lambda to find the appropriate vertex in the list
        val source = vertices.find {
            it.name == sourceName
        } ?: throw IllegalArgumentException("Invalid starting point provided")

        /*
        ?: is the elvis operator, which checks if a value is null. In this case, if the source is null,
        it means the user typed an invalid name, so the program throws an exception
         */

        //Now we do the same for the destination
        println("Input destination point name: ")
        val destinationName = scanner.nextLine()

        val destination = vertices.find {
            it.name == destinationName
        } ?: throw IllegalArgumentException("Invalid destination point provided")

        //and finally call the shortest path method
        findShortestPath(source, destination)
    }
}