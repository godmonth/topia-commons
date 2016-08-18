package com.godmonth.topia.commons.data.lock;

import java.io.Serializable;

import com.godmonth.topia.commons.data.model.MutableModel;

public interface LockOrder<ID extends Serializable> {
	void lock(Class<? extends MutableModel> entityClass, ID id, long dataVersion);

}
