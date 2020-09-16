package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class infos_compte extends AppCompatActivity {

    private TextView lblnom,lblprenom,lbladresse,lblusername,lblpassword,lblcredit,lblsolde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_infos_compte);


        setContentView(R.layout.activity_infos_compte);
        lblnom = (TextView)findViewById(R.id.textViewNom);
        lblprenom=(TextView)findViewById(R.id.textViewPrenom);
        lbladresse=(TextView)findViewById(R.id.textViewAdresse);
        lblusername=(TextView)findViewById(R.id.textViewUsername);
        lblpassword=(TextView)findViewById(R.id.textViewPassword);
        lblcredit=(TextView)findViewById(R.id.textViewCredit);
        lblsolde=(TextView)findViewById(R.id.textViewSolde);

        Bundle ex = getIntent().getExtras();

        lblnom.setText(ex.getString("nom"));
        lblprenom.setText(ex.getString("prenom"));
        lbladresse.setText(ex.getString("adresse"));
        lblusername.setText(ex.getString("username"));
        lblpassword.setText(ex.getString("password"));
        lblcredit.setText(ex.getString("credit"));
        lblsolde.setText(ex.getString("solde"));
    }
}
