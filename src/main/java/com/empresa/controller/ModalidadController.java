package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@RestController
@RequestMapping("/url/modalidad")
public class ModalidadController {

	@Autowired
	private ModalidadService modalidadService;
	

	@GetMapping
	public List<Modalidad> listaModalidad(){
		List<Modalidad> lstSalida = modalidadService.listaModalidad();
		return lstSalida;
	}
	
	@PostMapping
	public ResponseEntity<?> insertaModalidad(@RequestBody Modalidad obj){
		 List<String> lstMensajes = new ArrayList<String>();
		 obj.setEstado(1);
		 obj.setFechaRegistro(new Date());
		 obj.setFechaActualizacion(new Date());
		 Modalidad objSalida = modalidadService.insertaModalidad(obj);
		 if (objSalida == null) {
			 lstMensajes.add("Error en el registro");
		 }else {
			 lstMensajes.add("Se registro la modalidad de id : " + objSalida.getIdModalidad());
		 }
		return ResponseEntity.ok(lstMensajes);
	}
	
}
