/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemaventas.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.sistemaventas.logic.Usuario;
import com.sistemaventas.logic.Producto;
import com.sistemaventas.logic.Venta;
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
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public VentaJpaController(){
        emf = Persistence.createEntityManagerFactory("sistemaVentasPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        if (venta.getProductos() == null) {
            venta.setProductos(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario vendedor = venta.getVendedor();
            if (vendedor != null) {
                vendedor = em.getReference(vendedor.getClass(), vendedor.getId());
                venta.setVendedor(vendedor);
            }
            List<Producto> attachedProductos = new ArrayList<Producto>();
            for (Producto productosProductoToAttach : venta.getProductos()) {
                productosProductoToAttach = em.getReference(productosProductoToAttach.getClass(), productosProductoToAttach.getId());
                attachedProductos.add(productosProductoToAttach);
            }
            venta.setProductos(attachedProductos);
            em.persist(venta);
            if (vendedor != null) {
                vendedor.getListaVentas().add(venta);
                vendedor = em.merge(vendedor);
            }
            for (Producto productosProducto : venta.getProductos()) {
                Venta oldVentaOfProductosProducto = productosProducto.getVenta();
                productosProducto.setVenta(venta);
                productosProducto = em.merge(productosProducto);
                if (oldVentaOfProductosProducto != null) {
                    oldVentaOfProductosProducto.getProductos().remove(productosProducto);
                    oldVentaOfProductosProducto = em.merge(oldVentaOfProductosProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getId());
            Usuario vendedorOld = persistentVenta.getVendedor();
            Usuario vendedorNew = venta.getVendedor();
            List<Producto> productosOld = persistentVenta.getProductos();
            List<Producto> productosNew = venta.getProductos();
            if (vendedorNew != null) {
                vendedorNew = em.getReference(vendedorNew.getClass(), vendedorNew.getId());
                venta.setVendedor(vendedorNew);
            }
            List<Producto> attachedProductosNew = new ArrayList<Producto>();
            for (Producto productosNewProductoToAttach : productosNew) {
                productosNewProductoToAttach = em.getReference(productosNewProductoToAttach.getClass(), productosNewProductoToAttach.getId());
                attachedProductosNew.add(productosNewProductoToAttach);
            }
            productosNew = attachedProductosNew;
            venta.setProductos(productosNew);
            venta = em.merge(venta);
            if (vendedorOld != null && !vendedorOld.equals(vendedorNew)) {
                vendedorOld.getListaVentas().remove(venta);
                vendedorOld = em.merge(vendedorOld);
            }
            if (vendedorNew != null && !vendedorNew.equals(vendedorOld)) {
                vendedorNew.getListaVentas().add(venta);
                vendedorNew = em.merge(vendedorNew);
            }
            for (Producto productosOldProducto : productosOld) {
                if (!productosNew.contains(productosOldProducto)) {
                    productosOldProducto.setVenta(null);
                    productosOldProducto = em.merge(productosOldProducto);
                }
            }
            for (Producto productosNewProducto : productosNew) {
                if (!productosOld.contains(productosNewProducto)) {
                    Venta oldVentaOfProductosNewProducto = productosNewProducto.getVenta();
                    productosNewProducto.setVenta(venta);
                    productosNewProducto = em.merge(productosNewProducto);
                    if (oldVentaOfProductosNewProducto != null && !oldVentaOfProductosNewProducto.equals(venta)) {
                        oldVentaOfProductosNewProducto.getProductos().remove(productosNewProducto);
                        oldVentaOfProductosNewProducto = em.merge(oldVentaOfProductosNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = venta.getId();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Usuario vendedor = venta.getVendedor();
            if (vendedor != null) {
                vendedor.getListaVentas().remove(venta);
                vendedor = em.merge(vendedor);
            }
            List<Producto> productos = venta.getProductos();
            for (Producto productosProducto : productos) {
                productosProducto.setVenta(null);
                productosProducto = em.merge(productosProducto);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
