package com.twitter.developer.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvReader {

	private static Properties properties = new Properties();

	static {
		InputStream is = EnvReader.class.getClassLoader().getResourceAsStream( "env.properties" );
		try {
			properties.load( is );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static String getBaseUri() {
		return properties.getProperty( "baseUri" );
	}
	public static String getBasePath() {
		return properties.getProperty( "basePath" );
	}

	public static String getApiKey() {
		return properties.getProperty( "apikey" );
	}
	public static String getApiSecretKey() {
		return properties.getProperty( "apisecretkey" );
	}


	public static String getAccessToken() {
		return properties.getProperty( "accesstoken" );
	}

	public static String getAccessSecretToken() {
		return properties.getProperty( "accesssecrettoken" );
	}

}
