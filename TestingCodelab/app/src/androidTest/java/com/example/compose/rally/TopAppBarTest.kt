package com.example.compose.rally

import androidx.compose.material.Text
import androidx.compose.ui.semantics.SemanticsProperties.ContentDescription
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

//    @Test
//    fun myTest() {
//        composeTestRule.setContent {
//            Text("You can set any compose content!")
//        }
//    }
    
    @Test
    fun rallyTopAppBarTest() {
        composeTestRule.setContent {
            val allScreens = RallyScreen.values().toList()
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {  },
                currentScreen = RallyScreen.Accounts
            )
        }
        Thread.sleep(5000)
    }

    @Test
    fun rallyTopAppBarTest_currentTabSelected() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {  },
                currentScreen = RallyScreen.Accounts
            )
        }

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()

        Thread.sleep(5000)
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens =RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {  },
                currentScreen = RallyScreen.Accounts
            )
        }

//        composeTestRule
//            .onNodeWithText(RallyScreen.Accounts.name.uppercase())

//        composeTestRule.onRoot().printToLog("currentLabelExists")

//        |-Node #6 at (l=288.0, t=160.0, r=721.0, b=256.0)px
//        | ContentDescription = '[Accounts]'

//        composeTestRule
//            .onNodeWithContentDescription(RallyScreen.Accounts.name)
//            .assertExists()

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

//        |-Node #6 at (l=288.0, t=160.0, r=721.0, b=256.0)px
//        | ContentDescription = '[Accounts]'
//        | Role = 'Tab'
//        | Focused = 'false'
//        | Selected = 'true'
//        | Actions = [OnClick, RequestFocus]
//        | MergeDescendants = 'true'
//        | ClearAndSetSemantics = 'true'
//        |  |-Node #9 at (l=432.0, t=160.0, r=721.0, b=226.0)px
//        |    Text = '[ACCOUNTS]'
//        |    Actions = [SetTextSubstitution, ShowTextSubstitution, ClearTextSubstitution, GetTextLayoutResult]

        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.uppercase()) and
                hasParent(
                    hasContentDescription(RallyScreen.Accounts.name)
                ),
                useUnmergedTree = true
            )
            .assertExists()

        Thread.sleep(5000)
    }

}