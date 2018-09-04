package com.project.theater.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Kholishul_A on 20/08/2018.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface AccountRepository extends CrudRepository<Account, String> {

	Account findByUsername(@Param("username") String username);

}
