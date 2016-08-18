package com.godmonth.topia.commons.basic.competition;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicReference;
import com.hazelcast.core.ILock;

public class CompetitionTemplateTest {

	private CompetitionTemplate competitionTemplate;
	private HazelcastInstance hazelcastInstance;

	@BeforeClass
	private void prepare() {
		Config config = new Config();
		hazelcastInstance = Hazelcast.newHazelcastInstance(config);
		ILock lock = hazelcastInstance.getLock("a");
		IAtomicReference<DateTime> atomicReference = hazelcastInstance.getAtomicReference("b");
		competitionTemplate = new CompetitionTemplate();
		competitionTemplate.setLastExecutedTime(atomicReference);
		competitionTemplate.setLock(lock);
		competitionTemplate.setCoolingPeriod(Period.ZERO);

	}

	@AfterClass
	private void destory() {
		hazelcastInstance.shutdown();
	}

	@Test
	public void execute() {
		CompetitionCallback competitionCallback = new CompetitionCallback() {
			@Override
			public void won(Date executeTime) {
				System.out.println("win");
			}
		};
		competitionTemplate.execute(competitionCallback);
		competitionTemplate.execute(competitionCallback);
	}
}
