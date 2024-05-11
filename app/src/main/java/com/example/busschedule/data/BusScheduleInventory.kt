package com.example.busschedule.data

class BusScheduleInventory(private val dao: BusScheduleDao) : Inventory {
    override fun getAllSchedule() = dao.getAll()

    override fun getSchedulebyId(id: Int) = dao.getItemById(id)

    fun getSchedulebyStopName(stopName: String) = dao.getItemByStopName(stopName)
}