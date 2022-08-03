package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
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
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/toInsert")
	public String toInsert(InsertAdministratorForm insertAdministratorForm) {
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
		return "redirect:/";
	}
	/**
	 * @author kusakashiori
	 *ログイン用のメソッド
	 */
	@RequestMapping("/")
	public String toLogin(LoginForm loginForm) {
		return "administrator/login";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm loginForm, Model model) {
		Administrator administrator = service.login(loginForm.getMailAddress(), loginForm.getPassword());
		if(administrator == null) {
			String LoginErrorMessage = "メールアドレスまたはパスワードが不正です";
			model.addAttribute("LoginErrorMessage", LoginErrorMessage);
			return "administrator/login";
		} else {
			session.setAttribute("administratorName", administrator);
			return "forward:/employee/showList";
		}
	}
	
	/**
	 * @author kusakashiori
	 *ログアウトメソッド
	 */
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect/";
	}
	

}
