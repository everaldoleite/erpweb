/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.test;

import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeStatusServico2Stub;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.security.cert.X509Certificate;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author everaldo
 */
public class TesteWS {

    private final Logger LOGGER = LoggerFactory.getLogger(TesteWS.class);
    
    static String caminhoDoCertificadoDoCliente = "/home/everaldo/Downloads/8196100.pfx";
    static String senhaDoCertificado = "1234";
    static String arquivoCacertsGeradoTodosOsEstados = "/home/everaldo/NetBeansProjects/erpweb/erpweb/src/main/webapp/cacerts/NFEcacerts";

    public static void main(String[] args) throws FileNotFoundException, KeyStoreException {

      
        
        KeyStore ks = getKeyStore(caminhoDoCertificadoDoCliente, senhaDoCertificado);

        String alias = "";
        Enumeration<String> aliasesEnum = ks.aliases();
        while (aliasesEnum.hasMoreElements()) {
            alias = (String) aliasesEnum.nextElement();
            if (ks.isKeyEntry(alias)) {
                break;
            }
        }

        X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);

        PrivateKey privateKey = getPrivateKey(ks, alias, senhaDoCertificado);

        SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);
        socketFactoryDinamico.setFileCacerts(arquivoCacertsGeradoTodosOsEstados);

        Protocol protocol = new Protocol("https", socketFactoryDinamico, 443);
        Protocol.registerProtocol("https", protocol);

        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<consStatServ versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")
                .append("<tpAmb>2</tpAmb>")
                .append("<cUF>42</cUF>")
                .append("<xServ>STATUS</xServ>")
                .append("</consStatServ>");

        NfeStatusServico2Stub.NfeStatusServicoNF2Result resultado = getStatusSEFAZ(xml, "42", "3.10", "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx");
        System.out.println(resultado.getExtraElement().toString());

    }

    protected static NfeStatusServico2Stub.NfeStatusServicoNF2Result getStatusSEFAZ(StringBuilder xml, String codigoUF, String versaoDados, String urlStatusWebService) {

        OMElement ome = null;
        try {
            ome = AXIOMUtil.stringToOM(xml.toString());
        } catch (XMLStreamException e1) {
            e1.printStackTrace();
        }

        NfeStatusServico2Stub.NfeDadosMsg dadosMsg = new NfeStatusServico2Stub.NfeDadosMsg();
        dadosMsg.setExtraElement(ome);

        NfeStatusServico2Stub.NfeCabecMsg nfeCabecMsg = new NfeStatusServico2Stub.NfeCabecMsg();
        nfeCabecMsg.setCUF(codigoUF);
        nfeCabecMsg.setVersaoDados(versaoDados);

        NfeStatusServico2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeStatusServico2Stub.NfeCabecMsgE();
        nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);

        NfeStatusServico2Stub locator = null;
        NfeStatusServico2Stub.NfeStatusServicoNF2Result resultado = null;
        try {
            locator = new NfeStatusServico2Stub(urlStatusWebService);
            resultado = locator.nfeStatusServicoNF2(dadosMsg, nfeCabecMsgE);

        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return resultado;
    }

    private static KeyStore getKeyStore(String caminhoDoCertificadoDoCliente, String senhaDoCertificado) throws FileNotFoundException, KeyStoreException {
        InputStream entrada = new FileInputStream(caminhoDoCertificadoDoCliente);
        KeyStore ks = KeyStore.getInstance("pkcs12");
        try {
            try {
                ks.load(entrada, senhaDoCertificado.toCharArray());
            } catch (NoSuchAlgorithmException | CertificateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ks;
    }

    private static PrivateKey getPrivateKey(KeyStore ks, String alias, String senhaDoCertificado) throws KeyStoreException {
        PrivateKey privateKey = null;
        try {
            privateKey = (PrivateKey) ks.getKey(alias, senhaDoCertificado.toCharArray());
        } catch (UnrecoverableKeyException | NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return privateKey;
    }

}
