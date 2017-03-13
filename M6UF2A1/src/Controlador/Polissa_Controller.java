/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Polissa;

/**
 *
 * @author Jaume
 */
public class Polissa_Controller {

    public void Insertar(Polissa a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
//        em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Polissa a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Polissa a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(a) ? a : em.merge(a));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Polissa Buscar(int id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");
//        Query query = em.createNamedQuery("Persona.personesPerCognom",Persona.class);
//        query.setParameter("nombre", "Jorge");
//        Persona p = (Persona) query.getSingleResult();
        Polissa a = (Polissa) em.find(Polissa.class, id);

        System.out.println("close");
        em.close();

        return a;
    }
    
    public List BUSCALLISTA(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per id de Client");
        Query query = em.createNamedQuery("cercaPolizasCliente", Polissa.class);
        query.setParameter("id", id);
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
        return lista;
}

    public Polissa BuscarPolissaClient(int id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");
        Query query = em.createNamedQuery("Polissa.findByTipus", Polissa.class);
        query.setParameter("idCliente", id);
        Polissa p = (Polissa) query.getSingleResult();
//        Polissa a = (Polissa) em.find(Polissa.class, id);

        System.out.println("close");
        em.close();

        return p;
    }

    public Polissa BuscarPolissaVehicle(int id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");
        Query query = em.createNamedQuery("Polissa.findVehicle", Polissa.class);
        query.setParameter("idVehicle", id);
        Polissa p = (Polissa) query.getSingleResult();
//        Polissa a = (Polissa) em.find(Polissa.class, id);

        System.out.println("close");
        em.close();

        return p;
    }
    
        public void EliminarPolissaClient(List lista) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        for (Object object : lista) {
            em.remove(em.contains(object) ? object : em.merge(object));
        }

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();

}
        

    public List<Polissa> BuscarPolissaVigents() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");
        Query query = em.createNamedQuery("Polissa.findVigente", Polissa.class);
        List<Polissa> p = (List<Polissa>) query.getResultList();
//        Polissa a = (Polissa) em.find(Polissa.class, id);

        System.out.println("close");
        em.close();

        return p;
    }

    public void Consulta() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Persona");
        List<Polissa> lista = (List<Polissa>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    public void imprimirLista(List<Polissa> lista) {
        System.out.println("Numero d'empleats= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirPolissa(Polissa u) {
        System.out.println(u);
    }
}
