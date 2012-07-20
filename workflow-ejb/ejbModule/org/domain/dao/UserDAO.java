package org.domain.dao;

import java.util.List;

import org.domain.model.User;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("userDao")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class UserDAO extends SeamDAO {
	private static final long serialVersionUID = 1L;
	
	public List<User> findAllByEmail(String email){
		return findByExample(new User(email,null,null));
	}
	public User findAuthenticate(String email, String encryptedPassword){
		List<User> users = findByExample(new User(email,encryptedPassword,null));
		if(users.size() == 1){
			return users.get(0);
		}else{
			return null;
		}
		
	}
}