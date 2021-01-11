package com.kky.example;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.kky.example.mui.BasicActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


/**
 * Author: Zeus
 * Date: 2020/7/6 17:08
 * Description:
 * History:
 */
@RunWith(AndroidJUnit4.class)
public class BasicActivityTest {
    public static String STRING_TO_BE_TYPED = "Hello";

    @Rule
    public ActivityTestRule<BasicActivity> activityScenarioRule =
            new ActivityTestRule<BasicActivity>(BasicActivity.class);

//    @Test
//    public void changeText() {
//        onView(withId(R.id.button)).perform(click());
//    }

    @Test
    public void clickTest() {
        onView(withId(R.id.button))
                .check(matches(withText("Change")))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("hello ,i'm first")))
                .check(matches(isDisplayed()));
    }

}
