/**
 * 
 */
package com.mamglez.proyectojpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mamglez.proyectojpa.dao.IDisqueraDAO;
import com.mamglez.proyectojpa.entity.Disquera;

/**
 * @author skype
 *	implementacion transacciones para tabla Disquera
 */
public class DisqueraDAOImpl implements IDisqueraDAO {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceMamglez");

	@Override
	public void guardar(Disquera disquera) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if(et !=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public void actualizar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if(et !=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}

	}

	@Override
	public void eliminar(Long id) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disqueraConsultada = em.find(Disquera.class, id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(disqueraConsultada);
			et.commit();
		} catch (Exception e) {
			if(et !=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}

	}

	@Override
	public List<Disquera> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera =(TypedQuery<Disquera>) em.createQuery("from Disquera order by descripcion");
		return queryDisquera.getResultList();
		
	}

	@Override
	public Disquera consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultado =  em.find(Disquera.class, id);
		if(disqueraConsultado == null) {
			throw new EntityNotFoundException("la disquera con id "+ "no se econtro");
		}
		return disqueraConsultado;
	}

	@Override
	public Disquera consultarByDescripcionJPQL(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<Disquera> queryDisquera =(TypedQuery<Disquera>) em.createQuery("from Disquera where descripcion = :desc");
		queryDisquera.setParameter("desc", descripcion);
		return queryDisquera.getSingleResult();
	}

	@Override
	public Disquera consultarByDescripcionNative(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<Disquera> queryDisquera =(TypedQuery<Disquera>) em.createNativeQuery("select * from disquera where descripcion = :desc",Disquera.class);
		queryDisquera.setParameter("desc", descripcion);
		return queryDisquera.getSingleResult();
	}

}
