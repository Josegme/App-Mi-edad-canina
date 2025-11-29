package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. Inflar y establecer el contenido usando View Binding.
        //    Esto reemplaza a setContentView(R.layout.activity_main)
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 2. Usar una expresión lambda para el listener, es más limpio.
        binding.buttonId.setOnClickListener(v -> {
            // 3. Acceder a las vistas directamente desde el objeto 'binding'.
            String age = binding.ageEdit.getText().toString();

            if (!age.isEmpty()) {
                int ageInt = Integer.parseInt(age);
                int result = ageInt * 7;
                // 4. Formatear el string del resultado con el valor calculado.
                String resultString = getString(R.string.result_format, result);
                binding.resultText.setText(resultString);
            } else {
                Log.d("MainActivity", "El campo está vacío");
                // Dentro de una lambda, 'this' se refiere a MainActivity, así que es correcto.
                Toast.makeText(this, getString(R.string.you_have_to_insert_an_age), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
