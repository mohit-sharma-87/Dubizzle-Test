package com.codelife.dubizzle

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents.getIntents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.truth.content.IntentSubject.assertThat
import com.codelife.dubizzle.ui.home.HomeActivity
import com.codelife.dubizzle.ui.home.SplashActivity
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @Test
    fun splashActivityTest() {

        val scenario = ActivityScenario.launch(SplashActivity::class.java)
        assertThat(getIntents().first()).hasComponentClass(HomeActivity::class.java)


    }
}
