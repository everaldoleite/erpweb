package br.com.erpweb.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

public class ValidadeCertificadoDigitalA1 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {

        try {
            String caminhoDoCertificadoDoCliente = "/home/everaldo/Downloads/8196100.pfx";
            String senhaDoCertificadoDoCliente = "1234";

            KeyStore keystore = KeyStore.getInstance(("PKCS12"));
            keystore.load(new FileInputStream(caminhoDoCertificadoDoCliente), senhaDoCertificadoDoCliente.toCharArray());

            Enumeration<String> eAliases = keystore.aliases();

            while (eAliases.hasMoreElements()) {
                String alias = (String) eAliases.nextElement();
                Certificate certificado = (Certificate) keystore.getCertificate(alias);

                info("Alias: " + alias);
                X509Certificate cert = (X509Certificate) certificado;

                info(cert.getSubjectDN().getName());
                info("Válido a partir de..: " + dateFormat.format(cert.getNotBefore()));
                info("Válido até..........: " + dateFormat.format(cert.getNotAfter()));
            }
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            error(e.toString());
        }
    }

    /**
     * Error.
     *
     * @param log
     */
    private static void error(String log) {
        System.out.println("ERROR: " + log);
    }

    /**
     * Info
     *
     * @param log
     */
    private static void info(String log) {
        System.out.println("INFO: " + log);
    }

}
