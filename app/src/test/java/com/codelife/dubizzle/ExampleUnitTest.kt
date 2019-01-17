package com.codelife.dubizzle

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.codelife.dubizzle.ui.home.HomeActivity
import com.codelife.dubizzle.ui.home.SplashActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @get:Rule
    val rule = IntentsTestRule(SplashActivity::class.java)

    @Test
    fun splashActivityTest() {
        ActivityScenario.launch(SplashActivity::class.java)
        //assertThat(getIntents().first()).hasComponentClass(HomeActivity::class.java)
        intended(IntentMatchers.hasComponent(HomeActivity::class.java.canonicalName))
    }
}
