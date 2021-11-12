/**
 *
 */
package exception

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
class ParkingException : Exception {

    constructor(message: String?) : super(message)
    constructor(throwable: Throwable?) : super(throwable)
    constructor(message: String?, throwable: Throwable?) : super(message, throwable)

}