package play

import kindle.anki.model.Constant.Companion.DB_DESCRIPTION
import kindle.anki.model.Constant.Companion.DB_LONG_ARG
import kindle.anki.model.Constant.Companion.DB_SHORT_ARG
import kindle.anki.model.Constant.Companion.HELP_DESCRIPTION
import kindle.anki.model.Constant.Companion.HELP_LONG_ARG
import kindle.anki.model.Constant.Companion.HELP_SHORT_ARG
import kindle.anki.model.Constant.Companion.OUTPUT_DESCRIPTION
import kindle.anki.model.Constant.Companion.OUTPUT_LONG_ARG
import kindle.anki.model.Constant.Companion.OUTPUT_SHORT_ARG
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException


fun main(args: Array<String>) {

    val options =  Options()
    val inputOption: Option = Option(DB_SHORT_ARG, DB_LONG_ARG, true, DB_DESCRIPTION)
    inputOption.isRequired = true
    val outputOption: Option = Option(OUTPUT_SHORT_ARG, OUTPUT_LONG_ARG, true, OUTPUT_DESCRIPTION)
    outputOption.isRequired = false
    val helpOption = Option(HELP_SHORT_ARG, HELP_LONG_ARG, true, HELP_DESCRIPTION)
    helpOption.isRequired = false

    options.addOption(inputOption)
    options.addOption(outputOption)
    options.addOption(helpOption)

    val parser = DefaultParser()
    val formatter = HelpFormatter()

    var cmd: CommandLine? = null
    try {
        cmd = parser.parse(options, args)
    } catch (ex: ParseException) {
        println(ex.message)
        formatter.printHelp("Kindle to Anki", options)
        System.exit(1)
    }

    if (cmd == null) {
        throw KotlinNullPointerException()
    }

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