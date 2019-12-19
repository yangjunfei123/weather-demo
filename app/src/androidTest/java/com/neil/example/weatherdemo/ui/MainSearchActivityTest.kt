package com.neil.example.weatherdemo.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import android.support.test.rule.ActivityTestRule
import com.neil.example.weatherdemo.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainSearchActivityTest {

    @Rule @JvmField var rule = ActivityTestRule<SearchActivity>(SearchActivity::class.java)

    @Test
    fun test_search() {
        onView(withId(R.id.et_search_input)).perform(typeText("zhouzhi"), closeSoftKeyboard())

        Thread.sleep(5000)

        onView(withId(R.id.tv_name)).perform(click())

        Thread.sleep(10000)
    }

    @Test
    fun test_search_with_no_result() {
        onView(withId(R.id.et_search_input)).perform(typeText("fawfehfioehi"), closeSoftKeyboard())

        Thread.sleep(5000)

        onView(withText("Unable to find any matching weather location to the query submitted!")).perform(click())

    }

}