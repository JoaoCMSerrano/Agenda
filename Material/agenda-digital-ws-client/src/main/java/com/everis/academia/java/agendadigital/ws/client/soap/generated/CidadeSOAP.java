
package com.everis.academia.java.agendadigital.ws.client.soap.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CidadeSOAP", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CidadeSOAP {


    /**
     * 
     * @param cidade
     * @throws BusinessException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "update", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.UpdateResponse")
    @Action(input = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/updateRequest", output = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/updateResponse", fault = {
        @FaultAction(className = BusinessException_Exception.class, value = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/update/Fault/BusinessException")
    })
    public void update(
        @WebParam(name = "cidade", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Cidade> cidade)
        throws BusinessException_Exception
    ;

    /**
     * 
     * @param cidade
     */
    @WebMethod
    @RequestWrapper(localName = "delete", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.DeleteResponse")
    @Action(input = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/deleteRequest", output = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/deleteResponse")
    public void delete(
        @WebParam(name = "cidade", targetNamespace = "")
        Cidade cidade);

    /**
     * 
     * @return
     *     returns java.util.List<com.everis.academia.java.agendadigital.ws.client.soap.generated.Cidade>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "read", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.Read")
    @ResponseWrapper(localName = "readResponse", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.ReadResponse")
    @Action(input = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/readRequest", output = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/readResponse")
    public List<Cidade> read();

    /**
     * 
     * @param cidade
     * @throws BusinessException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "create", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://soap.web.agendadigital.java.academia.everis.com/", className = "com.everis.academia.java.agendadigital.ws.client.soap.generated.CreateResponse")
    @Action(input = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/createRequest", output = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/createResponse", fault = {
        @FaultAction(className = BusinessException_Exception.class, value = "http://soap.web.agendadigital.java.academia.everis.com/CidadeSOAP/create/Fault/BusinessException")
    })
    public void create(
        @WebParam(name = "cidade", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Cidade> cidade)
        throws BusinessException_Exception
    ;

}
