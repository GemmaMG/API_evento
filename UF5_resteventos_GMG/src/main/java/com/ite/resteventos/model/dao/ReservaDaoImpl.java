package com.ite.resteventos.model.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.resteventos.modelo.repository.ReservaRepository;

@Service
public class ReservaDaoImpl implements ReservaDao{
	
	@Autowired
	private ReservaRepository rrepo;

	@Override
	public Integer buscarPlaza(int idEvento) {
		return rrepo.buscarPlaza(idEvento);
	}


	
}
