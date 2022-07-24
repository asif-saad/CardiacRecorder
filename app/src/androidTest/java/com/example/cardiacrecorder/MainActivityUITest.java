package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
    public void AddButtonTest()
    {
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.systolic_pressure)).perform(ViewActions.typeText("120"));
        Espresso.pressBack();
        onView(withId(R.id.diastolic_pressure)).perform(ViewActions.typeText("80"));
        Espresso.pressBack();
        onView(withId(R.id.heart_rate)).perform(ViewActions.typeText("50"));
        Espresso.pressBack();
        onView(withId(R.id.comment)).perform(ViewActions.typeText("Dr. Amir tested."));
        Espresso.pressBack();
        onView(withId(R.id.add)).perform(click());
    }
}