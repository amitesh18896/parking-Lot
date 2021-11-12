package model.strategy

import java.util.*

/**
 * Created by Pallaw Pathak on 08/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
class NearestFirstParkingStrategy : BaseParkingStrategy {

    private val freeSlots: TreeSet<Int> = TreeSet()

    override fun addSlot(i: Int) {
        freeSlots.add(i)
    }

    override fun getSlot(): Int {
        return freeSlots.first()
    }

    override fun removeSlot(slot: Int) {
        freeSlots.remove(slot)
    }
}