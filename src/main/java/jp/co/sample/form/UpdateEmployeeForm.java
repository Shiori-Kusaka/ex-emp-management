package jp.co.sample.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author kusakashiori
 *従業員情報更新時に使用するフォーム
 */

public class UpdateEmployeeForm {
	private String id;
	@NotBlank(message = "入力は必須です")
	@Pattern(regexp = "^[0-9]*$", message ="半角数字で入力してください" )
	private String dependentsCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}
	
	

}
