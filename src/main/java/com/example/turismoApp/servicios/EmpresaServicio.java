package com.example.turismoApp.servicios;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.repositorios.EmpresaRepositorio;
import com.example.turismoApp.validaciones.EmpresaValidacion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmpresaServicio {
    @Autowired
    EmpresaRepositorio empresaRepositorio;
    @Autowired
    EmpresaValidacion empresaValidacion;

    public Empresa registrarEmpresa(Empresa datosARegistrar) throws Exception{
        try{
            if(!this.empresaValidacion.validarNombre(datosARegistrar.getNombre())){
                throw new Exception("Error en el servicio");
            }
            //falta validar el nit
            //si paso todos los if, estoy listo para llamar al repo
            return (this.empresaRepositorio.save(datosARegistrar));

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Empresa modificarEmpresa(Integer id, Empresa datosAModificar) throws Exception{
        try{
            //validamos la información
            if(!this.empresaValidacion.validarNombre(datosAModificar.getNombre())){
                throw new Exception("error en el dato entregado");
            }
            //buscar que la empresa que tiene el id que envía el usuario exista
            Optional<Empresa> empresaEncontrada= this.empresaRepositorio.findById(id);
            //pregunto si lo que busqué esta vacío(que no está)

            if(empresaEncontrada.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }

            //rutina por si la encontr
            // //1.convierto el opcional en la entidad respectiva
            Empresa empresaQueExiste = empresaEncontrada.get();

            //2.a la empresa que existe le cambio la información que el usuario necesita
            empresaQueExiste.setNombre(datosAModificar.getNombre());

            //3. guardar la información que se acaba de editar (set)
            return (this.empresaRepositorio.save(empresaQueExiste));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Empresa buscarEmpresaPorId(Integer id) throws Exception{
        try{
            Optional<Empresa> empresaOpcional = this.empresaRepositorio.findById(id);
            if(empresaOpcional.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }
            return empresaOpcional.get();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Empresa> buscarTodasLasEmpresas() throws Exception{
        try{
            List<Empresa> listaEmpresa = this.empresaRepositorio.findAll();
            return listaEmpresa;
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarEmpresa(Integer id) throws Exception{
        try{
            Optional<Empresa> empresaOpcional = this.empresaRepositorio.findById(id);
            if(empresaOpcional.isPresent()){
                this.empresaRepositorio.deleteById(id);
                return true;
            } else{
                throw new Exception("Empresa no encontrada");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }


}
