package vcamydeb.teccart.laboratoire1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class myDbAdapter {

    private Context c;
    private final String DATABASE_NAME = "maDB";
    private MyDbHelper dbHelper;
    private final int DATABASE_VERSION= 1;
    private SQLiteDatabase db;

    public myDbAdapter(Context context){
        this.c = context;
        this.dbHelper = new MyDbHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void Open(){this.db = this.dbHelper.getWritableDatabase();}




    public void InsertClient(String nom, String prenom, String adresse, String username, String password,Double solde, Double credit ){

        this.db.execSQL("INSERT INTO client(nom,prenom,adresse,solde,credit) values ("+nom+", "+prenom+", "+adresse+", "+solde+", "+credit+");");

    }


    public void DeleteClient(String nom, String prenom) {

        this.db.execSQL("DELETE FROM client WHERE nom ="+ nom+" AND prenom ="+ prenom+";");
    }

    public void UpdateClient(String nom, String prenom, String adresse, String username, String password, Double solde, Double credit) {

        this.db.execSQL("UPDATE client SET  adresse ="+ adresse +", username = "+ username+", password = "+password+", solde ="+ solde+", credit ="+ credit+" WHERE nom ="+ nom+" AND prenom ="+ prenom+"; ");
    }


    public ArrayList<client> selectClient()
    {

        ArrayList<client> listOfClients = new ArrayList<client>();

        Cursor cursor = this.db.rawQuery("select * from client ",null);

        int nomIndex = cursor.getColumnIndex("nom");
        int prenomIndex = cursor.getColumnIndex("prenom");
        int adresseIndex = cursor.getColumnIndex("adresse");
        int usernameIndex = cursor.getColumnIndex("username");
        int passwordIndex = cursor.getColumnIndex("password");
        int creditIndex = cursor.getColumnIndex("credit");
        int soldeIndex = cursor.getColumnIndex("solde");

        if((cursor != null) && cursor.moveToFirst())
        {
            do{
                listOfClients.add(new client(cursor.getString(nomIndex),cursor.getString(prenomIndex),cursor.getString(adresseIndex), cursor.getString(usernameIndex),
                                                cursor.getString(passwordIndex),cursor.getDouble(creditIndex),cursor.getDouble(soldeIndex)));
                }
            while(cursor.moveToNext());
        }
        Intent i = new Intent(c, infosClient.class);
        i.putExtra("clientInfos", listOfClients);
        c.startActivity(i);
        return listOfClients;



    }

    public void effacerClient()
    {
        this.db.execSQL("delete from client;");
    }



    public void UpdateCredit(String nom, String prenom, String credit) {

        this.db.execSQL("UPDATE client SET credit = "+credit+" WHERE nom="+nom+" AND prenom="+prenom+";");
    }
}
