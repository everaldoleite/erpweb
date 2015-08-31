package br.com.erpweb.view;

import br.com.erpweb.persistence.entities.Grupo;
import br.com.erpweb.persistence.entities.Produto;
import br.com.erpweb.persistence.entities.RegimeTributario;
import br.com.erpweb.persistence.entities.SubGrupo;
import br.com.erpweb.persistence.entities.TipoTributacao;
import br.com.erpweb.view.util.JsfUtil;
import br.com.erpweb.view.util.PaginationHelper;
import br.com.erpweb.session.bean.ProdutoFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("produtoController")
@SessionScoped
public class ProdutoController implements Serializable {

    private Produto current;
    private DataModel items = null;
    @EJB
    private br.com.erpweb.session.bean.ProdutoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    private List<TipoTributacao> tipoTributacao = null;
    private List<Grupo> listaGrupo = null;
    private List<SubGrupo> listaSubGrupo = null;

    @PersistenceContext
    private EntityManager em;
    
    public ProdutoController() {
    }

    public Produto getSelected() {
        if (current == null) {
            current = new Produto();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProdutoFacade getFacade() {
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
        current = (Produto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Produto();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProdutoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Produto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProdutoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Produto) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProdutoDeleted"));
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

    public Produto getProduto(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    /**
     * @return the tipoTributacao
     */
    public List<TipoTributacao> getTipoTributacao() {
        return tipoTributacao;
    }

    /**
     * @param tipoTributacao the tipoTributacao to set
     */
    public void setTipoTributacao(List<TipoTributacao> tipoTributacao) {
        this.tipoTributacao = tipoTributacao;
    }

    /**
     * @return the listaGrupo
     */
    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    /**
     * @param listaGrupo the listaGrupo to set
     */
    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    /**
     * @return the listaSubGrupo
     */
    public List<SubGrupo> getListaSubGrupo() {
        return listaSubGrupo;
    }

    /**
     * @param listaSubGrupo the listaSubGrupo to set
     */
    public void setListaSubGrupo(List<SubGrupo> listaSubGrupo) {
        this.listaSubGrupo = listaSubGrupo;
    }

    @FacesConverter(forClass = Produto.class)
    public static class ProdutoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProdutoController controller = (ProdutoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "produtoController");
            return controller.getProduto(getKey(value));
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
            if (object instanceof Produto) {
                Produto o = (Produto) object;
                return getStringKey(o.getIdProduto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Produto.class.getName());
            }
        }

    }

    public void lista(){

        RegimeTributario regimeTributario = (RegimeTributario) em.createNamedQuery("RegimeTributario.findByIdRegimeTributario")
                .setParameter("idRegimeTributario", Integer.parseInt(current.getIdRegimeTributario())).getSingleResult();
        
        List<TipoTributacao> lista = new ArrayList();
        lista.addAll(regimeTributario.getTipoTributacaoCollection());
        
        setTipoTributacao(lista);
        
    }
   
    public void atualizaGrupos(){

        Collection<Grupo> grupo = current.getIdCategoria().getGrupoCollection();
        
        listaSubGrupo = new ArrayList<>();
        
        listaGrupo = new ArrayList<>();
        listaGrupo.addAll(grupo);
        
    }
    
    
    public void atualizaSubGrupos(){

        Collection<SubGrupo> subGrupo = current.getIdGrupo().getSubGrupoCollection();
        
        listaSubGrupo = new ArrayList<>();
        listaSubGrupo.addAll(subGrupo);
        
        
    }
    
        
}
