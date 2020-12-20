package project.ssibam.SuhangProject.repository;

import project.ssibam.SuhangProject.domain.PoemNightMember;

import javax.persistence.EntityManager;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class JPAPoemRepository implements PoemRepository{
    private EntityManager em;

    public JPAPoemRepository(EntityManager em) { this.em = em; }

    @Override
    public PoemNightMember save(PoemNightMember pm) {
        em.persist(pm);
        return null;
    }

    @Override
    public PoemNightMember findById(int id) {
        PoemNightMember pm = em.find(PoemNightMember.class, id);
        return null;
    }

    @Override
    public ArrayList<PoemNightMember> findByTitle(String title) {
        ArrayList<PoemNightMember> list = (ArrayList)em.createQuery("select pm from PoemNightMember pm where pm.title = :title order by pm.id desc", PoemNightMember.class).setParameter("title",title).getResultList();
        return list;
    }

    @Override
    public ArrayList<PoemNightMember> findByAuthor(String author) {
        ArrayList<PoemNightMember> list = (ArrayList)em.createQuery("select pm from PoemNightMember pm where pm.author = :author order by pm.id desc", PoemNightMember.class).setParameter("author",author).getResultList();
        return list;
    }

    @Override
    public ArrayList<PoemNightMember> findAll() {
        return (ArrayList)em.createQuery("select pm from PoemNightMember pm", PoemNightMember.class).getResultList();
    }

    /*@Override
    public void updateContents(PoemNightMember poemNightMember) {
        poemNightMember.
    }*/

    @Override
    public void deletePoem(PoemNightMember poemNightMember) {
        em.remove(poemNightMember);
    }
}
