package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateClient extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText adresse;
    private EditText username;
    private EditText password;
    private EditText solde;
    private EditText credit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_update_client);
    }

    public void UpdateClient(View view) {

        nom =(EditText)findViewById(R.id.editTextNom);

        prenom=(EditText)findViewById(R.id.editTextPrenom);
        adresse=(EditText)findViewById(R.id.editTextAdresse);
        username=(EditText)findViewById(R.id.editTextUsername);
        password=(EditText)findViewById(R.id.editTextPassword);
        solde=(EditText)findViewById(R.id.editTextSolde);
        credit=(EditText)findViewById(R.id.editTextCrédit);

        client client = new client (nom.getText().toString(),prenom.getText().toString(),adresse.getText().toString(),username.getText().toString(),
                password.getText().toString(),Double.parseDouble(solde.getText().toString()),Double.parseDouble(credit.getText().toString()));

        try{
            myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
            myDbAdapter.Open();
            myDbAdapter.UpdateClient(client.getNom(),client.getPrenom(),client.getAdresse(), client.getUsername(),client.getPassword(),client.getSolde(),client.getCredit());
        }
        catch(Exception e){

        }
    }
}
