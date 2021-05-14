/**
 * 
 */
package com.mamglez.proyectojpa.dao.test;

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

	/**
	 * Test method for {@link java.lang.Object#Object()}.
	 */
	@Test
	void testObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#getClass()}.
	 */
	@Test
	void testGetClass() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	void testEquals() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#clone()}.
	 */
	@Test
	void testClone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#notify()}.
	 */
	@Test
	void testNotify() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#notifyAll()}.
	 */
	@Test
	void testNotifyAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#wait()}.
	 */
	@Test
	void testWait() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#wait(long)}.
	 */
	@Test
	void testWaitLong() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#wait(long, int)}.
	 */
	@Test
	void testWaitLongInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#finalize()}.
	 */
	@Test
	void testFinalize() {
		fail("Not yet implemented");
	}

}
