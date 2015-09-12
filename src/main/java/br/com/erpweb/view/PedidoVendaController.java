package br.com.erpweb.view;

import br.com.erpweb.persistence.entities.ListaPrecoProdutos;
import br.com.erpweb.persistence.entities.PedidoVenda;
import br.com.erpweb.persistence.entities.Produto;
import br.com.erpweb.persistence.entities.ProdutosPedido;
import br.com.erpweb.view.util.JsfUtil;
import br.com.erpweb.view.util.PaginationHelper;
import br.com.erpweb.session.bean.PedidoVendaFacade;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
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

@Named("pedidoVendaController")
@SessionScoped
public class PedidoVendaController implements Serializable {

    private PedidoVenda current;
    private DataModel items = null;
    @EJB
    private br.com.erpweb.session.bean.PedidoVendaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    @PersistenceContext
    private EntityManager em;
    
    private ListaPrecoProdutos listaPrecoProdutos;
    
    private List<Produto> listaProduto = new ArrayList<>();
    
    private List<ProdutosPedido> listaProdutosPedido = new ArrayList<>();
    
    private String produtoBusca;

    public PedidoVendaController() {
    }

    public PedidoVenda getSelected() {
        if (current == null) {
            current = new PedidoVenda();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PedidoVendaFacade getFacade() {
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
        current = (PedidoVenda) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new PedidoVenda();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PedidoVendaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PedidoVenda) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PedidoVendaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (PedidoVenda) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PedidoVendaDeleted"));
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

    public PedidoVenda getPedidoVenda(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    /**
     * @return the produtoBusca
     */
    public String getProdutoBusca() {
        return produtoBusca;
    }

    /**
     * @param produtoBusca the produtoBusca to set
     */
    public void setProdutoBusca(String produtoBusca) {
        this.produtoBusca = produtoBusca;
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
     * @return the listaPrecoProdutos
     */
    public ListaPrecoProdutos getListaPrecoProdutos() {
        return listaPrecoProdutos;
    }

    /**
     * @param listaPrecoProdutos the listaPrecoProdutos to set
     */
    public void setListaPrecoProdutos(ListaPrecoProdutos listaPrecoProdutos) {
        this.listaPrecoProdutos = listaPrecoProdutos;
    }

    /**
     * @return the listaProdutosPedido
     */
    public List<ProdutosPedido> getListaProdutosPedido() {
        return listaProdutosPedido;
    }

    /**
     * @param listaProdutosPedido the listaProdutosPedido to set
     */
    public void setListaProdutosPedido(List<ProdutosPedido> listaProdutosPedido) {
        this.listaProdutosPedido = listaProdutosPedido;
    }

    @FacesConverter(forClass = PedidoVenda.class)
    public static class PedidoVendaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PedidoVendaController controller = (PedidoVendaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pedidoVendaController");
            return controller.getPedidoVenda(getKey(value));
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
            if (object instanceof PedidoVenda) {
                PedidoVenda o = (PedidoVenda) object;
                return getStringKey(o.getIdPedidoVenda());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PedidoVenda.class.getName());
            }
        }

    }

    public List<Produto> buscaProduto(){
    
        String param = current.getBuscaProduto();
        
        
        if (current.getIdCliente() != null){
        
            listaPrecoProdutos = current.getIdCliente().getIdListaPrecosProdutos();
        }
        
        if ( param != null && !param.isEmpty()){
        
            Collection<Produto> results = em.createNamedQuery("Produto.findByDescricaoProduto")
                    .setParameter("descricaoProduto", "%" + param + "%")
                    .getResultList();
            
            listaProduto = new ArrayList<>();
            
            listaProduto.addAll(results);
            
            return listaProduto;
            
        }
        
        return new ArrayList<>();
        
    }
    
    public void incluiProduto(Produto produto){
    
        int coeficiente1 = new Integer("1,25");

        BigDecimal temporario = new BigDecimal(coeficiente1);
        
        listaProduto = new ArrayList<>();
        
        ProdutosPedido produtosPedido = new ProdutosPedido();
        produtosPedido.setPrecoLista(produto.getPrecoCusto().multiply(temporario));

        listaProdutosPedido.add(produtosPedido);
        
        
    
    }
    
}
