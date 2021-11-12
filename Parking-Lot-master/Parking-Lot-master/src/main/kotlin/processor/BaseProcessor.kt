package processor

import command.CommandManager


/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
interface BaseProcessor {
    /**
     * validate the input command and its required parameters
     */
    fun validate(input: String): Boolean {
        var valid = true
        try {
            val inputs = input.split(" ")
            val params: Int? = CommandManager.getCommandParamMap().get(inputs[0])//  if params is null that means command is not present in list
            when (inputs.size) {
                1 -> if (params != 0) // e.g status -> inputs = 1
                    valid = false
                2 -> if (params != 1) // create_parking_lot 6 -> inputs = 2
                    valid = false
                3 -> if (params != 2) // leave KA-01-P-333 4 -> inputs = 3
                    valid = false
                else -> valid = false
            }
        } catch (e: Exception) {
            valid = false
        }
        return valid
    }
    fun execute(command: String)
}