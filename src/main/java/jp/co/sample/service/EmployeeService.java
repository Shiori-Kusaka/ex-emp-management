package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;


@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * @author kusakashiori
	 *従業員一覧を表示するサービスメソッド
	 */
	public List<Employee> showList() {
		return employeeRepository.findAll();
	}
	
	/**
	 * @author kusakashiori
	 *従業員詳細ページを表示するサービスメソッド
	 */
	public Employee showDetail(Integer id) {
		return employeeRepository.load(id);
	}

}
