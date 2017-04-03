package giraffe.repository;


import giraffe.domain.GiraffeAuthority;
import org.springframework.stereotype.Repository;

/**
 * @author Olga Gushchyna
 * @version 0.0.1
 */
@Repository
public interface AuthorityRepository extends GiraffeRepository<GiraffeAuthority> {

    GiraffeAuthority findByRole(GiraffeAuthority.Role role);

}