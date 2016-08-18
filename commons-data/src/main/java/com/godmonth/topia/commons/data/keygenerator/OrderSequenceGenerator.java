package com.godmonth.topia.commons.data.keygenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderSequenceGenerator extends StringSequenceGenerator {

	private static final Logger logger = LoggerFactory.getLogger(OrderSequenceGenerator.class);

	private String prefix;

	private boolean date;

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		super.configure(type, params, serviceRegistry);
		prefix = params.getProperty("prefix");
		date = Boolean.valueOf(params.getProperty("date", "true"));
	}

	private FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyyMMdd");

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String id = (String) super.generate(session, object);
		String datePattern = date ? DATE_FORMAT.format(new Date()) : "";
		id = StringUtils.defaultString(prefix) + datePattern + StringUtils.leftPad(id, 8, '0');
		logger.trace("generated id:{}", id);
		return id;
	}

}
