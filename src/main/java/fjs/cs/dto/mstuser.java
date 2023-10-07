package fjs.cs.dto;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class mstuser extends AbstractDto<mstuser>{
	private static final long serialVersionUID = 1L;
	private BigDecimal psnCd;
	private String userId;
	private String passWord;
	private String userName;
	public mstuser() {
		
	}
	
	public mstuser(BigDecimal psnCd, String userId, String passWord, String userName) {
		this.psnCd = psnCd;
		this.userId = userId;
		this.passWord = passWord;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public BigDecimal getPsnCd() {
		return psnCd;
	}

	public void setPsnCd(BigDecimal psnCd) {
		this.psnCd = psnCd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		// Kiểm tra userId không được để trống
		if (userId == null || userId.trim().isEmpty()) {
	        errors.add("userId", new ActionMessage("error.required.userId"));
	    }
		
		// Kiểm tra passWord không được để trống
		if (passWord == null || passWord.trim().isEmpty()) {
	        errors.add("passWord", new ActionMessage("error.required.passWord"));
	    }
		request.setAttribute("errors", errors);
		return errors;
	}
}
	