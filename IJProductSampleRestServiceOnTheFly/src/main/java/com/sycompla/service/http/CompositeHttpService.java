package com.sycompla.service.http;

import ac4y.base.http.Ac4yHttpService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sycompla.composite.*;
import com.sycompla.object.user.UpdateByGuidRequest;
import com.sycompla.object.user.UserObjectService;
import com.sycompla.object.userToken.IsExistsByFbTokenRequest;
import com.sycompla.object.userToken.UserTokenObjectService;
import okio.Utf8;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

class Constants {

	static final String TEXTHTML = "text/html";
	static final String APPLICATIONJSON = "application/json charset=UTF-8";
	static final String CONTENTTYPE = "Content-Type";

} // Constants

public class CompositeHttpService extends Ac4yHttpService {

	private final Logger LOG = LogManager.getLogger(CompositeHttpService.class);

	public CompositeHttpService(int aPort) {
		setPort(aPort);
	}

	public CompositeHttpService() {
	}

	private int port = 8002;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPostRequest(HttpExchange request) throws IOException {

		String requestBody =
				new BufferedReader(
						new InputStreamReader(
								request.getRequestBody()
						)
				)
						.lines()
						.collect(
								Collectors.joining("\n")
						);

		return requestBody;

	} // getPostRequest

	public static void main(String[] args) throws Exception {

		CompositeHttpService compositeHttpService =
			new CompositeHttpService(
					Integer.valueOf(args[0]) //new Ac4yTennisChampyHttpService().getPort()
			);

		HttpServer server =
			HttpServer.create(
				new InetSocketAddress(
						compositeHttpService.getPort()
				)
				,0
			);

		server.createContext("/composite/isunknownorinvalidtoken", compositeHttpService.new IsUnknownOrInvalidToken());
		server.createContext("/composite/acceptauthentication", compositeHttpService.new AcceptAuthentication());
		server.createContext("/composite/signup", compositeHttpService.new SignUp());
		server.createContext("/composite/login", compositeHttpService.new LogIn());
		server.createContext("/composite/authentication", compositeHttpService.new Authentication());
		server.createContext("/composite/istokenexists", compositeHttpService.new IsTokenExists());
		server.createContext("/composite/updateuser", compositeHttpService.new UpdateUserByGuid());
		server.createContext("/composite/getuserfrombytoken", compositeHttpService.new GetUserFromByToken());
		server.createContext("/composite/getuserguidbytoken", compositeHttpService.new GetUserGuidByToken());

		server.setExecutor(null); // creates a default executor

		server.start();

	} // main

	class IsUnknownOrInvalidToken implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

	    	exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().isUnknownOrInvalidToken(
							(IsUnknownOrInvalidTokenRequest) new IsUnknownOrInvalidTokenRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // IsUnknownOrInvalidToken

	class AcceptAuthentication implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().acceptAuthentication(
								(AcceptAuthenticationRequest) new AcceptAuthenticationRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				System.out.println(response.length());

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // AcceptAuthentication

	class SignUp implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().signUp(
								(SignUpRequest) new SignUpRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // SignUp

	class LogIn implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().logIn(
								(LogInRequest) new LogInRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n" + response);

				System.out.println(Utf8.size(response));

				System.out.println(response.length());

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // LogIn

	class Authentication implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().authentication(
								(AuthenticationRequest) new AuthenticationRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // Authentication

	class IsTokenExists implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new UserTokenObjectService().isExistsByFbToken(
								(IsExistsByFbTokenRequest) new IsExistsByFbTokenRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // IsTokenExists

	class UpdateUserByGuid implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new UserObjectService().updateByGuid(
								(UpdateByGuidRequest) new UpdateByGuidRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // UpdateUserByGuid

	class GetUserFromByToken implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().getUserFromByToken(
								(GetUserFromByTokenRequest) new GetUserFromByTokenRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // GetUserFromByToken

	class GetUserGuidByToken implements HttpHandler {

		public void writeResponse(HttpExchange httpExchange, String response) throws IOException {

			httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

			OutputStream os = httpExchange.getResponseBody();

			os.write(response.getBytes(StandardCharsets.UTF_8), 0, response.getBytes(StandardCharsets.UTF_8).length);

			os.close();

		} // writeResponse

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);
			exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
			exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "*");
			exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().getUserGuidByToken(
								(GetUserGuidByTokenRequest) new GetUserGuidByTokenRequest().getFromJson(request)
						).getAsJson();

				LOG.info("\nresponse:\n"+response);

				writeResponse(
						exchange
						,response
				);

			} catch (Exception e) {
				e.printStackTrace();
				writeResponse(
						exchange
						,"{\"error\":\""+e.getLocalizedMessage()+"\"}"
				);
			}
		} // handle

	} // GetUserFromByToken

} // Ac4yIndicatorHttpService
