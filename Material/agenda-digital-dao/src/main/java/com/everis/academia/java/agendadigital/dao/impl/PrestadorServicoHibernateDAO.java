package com.everis.academia.java.agendadigital.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agendadigital.model.PrestadorServico;

@Repository
public class PrestadorServicoHibernateDAO implements IPrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static Short id = 0;
	
	@Override
	public void create(PrestadorServico prestadorServico) {
		id++;

		Session session = sessionFactory.getCurrentSession();

		session.save(prestadorServico);
		session.flush();

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Collection<PrestadorServico> read() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(PrestadorServico.class);
		return criteria.list();
	}

	@Override
	public void update(PrestadorServico prestadorServico) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(prestadorServico);
		session.flush();

	}

	@Override
	public void delete(PrestadorServico prestadorServico) {

		Session session = sessionFactory.getCurrentSession();	
		PrestadorServico ps = session.get(PrestadorServico.class, prestadorServico.getCodigo()); 
		
		session.delete(ps);	

	}

}
