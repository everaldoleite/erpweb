package br.com.erpweb.view;

import br.com.erpweb.persistence.entities.Cliente;
import br.com.erpweb.persistence.entities.NotaFiscal;
import br.com.erpweb.persistence.entities.Titulos;
import br.com.erpweb.view.util.JsfUtil;
import br.com.erpweb.view.util.PaginationHelper;
import br.com.erpweb.session.bean.TitulosFacade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.PersistenceContext;

@Named("titulosController")
@SessionScoped
public class TitulosController implements Serializable {

    private Titulos current;
    private DataModel items = null;
    @EJB
    private br.com.erpweb.session.bean.TitulosFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    @PersistenceContext
    private EntityManager em;
    
    public TitulosController() {
    }

    public Titulos getSelected() {
        if (current == null) {
            current = new Titulos();
            selectedItemIndex = -1;
        }
        return current;
    }

    private TitulosFacade getFacade() {
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
        return "List";
    }

    public String prepareView() {
        current = (Titulos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Titulos();
        current.setDataEmissao(new Date());
        selectedItemIndex = -1;
        return "erp_create_titulo";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TitulosCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Titulos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TitulosUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Titulos) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TitulosDeleted"));
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
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Titulos getTitulos(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Titulos.class)
    public static class TitulosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TitulosController controller = (TitulosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "titulosController");
            return controller.getTitulos(getKey(value));
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
            if (object instanceof Titulos) {
                Titulos o = (Titulos) object;
                return getStringKey(o.getIdTitulo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Titulos.class.getName());
            }
        }

    }

    public void buscaNotaFiscal(){
        
        if (current.getIdCliente() != null){
            
            System.out.println(current.getIdCliente());
            
            List<NotaFiscal> notaFiscal = em.createNamedQuery("NotaFiscal.findByIdCliente")
                    .setParameter("idCliente", current.getIdCliente())
                    .setParameter("boletoEmitido", false)
                    .setParameter("geraCobranca", true)
                    .getResultList();
            
            if (notaFiscal.isEmpty()){
            
                NotaFiscal notaMentira = new NotaFiscal();
                notaMentira.setNumeroNota("1010");
                
                Cliente cliente = new Cliente();
                cliente.setRazaoSocial("CONFEITARIA LOTUS");
                notaMentira.setIdCliente(cliente);
                
                notaFiscal.add(notaMentira);
            
            }
            

            
        
        
        
        }
    
    }
    
}
