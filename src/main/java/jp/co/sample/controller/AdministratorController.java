package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;



/**
 * @author kusakashiori
 *管理者のコントローラー
 */


@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService service;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm(InsertAdministratorForm insertAdministratorForm, Model model) {
		model.addAttribute("insertAdministratorForm", insertAdministratorForm);
		return insertAdministratorForm;
	}
	
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	/**
	 * @author kusakashiori
	 *管理者情報登録のメソッド
	 */
	
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm insertAdministratorForm, Model model) {
		Administrator administrator = new Administrator();
		administrator.setName(insertAdministratorForm.getName());
		administrator.setMailAddress(insertAdministratorForm.getMailAddress());
		administrator.setPassword(insertAdministratorForm.getPassword());
		service.insert(administrator);
		model.addAttribute("administrator", administrator);
		return "redirect://";
	}
	
	

}
