/**
 * 
 */
package com.mamglez.proyectojpa.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mamglez.proyectojpa.dao.IDisqueraDAO;
import com.mamglez.proyectojpa.dao.impl.DisqueraDAOImpl;
import com.mamglez.proyectojpa.entity.Disquera;

/**
 * @author skype
 *
 */
class DisqueraDAOImplTest {
	
	private IDisqueraDAO disqueraDAO = new DisqueraDAOImpl();

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.DisqueraDAOImpl#guardar(com.mamglez.proyectojpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("megaforcee");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.DisqueraDAOImpl#actualizar(com.mamglez.proyectojpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarById(9L);
		
		disqueraConsultada.setDescripcion("ironmaiden");
		this.disqueraDAO.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.DisqueraDAOImpl#eliminar(com.mamglez.proyectojpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 9L;
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disquerasConsultadas = this.disqueraDAO.consultar();
		assertTrue(disquerasConsultadas.size() > 0);
		disquerasConsultadas.forEach(disquera -> {
			System.out.println(disquera.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.mamglez.proyectojpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera =  this.disqueraDAO.consultarById(90L);
		System.out.println("Disquera: " + disquera.getDescripcion());
	}
	@Test
	void testConsultarByDescripcionJPQL() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarByDescripcionJPQL("megaforce");
		assertNotNull(disqueraConsultada);
		System.out.println(disqueraConsultada);
	}
	@Test
	void tesConsultarByDescripcionNative() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarByDescripcionNative("megaforce");
		assertNotNull(disqueraConsultada);
		System.out.println(disqueraConsultada);
	}

}
