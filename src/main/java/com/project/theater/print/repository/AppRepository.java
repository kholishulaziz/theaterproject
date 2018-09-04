package com.project.theater.print.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.project.theater.print.domain.App;

/**
 * Created by Kholishul_A on 20/08/2018.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface AppRepository extends CrudRepository<App, String> {

}
