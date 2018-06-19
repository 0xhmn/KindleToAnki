import kindle.anki.console.ConsoleHandler
import kindle.anki.data.DatabaseHandler

val consoleHandler: ConsoleHandler = ConsoleHandler()
val databaseHandler: DatabaseHandler = DatabaseHandler()

fun main(args: Array<String>) {

    val cmd = consoleHandler.createCommandLine(args)

    var pathToDb: String = ""
    var outArg: String = ""

    if (cmd.hasOption("d")) {
        pathToDb = cmd.getOptionValue("db")

        databaseHandler.readFile(pathToDb)
    }
    if (cmd.hasOption("o")) {
        outArg = cmd.getOptionValue("output")
    }
    if (cmd.hasOption("h")) {
        println("help is selected")
    }

    println(pathToDb)
    print(outArg)
}