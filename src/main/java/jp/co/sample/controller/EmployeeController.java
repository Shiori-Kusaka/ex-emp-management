package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * @author kusakashiori
	 *従業員一覧を表示するメソッド
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
	 List<Employee> employeeList = employeeService.showList();
	 model.addAttribute("employeeList", employeeList);
	 return "employee/list";
	}
	
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
	
	
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Integer intId = Integer.parseInt(id);
		Employee employee = employeeService.showDetail(intId);
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

}
