package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/url/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping
	public List<Empleado> listaEmpleado(){
		List<Empleado> lstSalida = empleadoService.listaEmpleado();
		return lstSalida;
	}
	

}
