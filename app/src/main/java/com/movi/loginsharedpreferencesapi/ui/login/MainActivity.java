package com.movi.loginsharedpreferencesapi.ui.login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.movi.loginsharedpreferencesapi.R;
import com.movi.loginsharedpreferencesapi.databinding.ActivityMainBinding;
import com.movi.loginsharedpreferencesapi.request.ApiClient;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vm;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        setContentView(binding.getRoot());

        //boton para registrar
        binding.btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vm.mostrarFormulario();
            }
        });

      binding.btIngresar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              vm.login(binding.etUsuario.getText().toString(),binding.etContrasenia.getText().toString());
          }
      });




    }




}