package vcamydeb.teccart.laboratoire1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class myDbAdapter {

    private Context context;
    private final String DATABASE_NAME = "maDB";
    private MyDbHelper dbHelper;
    private final int DATABASE_VERSION= 1;
    private SQLiteDatabase db;

    public myDbAdapter(Context context){
        this.context = context;
        this.dbHelper = new MyDbHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void Open(){this.db = this.dbHelper.getWritableDatabase();}

    public void InsertClient(String nom, String prenom, String adresse, String username, String password,Double solde, Double credit ){

        this.db.execSQL("INSERT INTO client(nom,prenom,adresse,solde,credit) values (nom, prenom, adresse, solde, credit);");

    }

}
