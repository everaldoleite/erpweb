/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.nfe.util;

import br.com.erpweb.persistence.entities.NotaFiscal;
import br.com.erpweb.util.Util;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TEnderEmi;
import br.inf.portalfiscal.nfe.TEndereco;
import br.inf.portalfiscal.nfe.TNFe;
import br.inf.portalfiscal.nfe.TUf;
import br.inf.portalfiscal.nfe.TUfEmi;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author everaldo
 */
public class NFEUtil {

    public static void main(String args[]){
    
        try {
            TNFe result = getTNFe(new NotaFiscal());
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(NFEUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static TNFe getTNFe(NotaFiscal notaFiscal) throws FileNotFoundException, JAXBException, IOException {

        TNFe nfe = new TNFe();

        TNFe.InfNFe infNFe = new TNFe.InfNFe();
        infNFe.setIde(dadosIdentificacao(notaFiscal));
        infNFe.setEmit(dadosEmitente(notaFiscal));
        infNFe.setDest(dadosDestinatario(notaFiscal));
        infNFe.getDet().add(dadosProduto(notaFiscal));
        infNFe.setTotal(totalNFe(notaFiscal));
        infNFe.setTransp(dadosTransporte(notaFiscal));
        infNFe.setInfAdic(informacoesAdicionais(notaFiscal));

        infNFe.setId(gerarChaveNotaFiscal(notaFiscal));
        infNFe.setVersao("3.10");

        nfe.setInfNFe(infNFe);
        System.out.println("/home/everaldo/temp/notafiscal/geradas/" + infNFe.getId() + ".xml");
        converteObjetoParaXML(nfe, "/home/everaldo/temp/notafiscal/geradas/" + infNFe.getId() + ".xml");

        return nfe;

    }

    /**
     * B - Identificação da Nota Fiscal eletrônica
     *
     * @param notaFiscal
     * @return
     */
    public static TNFe.InfNFe.Ide dadosIdentificacao(NotaFiscal notaFiscal) {

        TNFe.InfNFe.Ide identificacao = new TNFe.InfNFe.Ide();

        // Substituir pelos dados da entidade NotaFiscal
        identificacao.setCUF("42");
        identificacao.setCNF("76523280");
        identificacao.setNatOp("5102");
        identificacao.setIndPag("0");
        identificacao.setMod("55");
        identificacao.setSerie("1");
        identificacao.setNNF("101");
        identificacao.setDhEmi("2011-04-16T00:00:00-00:00");
        identificacao.setDhSaiEnt("2011-04-16T00:00:00-00:00");
        identificacao.setTpNF("1");
        identificacao.setCMunFG("4202800");
        identificacao.setTpImp("2");
        identificacao.setTpEmis("1");
        identificacao.setCDV("0");
        identificacao.setTpAmb("2");
        identificacao.setFinNFe("1");
        identificacao.setProcEmi("0");
        identificacao.setVerProc("3.0");

        return identificacao;

    }

    /**
     * C - Identificação do Emitente da Nota Fiscal eletrônica
     *
     * @return
     */
    private static TNFe.InfNFe.Emit dadosEmitente(NotaFiscal notaFiscal) {

        TNFe.InfNFe.Emit emitente = new TNFe.InfNFe.Emit();
        emitente.setCNPJ("14031738000120");
        emitente.setXNome("ITO1 SERVICOS EM LTDA ME");
        emitente.setXFant("NF-e");
        emitente.setIE("144472121116");
        emitente.setCRT("3");

        TEnderEmi enderecoEmitente = new TEnderEmi();
        enderecoEmitente.setXLgr("AV DOUTOR ALTINO ARANTES");
        enderecoEmitente.setNro("205");
        enderecoEmitente.setXBairro("VILA CLEMENTINO");
        enderecoEmitente.setCMun("3550308");
        enderecoEmitente.setXMun("SAO PAULO");
        enderecoEmitente.setUF(TUfEmi.SP);
        enderecoEmitente.setCEP("04042031");
        enderecoEmitente.setCPais("1058");
        enderecoEmitente.setXPais("Brasil");

        emitente.setEnderEmit(enderecoEmitente);

        return emitente;
    }

    /**
     * E - Identificação do Destinatário da Nota Fiscal eletrônica
     *
     * @return
     */
    private static TNFe.InfNFe.Dest dadosDestinatario(NotaFiscal notaFiscal) {

        TNFe.InfNFe.Dest destinatario = new TNFe.InfNFe.Dest();
        destinatario.setCNPJ("99999999000191");
        destinatario.setXNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
        destinatario.setIE("144472121116");
        destinatario.setIndIEDest("1");
    
        TEndereco enderecoDestino = new TEndereco();
        enderecoDestino.setXLgr("RUA FABIA");
        enderecoDestino.setNro("653");
        enderecoDestino.setXBairro("VILA ROMANA");
        enderecoDestino.setCMun("3550308");
        enderecoDestino.setXMun("SAO PAULO");
        enderecoDestino.setUF(TUf.SP);
        enderecoDestino.setCEP("05051030");
        enderecoDestino.setCPais("1058");
        enderecoDestino.setXPais("BRASIL");
        enderecoDestino.setFone("1932011234");

        destinatario.setEnderDest(enderecoDestino);

        return destinatario;
    }

    /**
     * H - Detalhamento de Produtos e Serviços da NF-e I - Produtos e Serviços
     * da NF-e M - Tributos incidentes no Produto ou Serviço V - Informações
     * adicionais
     *
     * @return
     */
    private static TNFe.InfNFe.Det dadosProduto(NotaFiscal notaFiscal) {

        TNFe.InfNFe.Det detalheProduto = new TNFe.InfNFe.Det();
        detalheProduto.setNItem("1");

        TNFe.InfNFe.Det.Prod produto = new TNFe.InfNFe.Det.Prod();
        produto.setCProd("1010");
        produto.setCEAN("051254100000");
        produto.setXProd("PRODUTO 1010");
        produto.setNCM("84733049");
        produto.setCFOP("5102");
        produto.setUCom("PEC");
        produto.setQCom("1.0000");
        produto.setVUnCom("454.5500");
        produto.setVProd("1");
        produto.setCEANTrib("");
        produto.setUTrib("PEC");
        produto.setQTrib("1.0000");
        produto.setVUnTrib("454.5500");
        produto.setIndTot("0");

        detalheProduto.setProd(produto);

        TNFe.InfNFe.Det.Imposto imposto = new TNFe.InfNFe.Det.Imposto();
        detalheProduto.setImposto(imposto);

        TNFe.InfNFe.Det.Imposto.ICMS icms = new TNFe.InfNFe.Det.Imposto.ICMS();
        TNFe.InfNFe.Det.Imposto.ICMS.ICMS00 icms00 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMS00();
        icms00.setOrig("0");
        icms00.setCST("00");
        icms00.setModBC("3");
        icms00.setVBC("454.55");
        icms00.setPICMS("12.00");
        icms00.setVICMS("54.55");
        icms.setICMS00(icms00);

        detalheProduto.getImposto().getContent().add(new ObjectFactory().createTNFeInfNFeDetImpostoICMS(icms));

        TNFe.InfNFe.Det.Imposto.PIS pis = new TNFe.InfNFe.Det.Imposto.PIS();
        TNFe.InfNFe.Det.Imposto.PIS.PISAliq pISAliq = new TNFe.InfNFe.Det.Imposto.PIS.PISAliq();
        pISAliq.setCST("01");
        pISAliq.setVBC("454.55");
        pISAliq.setPPIS("1.65");
        pISAliq.setVPIS("7.50");
        pis.setPISAliq(pISAliq);

        detalheProduto.getImposto().getContent().add(new ObjectFactory().createTNFeInfNFeDetImpostoPIS(pis));

        TNFe.InfNFe.Det.Imposto.COFINS cofins = new TNFe.InfNFe.Det.Imposto.COFINS();
        TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq cOFINSAliq = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq();
        cOFINSAliq.setCST("01");
        cOFINSAliq.setVBC("454.55");
        cOFINSAliq.setPCOFINS("7.60");
        cOFINSAliq.setVCOFINS("34.55");
        cofins.setCOFINSAliq(cOFINSAliq);

        detalheProduto.getImposto().getContent().add(new ObjectFactory().createTNFeInfNFeDetImpostoICMS(icms));

        detalheProduto.setInfAdProd("Nota Fiscal Eletronica de Exemplo");

        return detalheProduto;
    }

    /**
     * W - Valores Totais da NF-e
     *
     * @return
     */
    private static TNFe.InfNFe.Total totalNFe(NotaFiscal notaFiscal) {

        TNFe.InfNFe.Total total = new TNFe.InfNFe.Total();
        TNFe.InfNFe.Total.ICMSTot icmst = new TNFe.InfNFe.Total.ICMSTot();
        icmst.setVBC("454.55");
        icmst.setVICMS("54.55");
        icmst.setVBCST("0.00");
        icmst.setVST("0.00");
        icmst.setVProd("454.55");
        icmst.setVFrete("0.00");
        icmst.setVSeg("0.00");
        icmst.setVDesc("0.00");
        icmst.setVII("0.00");
        icmst.setVIPI("0.00");
        icmst.setVPIS("7.50");
        icmst.setVCOFINS("34.55");
        icmst.setVOutro("0.00");
        icmst.setVNF("454.55");
        icmst.setVICMSDeson("0.00");

        total.setICMSTot(icmst);

        return total;
    }

    /**
     * X - Informações do Transporte da NF-e
     *
     * @return
     */
    private static TNFe.InfNFe.Transp dadosTransporte(NotaFiscal notaFiscal) {

        TNFe.InfNFe.Transp transporte = new TNFe.InfNFe.Transp();
        transporte.setModFrete("1");

        TNFe.InfNFe.Transp.Transporta transportadora = new TNFe.InfNFe.Transp.Transporta();
        transportadora.setCNPJ("34523233000123");
        transportadora.setXNome("JavaC - Java Communuty");
        transportadora.setIE("121212121");
        transportadora.setXEnder("AV. www.javac.com.br");
        transportadora.setXMun("Java");
        transportadora.setUF(TUf.valueOf("SC"));
        transporte.setTransporta(transportadora);

        TNFe.InfNFe.Transp.Vol volume = new TNFe.InfNFe.Transp.Vol();
        volume.setQVol("0");
        volume.setEsp("CX PAP");
        transporte.getVol().add(volume);

        return transporte;
    }

    /**
     * Z - Informações Adicionais da NF-e
     *
     * @return
     */
    private static TNFe.InfNFe.InfAdic informacoesAdicionais(NotaFiscal notaFiscal) {

        TNFe.InfNFe.InfAdic informacoesAdicionais = new TNFe.InfNFe.InfAdic();
        informacoesAdicionais.setInfCpl("Informacoes Adicionais da NF-e.");

        return informacoesAdicionais;
    }

    /**
     * Método que Converte o Objeto em String.
     *
     * @param consStatServ
     * @return
     * @throws JAXBException
     */
    private static void converteObjetoParaXML(TNFe nfe, String caminhoNotaFiscal) throws JAXBException, FileNotFoundException, IOException {

        JAXBContext context = JAXBContext.newInstance(TNFe.class);
        Marshaller marshaller = context.createMarshaller();
        JAXBElement<TNFe> element = new ObjectFactory().createNFe(nfe);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        marshaller.marshal(element, sw);

        String conteudo = sw.toString();
        conteudo = conteudo.replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" ", "");
        conteudo = conteudo.replaceAll("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");

        gravaArquivo(caminhoNotaFiscal, conteudo);

    }

    public static void gravaArquivo(String caminho, String conteudo) throws IOException {
        try (FileOutputStream file = new FileOutputStream(caminho)) {
            file.write(conteudo.getBytes());
            file.flush();
        }
    }

    private static String gerarChaveNotaFiscal(NotaFiscal notaFiscal) {

        StringBuilder chave = new StringBuilder();
        
        //Obter dados da empresa emitente.
        
        chave.append("NFe");
        chave.append("35");
        chave.append("1507");
        chave.append("14031738000120");
        chave.append("55");
        chave.append("001");
        chave.append("123456789");
        chave.append("1");
        chave.append("00000001");
        chave.append(Util.modulo11(chave.toString()));
        
        return chave.toString();
        
    }

}
