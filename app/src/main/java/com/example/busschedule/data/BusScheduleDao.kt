package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    @Insert
    suspend fun insert(busSchedule: BusSchedule)

    @Update
    suspend fun update(busSchedule: BusSchedule)

    @Delete
    suspend fun delete(busSchedule: BusSchedule)

    @Query("SELECT * FROM $tableName")
    fun getAll(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM $tableName WHERE id = :id")
    fun getItemById(id: Int): Flow<List<BusSchedule>>

    @Query("SELECT * FROM $tableName WHERE stop_name = :stopName")
    fun getItemByStopName(stopName: String): Flow<List<BusSchedule>>
}