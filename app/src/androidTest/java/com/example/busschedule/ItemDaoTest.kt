package com.example.busschedule

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.BusScheduleDao
import com.example.busschedule.data.BusScheduleDatabase
import com.example.busschedule.data.dbName
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.FileOutputStream


@RunWith(AndroidJUnit4::class)
class ItemDaoTest {
    lateinit var busScheduleDatabase: BusScheduleDatabase
    lateinit var busScheduleDao: BusScheduleDao
    val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    val busSchedule1 = BusSchedule(1, "Main Street", 1617202800)
    val inputStream = context.assets.open("database/bus_schedule.db")

    val newBusSchedule1 = BusSchedule(32, "Jake Street", 1617202800)

    @Before
    fun setUp() {
        // if test database already exist, delete it
        context.deleteDatabase("test_database")
        // create in-memory database
        busScheduleDatabase =
            Room.databaseBuilder(context, BusScheduleDatabase::class.java, "test_database")
                .createFromAsset("database/bus_schedule.db").build()
        // get DAO
        busScheduleDao = busScheduleDatabase.busScheduleDao()
    }

    @After
    fun cleanUp() {
        busScheduleDatabase.close()
    }

    /*
    bus_schedule.db로 데이터베이스가 초기화 되었는지 테스트
     */
    @Test
    @Throws(Exception::class)
    fun database_initializationFromAsset() = runBlocking {
        val itemList = busScheduleDao.getAll().first()

        Assert.assertEquals(itemList.size, 31)
        Assert.assertEquals(itemList[0], busSchedule1)
    }


}