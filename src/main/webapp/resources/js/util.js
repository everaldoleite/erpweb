/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------
//Funcao: MascaraMoeda
//Sinopse: Mascara de preenchimento de moeda
//Parametro:
//   objTextBox : Objeto (TextBox)
//   SeparadorMilesimo : Caracter separador de milésimos
//   SeparadorDecimal : Caracter separador de decimais
//   e : Evento
//Retorno: Booleano
//Autor: Gabriel Fróes - www.codigofonte.com.br
//-----------------------------------------------------
function MascaraMoeda(objTextBox, SeparadorMilesimo, SeparadorDecimal, e){
    //var sep = 0;
    var key = '';
    var i = j = 0;
    var len = len2 = 0;
    var strCheck = '0123456789';
    var aux = aux2 = '';
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;
    key = String.fromCharCode(whichCode); // Valor para o código da Chave
    if (strCheck.indexOf(key) == -1) return false; // Chave inválida
    len = objTextBox.value.length;
    for(i = 0; i < len; i++)
        if ((objTextBox.value.charAt(i) != '0') && (objTextBox.value.charAt(i) != SeparadorDecimal)) break;
    aux = '';
    for(; i < len; i++)
        if (strCheck.indexOf(objTextBox.value.charAt(i))!=-1) aux += objTextBox.value.charAt(i);
    aux += key;
    len = aux.length;
    if (len == 0) objTextBox.value = '';
    if (len == 1) objTextBox.value = '0'+ SeparadorDecimal + '0' + aux;
    if (len == 2) objTextBox.value = '0'+ SeparadorDecimal + aux;
    if (len > 2) {
        aux2 = '';
        for (j = 0, i = len - 3; i >= 0; i--) {
            if (j == 3) {
                aux2 += SeparadorMilesimo;
                j = 0;
            }
            aux2 += aux.charAt(i);
            j++;
        }
        objTextBox.value = '';
        len2 = aux2.length;
        for (i = len2 - 1; i >= 0; i--)
        objTextBox.value += aux2.charAt(i);
        objTextBox.value += SeparadorDecimal + aux.substr(len - 2, len);
    }
    return false;
}

function MascaraPeso(o,f){ 
    v_obj=o 
    v_fun=f
    setTimeout("execmascara()",1) 
} 

function execmascara(){ 
    v_obj.value=v_fun(v_obj.value) 
} 

function moeda(v){ 
    v=v.replace(/\D/g,""); // permite digitar apenas numero 
    v=v.replace(/(\d{1})(\d{16})$/,"$1.$2") // coloca ponto antes dos ultimos digitos 
    v=v.replace(/(\d{1})(\d{12})$/,"$1.$2") // coloca ponto antes dos ultimos 12 digitos 
    v=v.replace(/(\d{1})(\d{9})$/,"$1.$2") // coloca ponto antes dos ultimos 9 digitos 
    v=v.replace(/(\d{1})(\d{6})$/,"$1.$2") // coloca ponto antes dos ultimos 4 digitos 
    v=v.replace(/(\d{1})(\d{1,3})$/,"$1,$2") // coloca virgula antes dos ultimos 3 digitos 
    return v; 
}