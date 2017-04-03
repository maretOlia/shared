package giraffe.repository;


import giraffe.domain.GiraffeEntity;
import giraffe.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author Olga Gushchyna
 * @version 0.0.1
 */
@Repository
public interface UserRepository extends GiraffeRepository<User> {

    User findByLoginAndStatus(String login, GiraffeEntity.Status status);

    User findBySocialIdAndSocialProviderAndStatus(String socialId, User.SocialProvider socialProvider, GiraffeEntity.Status status);

}
