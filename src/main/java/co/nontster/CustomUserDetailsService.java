package co.nontster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nontster
 *
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
        Users user = usersRepository.findByUsername(username);
         
		if (user != null) {
			String userName = user.getUsername();
			String password = user.getPassword();
			List<String> authorities = user.getAuthorities();
			
			logger.info(authorities.toString());

			MongoUserDetails mongoUserDetails = new MongoUserDetails(userName, password, authorities.toArray(new String[authorities.size()]));
			
			return mongoUserDetails;
		} else {
			throw new UsernameNotFoundException("username not found");
		}
	}
}
