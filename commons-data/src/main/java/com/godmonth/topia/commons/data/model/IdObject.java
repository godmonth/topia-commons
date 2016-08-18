package com.godmonth.topia.commons.data.model;

import java.io.Serializable;

public interface IdObject<ID extends Serializable> {
	/**
	 * Returns the id of the entity.
	 * 
	 * @return the id
	 */
	ID getId();
}
