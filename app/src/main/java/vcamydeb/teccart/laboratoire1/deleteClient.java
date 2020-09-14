package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class deleteClient extends AppCompatActivity {

    private EditText nomRef;
    private EditText prenomRef;
    private String nom;
    private String prenom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_client);
    }

    public void delClient(View view) {

        nomRef =(EditText)findViewById(R.id.editTextNomDelete);
        prenomRef=(EditText)findViewById(R.id.editTextPrenomDelete);

        nom = nomRef.getText().toString();
        prenom = prenomRef.getText().toString();


        //client client = new client (nom.getText().toString(),prenom.getText().toString());

        try{
            myDbAdapter myDbAdapterDel = new myDbAdapter(getApplicationContext());
            myDbAdapterDel.Open();
            myDbAdapterDel.DeleteClient(nom,prenom);
        }
        catch(Exception e){

        }
    }
}
