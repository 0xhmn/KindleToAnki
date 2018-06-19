package kindle.anki.data

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class DatabaseHandler {

    /**
     * Prints line of text file by a given file path.
     */
    public fun readFile(path: String) {
        val content = File(path).bufferedReader().readLines()
        content.forEach { line -> println(line) }
    }

}