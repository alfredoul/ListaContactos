package mx.alfredoul.listacontactos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;


/**
 * Created by alfredoul on 20/11/16.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    //cuando llamemos a la clase ContactoAdaptador se va a invocar el siguiente método constructor  y construirá la lista de contactos  contactos
    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador (ArrayList<Contacto> contactos, Activity activity) {
        this.contactos  = contactos;
        this.activity   = activity;
    }


    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //creamos el view pára inflar la vista e indicarle que view usará para mandar la informacion
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        //en este método vamos a setear los valores que tendrá cada uno de mis elementos del viewHolder de la lista contactos
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, contacto.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);
            }
        }
        );

    }

    @Override
    public int getItemCount() { //cantidad de elementos de mi arreglo que creamos contactos
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto         =(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      =(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV    =(TextView) itemView.findViewById(R.id.tvTelefonoCV);
        }
    }

}
