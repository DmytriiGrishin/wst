
package ru.ifmo.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "IllegalQException", targetNamespace = "http://service.ifmo.ru/")
public class IllegalQException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ru.ifmo.client.SculptureServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public IllegalQException(String message, ru.ifmo.client.SculptureServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public IllegalQException(String message, ru.ifmo.client.SculptureServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.ifmo.client.SculptureServiceFault
     */
    public ru.ifmo.client.SculptureServiceFault getFaultInfo() {
        return faultInfo;
    }

}
