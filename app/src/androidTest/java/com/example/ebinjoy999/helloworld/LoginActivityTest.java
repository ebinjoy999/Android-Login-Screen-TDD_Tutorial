package com.example.ebinjoy999.helloworld;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.net.sip.SipErrorCode.TIME_OUT;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by ebinjoy999 on 18/10/17.
 */


@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class) ;

    LoginActivity loginActivity;


    Instrumentation.ActivityMonitor homeActvityMonitor = InstrumentationRegistry.getInstrumentation()
            .addMonitor(HomeActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        loginActivity = loginActivityActivityTestRule.getActivity();
    }


    @Test
    public void editTextErrorCheck(){
        ViewInteraction buttonLogin = onView(withId(R.id.buttonLogin));
        ViewInteraction editTextUsername = onView(withId(R.id.editTextUserName));
        ViewInteraction editTextPassword = onView(withId(R.id.editTextPassword));
        buttonLogin.perform(click());
        editTextUsername.check(matches(ViewMatchers.hasErrorText("Please enter valid user name.")));


        editTextUsername.perform(typeText("ebin"));

        editTextUsername.perform(closeSoftKeyboard());
        buttonLogin.perform(click());
        editTextPassword.check(matches(ViewMatchers.hasErrorText("Please enter valid password.")));

    }

    @Test
    public void correctUserCheck(){
        ViewInteraction buttonLogin = onView(withId(R.id.buttonLogin));
        ViewInteraction editTextUsername = onView(withId(R.id.editTextUserName));
        ViewInteraction editTextPassword = onView(withId(R.id.editTextPassword));

        editTextUsername.perform(typeText("ebin"));
        editTextUsername.perform(closeSoftKeyboard());

        editTextPassword.perform(typeText("12345"));
        editTextPassword.perform(closeSoftKeyboard());
        buttonLogin.perform(click());

        HomeActivity homeActivity = (HomeActivity) InstrumentationRegistry.getInstrumentation().waitForMonitorWithTimeout(homeActvityMonitor,500);
        assertNotNull(homeActivity);
    }



    @After
    public void tearDown() throws Exception {
    }

}