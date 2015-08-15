/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.nfe.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 *
 * @author everaldo
 */
@XmlRegistry
public class ObjectFactory {
    
    private final static QName _RetConsStatServ_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "retConsStatServ");
    private final static QName _ConsStatServ_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "consStatServ");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.caelum.stella.nfe.xsd.schema.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TRetConsStatServ }
     * 
     */
    public TRetConsStatServ createTRetConsStatServ() {
        return new TRetConsStatServ();
    }

    /**
     * Create an instance of {@link TConsStatServ }
     * 
     */
    public TConsStatServ createTConsStatServ() {
        return new TConsStatServ();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRetConsStatServ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "retConsStatServ")
    public JAXBElement<TRetConsStatServ> createRetConsStatServ(TRetConsStatServ value) {
        return new JAXBElement<TRetConsStatServ>(_RetConsStatServ_QNAME, TRetConsStatServ.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TConsStatServ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "retConsStatServ")
    public JAXBElement<TConsStatServ> createConsStatServ(TConsStatServ value) {
        return new JAXBElement<TConsStatServ>(_ConsStatServ_QNAME, TConsStatServ.class, null, value);
    }

    
}
