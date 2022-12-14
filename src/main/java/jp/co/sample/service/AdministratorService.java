package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * @author kusakashiori
 *管理者情報を挿入するサービス
 */

@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository repository;
	
	public void insert(Administrator administrator) {
		repository.insert(administrator);
	}
	
	/**
	 * @author kusakashiori
	 *ログイン処理をするサービス
	 */
	public Administrator login(String mailAddress, String password) {
	 return repository.findByMailAddressAndPassword(mailAddress, password);
	}

}
