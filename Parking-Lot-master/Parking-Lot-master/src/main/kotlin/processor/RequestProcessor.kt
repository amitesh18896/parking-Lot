package processor

import command.Command
import exception.ConsoleMessage
import exception.ParkingException
import model.Car
import service.manager.ParkingServiceManager
import utils.ConsoleUtility
import java.lang.Exception
import kotlin.system.exitProcess

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
class RequestProcessor : BaseProcessor {
    override fun execute(command: String) {
        val inputs = command.split(" ")
        val commandKey = inputs[0]

        when (commandKey) {
            Command.HELP.inputCommand -> {
                ConsoleUtility.showAvailableCommands()
            }
            Command.EXIT.inputCommand -> {
                exitProcess(0)
            }
            Command.CREATE_PARKING.inputCommand -> {
                try {
                    val capacity: Int = inputs[1].toInt()
                    ParkingServiceManager.createParkingLot(capacity)
                } catch (e: NumberFormatException) {
                    throw ParkingException(String.format(ConsoleMessage.ERROR_INVALID_VALUE.message, "{CAPACITY}", command))
                }
            }

            Command.PARK.inputCommand -> {
                try {
                    ParkingServiceManager.parkVehicle(Car(inputs[1]))
                } catch (e: ParkingException) {
                    throw e
                }
            }

            Command.LEAVE.inputCommand -> {
                var registrationNumber: String = ""
                val hour: Int
                try {
                    registrationNumber = inputs[1]
                    hour = inputs[2].toInt()
                    ParkingServiceManager.leave(registrationNumber, hour)
                } catch (e: Exception) {
                    when(e){
                        is NumberFormatException ->{
                            throw ParkingException(String.format(ConsoleMessage.ERROR_INVALID_VALUE.message, "{HOURS}", command))// incorrect input for hour
                        }
                        is ParkingException ->{
                            throw e
                        }
                    }
                }
            }

            Command.STATUS.inputCommand -> {
                ParkingServiceManager.status()
            }
        }
    }
}