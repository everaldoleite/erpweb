/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.nfe;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509KeyManager;

/**
 *
 * @author everaldo
 */
public class HSKeyManager implements X509KeyManager{

    private X509Certificate certificate;
    private PrivateKey privateKey;

    public HSKeyManager(X509Certificate certificate, PrivateKey privateKey) {
        this.certificate = certificate;
        this.privateKey = privateKey;
    }

    @Override
    public String chooseClientAlias(String[] arg0, Principal[] arg1, Socket arg2) {
        return this.certificate.getIssuerDN().getName();
    }

    @Override
    public String chooseServerAlias(String arg0, Principal[] arg1, Socket arg2) {
        return null;
    }

    @Override
    public X509Certificate[] getCertificateChain(String arg0) {
        return new X509Certificate[]{this.certificate};
    }

    @Override
    public String[] getClientAliases(String arg0, Principal[] arg1) {
        return new String[]{this.certificate.getIssuerDN().getName()};
    }

    @Override
    public PrivateKey getPrivateKey(String arg0) {
        return this.privateKey;
    }

    @Override
    public String[] getServerAliases(String arg0, Principal[] arg1) {
        return null;
    }

}
