package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void HeadingTest() {
        onView(withText("Cardiac Recorder")).check(matches(isDisplayed()));
    }


    /**
     * This test method adds a new entry in the databse and then checks whether it is displayed or not.
     * Then it clicks on the entry and edits the data and checks again to see if it is displayed or not.
     * Then it clicks on the data again and deletes it and checks if it is deleted or not.
     */
    @Test
    public void AddEditDeleteTest()
    {
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.systolic_pressure)).perform(ViewActions.typeText("120"));
        Espresso.pressBack();
        onView(withId(R.id.diastolic_pressure)).perform(ViewActions.typeText("70"));
        Espresso.pressBack();
        onView(withId(R.id.heart_rate)).perform(ViewActions.typeText("50"));
        Espresso.pressBack();
        onView(withId(R.id.comment)).perform(ViewActions.typeText("Dr. Amir tested."));
        Espresso.pressBack();
        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.systolicCard)).check(matches(withText("120")));
        onView(withId(R.id.diastolicCard)).check(matches(withText("70")));
        onView(withId(R.id.heartCard)).check(matches(withText("50")));
        onView(withId(R.id.CommentMyRow)).check(matches(withText("Dr. Amir tested.")));

        onView(withId(R.id.lin_lay)).perform(click());
        onView(withId(R.id.DiastolicPressureEdit)).perform(ViewActions.clearText());
        onView(withId(R.id.DiastolicPressureEdit)).perform(ViewActions.typeText("60"));
        Espresso.pressBack();
        onView(withId(R.id.SaveEdit)).perform(click());
        onView(withId(R.id.diastolicCard)).check(matches(withText("60")));

        onView(withId(R.id.lin_lay)).perform(click());
        onView(withId(R.id.DeleteEdit)).perform(click());
        onView(withText("Yes")).perform(click());
        onView(withText("120")).check(doesNotExist());
    }

    /**
     * This test method checks whether the 'Delete All' button works or not.
     * It enters multiple entries and then presses the 'Delete All' button and then checks whether all data is deleted or not.
     */
    @Test
    public void DeleteAllTest()
    {
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.systolic_pressure)).perform(ViewActions.typeText("120"));
        Espresso.pressBack();
        onView(withId(R.id.diastolic_pressure)).perform(ViewActions.typeText("70"));
        Espresso.pressBack();
        onView(withId(R.id.heart_rate)).perform(ViewActions.typeText("50"));
        Espresso.pressBack();
        onView(withId(R.id.comment)).perform(ViewActions.typeText("Dr. Amir tested."));
        Espresso.pressBack();
        onView(withId(R.id.add)).perform(click());

        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.systolic_pressure)).perform(ViewActions.typeText("110"));
        Espresso.pressBack();
        onView(withId(R.id.diastolic_pressure)).perform(ViewActions.typeText("60"));
        Espresso.pressBack();
        onView(withId(R.id.heart_rate)).perform(ViewActions.typeText("45"));
        Espresso.pressBack();
        onView(withId(R.id.comment)).perform(ViewActions.typeText("Dr. Hamza tested."));
        Espresso.pressBack();
        onView(withId(R.id.add)).perform(click());


        onView(withId(R.id.delete_all)).perform(click());
        onView(withText("Yes")).perform(click());
        onView(withText("120")).check(doesNotExist());
        onView(withText("70")).check(doesNotExist());
        onView(withText("50")).check(doesNotExist());
        onView(withText("Dr. Amir tested.")).check(doesNotExist());
        onView(withText("110")).check(doesNotExist());
        onView(withText("60")).check(doesNotExist());
        onView(withText("45")).check(doesNotExist());
        onView(withText("Dr. Hamza tested.")).check(doesNotExist());

    }


}