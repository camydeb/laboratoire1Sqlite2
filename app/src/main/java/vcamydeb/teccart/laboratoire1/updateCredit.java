package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class updateCredit extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_credit);


    }

    public void UpdateCredit(View view) {

        nom =(EditText)findViewById(R.id.editTextNom);

        prenom=(EditText)findViewById(R.id.editTextPrenom);

        credit=(EditText)findViewById(R.id.editTextCrédit);



        try{
            myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
            myDbAdapter.Open();
            myDbAdapter.UpdateCredit(nom.getText().toString(),prenom.getText().toString(),credit.getText().toString());
        }
        catch(Exception e){

        }
    }
}
