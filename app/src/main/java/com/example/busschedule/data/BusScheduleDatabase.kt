package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val dbName = "bus_schedule_database"

@Database(entities = [BusSchedule::class], version = 1)
abstract class BusScheduleDatabase : RoomDatabase() {
    abstract fun busScheduleDao(): BusScheduleDao

    companion object {
        private var instance: BusScheduleDatabase? = null

        fun createDb(context: Context): BusScheduleDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, BusScheduleDatabase::class.java, dbName)
                    .createFromAsset("database/bus_schedule.db").build()
            }
        }
    }
}