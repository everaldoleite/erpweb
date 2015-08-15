package br.com.erpweb.test;

import br.com.erpweb.nfe.util.NFEUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AssinaturaNFE {

    private static final String C14N_TRANSFORM_METHOD = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    private static final String[] ELEMENTOS_ASSINAVEIS = new String[]{"infEvento", "infCanc", "infNFe", "infInut"};

    public static void main(String arg[]) throws Exception {

        String caminhoDoCertificadoDoCliente = "/home/everaldo/Downloads/8196100.pfx";
        String senhaDoCertificado = "1234";
        String pastaArquivo = "/home/everaldo/temp/notafiscal/assinadas/";

        String resultado = assinarDocumento(caminhoDoCertificadoDoCliente, senhaDoCertificado, "/home/everaldo/temp/notafiscal/geradas/NFe35150714031738000120550011234567891000000011.xml");

        NFEUtil.gravaArquivo(pastaArquivo + "NFe35150714031738000120550011234567891000000011-teste.xml", resultado);
        
    }

   
    public AssinaturaNFE() {
    }

    /**
     *
     * @param caminhoCertificado
     * @param senhaCertificado
     * @paaram senhaCertificado
     * @param caminhoArquivo
     * @return
     * @throws Exception
     */
    public static String assinarDocumento(String caminhoCertificado, String senhaCertificado, String caminhoArquivo) throws Exception {

        final KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream certificadoStream = new FileInputStream(new File(caminhoCertificado))) {
            keyStore.load(certificadoStream, senhaCertificado.toCharArray());
        }

        final KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(
                keyStore.aliases().nextElement(),
                new KeyStore.PasswordProtection(senhaCertificado.toCharArray()));

        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");

        final List<Transform> transforms = new ArrayList<>(2);
        transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        transforms.add(signatureFactory.newTransform(C14N_TRANSFORM_METHOD, (TransformParameterSpec) null));

        final KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        final X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList((X509Certificate) keyEntry.getCertificate()));
        final KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        final Document document = documentBuilderFactory.newDocumentBuilder().parse(new File(caminhoArquivo));

        for (final String elementoAssinavel : ELEMENTOS_ASSINAVEIS) {
            final NodeList elements = document.getElementsByTagName(elementoAssinavel);
            for (int i = 0; i < elements.getLength(); i++) {
                final Element element = (Element) elements.item(i);
                final String id = element.getAttribute("Id");
                element.setIdAttribute("Id", true);

                final Reference reference = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transforms, null, null);
                final SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));

                final XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
                signature.sign(new DOMSignContext(keyEntry.getPrivateKey(), element.getParentNode()));
            }
        }
        
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            final Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(outputStream));
            return outputStream.toString();
        }

    }

}
