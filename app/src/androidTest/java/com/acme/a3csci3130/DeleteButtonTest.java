package com.acme.a3csci3130;

/**
 * Created by Jasper on 2018/3/15.
 */

import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import com.firebase.ui.database.FirebaseListAdapter;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.anything;

public class DeleteButtonTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void deleteBusiness() throws Exception{
        Thread.sleep(5000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}