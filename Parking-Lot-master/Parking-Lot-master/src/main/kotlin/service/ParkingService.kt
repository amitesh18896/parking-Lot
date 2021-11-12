package service

import exception.ParkingException
import model.Car

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
interface ParkingService: BaseService {
    @Throws(ParkingException::class)
    fun createParkingLot(capacity: Int)

    fun parkVehicle(car: Car)
    fun leave(registrationNumber: String, hour: Int)
    fun status()

}