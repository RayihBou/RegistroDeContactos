package comrayihbou.github.registrocontactos;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Creacion de Variables para los TextInput
        final TextInputEditText tiNombre = (TextInputEditText) findViewById(R.id.tiNombre);
        final TextInputEditText tiFecha = (TextInputEditText) findViewById(R.id.tiFecha);
        final TextInputEditText tiTelefono = (TextInputEditText) findViewById(R.id.tiTelefono);
        final TextInputEditText tiEmail = (TextInputEditText) findViewById(R.id.tiEmail);
        final TextInputEditText tiDescripcion = (TextInputEditText) findViewById(R.id.tiDescripcion);


        //Creacion de Variables para el Calendario
        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);
        final TextInputEditText textdate = (TextInputEditText) findViewById(R.id.tiFecha);

        textdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepicker = new DatePickerDialog(Registro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textdate.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                    }
                }, year, month, day);
                datepicker.setTitle("Elegir Fecha");
                datepicker.show();
            }
        });

        Button boton = (Button) findViewById(R.id.botonSiguiente);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Registro.this, Datos.class);
                String auxNombre = tiNombre.getText().toString();
                String auxFecha = tiFecha.getText().toString();
                String auxTelefono = tiTelefono.getText().toString();
                String auxEmail = tiEmail.getText().toString();
                String auxDescripcion = tiDescripcion.getText().toString();

                intent.putExtra("Nombre", auxNombre);
                intent.putExtra("Fecha", auxFecha);
                intent.putExtra("Telefono", auxTelefono);
                intent.putExtra("Email", auxEmail);
                intent.putExtra("Descripcion", auxDescripcion);

                startActivity(intent);
            }
        });

        Intent intentDato = getIntent();
        Bundle extras = intentDato.getExtras();
        if (extras != null) {
            String datoNombre = (String) extras.get("Nombre");
            String datoFecha = (String) extras.get("Fecha");
            String datoTelefono = (String) extras.get("Telefono");
            String datoEmail = (String) extras.get("Email");
            String datoDescripcion = (String) extras.get("Descripcion");

            tiNombre.setText(datoNombre);
            tiFecha.setText(datoFecha);
            tiTelefono.setText(datoTelefono);
            tiEmail.setText(datoEmail);
            tiDescripcion.setText(datoDescripcion);

        }
    }

}
