package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/**
	 * @author kusakashiori
	 *従業員詳細ページで扶養人数を更新
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm updateEmployeeForm, BindingResult result, RedirectAttributes redirectAttributes,  Model model) {
		if(result.hasErrors()) {
			model.addAttribute("updateEmployeeForm", updateEmployeeForm);
			
			return showDetail(updateEmployeeForm.getId(), model);
		}
		String StId = updateEmployeeForm.getId();
		String StDepCount = updateEmployeeForm.getDependentsCount();
		Integer intId = Integer.parseInt(StId);
		Integer intDepCount = Integer.parseInt(StDepCount);
		Employee employee = employeeService.showDetail(intId);
		employee.setDependentsCount(intDepCount);
		
		
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}

}
