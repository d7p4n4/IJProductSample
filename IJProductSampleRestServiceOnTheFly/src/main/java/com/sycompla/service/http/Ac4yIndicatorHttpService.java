package com.sycompla.service.http;

import ac4y.base.http.Ac4yHttpService;
import ac4y.indicator.service.object.Ac4yIndicatorObjectService;
import ac4y.indicator.service.object.transfer.TransferRequest;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sycompla.composite.*;
import com.sycompla.object.user.UpdateByGuidRequest;
import com.sycompla.object.user.UserObjectService;
import com.sycompla.object.userToken.IsExistsByFbTokenRequest;
import com.sycompla.object.userToken.UserTokenObjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.stream.Collectors;

class Constants {

	static final String TEXTHTML = "text/html";
	static final String APPLICATIONJSON = "application/json";
	static final String CONTENTTYPE = "Content-Type";

} // Constants

public class Ac4yIndicatorHttpService extends Ac4yHttpService {

	private final Logger LOG = LogManager.getLogger(Ac4yIndicatorHttpService.class);

	public Ac4yIndicatorHttpService(int aPort) {
		setPort(aPort);
	}

	public Ac4yIndicatorHttpService() {
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

		Ac4yIndicatorHttpService ac4yIndicatorHttpService =
			new Ac4yIndicatorHttpService(
					Integer.valueOf(8002) //new Ac4yTennisChampyHttpService().getPort()
			);

		HttpServer server =
			HttpServer.create(
				new InetSocketAddress(
						ac4yIndicatorHttpService.getPort()
				)
				,0
			);

		server.createContext("/composite/isunknownorinvalidtoken", ac4yIndicatorHttpService.new IsUnknownOrInvalidToken());
		server.createContext("/composite/acceptauthentication", ac4yIndicatorHttpService.new AcceptAuthentication());
		server.createContext("/composite/signup", ac4yIndicatorHttpService.new SignUp());
		server.createContext("/composite/login", ac4yIndicatorHttpService.new LogIn());
		server.createContext("/composite/authentication", ac4yIndicatorHttpService.new Authentication());
		server.createContext("/composite/istokenexists", ac4yIndicatorHttpService.new IsTokenExists());
		server.createContext("/composite/updateuser", ac4yIndicatorHttpService.new UpdateUserByGuid());
		server.createContext("/composite/getuserfrombytoken", ac4yIndicatorHttpService.new GetUserFromByToken());
		server.createContext("/composite/getuserguidbytoken", ac4yIndicatorHttpService.new GetUserGuidByToken());

		server.setExecutor(null); // creates a default executor

		server.start();

	} // main

	class IsUnknownOrInvalidToken implements HttpHandler {

		public void handle(HttpExchange exchange) throws IOException {

	    	exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

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

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().acceptAuthentication(
								(AcceptAuthenticationRequest) new AcceptAuthenticationRequest().getFromJson(request)
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

	} // AcceptAuthentication

	class SignUp implements HttpHandler {

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

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

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new CompositeService().logIn(
								(LogInRequest) new LogInRequest().getFromJson(request)
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

	} // LogIn

	class Authentication implements HttpHandler {

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

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

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

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

		public void handle(HttpExchange exchange) throws IOException {

			exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

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

	public class GetUserFromByToken implements HttpHandler {

		public void handle(HttpExchange aHttpExchange) throws IOException {

			writeResponse(
					aHttpExchange
					, new CompositeService().getUserFromByToken(
							(GetUserFromByTokenRequest) new GetUserFromByTokenRequest().getFromJson(
									"{'fbToken': " + getParameterValue(aHttpExchange, "request") + "}"
							)
					).getAsJson()
			);

		} // handle

	} // GetUserFromByToken

	public class GetUserGuidByToken implements HttpHandler {

		public void handle(HttpExchange aHttpExchange) throws IOException {

			writeResponse(
					aHttpExchange
					, new CompositeService().getUserGuidByToken(
							(GetUserGuidByTokenRequest) new GetUserGuidByTokenRequest().getFromJson(
									getParameterValue(aHttpExchange, "request")
							)
					).getAsJson()
			);

		} // handle

	} // GetUserFromByToken

} // Ac4yIndicatorHttpService
