package com.ite.resteventos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ite.resteventos.model.dao.EventoDao;
import com.ite.resteventos.model.dao.ReservaDao;
import com.ite.resteventos.modelo.entitybeans.Evento;
import com.ite.resteventos.modelo.entitybeans.Reserva;

@RestController
@RequestMapping("/rest/eventos")
public class EventoRestController {

	@Autowired
	private EventoDao edao;
	
	@Autowired
	private ReservaDao rdao;
	
	@GetMapping("/todos")
	public List<Evento> procTodos(){
		return edao.findAll();
	}
	
	@GetMapping("/verUno/{idEvento}")
	public Evento procTodos(@PathVariable("idEvento") int idEvento){
		return edao.verUno(idEvento);
	}
	
	@PostMapping("/alta")
	public String procAlta(@RequestBody Evento evento) {
		return (edao.insertar(evento)== 1)?"Evento dado de Alta":"Evento NO dado de Alta";
	}
	
	@PutMapping("/modificar")
	public String procModif(@RequestBody Evento evento) {
		return (edao.modificar(evento)== 1)?"Evento Modificado":"Evento NO Modificado";
	}
	
	@DeleteMapping("/eliminar/{idEvento}")
	public String procEliminar(@PathVariable int idEvento) {
		return (edao.eliminar(idEvento)== 1)?"Evento Eliminado":"Evento NO Eliminado";
	}

	@GetMapping("/activos")
		public List<Evento> sacarActivos(){
		return edao.sacarActivos();		
	}
	
	@GetMapping("/destacados")
	public List<Evento> sacarDestacados(){
		return edao.sacarDestacados();		
	}

	@GetMapping("/buscarEventos/{subcadena}")
	public List<Evento> buscarEventos(@PathVariable("subcadena") String subcadena){
		return edao.buscarEventos(subcadena);
	}
	
	@GetMapping("/plazasQuedan/{idEvento}")
	public String buscarPlaza(@PathVariable ("idEvento") int idEvento) {
		int plazasOcupadas = rdao.buscarPlaza(idEvento);
		int plazasTotales = edao.verUno(idEvento).getAforoMaximo();
		int plazasLibres = plazasTotales - plazasOcupadas;
		if (plazasLibres <= 0)
			plazasLibres=0;
		return ("quedan_plazas: " + plazasLibres);
	}
}
