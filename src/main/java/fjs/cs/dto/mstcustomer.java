package fjs.cs.dto;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class mstcustomer extends AbstractDto<mstcustomer> {
	private static final long serialVersionUID = 1L;
	private BigDecimal customerId;
	private String customerName;
	private String sex;
	private String birthDay;
	private String txtCustomerName;
	private String txtBirthdayFromName;
	private String txtBirthdayToName;
	private String email;
	private String address;
	private String action;
	private String pageAction;
	private String currentPage;
	private String[] selectedCustomers;
	
	public mstcustomer() {
		
	}
	
	public mstcustomer(String txtCustomerName, String txtBirthdayFromName, String  txtBirthdayToName, BigDecimal customerId, String customerName, String sex, String birthDay, String email, String address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.sex = sex;
		this.birthDay = birthDay;
		this.email = email;
		this.address = address;
	}
	
	public String getcurrentPage() {
		return currentPage;
	}

	public void setcurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageAction() {
		return pageAction;
	}

	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String[] getSelectedCustomers() {
		return selectedCustomers;
	}

	public void setSelectedCustomers(String[] selectedCustomers) {
		this.selectedCustomers = selectedCustomers;
	}

	public String getTxtCustomerName() {
		return txtCustomerName;
	}

	public void setTxtCustomerName(String txtCustomerName) {
		this.txtCustomerName = txtCustomerName;
	}

	public String getTxtBirthdayFromName() {
		return txtBirthdayFromName;
	}

	public void setTxtBirthdayFromName(String txtBirthdayFromName) {
		this.txtBirthdayFromName = txtBirthdayFromName;
	}

	public String getTxtBirthdayToName() {
		return txtBirthdayToName;
	}

	public void setTxtBirthdayToName(String txtBirthdayToName) {
		this.txtBirthdayToName = txtBirthdayToName;
	}

	public BigDecimal getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//		ActionErrors errors = new ActionErrors();
//		if (customerId == null) {
//			errors.add("customerId", new ActionMessage("error.required.customerId"));
//		} 
//		if (customerName == null || customerName.trim().isEmpty()) {
//			errors.add("customerName", new ActionMessage("error.required.customerName"));
//		}
//		if (sex == null || sex.trim().isEmpty()) {
//			errors.add("sex", new ActionMessage("error.required.sex"));
//		}
//		if (birthDay == null || birthDay.trim().isEmpty()) {
//			errors.add("birthDay", new ActionMessage("error.required.birthDay"));
//		}
//		if (email == null || email.trim().isEmpty()) {
//			errors.add("email", new ActionMessage("error.required.email"));
//		}
//		if (address == null || address.trim().isEmpty()) {
//			errors.add("address", new ActionMessage("error.required.address"));
//		}
//		request.setAttribute("errors", errors);
//		return errors;
		return super.validate(mapping, request);
	}
}
