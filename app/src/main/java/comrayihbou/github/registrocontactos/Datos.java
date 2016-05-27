package comrayihbou.github.registrocontactos;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        final TextView tvNombre = (TextView) findViewById(R.id.tvMostrarNombre);
        final TextView tvFecha = (TextView) findViewById(R.id.tvMostrarFecha);
        final TextView tvTelefono = (TextView) findViewById(R.id.tvMostrarTelefono);
        final TextView tvEmail = (TextView) findViewById(R.id.tvMostrarEmail);
        final TextView tvDescripcion = (TextView) findViewById(R.id.tvMostrarDescripcion);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null){
            String datoNombre = (String) extras.get("Nombre");
            String datoFecha = (String) extras.get("Fecha");
            String datoTelefono = (String) extras.get("Telefono");
            String datoEmail = (String) extras.get("Email");
            String datoDescripcion = (String) extras.get("Descripcion");

            tvNombre.setText(datoNombre);
            tvFecha.setText(datoFecha);
            tvTelefono.setText(datoTelefono);
            tvEmail.setText(datoEmail);
            tvDescripcion.setText(datoDescripcion);

            Button Editar = (Button) findViewById(R.id.BotonEditarDatos);
            Editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentDato = new Intent(Datos.this,Registro.class);
                    String aNombre=tvNombre.getText().toString();
                    String aFecha=tvFecha.getText().toString();
                    String aTelefono=tvTelefono.getText().toString();
                    String aEmail=tvEmail.getText().toString();
                    String aDescripcion=tvDescripcion.getText().toString();

                    intentDato.putExtra("Nombre",aNombre);
                    intentDato.putExtra("Fecha",aFecha);
                    intentDato.putExtra("Telefono",aTelefono);
                    intentDato.putExtra("Email",aEmail);
                    intentDato.putExtra("Descripcion",aDescripcion);

                    startActivity(intentDato);
                }
            });
        }

    }

}
