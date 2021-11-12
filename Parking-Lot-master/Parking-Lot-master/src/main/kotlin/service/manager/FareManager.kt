package service.manager

import service.FareService

object FareManager : FareService {

    const val BASE_FARE = 20 // $20
    const val BASE_DURATION = 2 // 2 HOUR
    const val EXTRA_HOURLY_FARE = 10 // $10

    override fun calculateFare(parkingDurationInHour: Int): Int {
        var fare = 0
        if (parkingDurationInHour <= 2) {
            fare = BASE_FARE
        } else {
            fare = BASE_FARE + ((parkingDurationInHour - BASE_DURATION) * EXTRA_HOURLY_FARE)
        }

        return fare
    }
}