package com.empresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/url/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping
	public List<Medicamento> listaMedicamento() {
		List<Medicamento> lstsalida = medicamentoService.listaMedicamento();
		return lstsalida;
	}
	
	@PostMapping
	public ResponseEntity<?> insertaMedicamento(@RequestBody Medicamento obj){
		List<String> lstmensajes = new ArrayList<String>();
		Medicamento objsalida = medicamentoService.insertaMedicamento(obj);
		if (objsalida == null) {
			 lstmensajes.add("Error en el registro");
		 }else {
			 lstmensajes.add("Se registro la modalidad de id : " + objsalida.getIdMedicamento());
		 }
		return ResponseEntity.ok(lstmensajes);
	}
	
	

}
