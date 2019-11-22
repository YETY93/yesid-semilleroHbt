/**
 * GestionarUserBean.java
 */
package com.hbt.semillero.ejb;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Entity;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.UserDTO;
import com.hbt.semillero.entidades.EstadoUsuario;
import com.hbt.semillero.entidades.User;

/**
 * <b>Descripción:<b> Clase que determina la gstion de un Comic
 * <b>Caso de Uso:<b> 
 * @author Nuevo
 * @version 
 */

@Stateless
public class GestionarUserBean implements IGestionarUserLocal {
	
	@PersistenceContext
	private EntityManager em;

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUserLocal#crearUser(com.hbt.semillero.dto.UserDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)// cre una nueva transaccion
	public void crearUser(UserDTO userDTO) {
		
		User user = convertirUserDTOtouser(userDTO);
		LocalDate fechaActual = LocalDate.now();
		
		if(user.getFechaCreacion().isBefore(fechaActual)) {
			em.persist(user);
 		} else {
 			em.clear();
 		}
		
		
		System.out.println("Nose puede crear el usuario");
		
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUserLocal#modificarUser(java.lang.Long, java.lang.String, com.hbt.semillero.dto.UserDTO)
	 */
	@Override
	public void modificarUser(Long id, String nombre, UserDTO userNuevo) {
		User userModificar;
		if(userNuevo == null) {
			userModificar = em.find(User.class, id);
		} else {
			userModificar = convertirUserDTOtouser(userNuevo);
			
		}
		userModificar.setNombre(nombre);
		em.merge(userModificar);
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUserLocal#eliminarUser(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarUser(Long idUser) {
		// TODO Auto-generated method stub
		
		User userEstado;
		userEstado = em.find(User.class, idUser);
		
		if(userEstado != null) {
			userEstado.setEstadoUsuario(EstadoUsuario.INACTIVO);
			em.merge(userEstado);
		}
		
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUserLocal#consultarUser(java.lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UserDTO consultarUser(String idComic) {
		
		return null;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUserLocal#consultarUser()
	 */
	@Override
	public List<UserDTO> consultarUser() {
		List<UserDTO> resultadoComicDTO = new ArrayList<UserDTO>();
		
		List<User> resultados = (List<User>) em.createQuery("select u from TC_USUARIO u").getResultList();		
		for (UserDTO userDTO : resultadoComicDTO ) {
			
		}
		return resultadoComicDTO;
	}
	
	
	/**
	 * 
	 * Metodo encargado de permitir crear una nueva entidad
	 * <b>Caso de Uso</b>
	 * @author Yesid Rangel
	 * @param UserDTO
	 * @return
	 */
	
	private User convertirUserDTOtouser(UserDTO userDTO) {
		
		User user = new User();
		
		if( userDTO.getId() != null) {
		user.setId(Long.parseLong(userDTO.getId()));
		}
		
		user.setNombre(userDTO.getNombre());
		user.setFechaCreacion(userDTO.getFechaCreacion());
		user.setEstadoUsuario(userDTO.getEstadoUsuario());
		user.setIDpersona(userDTO.getIDpersona());
		
		
		return user;
	}
	
private UserDTO convertirUsertouserDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
		
		if( user.getId() != null) {
		userDTO.setId(user.getId().toString());
		}
		
		userDTO.setNombre(user.getNombre());
		userDTO.setFechaCreacion(user.getFechaCreacion());
		userDTO.setEstadoUsuario(user.getEstadoUsuario());
		userDTO.setIDpersona(user.getIDpersona());
		
		
		return userDTO;
	}
	

}
