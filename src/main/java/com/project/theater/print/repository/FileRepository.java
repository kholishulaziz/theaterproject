package com.project.theater.print.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.project.theater.print.domain.File;

/**
 * Created by Kholishul_A on 20/08/2018.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface FileRepository extends
		PagingAndSortingRepository<File, String> {

	@Query(value = "select f FROM File f, Transaction t WHERE f.id = t.fileId AND t.appId = ?1 AND t.status IN (0,1,2) ")
	Page<File> findRemaining(String appId, Pageable pageable);

}
