package com.sycompla.service.http;

import ac4y.base.http.Ac4yHttpService;
import ac4y.indicator.service.object.Ac4yIndicatorObjectService;
import ac4y.indicator.service.object.transfer.TransferRequest;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		//Object d2 = request.getRequestBody();

		return requestBody;

	} // getPostRequest

	public void main(String[] args) throws Exception {

		Ac4yIndicatorHttpService ac4yIndicatorHttpService =
			new Ac4yIndicatorHttpService(
					Integer.valueOf(args[0]) //new Ac4yTennisChampyHttpService().getPort()
			);

		HttpServer server =
			HttpServer.create(
				new InetSocketAddress(
						ac4yIndicatorHttpService.getPort()
				)
				,0
			);

		server.createContext("/transfer", ac4yIndicatorHttpService.new Transfer());

		server.setExecutor(null); // creates a default executor

		server.start();

	} // main

	class Transfer implements HttpHandler {

	    public void handle(HttpExchange exchange) throws IOException {

	    	exchange.getResponseHeaders().set(Constants.CONTENTTYPE, Constants.APPLICATIONJSON);

			try {

				String request = getPostRequest(exchange);

				LOG.info("\nrequest:\n"+request);

				String response =
						new Ac4yIndicatorObjectService().transfer(
							(TransferRequest) new TransferRequest().getFromJson(request)
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

	} // Transfer

} // Ac4yIndicatorHttpService
