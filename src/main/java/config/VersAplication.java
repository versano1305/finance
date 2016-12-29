package config;

import java.util.Map;
import java.util.logging.Logger;

import com.sun.jersey.api.core.ResourceConfig;

public class VersAplication extends ResourceConfig {

	
	public VersAplication(){
	    // Jackson JSON marshalling

	}

	@Override
	public boolean getFeature(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Boolean> getFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
