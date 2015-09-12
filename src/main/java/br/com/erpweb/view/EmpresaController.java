package br.com.erpweb.view;

import br.com.erpweb.persistence.entities.Empresa;
import br.com.erpweb.persistence.entities.LogLocalidade;
import br.com.erpweb.persistence.entities.LogLogradouro;
import br.com.erpweb.persistence.entities.MunicipiosIbge;
import br.com.erpweb.view.util.JsfUtil;
import br.com.erpweb.view.util.PaginationHelper;
import br.com.erpweb.session.bean.EmpresaFacade;
import br.com.erpweb.util.Util;
import java.io.IOException;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.apache.commons.io.IOUtils;

@Named("empresaController")
@SessionScoped
public class EmpresaController implements Serializable {

    private Empresa current;
    private DataModel items = null;
    @EJB
    private br.com.erpweb.session.bean.EmpresaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    private boolean pessoaFisica = false;
    private boolean pessoaJuridica = false;

    private static int MAX_DIGIT_CEP = 8;
    private String mascara = "99.999.999/999-99";

    @PersistenceContext
    private EntityManager em;

    public EmpresaController() {
    }

    public Empresa getSelected() {
        if (current == null) {
            current = new Empresa();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EmpresaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "erp_list_empresa";
    }

    public String prepareView() {
        current = (Empresa) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Empresa();
        selectedItemIndex = -1;
        return "erp_create_empresa";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmpresaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Empresa) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmpresaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Empresa) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmpresaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "erp_list_empresa";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "erp_list_empresa";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Empresa getEmpresa(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    /**
     * @return the pessoaFisica
     */
    public boolean isPessoaFisica() {
        return pessoaFisica;
    }

    /**
     * @param pessoaFisica the pessoaFisica to set
     */
    public void setPessoaFisica(boolean pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    /**
     * @return the pessoaJuridica
     */
    public boolean isPessoaJuridica() {
        return pessoaJuridica;
    }

    /**
     * @param pessoaJuridica the pessoaJuridica to set
     */
    public void setPessoaJuridica(boolean pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    /**
     * @return the mascara
     */
    public String getMascara() {
        return mascara;
    }

    /**
     * @param mascara the mascara to set
     */
    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

    @FacesConverter(forClass = Empresa.class)
    public static class EmpresaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpresaController controller = (EmpresaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empresaController");
            return controller.getEmpresa(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Empresa) {
                Empresa o = (Empresa) object;
                return getStringKey(o.getIdEMPRESA());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Empresa.class.getName());
            }
        }

    }

    public void atualizaMascaraIE() {

        if (current.getUfInscricaoEstadual() != null || current.getUfInscricaoEstadual().equals("")) {
            mascara = Util.getMascaraIE(current.getUfInscricaoEstadual());
}

    }

    public void atualizaTipoPessoa() {
        if (current.getTipoPessoa().equals('J')) {
            setPessoaJuridica(Boolean.TRUE);
            setPessoaFisica(Boolean.FALSE);
        } else {
            setPessoaJuridica(Boolean.FALSE);
            setPessoaFisica(Boolean.TRUE);
        }
    }

    public void buscaEnderecos() {

        LogLogradouro logLogradouro;
        MunicipiosIbge municipiosIbge;

        if (current.getCepEmpresa() != null && current.getCepEmpresa().length() == MAX_DIGIT_CEP) {

            try {

                logLogradouro = (LogLogradouro) em.createNamedQuery("LogLogradouro.findByCep")
                        .setParameter("cep", current.getCepEmpresa()).getSingleResult();

                current.setTipoLogradouro(logLogradouro.getLogTipoLogradouro().toUpperCase());
                current.setLogradouroEmpresa(logLogradouro.getLogNo().toUpperCase());
                current.setBairroEmpresa(logLogradouro.getBaiNuSequencialIni().getBaiNo().toUpperCase());
                current.setUfEmpresa(logLogradouro.getUfeSg().toUpperCase());
                current.setMunicipioEmpresa(logLogradouro.getLocNuSequencial().getLocNo().toUpperCase());
                
            } catch (NoResultException n) {

                current.setTipoLogradouro("");
                current.setLogradouroEmpresa("");
                current.setBairroEmpresa("");
                current.setUfEmpresa("");
                current.setMunicipioEmpresa("");
                current.setCodigoMunicipioIBGE("");

                try {

                    LogLocalidade logLocalidade = (LogLocalidade) em.createNamedQuery("LogLocalidade.findByCep")
                            .setParameter("cep", current.getCepEmpresa()).getSingleResult();

                    current.setTipoLogradouro(" -- ");
                    current.setLogradouroEmpresa(" -- ");
                    current.setBairroEmpresa(" -- ");
                    current.setUfEmpresa(logLocalidade.getUfeSg().getUfeSg().toUpperCase());
                    current.setMunicipioEmpresa(logLocalidade.getLocNo().toUpperCase());
                    
                    
                } catch (NoResultException nr) {

                    current.setTipoLogradouro("");
                    current.setLogradouroEmpresa("");
                    current.setBairroEmpresa("");
                    current.setUfEmpresa("");
                    current.setMunicipioEmpresa("");
                    current.setCodigoMunicipioIBGE("");

                    JsfUtil.addErrorMessage("Não foram encontrados registros com este parametro");

                }
            }

            if (current.getMunicipioEmpresa() != null) {

                try {

                    municipiosIbge = (MunicipiosIbge) em.createNamedQuery("MunicipiosIbge.findByCidadeIBGE")
                            .setParameter("cidadeIBGE", current.getMunicipioEmpresa()).getSingleResult();

                    current.setCodigoMunicipioIBGE(municipiosIbge.getCodigoIBGE());

                } catch (NonUniqueResultException uni){
                    
                    current.setCodigoMunicipioIBGE("");
            
                } catch (NoResultException nr) {

                    current.setCodigoMunicipioIBGE("");

                    JsfUtil.addErrorMessage("Não foram encontrados registros com este parametro");

                }
            }

        }

    }

    public void handleFileUpload(FileUploadEvent event) {

        UploadedFile file = event.getFile();

        byte[] dados = null;

        try {
            dados = IOUtils.toByteArray(file.getInputstream());
        } catch (IOException ex) {

        }
        current.setImagemEmpresa(dados);
    }

    public List<Empresa> getData(){
        return ejbFacade.findAll();
    }
    
}
