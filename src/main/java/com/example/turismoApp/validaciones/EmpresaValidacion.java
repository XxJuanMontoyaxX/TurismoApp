package com.example.turismoApp.validaciones;

import org.springframework.stereotype.Component;

@Component
public class EmpresaValidacion {

    public Boolean validarNombre(String nombre) throws Exception{
        if(nombre.length()>30){
            throw new Exception("Longitud de caracteres inválida");
        } else{
            return true;
        }
    }
}
