package vcamydeb.teccart.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
    }

    public void updateClient(View view) {
    }

    public void selectClient(View view) {
    }

    public void listeClient(View view) {
    }

    public void updateCredit(View view) {
    }

    public void updateSolde(View view) {
    }
}
