package com.ite.resteventos.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.resteventos.modelo.entitybeans.Evento;
import com.ite.resteventos.modelo.repository.EventoRepository;

@Service
public class EventoDaoImpl implements EventoDao{
	
	@Autowired
	private EventoRepository erepo;

	@Override
	public List<Evento> findAll() {
		return erepo.findAll();
	}

	@Override
	public Evento verUno(int idEvento) {
		return erepo.findById(idEvento).orElse(null);
	}

	@Override
	public int insertar(Evento evento) {
		if(verUno(evento.getIdEvento()) ==null) {
			erepo.save(evento);
			return 1;
		}else
			return 0;
	}

	@Override
	public int modificar(Evento evento) {
		if(verUno(evento.getIdEvento()) !=null) {
			erepo.save(evento);
			return 1;
		}else
			return 0;
	}

	@Override
	public int eliminar(int idEvento) {
		if(verUno(idEvento) !=null) {
			erepo.deleteById(idEvento);
			return 1;
		}else
			return 0;
	}

	@Override
	public List<Evento> sacarActivos() {
		return erepo.buscarActivos();
	}

	@Override
	public List<Evento> sacarDestacados() {
		return erepo.buscarDestacados();
	}

	@Override
	public List<Evento> buscarEventos(String subcadena) {
		return erepo.buscarEventos(subcadena);
	}


	
}
