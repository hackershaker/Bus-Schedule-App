package com.example.busschedule

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@RunWith(AndroidJUnit4::class)
class ActivityUITest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun homeScreen_display_test() {
        val scheduleRow1 = composeTestRule.onNodeWithTag("bus_schedule_detail_row_1", true)
        scheduleRow1.onChildren()[0].assertTextContains("Main Street")
        scheduleRow1.onChildren()[1].assertTextContains("12:00 오전")

        val scheduleRow2 = composeTestRule.onNodeWithTag("bus_schedule_detail_row_2", true)
        scheduleRow2.onChildren()[0].assertTextContains("Park Street")
        scheduleRow2.onChildren()[1].assertTextContains("12:12 오전")
    }

    fun Int.milliToTime(): String {
        return SimpleDateFormat("h:mm a", Locale.getDefault())
            .format(Date(this.toLong() * 1000))
    }

}