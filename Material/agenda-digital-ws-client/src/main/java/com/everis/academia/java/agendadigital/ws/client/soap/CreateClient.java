package com.everis.academia.java.agendadigital.ws.client.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.Holder;

import com.everis.academia.java.agendadigital.ws.client.soap.generated.BusinessException_Exception;
import com.everis.academia.java.agendadigital.ws.client.soap.generated.Cidade;
import com.everis.academia.java.agendadigital.ws.client.soap.generated.CidadeSOAP;
import com.everis.academia.java.agendadigital.ws.client.soap.generated.CidadeSOAPService;

public class CreateClient {

	public static void main(String[] args) throws MalformedURLException, BusinessException_Exception {
		URL url = new URL("http://localhost:8080/agenda-digital-web/soap/ClienteSOAP?wsdl");

		CidadeSOAPService service = new CidadeSOAPService(url);
		CidadeSOAP port = service.getCidadeSOAPPort();
		
		Cidade cidade = new Cidade();
		
		cidade.setNome("Lisboa");
		port.create(new Holder<Cidade>(cidade));

		cidade.setNome("Porto");
		port.create(new Holder<Cidade>(cidade));
		
		
	}

}
