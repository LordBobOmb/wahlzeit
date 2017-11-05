import org.junit.runner.*;
import org.junit.runners.*;

//TestSuite that runs all other TestSuites

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.services.mailing.EmailServiceTest.class,
	org.wahlzeit.handlers.TellFriendTest.class,
	org.wahlzeit.model.AccessRightsTest.class,
	org.wahlzeit.model.CoordinateTest.class,
	org.wahlzeit.model.FlagReasonTest.class,
	org.wahlzeit.model.GenderTest.class,
	org.wahlzeit.model.GuestTest.class,
	org.wahlzeit.model.PhotoFilterTest.class,
	org.wahlzeit.model.TagsTest.class,
	org.wahlzeit.model.UserStatusTest.class,
	org.wahlzeit.model.ValueTest.class,
	org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
	org.wahlzeit.services.EmailAddressTest.class,
	org.wahlzeit.services.LogBuilderTest.class,
	org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider.class,
	org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider.class,
	org.wahlzeit.testEnvironmentProvider.SysConfigProvider.class,
	org.wahlzeit.testEnvironmentProvider.UserServiceProvider.class,
	org.wahlzeit.testEnvironmentProvider.UserSessionProvider.class,
	org.wahlzeit.testEnvironmentProvider.WebFormHandlerProvider.class,
	org.wahlzeit.utils.StringUtilTest.class,
	org.wahlzeit.utils.VersionTest.class
})

public class AllSuites {
	/*
	 * do nothing
	 */
}
