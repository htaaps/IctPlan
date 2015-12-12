package in.htlabs.tapas.buthaina.fatma.ictplan;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tap on 12/12/2015.
 */
public class LoginAdminActivity extends Activity implements View.OnClickListener {

    private EditText ad_et_user, ad_et_pass;
    private Button ad_bt_login;
    private String username,password;

    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";
    private static final String LOGIN_URL = "http://www.htlabs.in/student/ttable/login.php";

    // JSON IDS:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_C_ID    = "c_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_admin_activity);

        //setup input fields
        ad_et_user = (EditText)findViewById(R.id.ad_et_user);
        ad_et_pass = (EditText)findViewById(R.id.ad_et_pass);

        //setup buttons
        ad_bt_login = (Button)findViewById(R.id.ad_bt_login);

        //register listeners
        ad_bt_login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.ad_bt_login:
                username = ad_et_user.getText().toString().toLowerCase();
                password = ad_et_pass.getText().toString();
                new AttemptLogin().execute();
                break;
        }
    }
    class AttemptLogin extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         * */
        boolean failure = false;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(LoginAdminActivity.this);
            pDialog.setMessage("Attempting login...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
            int success;
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));

                // getting product details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);

                // json success tag
                success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    Log.d("Login Successful!", json.toString());
                    Intent i = new Intent(LoginAdminActivity.this,AllotmentActivity.class);
                    startActivity(i);
                    return json.getString(TAG_MESSAGE);
                }else{
                    Log.d("Login Failure!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
                Toast.makeText(LoginAdminActivity.this, file_url, Toast.LENGTH_LONG).show();
            }
        }
    }
}
