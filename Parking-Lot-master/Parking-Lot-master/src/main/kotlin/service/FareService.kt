package service

/**
 * Created by Pallaw Pathak on 09/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
interface FareService: BaseService {
    fun calculateFare(parkingDurationInHour: Int): Int
}