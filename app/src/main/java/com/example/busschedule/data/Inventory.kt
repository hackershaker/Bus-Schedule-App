package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface Inventory {
    fun getAllSchedule(): Flow<List<BusSchedule>>

    fun getSchedulebyId(id: Int): Flow<List<BusSchedule>>
}