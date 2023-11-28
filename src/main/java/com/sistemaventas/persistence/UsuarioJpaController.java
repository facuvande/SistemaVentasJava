/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemaventas.persistence;

import com.sistemaventas.logic.Usuario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public UsuarioJpaController(){
        emf = Persistence.createEntityManagerFactory("sistemaVentasPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getListaVentas() == null) {
            usuario.setListaVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : usuario.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getId());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            usuario.setListaVentas(attachedListaVentas);
            em.persist(usuario);
            for (Venta listaVentasVenta : usuario.getListaVentas()) {
                Usuario oldVendedorOfListaVentasVenta = listaVentasVenta.getVendedor();
                listaVentasVenta.setVendedor(usuario);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldVendedorOfListaVentasVenta != null) {
                    oldVendedorOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldVendedorOfListaVentasVenta = em.merge(oldVendedorOfListaVentasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            List<Venta> listaVentasOld = persistentUsuario.getListaVentas();
            List<Venta> listaVentasNew = usuario.getListaVentas();
            List<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getId());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            usuario.setListaVentas(listaVentasNew);
            usuario = em.merge(usuario);
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    listaVentasOldVenta.setVendedor(null);
                    listaVentasOldVenta = em.merge(listaVentasOldVenta);
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    Usuario oldVendedorOfListaVentasNewVenta = listaVentasNewVenta.getVendedor();
                    listaVentasNewVenta.setVendedor(usuario);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldVendedorOfListaVentasNewVenta != null && !oldVendedorOfListaVentasNewVenta.equals(usuario)) {
                        oldVendedorOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldVendedorOfListaVentasNewVenta = em.merge(oldVendedorOfListaVentasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Venta> listaVentas = usuario.getListaVentas();
            for (Venta listaVentasVenta : listaVentas) {
                listaVentasVenta.setVendedor(null);
                listaVentasVenta = em.merge(listaVentasVenta);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
