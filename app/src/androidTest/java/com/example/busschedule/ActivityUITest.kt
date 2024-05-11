package com.example.busschedule

import android.transition.Scene
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityUITest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun HomeScreen_display_test() {
        val scheduleRow1 = composeTestRule.onNodeWithTag("bus_schedule_detail_row_1")
        scheduleRow1.assertTextContains("Main Street")
        scheduleRow1.assertTextContains("Main Street")

        val scheduleRow2 = composeTestRule.onNodeWithTag("bus_schedule_detail_row_1")
        scheduleRow2.assertTextContains("Park Street")
        scheduleRow2.assertTextContains("Park Street")
    }
}