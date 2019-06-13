package vertx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.impl.BodyReadStream;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;

@RunWith(VertxUnitRunner.class)
public class HelloVertXTest {

	private Vertx vertx;
	
	@Before
	public void setup(TestContext context) {
		
		vertx =Vertx.vertx();
		vertx.deployVerticle(HelloVertX.class.getName(),
				context.asyncAssertSuccess());
	}
	
	@After
	public void tearDown(TestContext context) {
		vertx.close(context.asyncAssertSuccess());
	}
	
	@Test
	public void testMyApp(TestContext context) {
		
		final Async async = context.async();
		
		vertx.createHttpClient().getNow(8080, "localhost", "/", 
				response -> {
					response.handler(b -> {
						context.assertTrue(b.toString().contains("Hello VertX"));
					async.complete();
					});
				});
	}
}
