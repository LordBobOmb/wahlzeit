package org.wahlzeit.testSuites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.utils.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.utils.StringUtilTest.class,
	org.wahlzeit.utils.VersionTest.class
})

public class UtilsSuite {
	/*
	 * do nothing
	 */
}
