package com.kky.example;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.Lifecycle;
import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.kky.example.mview.BottomSheetActivity;
import com.kky.example.util.ScreenUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleTest {
    @Test
    public void getScreenHeight() {
        // Context of the app under test.
//        Context appContext = ApplicationProvider.getApplicationContext();
        Context appContext = InstrumentationRegistry.getTargetContext();
//        int screenHeight = ScreenUtils.getScreenHeight(appContext);
//        Assert.assertEquals(screenHeight, 100);


        Context context = InstrumentationRegistry.getTargetContext();
        Intent intent = new Intent(context, BottomSheetActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        ActivityScenario<BottomSheetActivity> activityActivityTestRule =
//                new ActivityScenario(intent);
        ActivityScenario<Activity> scenario = ActivityScenario.launch(intent);
        scenario.moveToState(Lifecycle.State.CREATED);
    }

}
