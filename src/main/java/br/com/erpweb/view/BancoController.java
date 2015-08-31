package br.com.erpweb.view;

import br.com.erpweb.persistence.entities.Banco;
import br.com.erpweb.view.util.JsfUtil;
import br.com.erpweb.view.util.PaginationHelper;
import br.com.erpweb.session.bean.BancoFacade;
import java.io.ByteArrayInputStream;
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
import javax.faces.event.PhaseId;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named("bancoController")
@SessionScoped
public class BancoController implements Serializable {

    private Banco current;
    private DataModel items = null;
    @EJB
    private br.com.erpweb.session.bean.BancoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    @PersistenceContext
    private EntityManager em;
    
    public BancoController() {
    }

    public Banco getSelected() {
        if (current == null) {
            current = new Banco();
            selectedItemIndex = -1;
        }
        return current;
    }

    private BancoFacade getFacade() {
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
        return "erp_list_banco";
    }

    public String prepareView() {
        current = (Banco) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Banco();
        selectedItemIndex = -1;
        return "erp_create_banco";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage("Banco cadastrado com sucesso.");
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Operação não foi completada.");
            return null;
        }
    }

    public String prepareEdit() {
        current = (Banco) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "erp_edit_banco";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage("Banco atualizado com sucesso");
            return "erp_list_banco";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Banco) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("BancoDeleted"));
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
        return "erp_list_banco";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "erp_list_banco";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Banco getBanco(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Banco.class)
    public static class BancoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BancoController controller = (BancoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bancoController");
            return controller.getBanco(getKey(value));
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
            if (object instanceof Banco) {
                Banco o = (Banco) object;
                return getStringKey(o.getIdBanco());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Banco.class.getName());
            }
        }

    }

    public List<Banco> getData() {
        return ejbFacade.findAll();
    }

    public void handleFileUpload(FileUploadEvent event) {

        UploadedFile file = event.getFile();

        byte[] dados = null;

        try {
            dados = IOUtils.toByteArray(file.getInputstream());
        } catch (IOException ex) {

        }
        current.setImagem(dados);
    }

    public StreamedContent getImagem() {

        FacesContext context = FacesContext.getCurrentInstance();
        
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){

            return new DefaultStreamedContent();
            
        } else {
            
            String item_id = context.getExternalContext().getRequestParameterMap().get("item_id");
            Banco banco  = (Banco) em.createNamedQuery("Banco.findByIdBanco").setParameter("idBanco", Integer.parseInt(item_id)).getSingleResult();
            
            if(banco.getImagem() != null){
                return new DefaultStreamedContent(new ByteArrayInputStream(banco.getImagem()));
            } else {
                return new DefaultStreamedContent();
            }
        
        }
        

    }

}
