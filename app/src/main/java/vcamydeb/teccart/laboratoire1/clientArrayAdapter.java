package vcamydeb.teccart.laboratoire1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class clientArrayAdapter extends ArrayAdapter<client> {

    private Context context;
    private ArrayList<client> list;
    private int resource;

    public clientArrayAdapter (Context context, int resource, List<client> objects){
        super(context,resource,objects);
        this.context=context;
        this.resource=resource;
        list = new ArrayList<client>();
        list = (ArrayList<client>)objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        client temp = this.list.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.resource,parent,false);

        TextView nom = (TextView)convertView.findViewById(R.id.lblNom);
        TextView prenom = (TextView)convertView.findViewById(R.id.lblPrenom);
        TextView credit = (TextView)convertView.findViewById(R.id.lblCredit);
        TextView solde =(TextView) convertView.findViewById(R.id.lblSolde);


        nom.setText(temp.getNom());
        prenom.setText(temp.getPrenom());
        credit.setText("Credit :  "+temp.getCredit()+"$");
        solde.setText("Solde :  "+temp.getSolde()+"$");

        return convertView;
    }
}
