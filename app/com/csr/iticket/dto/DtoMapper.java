package com.csr.iticket.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class DtoMapper<E,D> {

	public D fromEntity(E entity){
		if(entity == null) return null;
		D dto = newDto();
		mapEntityToDto(entity,dto);
		return dto;
	}
	
	public List<D> fromEntities(Collection<E> entities){
		if(entities == null) return null;
		List<D> dtos = new ArrayList();
		for(E entity : entities){
			
			dtos.add(fromEntity(entity));
		}
		return dtos;
	}
	
	protected abstract D newDto();
	public abstract void mapEntityToDto(E entity, D dto);
	
}
