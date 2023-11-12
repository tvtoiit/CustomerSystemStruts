package fjs.cs.action;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fjs.cs.dao.impl.T001DaoImpl;
import fjs.cs.dto.mstuser;

public class T001 extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		mstuser myForm = (mstuser) form;
		HttpSession session = request.getSession();
		String user = myForm.getUserId();
		String pass = myForm.getPassWord();
		
		if (!isValidLogin(request,user, pass)) {
			ActionErrors errors = new ActionErrors();
			errors.add("login", new ActionMessage("message.error.user.not.exit"));
			request.setAttribute("userId", user);
			request.setAttribute("passWord", pass); 
			saveErrors(request, errors);
			return mapping.findForward("fail");
		}
		if (session != null) {
            session.invalidate();
        }
		return mapping.findForward("success");
	}

	private boolean isValidLogin(HttpServletRequest req ,String user, String pass) {
		T001DaoImpl imp = new T001DaoImpl();
		int resultLogin = imp.checkLogin(user, pass);
		if (resultLogin == 1) {
			mstuser ms = imp.getUserInfo(user, pass);
			HttpSession session = req.getSession();
			BigDecimal loggedInPsnCd = ms.getPsnCd();
			session.setAttribute("loggedInPsnCd", loggedInPsnCd);
			return true;
		}
		return false;
	}
}
