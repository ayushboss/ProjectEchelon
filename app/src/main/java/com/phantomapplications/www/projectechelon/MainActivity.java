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
        final DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("gradeBaseIO").child("studentData").child("admin-jared-testing");

        root.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                IRE = dataSnapshot.child("--AlastFivePushed").child("last").getValue().toString();
                System.out.println("IRE is: " + IRE);

                DatabaseReference recentData = root.child(IRE);

                for (int i = 0; i <= 11; i++) {
                    DatabaseReference periodX = recentData.child("" + i);
                    periodX.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            periods.add(dataSnapshot.getValue(Period.class));
                            System.out.println("size of vals: " + periods.size());
                            for (Period each : periods) {
                                System.out.print("\n" + each.getclassName() + " ");
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
