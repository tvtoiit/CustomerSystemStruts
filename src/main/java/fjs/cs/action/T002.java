package fjs.cs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fjs.cs.dao.impl.T002DaoImp;
import fjs.cs.dto.mstcustomer;

public class T002 extends Action {
	mstcustomer t002Dto = new mstcustomer();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		T002DaoImp impT002 = new T002DaoImp();
		List<mstcustomer> result = impT002.getData();
		request.setAttribute("listData", result);
		showData(request, result);
		return mapping.findForward("successT002");
	}
	
	private void showData(HttpServletRequest req, List<mstcustomer> result) {
	    t002Dto.setPageData(result); 
	    req.setAttribute("model", t002Dto);
	    
	}
}
