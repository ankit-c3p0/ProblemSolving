package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HelloVertX extends AbstractVerticle {

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		// TODO Auto-generated method stub
		vertx.createHttpServer()
		.requestHandler(r -> {
			r.response().end("<h1> Hello VertX !!! </h1>");
		}).listen(8080, result -> {
			if(result.succeeded()) {
				startFuture.complete();
			} else {
				startFuture.fail(result.cause());
			}
		});
	}
}
