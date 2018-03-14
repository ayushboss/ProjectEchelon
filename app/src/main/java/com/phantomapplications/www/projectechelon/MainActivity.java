package com.phantomapplications.www.projectechelon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    String IRE;
    GradeBlock gradeBlock;
    ArrayList<Period> periods = new ArrayList<Period>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrieveData();

    }

    private void retrieveData() {
        System.out.println("retrieving");
        final DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("gradeBaseIO").child("studentData").child("admin-ankush-testing");

        root.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                IRE = "-L496GYAm0z1JePqqI6J";
                System.out.println("IRE is: " + IRE);

                final DatabaseReference recentData = root.child(IRE);

                for (int i = 0; i <= 7; i++) {
                    final DatabaseReference periodX = recentData.child("" + i);
                    periodX.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            periods.add(dataSnapshot.getValue(Period.class));
                            DatabaseReference assignments = periodX.child("detailed");

                            final ArrayList<Assignment> assments = new ArrayList<>();

                            assignments.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) { //iterate over each of the cycles
                                        System.out.println("checkpoint 1");
                                        ArrayList<Category> categoryList = new ArrayList<Category>();
                                        for (DataSnapshot categories : ds.getChildren()) { //iterate over each of the categories in that class
                                            System.out.println("checkpoint 2");
                                            ArrayList<Assignment> as = new ArrayList<Assignment>();
                                            for (DataSnapshot assignment : categories.child("rows").child("0").getChildren()) {
                                                System.out.println("checkpoint 3");
                                                Assignment assment = new Assignment();
                                                assment.setName(assignment.child("0").child("value").toString());
                                                assment.setDateAssigned(assignment.child("1").child("value").toString());
                                                assment.setDateDue(assignment.child("2").child("value").toString());
                                                assment.setAssignmentGrade(assignment.child("3").child("value").toString());
                                                assment.setAssignmentNote(assignment.child("4").child("value").toString());
                                                assment.setAverage(assignment.child("6").child("value").toString());
                                                as.add(assment);
                                            }
                                            categoryList.add(new Category(categories.child("title").toString(), as));
                                        }
                                        for (Category c : categoryList) {
                                            System.out.println("Categories: " + c.getName());
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                setUpDataStructures();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setUpDataStructures() {

    }
}
