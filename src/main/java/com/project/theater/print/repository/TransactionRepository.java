package com.project.theater.print.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.project.theater.print.domain.Transaction;

/**
 * Created by Kholishul_A on 20/08/2018.
 */
@Repository
@RepositoryRestResource(exported = false)
public interface TransactionRepository extends
		PagingAndSortingRepository<Transaction, String> {

	Iterable<Transaction> findTop25ByAccountIdOrderByDateInDesc(String accountId);

	@Query("FROM Transaction t WHERE t.appId = ?1 AND t.status IN (0,1)")
	Page<Transaction> findRemaining(String appId, Pageable pageable);

	@Query("SELECT COUNT(*) FROM Transaction t WHERE t.status IN (0,1)")
	int getAllQueue();

	@Query("SELECT COUNT(*) FROM Transaction t WHERE t.appId = ?1 AND t.status IN (0,1)")
	int getQueue(String appId);

}
