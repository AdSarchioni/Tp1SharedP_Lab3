package com.movi.loginsharedpreferencesapi.ui.registro;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.movi.loginsharedpreferencesapi.R;
import com.movi.loginsharedpreferencesapi.databinding.ActivityRegistroBinding;
import com.movi.loginsharedpreferencesapi.model.Usuario;

public class RegistroActivity extends AppCompatActivity {
private RegistroActivityViewModel vm;
private ActivityRegistroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
       binding=ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       vm.getUsuario().observe(this, new Observer<Usuario>() {
           @Override
           public void onChanged(Usuario usuario) {
               binding.tvDni.setText(usuario.getDni()+"");
               binding.tvApellido.setText(usuario.getApellido());
               binding.tvNombre.setText(usuario.getNombre());
               binding.tvEmail.setText(usuario.getEmail());
               binding.tvContrasena.setText(usuario.getContrasena());
           }
       });
       binding.btGuardar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               vm.guardar(
                        binding.tvDni.getText().toString(),
                       binding.tvApellido.getText().toString(),
                       binding.tvNombre.getText().toString(),
                       binding.tvEmail.getText().toString(),
                       binding.tvContrasena.getText().toString());
           }
       });

       vm.leerDatos(getIntent());



    }
}