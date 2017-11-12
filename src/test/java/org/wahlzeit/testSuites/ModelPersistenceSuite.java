package org.wahlzeit.testSuites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
})

public class ModelPersistenceSuite {
	/*
	 * do nothing
	 */
}
