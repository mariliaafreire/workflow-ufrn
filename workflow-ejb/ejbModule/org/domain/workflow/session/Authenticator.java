package org.domain.workflow.session;

import org.domain.dao.UserDAO;
import org.domain.model.User;
import org.domain.utils.BasicPasswordEncryptor;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Name("authenticator")
public class Authenticator
{
    @Logger private Log log;

    @In Identity identity;
    @In Credentials credentials;
    @In("userDao") UserDAO userDAO;
    @Out(required=false)
    User user;
    
    public boolean authenticate()
    {
        log.info("authenticating {0}", credentials.getUsername());
        user = userDAO.findAuthenticate(credentials.getUsername(),  new BasicPasswordEncryptor().encryptPassword(credentials.getPassword()));
        if (user != null)
        {
            return true;
        }
        return false;
    }
    
    public String logout(){
    	user=null;
    	identity.logout();
    	
    	return "/index.html";
    }
}
