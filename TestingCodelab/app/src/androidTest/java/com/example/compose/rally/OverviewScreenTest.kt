package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.compose.rally.ui.overview.OverviewBody
import org.junit.Rule
import org.junit.Test

class OverviewScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun overviewScreen_alertsDisplayed() {
        composeTestRule.setContent {
            OverviewBody()
        }

        composeTestRule
            .onNodeWithText("Alerts")
            .assertIsDisplayed()

//        androidx.compose.ui.test.junit4.android.ComposeNotIdleException: Idling resource timed out: possibly due to compose being busy.
//        IdlingResourceRegistry has the following idling resources registered:
//        - [busy] ComposeIdlingResource is busy due to pending recompositions.
    }


}