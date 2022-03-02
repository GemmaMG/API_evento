package com.ite.resteventos.modelo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.resteventos.modelo.entitybeans.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

	@Query("select sum(r.cantidad) from Reserva r where r.evento.idEvento = ?1")
	public Integer buscarPlaza(int idEvento);
}
