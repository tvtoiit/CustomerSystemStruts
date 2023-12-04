package fjs.cs.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fjs.cs.dao.impl.T002DaoImp;
import fjs.cs.dto.ImportForm;
import fjs.cs.dto.mstcustomer;

public class Import extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		ImportForm importForm = (ImportForm)form;
        HttpSession session = request.getSession();
        String header[] = importForm.getSettingHeader();
        
        //Bấm nut save 
        
        String sMode = importForm.getsMode();
        if ("right".equals(sMode)) {
        	String listRightSubmit[] = importForm.getListRight();
        	String[] listHeader = new String[] {"1", "2", "3", "4", "5", "6"};
        	
        	List<String> filteredListRightSubmit = new ArrayList<>();
        	for (String value : listRightSubmit) {
        	    for (String headerItem : listHeader) {
        	        if (!value.equals(headerItem)) {
        	        	 filteredListRightSubmit.add(headerItem);
        	        }
        	    }
        	}

        	listRightSubmit = filteredListRightSubmit.toArray(new String[0]);
        }
        String settingHeaderLeft[] = new String[]{"1", "2", "3", "4", "5", "6"};
        if ( header != null ) {
        	String[] listHeader = header[0].split(",");
       	List<String> listLeft = new ArrayList<>();

            for (String item : settingHeaderLeft) {
                boolean found = false;
                for (String itemHeader : listHeader) {
                    if (item.equals(itemHeader)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    listLeft.add(item);
                }
            }
            
            // Chuyển danh sách sang mảng nếu cần
            String[] resultArray = listLeft.toArray(new String[0]);
            importForm.setListLeft(resultArray);
            request.setAttribute("importForm", importForm);
            System.out.println(resultArray);
        	return mapping.findForward("T002");
        }else {
        	String headerSetting[] =(String[])session.getAttribute("settingheader");
        	
        	// Tách mảng settingHeaderLeft thành các phần tử khác nhau
        	 String[] differentElements = getDifferentElements(settingHeaderLeft, headerSetting);
        	  
            importForm.setListLeft(differentElements);
        	importForm.setSettingHeader(headerSetting);
        }
        
       
        
        
        request.setAttribute("importForm", importForm);
		return mapping.findForward("T004");
	}
	
	// Hàm tách mảng thành các phần tử khác nhau
	public String[] getDifferentElements(String[] array1, String[] array2) {
	  List<String> listLeft = new ArrayList<>();

	  // Duyệt từng phần tử của mảng 1
	  for (String item : array1) {
	    // Kiểm tra xem phần tử đó có tồn tại trong mảng 2 hay không
	    boolean found = false;
	    for (String item2 : array2) {
	      if (item.equals(item2)) {
	        found = true;
	        break;
	      }
	    }

	    // Nếu phần tử đó không tồn tại trong mảng 2
	    if (!found) {
	    	listLeft.add(item);
	    }
	  }
	  
	  
	  String[] resultArray = listLeft.toArray(new String[0]);
	  return resultArray;
	}
	
	
	
	
	/**
     * Builds an import message based on the import result.
     *
     * @param importResult The import result containing success message, inserted lines, and updated lines.
     * @return A formatted import message.
     */
	private String buildImportMessage(Map<String, Object> importResult) {
		// Create a StringBuilder to build the message
	    StringBuilder message = new StringBuilder(importResult.get("successMessage").toString());

	    if (importResult.containsKey("insertedLines")) {
	        message.append("\nInserted line(s): ");
	        @SuppressWarnings("unchecked")
			List<Integer> insertedLines = (List<Integer>) importResult.get("insertedLines");
	        for (int i = 0; i < insertedLines.size(); i++) {
	            message.append(insertedLines.get(i));
	            if (i < insertedLines.size() - 1) {
	                message.append(", ");
	            }
	        }
	    }

	    if (importResult.containsKey("updatedLines")) {
	        message.append("\nUpdate line(s): ");
	        @SuppressWarnings("unchecked")
			List<Integer> updatedLines = (List<Integer>) importResult.get("updatedLines");
	        for (int i = 0; i < updatedLines.size(); i++) {
	            message.append(updatedLines.get(i));
	            if (i < updatedLines.size() - 1) {
	                message.append(", ");
	            }
	        }
	    }

	    return message.toString();
	}
	
	private List<String> validateData(String[] lines) {
	    List<String> errorMessages = new ArrayList<>();
	    T002DaoImp impT002 = new T002DaoImp();
        List<mstcustomer> listCustomer = impT002.getData();
	    for (int i = 1; i < lines.length; i++) {
	        String line = lines[i];
	        String[] columns = line.split(",");
	        
	        if (columns.length >= 6) {
	            String customerIdFromFile = columns[0].replace("\"", "").trim();
	            String customerNameFromFile = columns[1].replace("\"", "").trim();
	            String customerSexFromFile = columns[2].replace("\"", "").trim();
	            String customerBirthDayFromFile = columns[3].replace("\"", "").trim();
	            String customerEmailFromFile = columns[4].replace("\"", "").trim();
	            String customerAddressFromFile = columns[5].replace("\"", "").trim();

	            if (!customerIdFromFile.isEmpty()) {
                    boolean isCustomerExisted = false;
                    for (mstcustomer customer : listCustomer) {
                        String customerId = String.valueOf(customer.getCustomerId());

                        // Kiểm tra CUSTOMER_ID trong table MSTCUSTOMER
                        if (customerId.equals(customerIdFromFile) && customer.getDeleteYmd() == null) {
                            isCustomerExisted = true;
                            break;
                        }
                    }

                    if (!isCustomerExisted) {
                        // CUSTOMER_ID không tồn tại trong bảng MSTCUSTOMER
                        errorMessages.add("Line " + (i + 2) + " : CUSTOMER_ID=" + customerIdFromFile + " is not existed");
                    }
                }

                // Validate CUSTOMER_NAME length
                if (customerNameFromFile.isEmpty()) {
                    errorMessages.add("Line " + (i + 2) + " : CUSTOMER_NAME is empty");
                } else if (customerNameFromFile.length() > 50) {
                    errorMessages.add("Line " + (i + 2) + " : Value of CUSTOMER_NAME is more than 50 characters");
                }

                // Validate SEX validity
                if (!"Male".equals(customerSexFromFile) && !"Female".equals(customerSexFromFile)) {
                    errorMessages.add("Line " + (i + 2) + " : SEX=" + customerSexFromFile + " is invalid");
                }

                // Validate BIRTHDAY format and validity
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate parsedDate = LocalDate.parse(customerBirthDayFromFile, formatter);

                    if (!isValidDate(parsedDate)) {
                        errorMessages.add("Line " + (i + 2) + " : BIRTHDAY=" + customerBirthDayFromFile + " is invalid");
                    }
                } catch (DateTimeParseException e) {
                    errorMessages.add("Line " + (i + 2) + " : BIRTHDAY=" + customerBirthDayFromFile + " is invalid");
                }

                // Validate EMAIL format and length
                if (!isValidEmail(customerEmailFromFile)) {
                    errorMessages.add("Line " + (i + 2) + " : EMAIL=" + customerEmailFromFile + " is invalid");
                } else if (customerEmailFromFile.length() > 40) {
                    errorMessages.add("Line " + (i + 2) + " : Value of EMAIL is more than 40 characters");
                }

                // Validate ADDRESS length
                if (customerAddressFromFile.length() > 256) {
                    errorMessages.add("Line " + (i + 2) + " : Value of ADDRESS is more than 256 characters");
                }
	        }
	    }

	    return errorMessages;
	}
	
	private mstcustomer createCustomerObjectFromLine(String[] columns) {
	    // Assuming your mstcustomer class has a constructor that takes relevant parameters
		mstcustomer customer = new mstcustomer();
		//customer.setCustomerId(new BigDecimal(columns[0].replace("\"", "").trim()));
		customer.setCustomerName(columns[1].replace("\"", "").trim());
		String sex = columns[2].replace("\"", "").trim();
		if ("Male".equals(sex)) {
	        customer.setSex("1");
	    } else if ("Female".equals(sex)) {
	        customer.setSex("0");
	    } else {
	        // Handle the case where the sex is neither Male nor Female
	        customer.setSex(sex); // You may choose to set it as is or handle differently
	    }
		
		customer.setBirthDay(columns[3].replace("\"", "").trim());
		customer.setEmail(columns[4].replace("\"", "").trim());
		customer.setAddress(columns[5].replace("\"", "").trim());

	    return customer;
	}



	/**
	 * Check email address
	 * 
	 * @param email	Email needs checking
	 * @return		Returns whether the Email is in the correct format or not
	 */
	private static boolean isValidEmail(String email) {
	    //Check the basic format of the email
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	    //Check email format by regex matching
	    return email.matches(emailRegex);
	}
	
	/**
	 * Check birthday date
	 * 
	 * @param date The birthday date is checked and transmitted
	 * @return 	   Returns whether the date is correct or not
	 */
	private static boolean isValidDate(LocalDate date) {
	    try {
	    	//Test the format again to check if the date is valid
	        LocalDate.parse(date.toString());
	        return true;
	    } catch (DateTimeParseException e) {
	        return false;
	    }
	}

}
