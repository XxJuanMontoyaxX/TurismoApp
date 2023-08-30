package com.example.turismoApp.controladores;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.modelos.Oferta;
import com.example.turismoApp.servicios.EmpresaServicio;
import com.example.turismoApp.servicios.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ofertas")
public class OfertaControlador {
    @Autowired
    OfertaServicio ofertaServicio;

    @PostMapping
    public ResponseEntity<?> registrarOferta(@RequestBody Oferta datosOferta){
        return null;
    }

    @PutMapping
    public ResponseEntity<?> modificarOferta(@RequestBody Oferta datosNuevosOferta, @PathVariable Integer idOferta){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarOfertaPorId(@PathVariable Integer id){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasLasOfertas(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarOferta(@PathVariable Integer id){
        return null;
    }
}
