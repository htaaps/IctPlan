package in.htlabs.tapas.buthaina.fatma.ictplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tap on 06/12/2015.
 */
public class AllotmentActivity extends AppCompatActivity implements View.OnClickListener {
    Button al_bt_course,al_bt_room;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allotment);
        al_bt_course=(Button)findViewById(R.id.al_bt_course);
        al_bt_room=(Button)findViewById(R.id.al_bt_room);

        al_bt_course.setOnClickListener(this);
        al_bt_room.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    switch(v.getId()){
            case R.id.al_bt_course:
                i = new Intent(this,CourseSelectionActivity.class);
                startActivity(i);

                break;
            case R.id.al_bt_room:
                i = new Intent(this,RoomSelectionActivity.class);
                startActivity(i);

                break;
        }
    }
}
