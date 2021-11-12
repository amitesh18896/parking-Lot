package service.manager

import exception.ConsoleMessage
import exception.ParkingException
import model.Car
import model.Vehicle
import model.strategy.NearestFirstParkingStrategy
import service.ParkingService

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
object ParkingServiceManager : ParkingService {

    private var capacity: Int = 0
    private val parkingStrategy: NearestFirstParkingStrategy = NearestFirstParkingStrategy()
    private val vehicleMap: HashMap<String, Pair<Int, Vehicle>> = HashMap()


    @Throws(ParkingException::class)
    override fun createParkingLot(capacity: Int) {
        if (this.capacity == 0) {
            this.capacity = capacity
            //initialize free slots
            for (slotNo in 1..capacity) {
                parkingStrategy.addSlot(slotNo)
            }
            println(String.format(ConsoleMessage.SUCCESS_CREATE_PARKING.message, capacity))
        } else
            throw ParkingException(ConsoleMessage.ERROR_CREATE_PARKING.message)
    }

    @Throws(ParkingException::class)
    override fun parkVehicle(car: Car) {
        try {
            val slotNumber = parkingStrategy.getSlot()
            vehicleMap.put(car.regNumber, Pair(slotNumber, car))
            parkingStrategy.removeSlot(slotNumber)
            println(String.format(ConsoleMessage.SUCCESS_PARK.message, slotNumber))
        } catch (e: Exception) {
            throw ParkingException(ConsoleMessage.ERROR_PARK.message)
        }
    }

    @Throws(ParkingException::class)
    override fun leave(registrationNumber: String, hour: Int) {
        val vehicleInfo = vehicleMap.get(registrationNumber)
        if (null == vehicleInfo) {
            throw ParkingException(String.format(ConsoleMessage.ERROR_LEAVE.message, registrationNumber))
        } else {
            val totalFare = FareManager.calculateFare(hour)
            val slot = vehicleInfo.first

            parkingStrategy.addSlot(slot)
            vehicleMap.remove(registrationNumber)

            println(String.format(ConsoleMessage.SUCCESS_LEAVE.message, registrationNumber, slot, totalFare))
        }
    }

    override fun status() {
        println("Slot No.\tRegistration No.")
        vehicleMap.keys.forEach { registrationNo ->
            val vehicleInfo = vehicleMap.get(registrationNo)
            println("${vehicleInfo?.first}\t\t\t${registrationNo}")
        }
    }

}