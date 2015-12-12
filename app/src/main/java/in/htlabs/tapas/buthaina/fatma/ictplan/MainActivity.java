package in.htlabs.tapas.buthaina.fatma.ictplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button ma_bt_admin,ma_bt_student,ma_bt_teacher;
    Intent i;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ma_bt_admin=(Button)findViewById(R.id.ma_bt_admin);
        ma_bt_teacher=(Button)findViewById(R.id.ma_bt_teacher);
        ma_bt_student=(Button)findViewById(R.id.ma_bt_student);

        ma_bt_admin.setOnClickListener(this);
        ma_bt_teacher.setOnClickListener(this);
        ma_bt_student.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.ma_bt_admin:

                i = new Intent(this,LoginAdminActivity.class);
                startActivity(i);
                break;

            case R.id.ma_bt_teacher:

                i = new Intent(this,LoginTeacherActivity.class);
                startActivity(i);
                break;

            case R.id.ma_bt_student:

                i = new Intent(this,LoginStudentActivity.class);
                startActivity(i);
                break;
        }
    }
}