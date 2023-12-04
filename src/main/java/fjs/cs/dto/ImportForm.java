package fjs.cs.dto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import fjs.cs.dao.impl.T002DaoImp;

public class ImportForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private FormFile file;
	private String listRight[];
	private String listLeft[];
	private String sMode;

	private String settingHeader[];
	
	public String getsMode() {
		return sMode;
	}

	public void setsMode(String sMode) {
		this.sMode = sMode;
	}

	public String[] getListLeft() {
		return listLeft;
	}

	public void setListLeft(String[] listLeft) {
		this.listLeft = listLeft;
	}

	public String[] getSettingHeader() {
		return settingHeader;
	}

	public void setSettingHeader(String settingHeader[]) {
		this.settingHeader = settingHeader;
	}

	public String[] getListRight() {
		return listRight;
	}

	public void setListRight(String[] listRight) {
		this.listRight = listRight;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}
	
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	    ActionErrors errors = new ActionErrors();

	    if (file != null) {
	        String fileContent;
	        try {
	            fileContent = new String(file.getFileData(), StandardCharsets.UTF_8);
	            String[] lines = fileContent.split("\n");

	            T002DaoImp impT002 = new T002DaoImp();
	            List<mstcustomer> listCustomer = impT002.getData();

	            for (int i = 1; i < lines.length; i++) {
	                String line = lines[i];
	                String[] columns = line.split(",");

	                if (columns.length >= 6) {
	                    String customerIdFromFile = columns[0].replace("\"", "").trim();
	                    String customerNameFromFile = columns[1].replace("\"", "").trim();

	                    // Check CUSTOMER_ID existence
	                    if (!customerIdFromFile.isEmpty()) {
	                        boolean isCustomerExisted = false;
	                        for (mstcustomer customer : listCustomer) {
	                            String customerId = String.valueOf(customer.getCustomerId());

	                            if (customerId.equals(customerIdFromFile) && customer.getDeleteYmd() == null) {
	                                isCustomerExisted = true;
	                                break;
	                            }
	                        }

	                        if (!isCustomerExisted) {
	                        	String errorMessageID = "error.file.requiredid";
	                        	ActionMessage errorMessage = new ActionMessage(errorMessageID, i + 1, customerIdFromFile);
	                        	errors.add("", errorMessage);
	                        }
	                    }

	                    // Validate CUSTOMER_NAME length
	                    if (customerNameFromFile.isEmpty()) {
	                        String messageName = MessageFormat.format("Line {0} : CUSTOMER_NAME={1} is empty", i + 1, customerNameFromFile);
	                        errors.add("", new ActionMessage(messageName));
	                    } else if (customerNameFromFile.length() > 50) {
	                        String messageNameLength = MessageFormat.format("Line {0} : Value of CUSTOMER_NAME is more than 50 characters", i + 1);
	                        errors.add("", new ActionMessage(messageNameLength));
	                    }
	                }
	            }
	            if (errors != null) {
	            	saveErrorFile(errors, request);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return errors;
	}
	
	
	public String saveErrorFile(ActionErrors errors, HttpServletRequest request) {
	    try {
	        // Write file path
	        String baseFolder = "C:\\";
	        String errorsFolder = "errors";
	        String driveName = Paths.get(baseFolder, errorsFolder).toString();

	        // Try to get the errorsFolderPath from web.xml
//	        ServletContext servletContext = request.getServletContext();
//	        String webXmlErrorsFolderPath = servletContext.getInitParameter("errorsFolderPath");
//	        if (webXmlErrorsFolderPath != null && !webXmlErrorsFolderPath.isEmpty()) {
//	            driveName = webXmlErrorsFolderPath;
//	        }

	        // Convert time to "yyyyMMdd" format
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	        String formattedDate = dateFormat.format(new Date());

	        // Create a new filename
	        String fileName = "error_file_" + formattedDate + ".txt";
	        Path filePath = Paths.get(driveName, fileName);

	        // Create the "errors" folder if it doesn't exist
	        Path errorsFolderPath = Paths.get(driveName);
	        if (!Files.exists(errorsFolderPath)) {
	            Files.createDirectories(errorsFolderPath);
	        }

	        // Iterate over ActionMessages and write them to the file
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString()))) {
	            @SuppressWarnings("unchecked")
	            Iterator<ActionMessage> iterator = errors.get();
	            while (iterator.hasNext()) {
	                ActionMessage error = iterator.next();
	                String errorMessage = error.getKey();
	                writer.write(errorMessage);
	                writer.newLine();
	            }
	        }

	        return filePath.toString();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	 
}
