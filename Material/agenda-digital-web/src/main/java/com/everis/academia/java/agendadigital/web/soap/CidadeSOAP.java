package com.everis.academia.java.agendadigital.web.soap;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.business.impl.CidadeBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService()
public class CidadeSOAP {

	private ICidadeBusiness business = new CidadeBusiness();

	@WebMethod(operationName = "create")
	@WebResult(name = "cidade")
	public Cidade create(
			@WebParam(name = "cidade", mode = Mode.IN) Cidade cidade)
			throws BusinessException {

		business.create(cidade);
		return cidade;
	}
	
	@WebMethod(operationName = "read")
	public Collection<Cidade> read(){
		return business.read();
	}
	
	@WebMethod(operationName = "update")
	@WebResult(name = "cidade")
	public Cidade update(@WebParam(name = "cidade") Cidade cidade) throws BusinessException {
		business.update(cidade);
		return cidade;
	}
	
	@WebMethod(operationName = "delete")
	public void delete(@WebParam(name = "cidade") Cidade cidade) {
		business.delete(cidade.getCodigo());
	}
}