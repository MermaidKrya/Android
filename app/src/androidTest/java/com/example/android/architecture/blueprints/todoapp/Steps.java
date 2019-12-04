package com.example.android.architecture.blueprints.todoapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class Steps {
    public static void clickButton(Integer buttonName){
        onView(withId(buttonName))
                .perform(click());
    }

    public static void addNewTask(Integer buttonId, String TextofTask) {
        onView(withId(buttonId))
                .perform(typeText(TextofTask), closeSoftKeyboard());
    }

    public static void CheckTest(Integer button) {
        onView(withId(button)).check((matches(isDisplayed())));
    }

    public static void CompleteTest(String Text) {
        onView(withText(Text))
                .check(matches(isDisplayed()));
    }

}
