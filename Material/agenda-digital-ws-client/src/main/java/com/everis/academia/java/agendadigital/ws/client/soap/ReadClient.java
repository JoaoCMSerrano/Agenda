package com.everis.academia.java.agendadigital.ws.client.soap;

import java.net.MalformedURLException;
import java.net.URL;

import com.everis.academia.java.agendadigital.ws.client.soap.generated.Cidade;
import com.everis.academia.java.agendadigital.ws.client.soap.generated.CidadeSOAP;
import com.everis.academia.java.agendadigital.ws.client.soap.generated.CidadeSOAPService;

public class SOAPmain {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/agenda-digital-web/soap/ClienteSOAP?wsdl");

		CidadeSOAPService service = new CidadeSOAPService(url);
		CidadeSOAP port = service.getCidadeSOAPPort();
		
		for (Cidade cidade : port.read()) {
			System.out.println(cidade.getNome());
		}
		
	}

}
