package com.acme.a3csci3130;
/**
 * Created by Jaspering21 on 2018-03-15.
 */
import android.support.test.espresso.ViewInteraction;
import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    public void check0(){
        onView(withId(R.id.name)).perform(typeText("John"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).check(matches(withText("John")));
    }
    public void check1(){
        onView(withId(R.id.num)).perform(typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.num)).check(matches(withText("123456789")));
    }
    public void check2(){
        onView(withId(R.id.address)).perform(typeText("Country Road"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.address)).check(matches(withText("Country Road")));
    }
    public void check3(){
        onView(withId(R.id.pb)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.pb)).check(matches(withText("Fisher")));
    }
    public void check4(){
        onView(withId(R.id.province)).perform(typeText("AB"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.province)).check(matches(withText("AB")));
    }
}