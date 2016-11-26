package com.example.priscila.mybutchershop.espresso.com.example.priscila.mybutchershop.espresso.mainscreen;

import android.content.Context;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.priscila.mybutchershop.MainActivity;
import com.example.priscila.mybutchershop.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String MESSAGE = "This is a test";
    private static final String PACKAGE_NAME = "com.example.priscila.mybutchershop";

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = getTargetContext();

        assertEquals("com.example.priscila.mybutchershop", appContext.getPackageName());
    }

    /* Instantiate an IntentsTestRule object. */
    @Rule
    public IntentsTestRule<MainActivity> mIntentsRule =
            new IntentsTestRule<>(MainActivity.class);


    @Test
    public void clickListItem() {
        String title = "Banana";
        //click on a list item
        onData(hasToString(containsString(title)))
                .inAdapterView(withId(R.id.listView)).atPosition(0)
                .perform(click());

        // check if it opens ProductDetailActivity
        intended(allOf(
                hasComponent(hasShortClassName(".ProductDetailActivity")),
                toPackage(PACKAGE_NAME)
                ));

        //check if ProductDetailActivity has the right info displayed on title
        onView(withId(R.id.textView3)).check(matches(withText(title)));



    }
}