package com.gisgraphy.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.gisgraphy.client.impl.HttpGisgraphyServer;
import org.junit.Ignore;

@ContextConfiguration(locations = { "classpath:/com/gisgraphy/client/tests/integration/appcontext.xml"})
@Ignore
public class AbstractGisgraphyClientIntegrationTestCase extends AbstractJUnit4SpringContextTests {
	@Autowired
	protected HttpGisgraphyServer httpGisgraphyServer;
	
	public AbstractGisgraphyClientIntegrationTestCase() {
		super();
	}
}
