package com.management.project.dao.hibernate;

import com.management.project.dao.SkillDAO;
import com.management.project.models.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 *  * The class implements a set of methods for working with database including Hibernate framework, with Skill entity

 * @author Вадим
 */
public class HibSkillDao implements SkillDAO{


    private SessionFactory sessionFactory;

    public HibSkillDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Skill obj) {
        Long id;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            id = (Long) session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public Skill findById(Long aLong) {
        Skill skill;
        try(Session session = sessionFactory.openSession()){
            skill = session.get(Skill.class,aLong);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return skill;
    }

    @Override
    public void update(Skill obj) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Skill skillToUpdate = session.get(Skill.class,obj.getId());
            skillToUpdate.setName(obj.getName());
            session.update(skillToUpdate);
            session.getTransaction().commit();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Skill obj) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Skill skillToDelete = session.get(Skill.class,obj.getId());
            session.delete(skillToDelete);
            session.getTransaction().commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Skill> findAll() {
        try (Session session = sessionFactory.openSession()){
            return   session.createQuery("from Skill").list();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Skill findByName(String name) {
        try(Session session = sessionFactory.openSession()){
            return (Skill) session.createQuery("from Skill s where s.name like :name")
                    .setParameter("name",name).uniqueResult();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
