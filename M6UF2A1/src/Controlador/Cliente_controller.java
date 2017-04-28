/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author ALUMNEDAM
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jorge
 */
public class Cliente_controller {

    public void Insertar(Cliente cliente1) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
//        em.getTransaction().begin();
        EntityTransaction et = em.getTransaction();

        System.out.println("begin");
        et.begin();

        System.out.println("persist");
        em.persist(cliente1);

        System.out.println("commit");
        //em.getTransaction().commit();
        et.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Cliente c) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Cliente c) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(c) ? c : em.merge(c));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Cliente buscar(int DNI) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");
//        Query query = em.createNamedQuery("Persona.personesPerCognom",Persona.class);
//        query.setParameter("nombre", "Jorge");
//        Persona p = (Persona) query.getSingleResult();
        Cliente c = (Cliente) em.find(Cliente.class, DNI);

        System.out.println("close");
        em.close();

        return c;
    }

    public Cliente buscarPorNombre(String nombre) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");
        Query query = em.createNamedQuery("Cliente.findByNombre", Cliente.class);
        query.setParameter("nombre", nombre);
        Cliente c = (Cliente) query.getSingleResult();
//        Cliente c = (Cliente) em.find(Cliente.class, nombre);

        System.out.println("close");
        em.close();

        return c;
    }

    public void Consulta() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Persona");
        List<Cliente> lista = (List<Cliente>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    public Cliente obtenerPolissesClients(String nombre) {
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");
        Query query = em.createNamedQuery("Cliente.BuscarPolisses", Cliente.class);
        query.setParameter("nombre", nombre);
        Cliente c = (Cliente) query.getSingleResult();
        System.out.println("close");
        em.close();

        return c;
    }

    public void imprimirLista(List<Cliente> lista) {
        System.out.println("Numero d'empleats= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirCliente(Cliente c) {
        System.out.println(c);
    }
}
