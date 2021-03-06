package com.mango.cs_408_project;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.guava.cache.Weigher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddCourseReviewTest {
    int counter;
    ArrayList<CourseReview> reviews = new ArrayList<>();

    @Rule
    public ActivityTestRule<AddCourseReview> addCourseReviewTest =
            new ActivityTestRule<AddCourseReview>(AddCourseReview.class);


    // Accessbility Test

    @Test
    public void buttonDisplayed() throws Exception {
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_ezAccess)).check(matches(isDisplayed()));
        Thread.sleep(1000);
    }

    @Test
    public void buttonDisplayed2() throws Exception {
        onView(withId(R.id.add_course_hardAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_hardAccess)).check(matches(isDisplayed()));
        Thread.sleep(1000);
    }


    @Test
    public void buttonChecked() throws Exception {
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_ezAccess)).check(matches(isChecked()));
        Thread.sleep(1000);
    }

    @Test
    public void buttonChecked2() throws Exception {
        onView(withId(R.id.add_course_hardAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_hardAccess)).check(matches(isChecked()));
        Thread.sleep(1000);
    }

    @Test
    public void buttonChecked3() throws Exception {
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_hardAccess)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void buttonChecked4() throws Exception {
        onView(withId(R.id.add_course_hardAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_ezAccess)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void buttonStartsUnselected() throws Exception {
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_hardAccess)).check(matches(not(isSelected())));
        Thread.sleep(1000);
    }

    @Test
    public void buttonStartsUnselected2() throws Exception {
        onView(withId(R.id.add_course_hardAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_ezAccess)).check(matches(not(isSelected())));
        Thread.sleep(1000);
    }

    @Test
    public void buttonSwitches() throws Exception {
        onView(withId(R.id.add_course_hardAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_hardAccess)).check(matches(not(isSelected())));
        Thread.sleep(1000);
    }

    @Test
    public void buttonSwitches2() throws Exception {
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_hardAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_ezAccess)).check(matches(not(isSelected())));
        Thread.sleep(1000);
    }


    // Toughness Button

    @Test
    public void toughnessButtonSwitche() throws Exception {
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).check(matches(isChecked()));
        onView(withId(R.id.add_course_toughness_mild)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_typical)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_tough)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_unreasonable)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButtonSwitche2() throws Exception {
        onView(withId(R.id.add_course_toughness_mild)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_mild)).check(matches(isChecked()));
        onView(withId(R.id.add_course_toughness_easy)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_typical)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_tough)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_unreasonable)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButtonSwitche3() throws Exception {
        onView(withId(R.id.add_course_toughness_typical)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_typical)).check(matches(isChecked()));
        onView(withId(R.id.add_course_toughness_mild)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_easy)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_tough)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_unreasonable)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButtonSwitche4() throws Exception {
        onView(withId(R.id.add_course_toughness_tough)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_tough)).check(matches(isChecked()));
        onView(withId(R.id.add_course_toughness_mild)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_typical)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_easy)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_unreasonable)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButtonSwitche5() throws Exception {
        onView(withId(R.id.add_course_toughness_unreasonable)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_unreasonable)).check(matches(isChecked()));
        onView(withId(R.id.add_course_toughness_mild)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_typical)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_tough)).check(matches(not(isChecked())));
        onView(withId(R.id.add_course_toughness_easy)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }


    // Grade Buttons

    @Test
    public void gradeButtons() throws Exception {
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).check(matches(isChecked()));
        onView(withId(R.id.add_course_grade_no)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void gradeButtons2() throws Exception {
        onView(withId(R.id.add_course_grade_no)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_no)).check(matches(isChecked()));
        onView(withId(R.id.add_course_grade_yes)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }


    // Misc Buttons

    @Test
    public void miscButton() throws Exception {
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).check(matches(isChecked()));
        onView(withId(R.id.add_course_misc_no)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void miscButton2() throws Exception {
        onView(withId(R.id.add_course_misc_no)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_no)).check(matches(isChecked()));
        onView(withId(R.id.add_course_misc_yes)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }


    // Book Buttons

    @Test
    public void bookButtons() throws Exception {
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).check(matches(isChecked()));
        onView(withId(R.id.add_course_book_no)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void bookButtons2() throws Exception {
        onView(withId(R.id.add_course_book_no)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_no)).check(matches(isChecked()));
        onView(withId(R.id.add_course_book_yes)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    // --------------------------------------------------------------------------

    @Test
    public void invalidCourseName() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("!"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("InstructorTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Invalid inputs")));
        Thread.sleep(1000);
    }

    @Test
    public void noCourseName() throws Exception {
        onView(withId(R.id.add_course_instructor)).perform(typeText("InstructorTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void invalidInstructorName() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CS 180"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("!"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please follow the format \"Buster Dunsmore\" for instructor name")));
        Thread.sleep(1000);
    }

    @Test
    public void noInstructorName() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CourseNameTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void no_ezAccess() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CourseNameTest"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("InstructorTest"));
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void no_grade_yes() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CourseNameTest"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("InstructorTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void no_misc_yes() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CourseNameTest"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("InstructorTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void no_book_yes() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CourseNameTest"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("InstructorTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void noDifficulty() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CourseNameTest"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("InstructorTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void courseNameNoSpace() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("invalidCourseName"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("Buster Dunsmore"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please follow the format \"CS 408\"")));
    }

    @Test
    public void courseNameCourseTooLong() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("TOOLONG 180"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("Buster Dunsmore"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please follow the format \"CS 408\" for course name")));
    }

    @Test
    public void courseNameNumberTooShort() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CS 18"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("Buster Dunsmore"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please follow the format \"CS 408\" for course name")));
    }

    @Test
    public void courseNameNumberTooLong() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CS 18000"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("Buster Dunsmore"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please follow the format \"CS 408\" for course name")));
    }

    @Test
    public void invalidFirstName() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CS 18000"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("test01 Dunsmore"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please follow the format \"Buster Dunsmore\" for instructor name")));
    }

    @Test
    public void invalidLastName() throws Exception {
        onView(withId(R.id.add_course_courseName)).perform(typeText("CS 18000"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("Buster Dunsmore1"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_submitText)).check(matches(withText("Please follow the format \"Buster Dunsmore\" for instructor name")));
    }

    @Test
    public void submitDatabaseCourse() throws Exception{
        onView(withId(R.id.add_course_courseName)).perform(typeText("TEST 123"));
        onView(withId(R.id.add_course_instructor)).perform(typeText("Test Name"));
        onView(withId(R.id.add_course_description)).perform(typeText("CourseDescriptionTest"));
        onView(withId(R.id.add_course_ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_book_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_grade_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_misc_yes)).perform(scrollTo(), click());
        onView(withId(R.id.add_course_toughness_easy)).perform(scrollTo(), click());
        onView(withId(R.id.courseComment)).perform(scrollTo(), typeText("CourseCommentTest"));
        onView(withId(R.id.course_submitBut)).perform(scrollTo(), click());

        //Read database to see if course info is in firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference courseInfo = database.getReference("message/reviews/course");
        final DatabaseReference ref = courseInfo.child("TEST 123");
        counter = 0;
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    CourseReview course = child.getValue(CourseReview.class); // <-- do . at end here to specify which child
                    reviews.add(course);
                    counter++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Thread.sleep(1000);
        CourseReview review_to_check = reviews.get(0);
        assertEquals(review_to_check.courseName, "TEST 123");
        assertEquals(review_to_check.instructorName, "Test Name");
        assertEquals(review_to_check.courseDescr, "CourseDescriptionTest");
        assertEquals(review_to_check.helpSession, true);
        assertEquals(review_to_check.extraCredit, true);
        assertEquals(review_to_check.toughness, 1);
        assertEquals(review_to_check.electronics, true);
        assertEquals(review_to_check.textBook, true);
        assertEquals(review_to_check.courseComment, "CourseCommentTest");


        Thread.sleep(1000);
    }

}
