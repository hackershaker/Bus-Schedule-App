package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.BusScheduleDatabase
import com.example.busschedule.data.BusScheduleInventory

class AppContainer(application: Application) {
    val context = application.applicationContext

    val database = BusScheduleDatabase.createDb(context)
    val dao = database.busScheduleDao()
    val inventory = BusScheduleInventory(dao)
}