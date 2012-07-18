package org.domain.initializer;

import org.domain.dao.SeamDAO;
import org.domain.model.User;
import org.domain.utils.BasicPasswordEncryptor;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;

@Name("seed")
@Install(precedence = Install.APPLICATION)
public class Seed {
	@In("seamDao") SeamDAO seamDao;
	
	@Observer("org.jboss.seam.postInitialization")
	public void popula() {
		User u = new User("gustavosizilio@gmail.com", new BasicPasswordEncryptor().encryptPassword("admin"), "Gustavo Sizílio Nery");
		seamDao.persist(u);
	}

}
