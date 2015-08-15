SELECT 
l.log_nome AS LOGRADOURO, 
b.bai_no AS BAIRRO, 
c.loc_no AS CIDADE, 
l.ufe_sg as UF, 
l.cep AS CEP, 
i.codigoIBGE AS CODIBGE FROM 
erpweb.log_logradouro l,
erpweb.log_bairro b, 
erpweb.log_localidade c, 
erpweb.MUNICIPIOS_IBGE i
where l.cep='08032360' and
b.bai_nu_sequencial = l.bai_nu_sequencial_ini and
c.loc_nu_sequencial = l.loc_nu_sequencial and
c.loc_no = i.municipio;