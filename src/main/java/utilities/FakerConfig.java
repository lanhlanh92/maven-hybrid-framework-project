package utilities;

import java.util.Locale;

import net.datafaker.Faker;
public class FakerConfig {
	Faker faker = new Faker(new Locale("en-US"));
	
	public static FakerConfig getFaker() {
		return new FakerConfig();
	}
	
	public String getFirstName() {
		return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
}
