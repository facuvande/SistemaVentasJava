/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemaventas.persistence;

import com.sistemaventas.logic.Pedido;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.sistemaventas.logic.Usuario;
import com.sistemaventas.logic.Producto;
import com.sistemaventas.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author facun
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PedidoJpaController(){
        emf = Persistence.createEntityManagerFactory("sistemaVentasPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        if (pedido.getProductos() == null) {
            pedido.setProductos(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario vendedor = pedido.getVendedor();
            if (vendedor != null) {
                vendedor = em.getReference(vendedor.getClass(), vendedor.getId());
                pedido.setVendedor(vendedor);
            }
            List<Producto> attachedProductos = new ArrayList<Producto>();
            for (Producto productosProductoToAttach : pedido.getProductos()) {
                productosProductoToAttach = em.getReference(productosProductoToAttach.getClass(), productosProductoToAttach.getId_producto());
                attachedProductos.add(productosProductoToAttach);
            }
            pedido.setProductos(attachedProductos);
            em.persist(pedido);
            if (vendedor != null) {
                vendedor.getPedidos().add(pedido);
                vendedor = em.merge(vendedor);
            }
            for (Producto productosProducto : pedido.getProductos()) {
                productosProducto.getPedidos().add(pedido);
                productosProducto = em.merge(productosProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getId_pedido());
            Usuario vendedorOld = persistentPedido.getVendedor();
            Usuario vendedorNew = pedido.getVendedor();
            List<Producto> productosOld = persistentPedido.getProductos();
            List<Producto> productosNew = pedido.getProductos();
            if (vendedorNew != null) {
                vendedorNew = em.getReference(vendedorNew.getClass(), vendedorNew.getId());
                pedido.setVendedor(vendedorNew);
            }
            List<Producto> attachedProductosNew = new ArrayList<Producto>();
            for (Producto productosNewProductoToAttach : productosNew) {
                productosNewProductoToAttach = em.getReference(productosNewProductoToAttach.getClass(), productosNewProductoToAttach.getId_producto());
                attachedProductosNew.add(productosNewProductoToAttach);
            }
            productosNew = attachedProductosNew;
            pedido.setProductos(productosNew);
            pedido = em.merge(pedido);
            if (vendedorOld != null && !vendedorOld.equals(vendedorNew)) {
                vendedorOld.getPedidos().remove(pedido);
                vendedorOld = em.merge(vendedorOld);
            }
            if (vendedorNew != null && !vendedorNew.equals(vendedorOld)) {
                vendedorNew.getPedidos().add(pedido);
                vendedorNew = em.merge(vendedorNew);
            }
            for (Producto productosOldProducto : productosOld) {
                if (!productosNew.contains(productosOldProducto)) {
                    productosOldProducto.getPedidos().remove(pedido);
                    productosOldProducto = em.merge(productosOldProducto);
                }
            }
            for (Producto productosNewProducto : productosNew) {
                if (!productosOld.contains(productosNewProducto)) {
                    productosNewProducto.getPedidos().add(pedido);
                    productosNewProducto = em.merge(productosNewProducto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pedido.getId_pedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getId_pedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            Usuario vendedor = pedido.getVendedor();
            if (vendedor != null) {
                vendedor.getPedidos().remove(pedido);
                vendedor = em.merge(vendedor);
            }
            List<Producto> productos = pedido.getProductos();
            for (Producto productosProducto : productos) {
                productosProducto.getPedidos().remove(pedido);
                productosProducto = em.merge(productosProducto);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pedido findPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
