/**
 * 
 */
package com.mamglez.proyectojpa.dao;

import java.util.List;

import com.mamglez.proyectojpa.entity.Disquera;

/**
 * @author skype
 * interface para generar DAO para CRUD a tabla disquera
 */
public interface IDisqueraDAO {
	
	void guardar(Disquera disquera);
	void actualizar(Disquera disquera);
	void eliminar(Long id);
	List<Disquera> consultar();
	Disquera consultarById(Long id);
	Disquera consultarByDescripcionJPQL(String descripcion);
	Disquera consultarByDescripcionNative(String descripcion);
	
}
