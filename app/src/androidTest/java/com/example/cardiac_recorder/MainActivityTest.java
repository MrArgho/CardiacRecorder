package com.example.cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.os.SystemClock;

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
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void test2addmeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.add_msr)).perform(click());
        Espresso.onView(withId(R.id.edit_date)).perform(ViewActions.typeText("22/07/2022"));
        Espresso.onView(withId(R.id.edit_time)).perform(ViewActions.typeText("9:51"));
        Espresso.onView(withId(R.id.edit_sys_pr)).perform(ViewActions.typeText("135"));
        Espresso.onView(withId(R.id.edit_dais_pr)).perform(ViewActions.typeText("80"));
        Espresso.onView(withId(R.id.edit_heat_rate)).perform(ViewActions.typeText("80"));
        Espresso.pressBack(); //Back button
        Espresso. onView(withId(R.id.edit_comment)).perform(ViewActions.typeText("Health is good"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.button_save)).perform(click());
        Espresso.onView(withId(R.id.measurement)).check(matches(isDisplayed()));

        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.add_msr)).perform(click());
        Espresso.onView(withId(R.id.edit_date)).perform(ViewActions.typeText("11/01/2022"));
        Espresso.onView(withId(R.id.edit_time)).perform(ViewActions.typeText("15:51"));
        Espresso.onView(withId(R.id.edit_sys_pr)).perform(ViewActions.typeText("135"));
        Espresso.onView(withId(R.id.edit_dais_pr)).perform(ViewActions.typeText("80"));
        Espresso.onView(withId(R.id.edit_heat_rate)).perform(ViewActions.typeText("70"));
        Espresso.pressBack(); //Back button
        Espresso. onView(withId(R.id.edit_comment)).perform(ViewActions.typeText("HEllo"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.button_save)).perform(click());
        Espresso.onView(withId(R.id.measurement)).check(matches(isDisplayed()));
    }

    @Test
    public void test3updatemeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.measurement)).perform(click());
//        SystemClock.sleep(5000);
//        Espresso.onView(withId(R.id.button_edit)).perform(click());

        Espresso.onView(withId(R.id.edit_date)).perform(clearText()).perform(ViewActions.typeText("31/11/2022"));
        Espresso.onView(withId(R.id.edit_time)).perform(clearText()).perform(ViewActions.typeText("11:52"));
        Espresso.onView(withId(R.id.edit_sys_pr)).perform(clearText()).perform(ViewActions.typeText("140"));
        Espresso.onView(withId(R.id.edit_dias_pr)).perform(clearText()).perform(ViewActions.typeText("100"));
        Espresso.onView(withId(R.id.edit_heart_rate)).perform(clearText()).perform(ViewActions.typeText("80"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.edit_comment)).perform(clearText()).perform(ViewActions.typeText("You May be sick"));
        Espresso.pressBack(); //Back button
        SystemClock.sleep(2000);
        onView(withId(R.id.button_edit)).perform(click());
        SystemClock.sleep(5000);
//        onView(withId(R.id.button_delete)).perform(click());
    }
    @Test
    public void test4deletemeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.measurement)).perform(click());
        SystemClock.sleep(3000);
        Espresso.onView(withId(R.id.button_delete)).perform(click());
        SystemClock.sleep(5000);

    }
}