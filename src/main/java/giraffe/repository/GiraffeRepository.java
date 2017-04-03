package giraffe.repository;

import giraffe.domain.GiraffeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Olga Gushchyna
 * @version 0.0.1
 */
@NoRepositoryBean
public interface GiraffeRepository<T extends GiraffeEntity> extends CrudRepository<T, String>, JpaSpecificationExecutor<T> {

    @Query("select t from #{#entityName} t where t.uuid = ?1 and t.status = ?2")
    T findByUuidAndStatus(String uuid, GiraffeEntity.Status status);

}
