package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createClient(View view) {
        setContentView(R.layout.activity_new_client);
    }

    public void deleteClient(View view) {
        setContentView(R.layout.activity_delete_client);
    }

    public void updateClient(View view) {
        setContentView(R.layout.activity_update_client);
    }

    public void listeClient(View view) {
    }

    public void updateCredit(View view) {
    }

    public void updateSolde(View view) {
    }

    public void infosCompte(View view) {

        try{
            ArrayList<client> ls = new ArrayList<client>();
            myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
            myDbAdapter.Open();
            ls = myDbAdapter.selectClient();
            Log.i("dbTest",String.valueOf(ls.size()));
            myDbAdapter.effacerClient();
            ls = myDbAdapter.selectClient();
            Log.i("dbTest",String.valueOf(ls.size()));
        }
        catch(Exception ex){

            Log.i("dbTest",ex.getMessage());

        }






    }
}
