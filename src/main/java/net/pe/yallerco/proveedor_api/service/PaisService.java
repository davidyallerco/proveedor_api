package net.pe.yallerco.proveedor_api.service;

import java.util.List;
import java.util.Optional;

import net.pe.yallerco.proveedor_api.persistence.entity.Pais;

public interface PaisService {

	// Read
	public List<Pais> buscarTodos();

	public Pais buscarPorId(Long id);

	public Optional<Pais> buscarPorIdOptional(Long id);

	// Create
	public Pais crear(Pais pais);

	public void guardar(Pais pais);

	// Update
	public Pais actualizar(Pais pais);

	// Delete
	public void eliminar(Long id);

	public Pais eliminarPais(Long id);

	public Pais eliminadoLogico(Long id);

}
