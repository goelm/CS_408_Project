package com.mango.cs_408_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.common.escape.Escaper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Elvin Uthuppan on 2/26/2017.
 */

public class CourseDisplay extends AppCompatActivity {
    private float rating = 0;
    private float counter = 0;
    private static CustomAdapter adapter;

    public static boolean has_user_input = true;
    String user_input;

    Button course_addReview;

    Button view_reviews;

    private final ArrayList<CourseReview> reviews = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference courseInfo = database.getReference("message/reviews/course");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info);

        user_input = getIntent().getStringExtra("user_input");

        display_course_review(user_input.toUpperCase());
       // display_course_review("HIST 371");
    }


    public void display_course_review(String course_name) {

        course_addReview = (Button) findViewById(R.id.course_info_addReview);

        TextView courseName = (TextView) findViewById(R.id.textCourseName); //Set the Name of the Course here
        courseName.setText(course_name);

        final RatingBar stars = (RatingBar) findViewById(R.id.course_rating); //Finds the stars to update

        final DatabaseReference ref = courseInfo.child(course_name);

        course_addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CourseDisplay.this, AddCourseReview.class);
                i.putExtra("user_input", user_input);
                CourseDisplay.this.startActivity(i);
            }
        });

        view_reviews = (Button) findViewById(R.id.view_course_reviews);
        view_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CourseDisplay.this, CourseReviewsDisplay.class);
                i.putExtra("user_input", user_input);
                CourseDisplay.this.startActivity(i);
            }
        });


        ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child: children) {
                            CourseReview course = child.getValue(CourseReview.class); // <-- do . at end here to specify which child
                            reviews.add(course);
                            counter++;
                            rating += course.rating;//for stars
                        }

                        //Set statistics here
                        stars.setRating(rating/reviews.size());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

    }
}