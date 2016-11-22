package mx.alfredoul.listacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static mx.alfredoul.listacontactos.R.id.cvContacto;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos; //creamos nuestro arreglo que contendrá los contactos, lo declaramos fuera del metodo oncreate
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asignamos la vista que definimos en cardview_contacto rvContactos, la vista la hemos convertido a un objeto para poder
        // manipularlo en java
        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);


        //lo mostraremos en una lista mi recycledView
        LinearLayoutManager llm = new LinearLayoutManager(this);    //lo declaramos e instanciamos como objeto llm
        llm.setOrientation(LinearLayoutManager.VERTICAL);           //le definimos al objeto la propiedad de orientación
        listaContactos.setLayoutManager(llm);                       // le decimos que el objeto se comporte como un linearLayout y que adquiera todas sus características

        inicicializarListaContactos();
        inicializarAdaptador();


        /* lo comentamos porque ya no usaremos listView
        //vamos a separar solo en nombre en un nuevo arreglo para mostrar mi lista solo de nombres
        ArrayList<String> nombresContacto = new ArrayList<>(); // creamos el array y lo instanciamos en una sola línea
        for (Contacto contacto : contactos ) {
            nombresContacto.add(contacto.getNombre());
        }

        // en el listview definimos un nombre despueés = casteamos el ListView, de otro modo me traeria el objeto de memoria y no el contenido, después buscamos el source que definimos en el XML para MainActivity
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContacto)); //para llenar la lista de contactos necesitamos un adaptador que le pasamos una lista o un arreglo como parámetro

        //creamos un intent implicito para unir las actividades para ello creamos un listener primero para setOnItemClickListener y se crea el adaptador el cual recibirá los parametrops de
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {  // aqui se recibe el parametro de la posición i
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class); //con la acción generamos el Intent que llamaremos intent, lo instanciamos declarando la actividad principal y la clase a ejecutar, en este caso DetalleContacto.java
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre()); // enviamos los parámetros y en detalle contacto debemos recibir los parámetros
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono()); // con getResources().getString(R.string.pnombre) enviamos los parametros a partir de un nombre declarado en strings
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();  //con esto eliminamos la actividad de memoria, al regresar con back de la siguiente activity debemos crearla por completo
            }
        });
        */


    }

    public void inicializarAdaptador () {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        // listaContactos.setAdapter(adaptador);           //toda mi clase se llama adaptador y se manda a la vista listaContactos
        listaContactos.setAdapter(adaptador);           //toda mi clase se llama adaptador y se manda a la vista listaContactos
    }


    public void inicicializarListaContactos() {
        contactos=new ArrayList<Contacto>(); //instanciamios el arraylist contactos

        contactos.add(new Contacto(R.drawable.user1, "Anahi Salgado", "1111199999","anahi@gmail.com")); //declaramos 5 objetos
        contactos.add(new Contacto(R.drawable.user2,"Alberto Cortez", "2222288888","alberto@gmail.com"));
        contactos.add(new Contacto(R.drawable.user3,"Margarita Lopez", "3333377777","marga@gmail.com"));
        contactos.add(new Contacto(R.drawable.user4,"Juana Jhons", "4444466666","juana@gmail.com"));
        contactos.add(new Contacto(R.drawable.user5,"Rufina Tamaya", "5555555555","alberto@gmail.com"));
        contactos.add(new Contacto(R.drawable.user1, "Anahi Salgado", "1111199999","anahi@gmail.com")); //declaramos 5 objetos
        contactos.add(new Contacto(R.drawable.user2,"Alberto Cortez", "2222288888","alberto@gmail.com"));
        contactos.add(new Contacto(R.drawable.user3,"Margarita Lopez", "3333377777","marga@gmail.com"));
        contactos.add(new Contacto(R.drawable.user4,"Juana Jhons", "4444466666","juana@gmail.com"));
        contactos.add(new Contacto(R.drawable.user5,"Rufina Tamaya", "5555555555","alberto@gmail.com"));
    }
}
