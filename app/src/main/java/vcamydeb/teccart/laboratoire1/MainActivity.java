package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import java.util.ArrayList;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText adresse;
    private EditText username;
    private EditText password;
    private EditText solde;
    private EditText credit;

    private String test;
    private EditText nomRef;
    private EditText prenomRef;
    private String nomS;
    private String prenomS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void createClient(View view) {setContentView(R.layout.newclients); }
///////////////////////////evenement onclick bouton creation du nouveau client   //////////////////////
    public void newClient(View view) {
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
            myDbAdapter.InsertClient(client.getNom(),client.getPrenom(),client.getAdresse(), client.getUsername(),client.getPassword(),client.getSolde(),client.getCredit());
            
            Toast.makeText(this, "Client créé avec succès", Toast.LENGTH_SHORT).show();

            nom.setText("");
            prenom.setText("");
            adresse.setText("");
            username.setText("");
            password.setText("");
            solde.setText("");
            credit.setText("");

        }
        catch(Exception e){

            Toast.makeText(this, "Echec de la creation", Toast.LENGTH_SHORT).show();

        }



        setContentView(R.layout.activity_main);

    }


    public void deleteClient(View view) {
        setContentView(R.layout.deleteclient);
    }

    public void delClient(View view) {
/////////////////////////////////evevement onclick delete client ///////////////////////////////////////////
        nomRef =(EditText)findViewById(R.id.editTextNomDelete);
        prenomRef=(EditText)findViewById(R.id.editTextPrenomDelete);

        nomS = nomRef.getText().toString();
        prenomS = prenomRef.getText().toString();


        //client client = new client (nom.getText().toString(),prenom.getText().toString());

        try
        {
            myDbAdapter myDbAdapterDel = new myDbAdapter(getApplicationContext());
            myDbAdapterDel.Open();
            myDbAdapterDel.DeleteClient(nomS,prenomS);

            setContentView(R.layout.activity_main);

            Toast.makeText(this, "Suppression reussie", Toast.LENGTH_SHORT).show();
        }

        catch(Exception e){
            Toast.makeText(this, "Echec de la suppression", Toast.LENGTH_SHORT).show();
        }

    }

    public void updateClient(View view) {
        setContentView(R.layout.updateclient);
    }

////////////////////////evenement onclick update du client //////////////////////////////////////
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

            Toast.makeText(this, "Mise a jour reussie", Toast.LENGTH_SHORT).show();
            
            nom.setText("");
            prenom.setText("");
            adresse.setText("");
            username.setText("");
            password.setText("");
            solde.setText("");
            credit.setText("");

            setContentView(R.layout.activity_main);
        }
        catch(Exception e){
            Toast.makeText(this, "Echec de la mise a jour", Toast.LENGTH_SHORT).show();
        }
    }


    public void updateCredit(View view) {
        setContentView(R.layout.updatecredit);
    }
    public void UpdateCredit(View view) {

        nom =(EditText)findViewById(R.id.editTextNom);

        prenom=(EditText)findViewById(R.id.editTextPrenom);

        credit=(EditText)findViewById(R.id.editTextCrédit);

        try{
            myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
            myDbAdapter.Open();
            myDbAdapter.UpdateCredit(nom.getText().toString(),prenom.getText().toString(),credit.getText().toString());

            nom.setText("");
            prenom.setText("");
            credit.setText("");

            setContentView(R.layout.activity_main);

            Toast.makeText(this, "Mise a jour du credit reussie", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(this, "Echec de la mise a jour", Toast.LENGTH_SHORT).show();

        }
    }

    public void updateSolde(View view) {
        setContentView(R.layout.updatesolde);
    }
    public void UpdateSolde(View view) {

        nom =(EditText)findViewById(R.id.editTextNom);

        prenom=(EditText)findViewById(R.id.editTextPrenom);

        solde=(EditText)findViewById(R.id.editTextsolde);

        try{
            myDbAdapter myDbAdapter = new myDbAdapter(getApplicationContext());
            myDbAdapter.Open();
            myDbAdapter.UpdateSolde(nom.getText().toString(),prenom.getText().toString(),solde.getText().toString());

            nom.setText("");
            prenom.setText("");
            solde.setText("");

            setContentView(R.layout.activity_main);

            Toast.makeText(this, "Mise a jour du solde reussie", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(this, "Echec de la mise a jour", Toast.LENGTH_SHORT).show();

        }
    }



    public void listecomptes(View view) {

        Intent i = new Intent(MainActivity.this, infosClient.class);
        startActivity(i);

//

    }

    public void listeDelinquants(View view) {
        Intent i = new Intent (MainActivity.this, delinquants.class);
        startActivity(i);
    }



}
