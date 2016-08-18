package com.godmonth.topia.commons.basic.competition;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import com.hazelcast.core.IAtomicReference;
import com.hazelcast.core.ILock;

public class CompetitionTemplate {

	private static final Logger logger = LoggerFactory.getLogger(CompetitionTemplate.class);

	public static final Period DEFAULT_COOLING_PERIOD = Period.minutes(1);

	private ILock lock;

	private IAtomicReference<DateTime> lastExecutedTime;

	private Period coolingPeriod = DEFAULT_COOLING_PERIOD;

	public void execute(CompetitionCallback competitionCallback) {

		boolean tryLock = lock.tryLock();
		if (!tryLock) {
			logger.debug("lock failure,skip this turn.");
			return;
		}
		try {
			DateTime clusterTime = lastExecutedTime.get();
			DateTime localTime = new DateTime();
			if (clusterTime != null) {
				if (!localTime.isAfter(clusterTime)) {
					logger.debug("clusterTime:{} is later than local time:{}.", clusterTime, localTime);
					return;
				}
				Interval interval = new Interval(clusterTime, localTime);
				if (interval.toDuration().compareTo(coolingPeriod.toStandardDuration()) <= 0) {
					logger.debug("cooling:{}", interval);
					return;
				}
			}
			boolean compareAndSet = lastExecutedTime.compareAndSet(clusterTime, localTime);
			if (compareAndSet) {
				competitionCallback.won(localTime.toDate());
			} else {
				logger.error("cas failure");
			}
		} finally {
			lock.unlock();
		}
	}

	@Required
	public void setLock(ILock lock) {
		this.lock = lock;
	}

	@Required
	public void setLastExecutedTime(IAtomicReference<DateTime> lastExecutedTime) {
		this.lastExecutedTime = lastExecutedTime;
	}

	public void setCoolingPeriod(Period coolingPeriod) {
		this.coolingPeriod = coolingPeriod;
	}

}
