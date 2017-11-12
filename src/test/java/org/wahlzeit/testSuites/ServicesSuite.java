package org.wahlzeit.testSuites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.services.EmailAddressTest.class,
	org.wahlzeit.services.LogBuilderTest.class
})

public class ServicesSuite {
	/*
	 * do nothing
	 */
}
