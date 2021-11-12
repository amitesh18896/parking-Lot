package exception

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
enum class ConsoleMessage(var message: String) {
    ERROR_CREATE_PARKING("Sorry Parking Already Created, It CAN NOT be recreated."),
    SUCCESS_CREATE_PARKING("Created parking lot with %d slots"),
    ERROR_INVALID_VALUE("%s value is incorrect in command %s"),
    SUCCESS_PARK("Allocated slot number: %d"),
    ERROR_PARK("Sorry, parking lot is full"),
    ERROR_LEAVE("Registration number %s not found"),
    SUCCESS_LEAVE("Registration number %S with Slot Number %d is free with Charge %d"),
    ERROR_FILE_INVALID("file not found"),
    ERROR_FILE_LINE("Wrong command at line %d"),
    ERROR_WRONG_FILE_NAME("file path is wrong"),
}