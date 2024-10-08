package com.movi.loginsharedpreferencesapi.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.movi.loginsharedpreferencesapi.model.Usuario;
import com.movi.loginsharedpreferencesapi.request.ApiClient;
import com.movi.loginsharedpreferencesapi.ui.registro.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();


    }
    public void mostrarFormulario() {

        Intent intent = new Intent(context, RegistroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public void login(String email, String contrasena) {

        if (!email.isEmpty() && !contrasena.isEmpty()){
        Usuario usuario = ApiClient.login(context, email, contrasena);

        if (usuario != null) {

            Intent intent = new Intent(context, RegistroActivity.class);
            intent.putExtra("usuario",true);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            Toast.makeText(context, "Bienvenido", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Datos Incorrectos",Toast.LENGTH_SHORT).show();
        }
        }else{
            Toast.makeText(context,"Campos Vacios",Toast.LENGTH_SHORT).show();
        }
    }
}
