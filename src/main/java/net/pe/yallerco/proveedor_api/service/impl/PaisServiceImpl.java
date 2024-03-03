package net.pe.yallerco.proveedor_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pe.yallerco.proveedor_api.persistence.dao.PaisRepository;
import net.pe.yallerco.proveedor_api.persistence.entity.Pais;
import net.pe.yallerco.proveedor_api.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
	private PaisRepository paisRepository;

	//********* listar ************************
	@Override
	public List<Pais> buscarTodos() {
		return paisRepository.findAll();
	}

	@Override
	public Pais buscarPorId(Long id) {
		return paisRepository.findById(id).orElse(null);
	}
	
	@Override
	public Optional<Pais> buscarPorIdOptional(Long id) {
		return paisRepository.findById(id);
	}

	//************crear ********************
	@Override
	public Pais crear(Pais pais) {
		return paisRepository.save(pais);
	}
	
	@Override
	public Pais agregar(String nombrePais, String capital, String codigo) {
		Pais pais = new Pais();
		pais.setPais(nombrePais);
		pais.setCapital(capital);
		pais.setCodigo(codigo);
		return paisRepository.save(pais);
	}
	
	@Override
	public void guardar(Pais pais) {
		paisRepository.save(pais);
	}
	
	//**********actualizar ***************
	
	
	
	@Override
	public Pais actualizar(Pais pais) {

		Optional<Pais> optionalPais = paisRepository.findById(pais.getId());

		if (optionalPais.isPresent()) {
			Pais retPais = optionalPais.get();
			BeanUtils.copyProperties(pais, retPais);
			return paisRepository.save(retPais);
		}
		return null;
	}

	//*************Eliminar******************
	
	@Override
	public void eliminar(Long id) {
		paisRepository.deleteById(id);
	}

	@Override
	public Pais eliminarPais(Long id) {
		Optional<Pais> paisOptional = paisRepository.findById(id);

        if (paisOptional.isPresent()) {
            Pais pais = paisOptional.get();
            paisRepository.deleteById(id);
            return pais;
        } else {
            // Manejo de la situación donde el país con el ID dado no se encuentra
            //throw new EntityNotFoundException("No se encontró el país con ID: " + id);
        	return null;
        }
	}
	
	@Override
	public Pais eliminadoLogico(Long id) {
//		Optional<Pais> optionalPais = paisRepository.findById(id);
//
//		if (optionalPais.isPresent()) {
//			Pais retPais = optionalPais.get();
//			retPais.setEstado("0");
//			return paisRepository.save(retPais);
//		}
		return null;
	}

	

	

}
