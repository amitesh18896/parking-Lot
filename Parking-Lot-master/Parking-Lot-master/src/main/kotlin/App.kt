import exception.ConsoleMessage
import exception.ParkingException
import processor.BaseProcessor
import processor.RequestProcessor
import utils.ConsoleUtility
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
object App {

    val requestProcessor: BaseProcessor = RequestProcessor()

    @JvmStatic
    fun main(args: Array<String>) {
        //app related info
        ConsoleUtility.printAboutProject()

        //list of available commands
        ConsoleUtility.showAvailableCommands()

        //show command example
        ConsoleUtility.showCommandInstructions()

        when(args.size) {
            0 -> {// Interective session
                startInterectiveSession()
            }
            1 -> {
                startFileInputSession(args[0])
            }
            else -> {
                ConsoleUtility.showError(ConsoleMessage.ERROR_WRONG_FILE_NAME.message)
            }
        }


    }

    private fun startFileInputSession(filePath: String) {
        try {
            val inputFile = File(filePath)
            inputFile.readText().split("\n").forEachIndexed { index, command ->
                if (requestProcessor.validate(command)){
                    try {
                        requestProcessor.execute(command)
                    } catch (parkingException: Exception) {
                        ConsoleUtility.showError(parkingException.message)
                    }
                }else {// wrong command
                    ConsoleUtility.showError(String.format(ConsoleMessage.ERROR_FILE_LINE.message, index))
                }
            }
        } catch (e: Exception) {
            throw ParkingException(ConsoleMessage.ERROR_FILE_INVALID.message, e)
        }
    }

    private fun startInterectiveSession() {
        while (true) {
            val bufferReader = BufferedReader(InputStreamReader(System.`in`))
            var input = bufferReader.readLine().trim()

            if (requestProcessor.validate(input)) {
                try {
                    requestProcessor.execute(input)
                }catch (parkingException: Exception) {
                    parkingException.printStackTrace()
                    ConsoleUtility.showError(parkingException.message)
                }
            } else
                ConsoleUtility.showCommandInstructions()

        }
    }
}