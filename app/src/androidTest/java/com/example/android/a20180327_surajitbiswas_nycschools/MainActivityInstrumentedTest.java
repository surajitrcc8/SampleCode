package com.example.android.a20180327_surajitbiswas_nycschools;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by surajitbiswas on 3/27/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity>mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    public IdlingResource mIdlingResource;
    @Before
    public void registerIdlingResource(){
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }
    @Test
    public void shouldShowCorrectSchoolname(){
        onView(withId(R.id.b_loadSchoolList)).perform(click());
        onView(withRecyclerView(R.id.rv_schoolName).atPosition(2))
                .check(matches(hasDescendant(withText("EAST SIDE COMMUNITY SCHOOL"))));
    }
    @Test
    public void shouldShowCorrectDetails(){
        onView(withId(R.id.b_loadSchoolList)).perform(click());
        onView(withRecyclerView(R.id.rv_schoolName).atPosition(2)).perform(click());
        onView(withId(R.id.tv_numSatTestTakerValue)).check(matches(withText("70")));
        onView(withId(R.id.tv_mathAvgScoreValue)).check(matches(withText("402")));
        onView(withId(R.id.tv_readingAvgScoreValue)).check(matches(withText("377")));
        onView(withId(R.id.tv_writingAvgScoreValue)).check(matches(withText("370")));
    }

    @After
    public void unRegisterIdlingResource(){
        Espresso.unregisterIdlingResources(mIdlingResource);
    }

    // Convenience helper
    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

}
