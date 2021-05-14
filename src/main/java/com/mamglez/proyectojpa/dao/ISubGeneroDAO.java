/**
 * 
 */
package com.mamglez.proyectojpa.dao;

import java.util.List;

import com.mamglez.proyectojpa.entity.SubGenero;

/**
 * @author skype
 *
 */
public interface ISubGeneroDAO {
	
	void guardar(SubGenero subGenero);
	void actualizar(SubGenero subGenero);
	void eliminar(Long id);
	List<SubGenero> consultar();
	SubGenero consultarById(Long id);

}
