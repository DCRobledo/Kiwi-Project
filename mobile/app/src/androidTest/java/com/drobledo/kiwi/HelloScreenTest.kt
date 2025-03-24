package com.drobledo.kiwi

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import com.drobledo.kiwi.ui.HelloScreen
import org.junit.Rule
import org.junit.Test

class HelloScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun helloScreen_displaysText() {
        composeTestRule.setContent {
            HelloScreen()
        }

        composeTestRule.onNodeWithText("Hello from Mobile!").assertIsDisplayed()
    }
}
