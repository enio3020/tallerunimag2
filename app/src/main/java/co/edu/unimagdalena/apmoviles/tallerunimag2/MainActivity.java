package co.edu.unimagdalena.apmoviles.tallerunimag2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textResul;
    EditText x1, x2, y1, y2;
    Button puntomedio, pendiente, cuadrante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResul = findViewById(R.id.textresultado);
        x1 = findViewById(R.id.edtx1);
        x2 = findViewById(R.id.edtx2);
        y1 = findViewById(R.id.edty1);
        y2 = findViewById(R.id.edty2);
        puntomedio = findViewById(R.id.btnpuntom);
        pendiente = findViewById(R.id.btnpendiente);
        cuadrante = findViewById(R.id.btncuadrante);
        puntomedio.setOnClickListener(this);
        cuadrante.setOnClickListener(this);
        pendiente.setOnClickListener(this);
    }

    public String xcuadrante(float xx, float yy){
        if(xx >= 0 && yy >= 0){
            return "Cuadrante I";
        }else if(xx < 0 && yy < 0){
            return "Cuadrante III";
        }else if(xx >= 0 && yy < 0){
            return "Cuadrante IV";
        }else{
            return "Cuadrante II";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.m1:   x1.setText(""+(Math.random()*(100)-50));
                            x2.setText(""+(Math.random()*(100)-50));
                            y1.setText(""+(Math.random()*(100)-50));
                            y2.setText(""+(Math.random()*(100)-50));
                break;
            case R.id.m2:
                    if(TextUtils.isEmpty(x1.getText().toString()) ||
                            TextUtils.isEmpty(x2.getText().toString()) ||
                            TextUtils.isEmpty(y1.getText().toString()) ||
                            TextUtils.isEmpty(y2.getText().toString()) ){
                        textResul.setText("Datos inválidos");
                    }else {
                        float xx1 = Float.parseFloat(x1.getText().toString());
                        float xx2 = Float.parseFloat(x2.getText().toString());
                        float yy1 = Float.parseFloat(y1.getText().toString());
                        float yy2 = Float.parseFloat(y2.getText().toString());
                        textResul.setText("La distancia entre los dos puntos es: " + Math.sqrt(Math.pow((xx2 - xx1), 2) + Math.pow((yy2 - yy1), 2)));
                    }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(x1.getText().toString()) ||
                TextUtils.isEmpty(x2.getText().toString()) ||
                TextUtils.isEmpty(y1.getText().toString()) ||
                TextUtils.isEmpty(y2.getText().toString()) ){
            textResul.setText("Datos inválidos");
        }else {
            float xx1 = Float.parseFloat(x1.getText().toString());
            float xx2 = Float.parseFloat(x2.getText().toString());
            float yy1 = Float.parseFloat(y1.getText().toString());
            float yy2 = Float.parseFloat(y2.getText().toString());
            switch (v.getId()){
                case R.id.btnpuntom: textResul.setText("EL punto medio es: ("+((xx1+xx2)/2)+", "+((yy1+yy2)/2)+")");
                    break;
                case R.id.btnpendiente: textResul.setText("La pendiente es: "+((yy2-yy1)/(xx2-xx1)));
                    break;
                case R.id.btncuadrante: textResul.setText("El Cuadrante del P(x1, y1) es el: "+xcuadrante(xx1,yy1)+"; El Cuadrante del P(x2, y2) es el: "+xcuadrante(xx2,yy2));
                    break;
            }
        }

    }
}