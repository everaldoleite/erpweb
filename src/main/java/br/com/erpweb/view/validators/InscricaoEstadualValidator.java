/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erpweb.view.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author everaldo
 */
@FacesValidator("inscricaoEstadualValidator")
public class InscricaoEstadualValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String unidadeFederativa = (String) component.getAttributes().get("UF");
        String inscricaoEstadual = (String) value;

        if (!inscricaoEstadual.equals("")) {

            switch (unidadeFederativa) {
                case "AC":
                    validaIEAcre(inscricaoEstadual);
                    break;
                case "AL":
                    validaIEAlagoas(inscricaoEstadual);
                    break;
                case "AP":
                    validaIEAmapa(inscricaoEstadual);
                    break;
                case "AM":
                    validaIEAmazonas(inscricaoEstadual);
                    break;
                case "BA":
                    validaIEBahia(inscricaoEstadual);
                    break;
                case "CE":
                    validaIECeara(inscricaoEstadual);
                    break;
                case "ES":
                    validaIEEspiritoSanto(inscricaoEstadual);
                    break;
                case "GO":
                    validaIEGoias(inscricaoEstadual);
                    break;
                case "MA":
                    validaIEMaranhao(inscricaoEstadual);
                    break;
                case "MT":
                    validaIEMatoGrosso(inscricaoEstadual);
                    break;
                case "MS":
                    validaIEMatoGrossoSul(inscricaoEstadual);
                    break;
                case "MG":
                    validaIEMinasGerais(inscricaoEstadual);
                    break;
                case "PA":
                    validaIEPara(inscricaoEstadual);
                    break;
                case "PB":
                    validaIEParaiba(inscricaoEstadual);
                    break;
                case "PR":
                    validaIEParana(inscricaoEstadual);
                    break;
                case "PE":
                    validaIEPernambuco(inscricaoEstadual);
                    break;
                case "PI":
                    validaIEPiaui(inscricaoEstadual);
                    break;
                case "RJ":
                    validaIERioJaneiro(inscricaoEstadual);
                    break;
                case "RN":
                    validaIERioGrandeNorte(inscricaoEstadual);
                    break;
                case "RS":
                    validaIERioGrandeSul(inscricaoEstadual);
                    break;
                case "RO":
                    validaIERondonia(inscricaoEstadual);
                    break;
                case "RR":
                    validaIERoraima(inscricaoEstadual);
                    break;
                case "SC":
                    validaIESantaCatarina(inscricaoEstadual);
                    break;
                case "SP":
                    if (inscricaoEstadual.charAt(0) == 'P') {
                        inscricaoEstadual = "P" + inscricaoEstadual;
                    }
                    validaIESaoPaulo(inscricaoEstadual);
                    break;
                case "SE":
                    validaIESergipe(inscricaoEstadual);
                    break;
                case "TO":
                    validaIETocantins(inscricaoEstadual);
                    break;
                case "DF":
                    validaIEDistritoFederal(inscricaoEstadual);
                    break;
                default:
                    FacesMessage message = new FacesMessage();
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    message.setSummary("Inscricao Estadual Inválida");
                    throw new ValidatorException(message);

            }
        }
    }

    private void validaIEAcre(String ie) {

        boolean retorno = true;

        // Valida tamanho
        if (ie.length() != 13) {
            retorno = false;
        }

        //valida os dois primeiros digitos - devem ser iguais a 01 
        for (int i = 0; i < 2; i++) {
            if (Integer.parseInt(String.valueOf(ie.charAt(i))) != i) {
                retorno = false;
            }
        }

        int soma = 0;
        int pesoInicial = 4;
        int pesoFinal = 9;

        //calcula o primeiro digito 
        for (int i = 0; i < ie.length() - 2; i++) {
            if (i < 3) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicial;
                pesoInicial--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFinal;
                pesoFinal--;
            }
        }
        int d1 = 11 - (soma % 11);
        if (d1 == 10 || d1 == 11) {
            d1 = 0;
        }

        //calcula o segundo digito 
        soma = d1 * 2;
        pesoInicial = 5;
        pesoFinal = 9;
        for (int i = 0; i < ie.length() - 2; i++) {
            if (i < 4) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicial;
                pesoInicial--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFinal;
                pesoFinal--;
            }
        }

        int d2 = 11 - (soma % 11);
        if (d2 == 10 || d2 == 11) {
            d2 = 0;
        }

        //valida os digitos verificadores 
        String dv = d1 + "" + d2;
        if (!dv.equals(ie.substring(ie.length() - 2, ie.length()))) {
            retorno = false;
        }

        sendMessage(retorno);
    }

    private void sendMessage(boolean retorno) {
        if (retorno == false) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Inscricao Inválida");
            throw new ValidatorException(message);
        }
    }

    private void validaIEAlagoas(String ie) {

        boolean retorno = true;

        //valida quantidade de digitos 
        if (ie.length() != 9) {
            retorno = false;
        }

        //valida os dois primeiros digitos - deve ser iguais a 24 
        if (!ie.substring(0, 2).equals("24")) {
            retorno = false;
        }

        //valida o terceiro digito - deve ser 0,3,5,7,8 
        int[] digits = {0, 3, 5, 7, 8};
        boolean check = false;
        for (int i = 0; i < digits.length; i++) {
            if (Integer.parseInt(String.valueOf(ie.charAt(2))) == digits[i]) {
                check = true;
                break;
            }
        }
        if (!check) {
            retorno = false;
        }

        //calcula o digito verificador 
        int soma = 0;
        int peso = 9;
        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }
        int d = ((soma * 10) % 11);
        if (d == 10) {
            d = 0;
        }

        //valida o digito verificador 
        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEAmapa(String ie) {

        boolean retorno = true;

        //valida quantida de digitos
        if (ie.length() != 9) {
            retorno = false;
        }

        //verifica os dois primeiros digitos - deve ser igual 03 
        if (!ie.substring(0, 2).equals("03")) {
            retorno = false;
        }

        //calcula o digito verificador 
        int d1 = -1;
        int soma = -1;
        int peso = 9;

        //configura o valor do digito verificador e da soma de acordo com faixa das inscricoes
        long x = Long.parseLong(ie.substring(0, ie.length() - 1));
        if (x >= 3017001L && x <= 3019022L) {
            d1 = 1;
            soma = 9;
        } else if (x >= 3000001L && x <= 3017000L) {
            d1 = 0;
            soma = 5;
        } else if (x >= 3019023L) {
            d1 = 0;
            soma = 0;
        }

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        int d = 11 - ((soma % 11));
        if (d == 10) {
            d = 0;
        } else if (d == 11) {
            d = d1;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEAmazonas(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;
        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        if (soma < 11) {
            d = 11 - soma;
        } else if ((soma % 11) <= 1) {
            d = 0;
        } else {
            d = 11 - (soma % 11);
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEBahia(String ie) {

        boolean retorno = true;

        if (ie.length() != 8 && ie.length() != 9) {
            retorno = false;
        }

        int modulo = 10;
        int firstDigit = Integer.parseInt(String.valueOf(ie.charAt(ie.length() == 8 ? 0 : 1)));
        if (firstDigit == 6 || firstDigit == 7 || firstDigit == 9) {
            modulo = 11;
        }

        int d2;
        int soma = 0;
        int peso = ie.length() == 8 ? 7 : 8;

        for (int i = 0; i < ie.length() - 2; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        int resto = soma % modulo;

        if (resto == 0 || (modulo == 11 && resto == 1)) {
            d2 = 0;
        } else {
            d2 = modulo - resto;
        }

        int d1;
        soma = d2 * 2;
        peso = ie.length() == 8 ? 8 : 9;

        for (int i = 0; i < ie.length() - 2; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        resto = soma % modulo;

        if (resto == 0 || (modulo == 11 && resto == 1)) {
            d1 = 0;
        } else {
            d1 = modulo - resto;
        }

        String dv = d1 + "" + d2;
        if (!dv.equals(ie.substring(ie.length() - 2, ie.length()))) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIECeara(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if (d == 10 || d == 11) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }

        sendMessage(retorno);
    }

    private void validaIEEspiritoSanto(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d = -1;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        int resto = soma % 11;
        if (resto < 2) {
            d = 0;
        } else if (resto > 1) {
            d = 11 - resto;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEGoias(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        if (!"10".equals(ie.substring(0, 2))) {
            if (!"11".equals(ie.substring(0, 2))) {
                if (!"15".equals(ie.substring(0, 2))) {
                    retorno = false;
                }
            }
        }

        if (ie.substring(0, ie.length() - 1).equals("11094402")) {
            if (!ie.substring(ie.length() - 1, ie.length()).equals("0")) {
                if (!ie.substring(ie.length() - 1, ie.length()).equals("1")) {
                    retorno = false;
                }
            }

        } else {

            int soma = 0;
            int peso = 9;
            int d = -1;
            for (int i = 0; i < ie.length() - 1; i++) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
                peso--;
            }

            int resto = soma % 11;
            long faixaInicio = 10103105;
            long faixaFim = 10119997;
            long insc = Long.parseLong(ie.substring(0, ie.length() - 1));

            if (resto == 0) {
                d = 0;
            } else if (resto == 1) {
                if (insc >= faixaInicio && insc <= faixaFim) {
                    d = 1;
                } else {
                    d = 0;
                }
            } else if (resto != 0 && resto != 1) {
                d = 11 - resto;
            }

            String dv = d + "";
            if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
                retorno = false;
            }
        }
        sendMessage(retorno);
    }

    private void validaIEMaranhao(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        if (!ie.substring(0, 2).equals("12")) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if ((soma % 11) == 0 || (soma % 11) == 1) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEMatoGrosso(String ie) {

        boolean retorno = true;

        if (ie.length() != 11) {
            retorno = false;
        }

        int soma = 0;
        int pesoInicial = 3;
        int pesoFinal = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            if (i < 2) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicial;
                pesoInicial--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFinal;
                pesoFinal--;
            }
        }

        d = 11 - (soma % 11);
        if ((soma % 11) == 0 || (soma % 11) == 1) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);

    }

    private void validaIEMatoGrossoSul(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        if (!ie.substring(0, 2).equals("28")) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d = -1;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        int resto = soma % 11;
        int result = 11 - resto;
        if (resto == 0) {
            d = 0;
        } else if (resto > 0) {
            if (result > 9) {
                d = 0;
            } else if (result < 10) {
                d = result;
            }
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEMinasGerais(String ie) {

        boolean retorno = true;

        if (ie.length() != 13) {
            retorno = false;
        }

        String str = "";
        for (int i = 0; i < ie.length() - 2; i++) {
            if (Character.isDigit(ie.charAt(i))) {
                if (i == 3) {
                    str += "0";
                    str += ie.charAt(i);
                } else {
                    str += ie.charAt(i);
                }
            }
        }

        int soma = 0;
        int pesoInicio = 1;
        int pesoFim = 2;
        int d1;

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                int x = Integer.parseInt(String.valueOf(str.charAt(i))) * pesoInicio;
                String strX = Integer.toString(x);
                for (int j = 0; j < strX.length(); j++) {
                    soma += Integer.parseInt(String.valueOf(strX.charAt(j)));
                }
            } else {
                int y = Integer.parseInt(String.valueOf(str.charAt(i))) * pesoFim;
                String strY = Integer.toString(y);
                for (int j = 0; j < strY.length(); j++) {
                    soma += Integer.parseInt(String.valueOf(strY.charAt(j)));
                }
            }
        }

        int dezenaExata = soma;
        while (dezenaExata % 10 != 0) {
            dezenaExata++;
        }
        d1 = dezenaExata - soma;

        soma = d1 * 2;
        pesoInicio = 3;
        pesoFim = 11;
        int d2;

        soma = sumarizar(ie, soma, pesoInicio, pesoFim);

        d2 = 11 - (soma % 11);
        if ((soma % 11 == 0) || (soma % 11 == 1)) {
            d2 = 0;
        }

        String dv = d1 + "" + d2;
        if (!dv.equals(ie.substring(ie.length() - 2, ie.length()))) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    public int sumarizar(String ie, int soma, int pesoInicio, int pesoFim) throws NumberFormatException {
        for (int i = 0; i < ie.length() - 2; i++) {
            if (i < 2) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicio;
                pesoInicio--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFim;
                pesoFim--;
            }
        }
        return soma;
    }

    private void validaIEPara(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        if (!ie.substring(0, 2).equals("15")) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if ((soma % 11) == 0 || (soma % 11) == 1) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEParaiba(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if (d == 10 || d == 11) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }

        sendMessage(retorno);
    }

    private void validaIEParana(String ie) {

        boolean retorno = true;

        if (ie.length() != 10) {
            retorno = false;
        }

        int soma = 0;
        int pesoInicio = 3;
        int pesoFim = 7;
        int d1;

        soma = sumarizar(ie, soma, pesoInicio, pesoFim);

        d1 = 11 - (soma % 11);
        if ((soma % 11) == 0 || (soma % 11) == 1) {
            d1 = 0;
        }

        soma = d1 * 2;
        pesoInicio = 4;
        pesoFim = 7;
        int d2;

        for (int i = 0; i < ie.length() - 2; i++) {
            if (i < 3) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicio;
                pesoInicio--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFim;
                pesoFim--;
            }
        }

        d2 = 11 - (soma % 11);
        if ((soma % 11) == 0 || (soma % 11) == 1) {
            d2 = 0;
        }

        String dv = d1 + "" + d2;
        if (!dv.equals(ie.substring(ie.length() - 2, ie.length()))) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEPernambuco(String ie) {

        boolean retorno = true;

        if (ie.length() != 14) {
            retorno = false;
        }

        int soma = 0;
        int pesoInicio = 5;
        int pesoFim = 9;
        int d;

        sumarizar(ie, soma, pesoInicio, pesoFim);

        d = 11 - (soma % 11);
        if (d > 9) {
            d -= 10;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEPiaui(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if (d == 11 || d == 10) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }

        sendMessage(retorno);

    }

    private void validaIERioJaneiro(String ie) {

        boolean retorno = true;

        if (ie.length() != 8) {
            retorno = false;
        }

        int soma = 0;
        int peso = 7;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            if (i == 0) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * 2;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
                peso--;
            }
        }

        d = 11 - (soma % 11);
        if ((soma % 11) <= 1) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIERioGrandeNorte(String ie) {

        boolean retorno = true;

        if (ie.length() != 10 && ie.length() != 9) {
            retorno = false;
        }

        if (!ie.substring(0, 2).equals("20")) {
            retorno = false;
        }

        if (ie.length() == 9) {

            int soma = 0;
            int peso = 9;
            int d;

            for (int i = 0; i < ie.length() - 1; i++) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
                peso--;
            }

            d = ((soma * 10) % 11);
            if (d == 10) {
                d = 0;
            }

            String dv = d + "";
            if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
                retorno = false;
            }

        } else {

            int soma = 0;
            int peso = 10;
            int d;

            for (int i = 0; i < ie.length() - 1; i++) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
                peso--;
            }
            d = ((soma * 10) % 11);
            if (d == 10) {
                d = 0;
            }

            String dv = d + "";
            if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
                retorno = false;
            }
        }
        sendMessage(retorno);
    }

    private void validaIERioGrandeSul(String ie) {

        boolean retorno = true;

        if (ie.length() != 10) {
            retorno = false;
        }

        int soma = Integer.parseInt(String.valueOf(ie.charAt(0))) * 2;
        int peso = 9;
        int d;

        for (int i = 1; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if (d == 10 || d == 11) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIERondonia(String ie) {

        boolean retorno = true;

        if (ie.length() != 14) {
            retorno = false;
        }

        int soma = 0;
        int pesoInicio = 6;
        int pesoFim = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            if (i < 5) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicio;
                pesoInicio--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFim;
                pesoFim--;
            }
        }

        d = 11 - (soma % 11);
        if (d == 11 || d == 10) {
            d -= 10;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIERoraima(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        if (!ie.substring(0, 2).equals("24")) {
            retorno = false;
        }

        int soma = 0;
        int peso = 1;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso++;
        }

        d = soma % 9;

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIESantaCatarina(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if ((soma % 11) == 0 || (soma % 11) == 1) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIESaoPaulo(String ie) {

        boolean retorno = true;

        if (ie.length() != 12 && ie.length() != 13) {
            retorno = false;
        }

        if (ie.length() == 12) {

            int soma = 0;
            int peso = 1;
            int d1;

            for (int i = 0; i < ie.length() - 4; i++) {
                if (i == 1 || i == 7) {
                    soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * ++peso;
                    peso++;
                } else {
                    soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
                    peso++;
                }
            }

            d1 = soma % 11;
            String strD1 = Integer.toString(d1);
            d1 = Integer.parseInt(String.valueOf(strD1.charAt(strD1.length() - 1)));

            soma = 0;
            int pesoInicio = 3;
            int pesoFim = 10;
            int d2;

            for (int i = 0; i < ie.length() - 1; i++) {
                if (i < 2) {
                    soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicio;
                    pesoInicio--;
                } else {
                    soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFim;
                    pesoFim--;
                }
            }

            d2 = soma % 11;
            String strD2 = Integer.toString(d2);
            d2 = Integer.parseInt(String.valueOf(strD2.charAt(strD2.length() - 1)));

            if (!ie.substring(8, 9).equals(d1 + "")) {
                retorno = false;
            }
            if (!ie.substring(11, 12).equals(d2 + "")) {
                retorno = false;
            }

        } else {

            if (ie.charAt(0) != 'P') {
                retorno = false;
            }

            String strIE = ie.substring(1, 10);
            int soma = 0;
            int peso = 1;
            int d1;

            for (int i = 0; i < strIE.length() - 1; i++) {
                if (i == 1 || i == 7) {
                    soma += Integer.parseInt(String.valueOf(strIE.charAt(i))) * ++peso;
                    peso++;
                } else {
                    soma += Integer.parseInt(String.valueOf(strIE.charAt(i))) * peso;
                    peso++;
                }
            }

            d1 = soma % 11;
            String strD1 = Integer.toString(d1);
            d1 = Integer.parseInt(String.valueOf(strD1.charAt(strD1.length() - 1)));

            if (!ie.substring(9, 10).equals(d1 + "")) {
                retorno = false;
            }
        }
        sendMessage(retorno);
    }

    private void validaIESergipe(String ie) {

        boolean retorno = true;

        if (ie.length() != 9) {
            retorno = false;
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
            peso--;
        }

        d = 11 - (soma % 11);
        if (d == 11 || d == 11 || d == 10) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIETocantins(String ie) {

        boolean retorno = true;

        if (ie.length() != 9 && ie.length() != 11) {
            retorno = false;
        } else if (ie.length() == 9) {
            ie = ie.substring(0, 2) + "02" + ie.substring(2);
        }

        int soma = 0;
        int peso = 9;
        int d;

        for (int i = 0; i < ie.length() - 1; i++) {
            if (i != 2 && i != 3) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * peso;
                peso--;
            }
        }
        d = 11 - (soma % 11);
        if ((soma % 11) < 2) {
            d = 0;
        }

        String dv = d + "";
        if (!ie.substring(ie.length() - 1, ie.length()).equals(dv)) {
            retorno = false;
        }
        sendMessage(retorno);
    }

    private void validaIEDistritoFederal(String ie) {

        boolean retorno = true;

        if (ie.length() != 13) {
            retorno = false;
        }

        int soma = 0;
        int pesoInicio = 4;
        int pesoFim = 9;
        int d1;

        for (int i = 0; i < ie.length() - 2; i++) {
            if (i < 3) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicio;
                pesoInicio--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFim;
                pesoFim--;
            }
        }

        d1 = 11 - (soma % 11);
        if (d1 == 11 || d1 == 10) {
            d1 = 0;
        }

        soma = d1 * 2;
        pesoInicio = 5;
        pesoFim = 9;
        int d2;

        for (int i = 0; i < ie.length() - 2; i++) {
            if (i < 4) {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoInicio;
                pesoInicio--;
            } else {
                soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * pesoFim;
                pesoFim--;
            }
        }

        d2 = 11 - (soma % 11);
        if (d2 == 11 || d2 == 10) {
            d2 = 0;
        }

        String dv = d1 + "" + d2;
        if (!dv.equals(ie.substring(ie.length() - 2, ie.length()))) {
            retorno = false;
        }
        sendMessage(retorno);
    }

}
