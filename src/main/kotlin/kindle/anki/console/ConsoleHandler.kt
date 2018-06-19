package kindle.anki.console

import kindle.anki.model.Constant
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException

class ConsoleHandler {

    val IS_DB_REQUIRED = true
    val IS_OUTPUT_REQUIRED = false

    private fun generateOptions(isDbRequired: Boolean, isOutputRequired: Boolean) : Options {
        val options =  Options()
        val inputOption: Option = Option(
                Constant.DB_SHORT_ARG,
                Constant.DB_LONG_ARG,
                true,
                Constant.DB_DESCRIPTION)
        inputOption.isRequired = true

        val outputOption: Option = Option(
                Constant.OUTPUT_SHORT_ARG,
                Constant.OUTPUT_LONG_ARG,
                true,
                Constant.OUTPUT_DESCRIPTION)
        outputOption.isRequired = false

        val helpOption = Option(
                Constant.HELP_SHORT_ARG,
                Constant.HELP_LONG_ARG,
                true,
                Constant.HELP_DESCRIPTION)
        helpOption.isRequired = false

        options.addOption(inputOption)
        options.addOption(outputOption)
        options.addOption(helpOption)

        return options
    }

    public fun createCommandLine(args: Array<String>) : CommandLine {
        val options = generateOptions(IS_DB_REQUIRED, IS_OUTPUT_REQUIRED)

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

        return cmd
    }

}