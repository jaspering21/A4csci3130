package com.acme.a3csci3130;
/**
 * Created by Jaspering21 on 2018-03-15.
 */

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import com.firebase.ui.database.FirebaseListAdapter;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class EspressoTest {
    @Rule

    public ActivityTestRule<MainActivity> ActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void check0(){
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("John"),closeSoftKeyboard());
        onView(withId(R.id.name)).check(matches(withText("John")));
        onView(withId(R.id.num)).perform(typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.num)).check(matches(withText("123456789")));
        onView(withId(R.id.address)).perform(typeText("Country Road"),closeSoftKeyboard());
        onView(withId(R.id.address)).check(matches(withText("Country Road")));
        onView(withId(R.id.pb)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.pb)).check(matches(withText("Fisher")));
        onView(withId(R.id.province)).perform(typeText("AB"),closeSoftKeyboard());
        onView(withId(R.id.province)).check(matches(withText("AB")));
        onView(withId(R.id.submitButton)).perform(click());

    }
}