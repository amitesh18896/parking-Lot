package command

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
object CommandManager {

    /**
     * Map which stores command and their corresponding required input values
     */
    private val commandsParameterMap: HashMap<String, Int> = HashMap()

    init {
        commandsParameterMap.put(Command.CREATE_PARKING.inputCommand, 1)
        commandsParameterMap.put(Command.PARK.inputCommand, 1)
        commandsParameterMap.put(Command.LEAVE.inputCommand, 2)
        commandsParameterMap.put(Command.STATUS.inputCommand, 0)
        commandsParameterMap.put(Command.HELP.inputCommand, 0)
        commandsParameterMap.put(Command.EXIT.inputCommand, 0)
    }

    fun getCommandParamMap(): HashMap<String, Int> = commandsParameterMap
}