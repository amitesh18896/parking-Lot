package command

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
enum class Command(var inputCommand: String) {
    CREATE_PARKING("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    STATUS("status"),
    HELP("help"),
    EXIT("exit"),
}