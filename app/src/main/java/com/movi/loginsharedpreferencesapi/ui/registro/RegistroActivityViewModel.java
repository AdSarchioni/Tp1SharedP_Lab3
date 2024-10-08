package com.movi.loginsharedpreferencesapi.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.movi.loginsharedpreferencesapi.model.Usuario;
import com.movi.loginsharedpreferencesapi.request.ApiClient;
import com.movi.loginsharedpreferencesapi.ui.login.MainActivity;

public class RegistroActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> mUsuario;


    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }
    public LiveData<Usuario> getUsuario(){
        if (mUsuario == null) {
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }


    public void guardar(String dni,String apellido,String nombre, String mail, String contrasena) {
        if (!dni.isEmpty() && !apellido.isEmpty() && !nombre.isEmpty() && !mail.isEmpty() && !contrasena.isEmpty()){
        Usuario usuario = new Usuario(Long.parseLong(dni),apellido,nombre,mail,contrasena);
        ApiClient.guardar(context, usuario);

        Toast.makeText(context,"Datos Guardado",Toast.LENGTH_SHORT).show();

        Intent intent =new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    else{
            Toast.makeText(context,"Datos Incorrectos o Vacios",Toast.LENGTH_SHORT).show();
    }
    }


    public void leerDatos(Intent intent) {
        boolean usu=intent.getBooleanExtra("usuario",false);
        if(usu){
        Usuario usuario = ApiClient.leerDatos(context);
        mUsuario.setValue(usuario);}
    }
}
