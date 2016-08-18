package com.godmonth.topia.commons.data.supplier;

import java.io.Serializable;
import java.util.function.Supplier;

import org.springframework.data.repository.CrudRepository;

public class ModelSupplier<MODEL, KEY extends Serializable> implements
		Supplier<MODEL> {
	private CrudRepository<MODEL, KEY> crudRepository;
	private KEY id;

	public ModelSupplier(CrudRepository<MODEL, KEY> crudRepository, KEY id) {
		this.crudRepository = crudRepository;
		this.id = id;
	}

	@Override
	public MODEL get() {
		return crudRepository.findOne(id);
	}

}
