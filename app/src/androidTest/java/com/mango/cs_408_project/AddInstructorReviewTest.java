package com.mango.cs_408_project;

import android.support.test.espresso.core.deps.guava.cache.Weigher;
import android.support.test.internal.runner.TestSize;
import android.support.test.rule.ActivityTestRule;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

/**
 * Created by KennyZheng on 2/11/17.
 */

public class AddInstructorReviewTest {

    int counter;
    ArrayList<ProfReview> reviews = new ArrayList<>();

    @Rule
    public ActivityTestRule<AddInstructorReview> addInstructorReviewClass =
            new ActivityTestRule<AddInstructorReview>(AddInstructorReview.class);


    // Instructor Button

    @Test
    public void instructorButton() throws Exception {
        onView(withId(R.id.instructor)).perform(click());
        onView(withId(R.id.teachingassistant)).check(matches(isDisplayed()));
        Thread.sleep(1000);
    }

    @Test
    public void instructorButton2() throws Exception {
        onView(withId(R.id.teachingassistant)).perform(click());
        onView(withId(R.id.instructor)).check(matches(isDisplayed()));
        Thread.sleep(1000);
    }


    // Accessbility Button

    @Test
    public void accessButton() throws Exception {
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.hardAccess)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void accessButton2() throws Exception {
        onView(withId(R.id.hardAccess)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }


    // Extra Credit Button

    @Test
    public void extraCreditButton() throws Exception {
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.noButton1)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void extraCreditButton2() throws Exception {
        onView(withId(R.id.noButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }


    // Toughness Buttons

    @Test
    public void toughnessButton() throws Exception {
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).check(matches(isChecked()));
        onView(withId(R.id.diffButton2)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton3)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton4)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton5)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButton2() throws Exception {
        onView(withId(R.id.diffButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton2)).check(matches(isChecked()));
        onView(withId(R.id.diffButton1)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton3)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton4)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton5)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButton3() throws Exception {
        onView(withId(R.id.diffButton3)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton3)).check(matches(isChecked()));
        onView(withId(R.id.diffButton2)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton1)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton4)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton5)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButton4() throws Exception {
        onView(withId(R.id.diffButton4)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton4)).check(matches(isChecked()));
        onView(withId(R.id.diffButton2)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton3)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton1)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton5)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void toughnessButton5() throws Exception {
        onView(withId(R.id.diffButton5)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton5)).check(matches(isChecked()));
        onView(withId(R.id.diffButton2)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton3)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton4)).check(matches(not(isChecked())));
        onView(withId(R.id.diffButton1)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }


    // Misc Button

    @Test
    public void miscButton() throws Exception {
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.noButton2)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    @Test
    public void miscButton2() throws Exception {
        onView(withId(R.id.noButton2)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).check(matches(not(isChecked())));
        Thread.sleep(1000);
    }

    // --------------------------------------------------------------------------

    @Test
    public void noFirstName() throws Exception {
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void noSecondName() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void noName() throws Exception {
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void invalidFirstName() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("!"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Invalid first name")));
        Thread.sleep(1000);
    }

    @Test
    public void invalidFirstName2() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest1"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Invalid first name")));
        Thread.sleep(1000);
    }

    @Test
    public void invalidLastName() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("!"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Invalid last name")));
        Thread.sleep(1000);
    }

    @Test
    public void invalidLastName1() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest1"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Invalid last name")));
        Thread.sleep(1000);
    }

    @Test
    public void invalidCourseName() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.add_info_courseName)).perform(typeText("Sighs ..."));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please follow the format \"CS 408\" for course name")));
        Thread.sleep(1000);
    }

    @Test
    public void invalidCourseName2() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.add_info_courseName)).perform(typeText("CS 18000"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please follow the format \"CS 408\" for course name")));
        Thread.sleep(1000);
    }

    @Test
    public void noInstructorAndTA() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void ezAccess() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void noYes1AndNo1() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void noYes2AndNo2() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void difficulties() throws Exception {
        onView(withId(R.id.first_name)).perform(typeText("FirstNameTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastNameTest"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());
        onView(withId(R.id.add_info_submitText)).check(matches(withText("Please fill in every field")));
        Thread.sleep(1000);
    }

    @Test
    public void submitDatabaseProf() throws Exception{

        onView(withId(R.id.first_name)).perform(typeText("FirstTest"));
        onView(withId(R.id.last_name)).perform(typeText("LastTest"));
        onView(withId(R.id.instructor)).perform(scrollTo(), click());
        onView(withId(R.id.ezAccess)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton1)).perform(scrollTo(), click());
        onView(withId(R.id.diffButton1)).perform(scrollTo(), click());
        onView(withId(R.id.yesButton2)).perform(scrollTo(), click());
        onView(withId(R.id.profComment)).perform(scrollTo(), typeText("ProfCommentTest"));
        onView(withId(R.id.submitBut)).perform(scrollTo(), click());

        //Read database to see if course info is in firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference courseInfo = database.getReference("message/reviews/instructor");
        final DatabaseReference ref = courseInfo.child("FIRSTTEST LASTTEST");
        counter = 0;
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    ProfReview prof = child.getValue(ProfReview.class); // <-- do . at end here to specify which child
                    reviews.add(prof);
                    counter++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Thread.sleep(1000);

        ProfReview review_to_check = reviews.get(0);
        assertEquals(review_to_check.profName, "FIRSTTEST LASTTEST");
        assertEquals(review_to_check.prof, true);
        assertEquals(review_to_check.helpSession, true);
        assertEquals(review_to_check.extraCredit, true);
        assertEquals(review_to_check.toughness, 1);
        assertEquals(review_to_check.electronics, true);
        assertEquals(review_to_check.profComment, "ProfCommentTest");


        Thread.sleep(1000);
    }

}