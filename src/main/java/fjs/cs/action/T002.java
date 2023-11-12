package fjs.cs.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        mstcustomer t002Form = (mstcustomer) form;
        
        List<mstcustomer> listPaga = handleActions(request, t002Form, impT002);

        int pageSize = 15;
        
        int endPage = calculateEndPage(listPaga.size(), pageSize);
        int page = handlePagination(t002Form, listPaga, pageSize);
        
        List<mstcustomer> paginatedList = paginateList(listPaga, page, pageSize);
        t002Dto.setPageData(paginatedList);
        request.setAttribute("tag", page);
        request.setAttribute("endl", endPage);
        
        if (page == endPage) {
        	request.setAttribute("disBtnEndPage", endPage);
        }
        request.setAttribute("model", t002Dto);
        return mapping.findForward("successT002");
    }
    
    private int handlePagination(mstcustomer t002Form, List<mstcustomer> listPaga, int pageSize) {
        String currentPageStr = t002Form.getcurrentPage();
        int currentPage;
        if (currentPageStr != null && !currentPageStr.isEmpty()) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1; 
        }
        return getPage(currentPage, t002Form, calculateEndPage(listPaga.size(), pageSize));
    }
    
    private List<mstcustomer> handleActions(HttpServletRequest request, mstcustomer t002Form, T002DaoImp impT002) {
    	String action = t002Form.getAction();
    	if ("search".equals(action)) {
            return handleSearch(request, t002Form, impT002);
        } else if ("delete".equals(action)) {
            handleDelete(request, impT002, t002Form);
        }
        return impT002.getData();
    }
    
    private int getPage(int currentPage,  mstcustomer t002Form, int endPage) {
    	String pageAction = t002Form.getPageAction();
    	if ("first".equals(pageAction)) {
    		 return 1;
    	} else if ("previous".equals(pageAction)) {
            return Math.max(currentPage - 1, 1);
        } else if ("next".equals(pageAction)) {
            return Math.min(currentPage + 1, endPage);
        } else if ("last".equals(pageAction)) {
            return endPage;
        }
	    return currentPage;
	}

    private List<mstcustomer> handleSearch(HttpServletRequest request, mstcustomer t002Form, T002DaoImp impT002) {
        String name = t002Form.getTxtCustomerName();
       
        String sex = t002Form.getSex();
        request.setAttribute("sex", sex);
        String birthdayFrom = t002Form.getTxtBirthdayFromName();
        
        String birthdayTo = t002Form.getTxtBirthdayToName();
        if (birthdayTo != null && !isValidDateFormat(birthdayTo)) {
            // Nếu không đúng định dạng, hiển thị thông báo và không thực hiện tìm kiếm
            request.setAttribute("invalidDateFormat", true);
            return new ArrayList<>(); // Hoặc trả về null hoặc danh sách rỗng tùy thuộc vào yêu cầu của bạn
        }
        
        if (birthdayTo != null && birthdayFrom != null && !isStartDateBeforeEndDate(birthdayFrom, birthdayTo)) {
            // Nếu không, hiển thị thông báo và không thực hiện tìm kiếm
            request.setAttribute("invalidDateRange", true);
            return new ArrayList<>(); // Hoặc trả về null hoặc danh sách rỗng tùy thuộc vào yêu cầu của bạn
        }
        
        List<mstcustomer> resultSearch = impT002.getDataSearch(name, sex, birthdayFrom, birthdayTo);
        return resultSearch;
    }
    
    // Hàm kiểm tra định dạng ngày tháng "YYYY/MM/DD"
    private boolean isValidDateFormat(String date) {
        try {
            // Sử dụng SimpleDateFormat để kiểm tra định dạng
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            // Nếu có lỗi ParseException, định dạng không đúng
            return false;
        }
    }
    
 // Hàm kiểm tra xem ngày bắt đầu có nhỏ hơn ngày kết thúc hay không
    private boolean isStartDateBeforeEndDate(String startDate, String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
            return start.before(end);
        } catch (ParseException e) {
            // Nếu có lỗi ParseException, coi như không hợp lệ
            return false;
        }
    }
   
    private int calculateEndPage(int totalItems, int pageSize) {
        int endPage = totalItems / pageSize;
        if (totalItems % pageSize != 0) {
            endPage++;
        }
        return endPage;
    }

    private void handleDelete(HttpServletRequest request, T002DaoImp impT002, mstcustomer t002Form) {
        String[] selectedCustomerIds = t002Form.getSelectedCustomers();
        if (selectedCustomerIds != null) {
            impT002.deleteData(selectedCustomerIds);
        }
    }

    private List<mstcustomer> paginateList(List<mstcustomer> fullList, int page, int pageSize) {
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, fullList.size());
        return fullList.subList(startIndex, endIndex);
    }
}
