package com.everis.academia.java.agendadigital.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.dao.ITipoServicoDAO;
import com.everis.academia.java.agendadigital.model.TipoServico;

@Repository
public class TipoServicoHibernateDAO implements ITipoServicoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Short id = 0;
	
	@Override
	public void create(TipoServico tipoServico) {
		id++;

		Session session = sessionFactory.getCurrentSession();

		session.save(tipoServico);
		session.flush();
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Collection<TipoServico> read() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(TipoServico.class);
		return criteria.list();
	}

	@Override
	public void update(TipoServico tipoServico) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(tipoServico);
		session.flush();
	}

	@Override
	public void delete(TipoServico tipoServico) {

		Session session = sessionFactory.getCurrentSession();	
		TipoServico ts = session.get(TipoServico.class, tipoServico.getCodigo()); 
		
		session.delete(ts);	
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean jaExisteTipoServico(TipoServico tipoServico) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(TipoServico.class);

		criteria.add(Restrictions.and(Restrictions.eq("descricao", tipoServico.getDescricao()).ignoreCase()));
		if (tipoServico.getCodigo() != null) {
			criteria.add(Restrictions.ne("codigo", tipoServico.getCodigo()));
		}				
		criteria.setProjection(Projections.count("codigo"));
		return (Long) criteria.uniqueResult() > 0;

	}

}
