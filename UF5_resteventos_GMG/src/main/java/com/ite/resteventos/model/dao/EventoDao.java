package com.ite.resteventos.model.dao;

import java.util.List;

import com.ite.resteventos.modelo.entitybeans.Evento;

public interface EventoDao {

	List<Evento> findAll();
	Evento verUno(int idEvento);
	int insertar(Evento evento);
	int modificar(Evento evento);
	int eliminar(int idEvento);
	List<Evento> sacarActivos();
	List<Evento> sacarDestacados();
	List<Evento> buscarEventos(String subcadena);
	//List<Evento> plazasDispo(int cantidad);
	
}
