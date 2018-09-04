package com.project.theater.account;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.theater.TheaterProjectConst;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@Service("userDetailsService")
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Account account = findAccountByUsername(username);
		if (account == null) {
			throw new NoSuchElementException(
					TheaterProjectConst.ERROR_NOT_FOUND);
		}
		account.setLastLogin(new Date());
		userRepository.save(account);
		return account;
	}

	public Account createAccount(Account account) {
		if (findAccountByUsername(account.getUsername()) != null) {
			throw new DuplicateKeyException(TheaterProjectConst.ERROR_DUPLICATE);
		}
		return userRepository.save(account);
	}

	public Account findAccountByUsername(String username) {
		Account account = userRepository.findByUsername(username);
		if (account != null) {
			return account;
		}
		return null;
	}

}
