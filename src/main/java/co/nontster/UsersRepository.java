/**
 * 
 */
package co.nontster;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author nontster
 *
 */
public interface UsersRepository extends MongoRepository<Users, String> {
	 public Users findByUsername(String username);
}
