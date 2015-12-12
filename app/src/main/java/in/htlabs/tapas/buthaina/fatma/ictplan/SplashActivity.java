package in.htlabs.tapas.buthaina.fatma.ictplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tap on 06/12/2015.
 */
public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    Button sp_bt_start;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sp_bt_start=(Button)findViewById(R.id.sp_bt_start);
        sp_bt_start.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.sp_bt_start:

                i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
