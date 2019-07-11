package com.everis.academia.java.agendadigital.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.dao.ICidadeDAO;
import com.everis.academia.java.agendadigital.model.Cidade;

@Repository
public class CidadeHibernateDAO implements ICidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static Short id = 0;

	@Override
	public void create(String nome) {
		id++;

		Session session = sessionFactory.getCurrentSession();
		
		session.save(new Cidade(id,nome));
//		session.save(cidade);
		session.flush();
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Collection<Cidade> read() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Cidade.class);
		return criteria.list();
	}
	
	@Override
	public void update(Cidade cidade) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(cidade);
		session.flush();	
	}

	@Override
	public void delete(Short codigo) {
		
		Session session = sessionFactory.getCurrentSession();
		
//		Cidade cidade = session.get(Cidade.class, cidade.getCodigo()); // Para o caso de se fazer o delete(Cidade cidade)
		Cidade cidade = session.get(Cidade.class, codigo);
		
		session.delete(cidade);	
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean jaExisteCidade(Cidade cidade) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Cidade.class);
		
		criteria.add(Restrictions.and(Restrictions.eq("nome", cidade.getNome()).ignoreCase()));
		if (cidade.getCodigo() != null) {
			criteria.add(Restrictions.ne("codigo", cidade.getCodigo()));
		}				
		criteria.setProjection(Projections.count("codigo"));
		return (Long) criteria.uniqueResult() > 0;
	}

}
