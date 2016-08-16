package com.cct.marvelwallapop.presentation.activity;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.cct.marvelwallapop.ElapsedTimeIdlingResource;
import com.cct.marvelwallapop.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by carloscarrasco on 16/8/16.
 */
@RunWith(AndroidJUnit4.class)
public class ComicDetailTest {
    private String CHARACTER_TITLE = "All-New Wolverine (2015) #11";
    private String CHARACTER_DESCRIPTION = "CIVIL WAR II TIE-IN! DESTINY COMES KNOCKING FOR WOLVERINE! LAURA KINNEY has fought all her life to avoid a destiny she did not want. She has fought against instincts that would make her nothing more than a weapon to be used by others, instead becoming a hero — becoming WOLVERINE. But now, destiny intrudes again, this time threatening those dearest to her. And with a SUPER HERO CIVIL WAR tearing her world apart, is there any hope that Wolverine will emerge victorious? Or will she finally succumb to destiny?";
    @Rule
    public ActivityTestRule<ComicList> mActivityRule = new ActivityTestRule(ComicList.class);
    private long waitingTime = 3000;

    @Test
    public void goToComicDetailActivityAndCheckDetailComic() {
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.recycleview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.comic_description), withText(CHARACTER_DESCRIPTION)))
                .check(matches(isDisplayed()));
        onView(allOf(withId(R.id.comic_title), withText(CHARACTER_TITLE)))
                .check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

}