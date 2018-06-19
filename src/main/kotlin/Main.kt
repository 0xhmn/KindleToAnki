import kindle.anki.console.ConsoleHandler

fun main(args: Array<String>) {

    val consoleHandler:ConsoleHandler = ConsoleHandler()
    val cmd = consoleHandler.createCommandLine(args)

    var inputArg: String = ""
    var outArg: String = ""

    if (cmd.hasOption("d")) {
        inputArg = cmd.getOptionValue("db")
    }
    if (cmd.hasOption("o")) {
        outArg = cmd.getOptionValue("output")
    }
    if (cmd.hasOption("h")) {
        println("help is selected")
    }

    println(inputArg)
    print(outArg)
}