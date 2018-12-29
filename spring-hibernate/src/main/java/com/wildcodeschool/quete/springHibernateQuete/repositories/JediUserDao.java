package com.wildcodeschool.quete.springHibernateQuete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.quete.springHibernateQuete.entities.JediUser;

@Repository
public interface JediUserDao extends JpaRepository<JediUser, Long> {

}
