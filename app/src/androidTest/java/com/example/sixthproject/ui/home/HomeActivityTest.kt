package com.example.sixthproject.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.sixthproject.R
import com.example.sixthproject.utils.EspressoIdlingResource
import com.example.sixthproject.utils.NotDataDummy
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{

    private val notDummyMovies = NotDataDummy.generateMovies()
    private val notDummyTvShows = NotDataDummy.generateTvShows()



    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadTvShows(){

        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_tv_shows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(notDummyTvShows.size))
    }

    @Test
    fun loadDetailTvShows(){

        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.tv_show_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_title))
            .check(ViewAssertions.matches(withText(notDummyTvShows[0].title)))
        onView(withId(R.id.tv_show_detail_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_first_episode))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_first_episode))
            .check(ViewAssertions.matches(withText("First Episode ${notDummyTvShows[0].firstEpisode}")))
        onView(withId(R.id.tv_show_last_episode))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_last_episode))
            .check(ViewAssertions.matches(withText("Last Episode ${notDummyTvShows[0].lastEpisode}")))
        onView(withId(R.id.tv_show_total_episode))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_total_episode))
            .check(ViewAssertions.matches(withText("Total Episode ${notDummyTvShows[0].totalEpisode}")))
        onView(withId(R.id.tv_show_total_season))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_total_season))
            .check(ViewAssertions.matches(withText("Total Season ${notDummyTvShows[0].totalSeason}")))
        onView(withId(R.id.tv_show_synopsis))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_synopsis))
            .check(ViewAssertions.matches(withText(notDummyTvShows[0].synopsis)))
        onView(withId(R.id.tv_show_score))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_show_score))
            .check(ViewAssertions.matches(withText("Score ${notDummyTvShows[0].score}")))
    }

    @Test
    fun loadMovies(){

        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(notDummyMovies.size))
    }

    @Test
    fun loadDetailMovies(){

        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.movie_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movie_title))
            .check(ViewAssertions.matches(withText(notDummyMovies[0].title)))
        onView(withId(R.id.movie_detail_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movie_release_date))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movie_release_date))
            .check(ViewAssertions.matches(withText("Release Date ${notDummyMovies[0].releaseDate}")))
        onView(withId(R.id.movie_synopsis))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movie_synopsis))
            .check(ViewAssertions.matches(withText(notDummyMovies[0].synopsis)))
        onView(withId(R.id.movie_score))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.movie_score))
            .check(ViewAssertions.matches(withText("Score ${notDummyMovies[0].score}")))

    }
}