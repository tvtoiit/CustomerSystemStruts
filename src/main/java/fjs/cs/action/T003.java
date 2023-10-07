package fjs.cs.action;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fjs.cs.dao.impl.T003DaoImp;
import fjs.cs.dto.mstcustomer;

public class T003 extends Action {
	private void updateCustomer(mstcustomer dto, T003DaoImp t003Dao) {
	    t003Dao.update(dto);
	}
	
	private void saveCustomer(mstcustomer dto, T003DaoImp t003Dao, BigDecimal loggedInPsnCd) {
	    t003Dao.save(dto, loggedInPsnCd);
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		mstcustomer t003Form = (mstcustomer)form;
		T003DaoImp t003Dao = new T003DaoImp();
		
		//Lấy dữ liệu từ form 
		BigDecimal customerId = t003Form.getCustomerId();
		String customerName = t003Form.getCustomerName();
		
		String sex = t003Form.getSex();
        String birthday = t003Form.getBirthDay();
        String email = t003Form.getEmail();
        String address = t003Form.getAddress();
        
        mstcustomer dto = new mstcustomer();
        String id = request.getParameter("id");
        if (id != null) {
        	dto = t003Dao.getCustomerById(Integer.parseInt(id));
        	request.setAttribute("dtoCustomerId", dto.getCustomerId());
			request.setAttribute("dtoCustomerName", dto.getCustomerName());
			request.setAttribute("dtoCustomerSex", dto.getSex());
			request.setAttribute("dtoCustomerBirthDay", dto.getBirthDay());
			request.setAttribute("dtoCustomerEmail", dto.getEmail());
			request.setAttribute("dtoCustomerAddress", dto.getAddress());
			return mapping.findForward("T003");
        }
        
        dto.setCustomerName(customerName);
	    
        dto.setSex(sex);
	    dto.setBirthDay(birthday);
	    dto.setEmail(email);
	    dto.setAddress(address);
        
	 // Lấy giá trị loggedInPsnCd từ session
	    HttpSession session = request.getSession();
	    BigDecimal loggedInPsnCd = (BigDecimal) session.getAttribute("loggedInPsnCd");
	    
        if (customerId != null) {
        	dto.setCustomerId(customerId);
        	updateCustomer(dto, t003Dao); 
        }else {
        	saveCustomer(dto, t003Dao,loggedInPsnCd);
        }
        return mapping.findForward("T002");
	}
}
