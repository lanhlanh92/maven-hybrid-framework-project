package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
@Sources({"file:src/main/environmentConfig/${server}.properties"})
public interface EnvironmentConfig extends Config {
	@Key("App.Url")
	String appUrl();
	
	@Key("App.User")
	String appUserName();
	
	@Key("App.Pass")
	String appPassword();
}
