package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.os.Bundle;
import java.util.ArrayList;

public class infosClient extends AppCompatActivity {
    private ArrayList<String> listeClients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_client);


        ListView listView = (ListView)findViewById(R.id.listPatients);
        ArrayList<client> clientArrayList = new ArrayList<client>();

        Bundle ex = getIntent().getExtras();
        listeClients = ex.getStringArrayList("clientInfos");




    }
}
