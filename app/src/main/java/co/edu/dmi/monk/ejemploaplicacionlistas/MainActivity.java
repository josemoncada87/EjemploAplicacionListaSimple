package co.edu.dmi.monk.ejemploaplicacionlistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista; // referecia al view de la lista
    private ArrayList<String> contenedorItems; // contenedor (buffer) de elementos
    private ArrayAdapter<String> adaptadorDeItems; // controlador de los elementos "conecta" el ArrayList con el View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedorItems =  new ArrayList<String>();
        contenedorItems.add("Item inicial de prueba");

        lista =  (ListView) findViewById(R.id.listView_items_main); // encuentra el view en el xml
        adaptadorDeItems =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contenedorItems); // inicializa el adaptador usando una vista simple
        lista.setAdapter(adaptadorDeItems); // se asigna el adaptador a la lista(View)

        Button btnAgregar = (Button) findViewById(R.id.btn_agregar_item);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed =  (EditText) findViewById(R.id.ed_txt_item); // obtener la vista del texto editable
                //contenedorItems.add("..."); // esto tambien funciona pero es mejor sobre el adaptador
                adaptadorDeItems.add(ed.getText().toString()); // agregar el texto dentro del texto editable
                adaptadorDeItems.notifyDataSetChanged(); // informa que se modificaron los datos para poder actualizar la vista
            }
        });




    }
}
