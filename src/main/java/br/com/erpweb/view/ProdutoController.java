package br.com.erpweb.view;

import br.com.erpweb.persistence.entities.Grupo;
import br.com.erpweb.persistence.entities.Produto;
import br.com.erpweb.persistence.entities.RegimeTributario;
import br.com.erpweb.persistence.entities.SubGrupo;
import br.com.erpweb.persistence.entities.TipoTributacao;
import br.com.erpweb.view.util.JsfUtil;
import br.com.erpweb.view.util.PaginationHelper;
import br.com.erpweb.session.bean.ProdutoFacade;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
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

@Named("produtoController")
@SessionScoped
public class ProdutoController implements Serializable {

    private Produto current;
    private DataModel items = null;
    @EJB
    private br.com.erpweb.session.bean.ProdutoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    private List<TipoTributacao> listaTipoTributacao = null;
    private List<Grupo> listaGrupo = null;
    private List<SubGrupo> listaSubGrupo = null;
    private List<Produto> listaProduto = null;
    
    private String produto;

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
        return "erp_list_produto";
    }

    public String prepareView() {
        current = (Produto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Produto();
        selectedItemIndex = -1;
        return "erp_create_produto";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage("Produto Cadastrado com sucesso.");
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Produto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "erp_edit_produto";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage("Produto Atualizado com sucesso.");
            return "erp_list_produto";
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
        return "erp_list_produto";
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
            return "erp_list_produto";
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
        return "erp_list_produto";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "erp_list_produto";
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

    /**
     * @return the listaTipoTributacao
     */
    public List<TipoTributacao> getListaTipoTributacao() {
        return listaTipoTributacao;
    }

    /**
     * @param listaTipoTributacao the listaTipoTributacao to set
     */
    public void setListaTipoTributacao(List<TipoTributacao> listaTipoTributacao) {
        this.listaTipoTributacao = listaTipoTributacao;
    }

    /**
     * @return the listaProduto
     */
    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    /**
     * @param listaProduto the listaProduto to set
     */
    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
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
        
        RegimeTributario idRegimeTributario = current.getIdRegimeTributario();
        
        Collection<TipoTributacao> tipoTributacao = idRegimeTributario.getTipoTributacaoCollection();

        listaTipoTributacao = new ArrayList<>();
        listaTipoTributacao.addAll(tipoTributacao);
        
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

      public void handleFileUpload(FileUploadEvent event) {

        UploadedFile file = event.getFile();

        byte[] dados = null;

        try {
            dados = IOUtils.toByteArray(file.getInputstream());
        } catch (IOException ex) {

        }
        current.setImagem(dados);
    }

    public StreamedContent getImagem() throws FileNotFoundException {

        FacesContext context = FacesContext.getCurrentInstance();
        
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){

            return new DefaultStreamedContent();
            
        } else {
            
            String item_id = context.getExternalContext().getRequestParameterMap().get("item_id");
            Produto produto = (Produto) em.createNamedQuery("Produto.findByIdProduto").setParameter("idProduto", Integer.parseInt(item_id)).getSingleResult();
            
            if(produto.getImagem() != null){
                return new DefaultStreamedContent(new ByteArrayInputStream(produto.getImagem()));
            } else {
                return new DefaultStreamedContent();
            }
        }
    }
      
    
}
