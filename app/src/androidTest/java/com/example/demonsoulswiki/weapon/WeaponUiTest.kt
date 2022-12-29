package com.example.demonsoulswiki.weapon

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.demonsoulswiki.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeaponUiTest {

    @Rule
    @JvmField
    var composeTestRule: ComposeContentTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun listGoesIntoDetailsAndHasDaggerName() {
        composeTestRule.onNodeWithText("Dagger").performClick()
        composeTestRule.onNodeWithTag("Weapon Name").assertTextEquals("Dagger")
    }
}