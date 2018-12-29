package com.wildcodeschool.quete.springHibernateQuete.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wildcodeschool.quete.springHibernateQuete.entities.JediUser;
import com.wildcodeschool.quete.springHibernateQuete.repositories.JediUserDao;

@Component
public class Outputter implements CommandLineRunner {
	
	private Logger LOG = LoggerFactory.getLogger("Jedi");
	
	@Autowired
	private JediUserDao jediUserDao;

	@Override
	public void run(String... args) throws Exception {
		LOG.info("*********************");
		LOG.info("Objects in DB : " + jediUserDao.count());
	
	
	//CREATE NEW JEDI
	
	JediUser jediuser1 = new JediUser("Aayla", "Secura");
	LOG.info("*****************");
	LOG.info(jediuser1 + " has been created !");
	jediUserDao.save(jediuser1);
	LOG.info(jediuser1 + " has been saved !");
	
	JediUser jediuser2 = new JediUser("Depa", "Billaba");
	LOG.info("*****************");
	LOG.info(jediuser2 + " has been created !");
	jediUserDao.save(jediuser2);
	LOG.info(jediuser2 + " has been saved !");
	
	//READ INFO
	
	JediUser tempJediUser = jediUserDao.findById(2L).get();
	 LOG.info("******************");
     LOG.info("Second Jedi's name is " + tempJediUser.getName());
     LOG.info("Second Jedi's surName is " + tempJediUser.getSurName());
	
     //UPDATE
 
     JediUser updateJedi = jediUserDao.findById(2L).get(); 
    	 updateJedi.setName("Leia");
    	 
    	 
    //DELETE
    	 
    jediUserDao.deleteById(2L);  
     }
     	
	}
