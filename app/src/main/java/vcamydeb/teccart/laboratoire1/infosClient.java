package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.os.Bundle;
import android.content.Intent;


import java.io.Serializable;
import java.util.ArrayList;

public class infosClient extends AppCompatActivity {
    private ArrayList<client> liste;
    private String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_client);

        ListView listView = (ListView)findViewById(R.id.listClients);

        myDbAdapter myDBAdapter = new myDbAdapter(getApplicationContext());
        myDBAdapter.Open();
        liste = myDBAdapter.selectClient();

        final clientArrayAdapter adapter = new clientArrayAdapter(this,R.layout.listeclients,liste);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent (infosClient.this, infos_compte.class);

                i.putExtra("nom",liste.get(position).getNom());
                i.putExtra("prenom",liste.get(position).getPrenom());
                i.putExtra("adresse",liste.get(position).getAdresse());
                i.putExtra("username",liste.get(position).getUsername());
                i.putExtra("password",liste.get(position).getPassword());
                i.putExtra("solde",liste.get(position).getSolde().toString());
                i.putExtra("credit",liste.get(position).getCredit().toString());
                startActivity(i);

            }
        });







    }
}
