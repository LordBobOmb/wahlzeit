package org.wahlzeit.testSuites;
import org.junit.runner.*;
import org.junit.runners.*;

//TestSuite that runs all other TestSuites

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ServiceMailSuite.class,
	HandlersSuite.class,
	ModelSuite.class,
	TestEnvironmentSuite.class,
	ModelPersistenceSuite.class,
	ServicesSuite.class,
	UtilsSuite.class
})

public class AllSuites {
	/*
	 * do nothing
	 */
}
