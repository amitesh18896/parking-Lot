package utils

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */

object ConsoleUtility {

    fun printAboutProject() {
        println(
            """
    |###################################################################################################################
    |#########################################      PARKING LOT     ####################################################
    |###################################################################################################################                        
    |""".trimMargin()
        )
    }

    fun showAvailableCommands() {
        println(
            """
    |######### Please Enter one of the below commands. Replace variables (written in capitals) with your values ########
    |
    |A) Create parking lot of size n                        ---> create_parking_lot {CAPACITY}
    |B) Park a car                                          ---> park {CAR_NUMBER}
    |C) Remove(Unpark) car from                             ---> leave {CAR_NUMBER} {HOURS}
    |D) Print status of parking slot                        ---> status
    |E) List of available commands                          ---> help
    |F) Exit app.                                           ---> exit
    |""".trimMargin()
        )
    }

    fun showCommandInstructions() {
        println(
            """
        |######### Please enter a valid command. type 'Exit' to exit the program or 'Help' for available list of commands ########
        |""".trimMargin()
        )
    }

    fun showError(message: String?) {
        println(message)
    }
}
