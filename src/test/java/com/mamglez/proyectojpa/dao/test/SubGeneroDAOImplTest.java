/**
 * 
 */
package com.mamglez.proyectojpa.dao.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mamglez.proyectojpa.dao.ISubGeneroDAO;
import com.mamglez.proyectojpa.dao.impl.SubGeneroDAOImpl;
import com.mamglez.proyectojpa.entity.Genero;
import com.mamglez.proyectojpa.entity.SubGenero;

/**
 * @author skype
 *
 */
class SubGeneroDAOImplTest {
	
	private ISubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.SubGeneroDAOImpl#guardar(com.mamglez.proyectojpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("harcore");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		this.subGeneroDAO.guardar(subGenero);
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.SubGeneroDAOImpl#actualizar(com.mamglez.proyectojpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado = this.subGeneroDAO.consultarById(7L);
		subGeneroConsultado.setDescripcion("trashmetal");
		subGeneroConsultado.getGenero().setDescripcion("metal trash");
		this.subGeneroDAO.actualizar(subGeneroConsultado);
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDAO.eliminar(7L);
		
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados = this.subGeneroDAO.consultar();
		assertTrue(subGenerosConsultados.size() > 0);
		for(SubGenero subGenero: subGenerosConsultados) {
			System.out.println(subGenero);
			System.out.println(subGenero.getGenero().getDescripcion());
		}
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
