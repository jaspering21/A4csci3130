package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by Jasper on 2018/3/15.
 */

public class UpdateButtonTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void deleteBusiness() throws Exception{
        onData(anything()).inAdapterView(withId(R.id.updateButton)).atPosition(0).perform(click());
        onView(withId(R.id.updateButton)).perform(click());
    }
}