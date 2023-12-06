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
import com.sistemaventas.logic.Pedido;
import com.sistemaventas.logic.Usuario;
import com.sistemaventas.persistence.exceptions.NonexistentEntityException;
import com.sistemaventas.persistence.exceptions.PreexistingEntityException;
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

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        if (usuario.getPedidos() == null) {
            usuario.setPedidos(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Pedido> attachedPedidos = new ArrayList<Pedido>();
            for (Pedido pedidosPedidoToAttach : usuario.getPedidos()) {
                pedidosPedidoToAttach = em.getReference(pedidosPedidoToAttach.getClass(), pedidosPedidoToAttach.getId_pedido());
                attachedPedidos.add(pedidosPedidoToAttach);
            }
            usuario.setPedidos(attachedPedidos);
            em.persist(usuario);
            for (Pedido pedidosPedido : usuario.getPedidos()) {
                Usuario oldVendedorOfPedidosPedido = pedidosPedido.getVendedor();
                pedidosPedido.setVendedor(usuario);
                pedidosPedido = em.merge(pedidosPedido);
                if (oldVendedorOfPedidosPedido != null) {
                    oldVendedorOfPedidosPedido.getPedidos().remove(pedidosPedido);
                    oldVendedorOfPedidosPedido = em.merge(oldVendedorOfPedidosPedido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getId()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
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
            List<Pedido> pedidosOld = persistentUsuario.getPedidos();
            List<Pedido> pedidosNew = usuario.getPedidos();
            List<Pedido> attachedPedidosNew = new ArrayList<Pedido>();
            for (Pedido pedidosNewPedidoToAttach : pedidosNew) {
                pedidosNewPedidoToAttach = em.getReference(pedidosNewPedidoToAttach.getClass(), pedidosNewPedidoToAttach.getId_pedido());
                attachedPedidosNew.add(pedidosNewPedidoToAttach);
            }
            pedidosNew = attachedPedidosNew;
            usuario.setPedidos(pedidosNew);
            usuario = em.merge(usuario);
            for (Pedido pedidosOldPedido : pedidosOld) {
                if (!pedidosNew.contains(pedidosOldPedido)) {
                    pedidosOldPedido.setVendedor(null);
                    pedidosOldPedido = em.merge(pedidosOldPedido);
                }
            }
            for (Pedido pedidosNewPedido : pedidosNew) {
                if (!pedidosOld.contains(pedidosNewPedido)) {
                    Usuario oldVendedorOfPedidosNewPedido = pedidosNewPedido.getVendedor();
                    pedidosNewPedido.setVendedor(usuario);
                    pedidosNewPedido = em.merge(pedidosNewPedido);
                    if (oldVendedorOfPedidosNewPedido != null && !oldVendedorOfPedidosNewPedido.equals(usuario)) {
                        oldVendedorOfPedidosNewPedido.getPedidos().remove(pedidosNewPedido);
                        oldVendedorOfPedidosNewPedido = em.merge(oldVendedorOfPedidosNewPedido);
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
            List<Pedido> pedidos = usuario.getPedidos();
            for (Pedido pedidosPedido : pedidos) {
                pedidosPedido.setVendedor(null);
                pedidosPedido = em.merge(pedidosPedido);
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
