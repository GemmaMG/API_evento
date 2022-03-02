package com.ite.resteventos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.resteventos.modelo.entitybeans.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
		
	@Query("select e from Evento e where e.estado = 'Activo'")
	public List<Evento> buscarActivos();
	
	@Query("select e from Evento e where e.destacado = 'S'")
	public List<Evento> buscarDestacados();
	
	@Query("select e from Evento e where e.nombre = ?1")
	public List<Evento> buscarEventos(String subcadena);
	
	//@Query("select e from Evento e where e.idReserva.cantidad = ?1")
	//public List<Evento> plazasDispo(int cantidad);
}
