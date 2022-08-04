package jp.co.sample.form;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

/**
 * @author kusakashiori
 *従業員情報更新時に使用するフォーム
 */

public class UpdateEmployeeForm {
	private String id;
	@NotBlank(message = "入力は必須です")
	@Pattern(regexp = "^[0-9]*$", message ="半角数字で入力してください" )
	private String dependentsCount;
	
	@Pattern(regexp="^[0-9]{3}-[0-9]{4}$", message = "郵便番号の形式で入力してください(ハイフンあり)")
	private String zipCode;
	private String address;
	
	@Pattern(regexp = "^[^ -~｡-ﾟ]*$", message = "全角文字で入力してください")
	private String name;
	private String gender;
	private Date hireDate;
	@Email(message = "Eメールの形式が不正です")
	private String mailAddress;
	@Pattern(regexp = "^0[-0-9]{11,12}$", message ="半角数字で入力してください(ハイフンあり)" )
	private String telephone;
	@Pattern(regexp = "^[0-9]*$", message ="半角数字で入力してください" )
	private Integer salary;
	private String characteristics;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + ", zipCode=" + zipCode
				+ ", address=" + address + ", name=" + name + ", gender=" + gender + ", hireDate=" + hireDate
				+ ", mailAddress=" + mailAddress + ", telephone=" + telephone + ", salary=" + salary
				+ ", characteristics=" + characteristics + "]";
	}
	
	
	

}
