package fjs.cs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import fjs.cs.dao.IT002Dao;
import fjs.cs.dto.mstcustomer;
import fjs.cs.rowmapper.T002Mapper;

public class T002DaoImp extends AbstractDao<mstcustomer> implements IT002Dao {

	@Override
	public List<mstcustomer> getData() {
		String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, CASE WHEN SEX = 0 THEN 'Male' ELSE 'Female' END AS SEX, BIRTHDAY, ADDRESS FROM mstcustomer WHERE DELETE_YMD IS NULL ORDER BY CUSTOMER_ID";
		return query(sql, new T002Mapper());
	}

	@Override
	public List<mstcustomer> getDataSearch(String name, String sex, String birthdayFrom, String birthdayTo) {
		StringBuilder query = new StringBuilder("SELECT CUSTOMER_ID, CUSTOMER_NAME, CASE WHEN SEX = 0 THEN 'Male' else 'Female' end as SEX, BIRTHDAY, ADDRESS ")
				.append("FROM MSTCUSTOMER ")
				.append("WHERE DELETE_YMD IS NULL");
		
		// Danh sách tham số sẽ được sử dụng trong truy vấn SQL
	    List<Object> parameters = new ArrayList<>();
	    
	    // Thêm điều kiện tìm kiếm theo tên nếu tên có
	    if (name != null && !name.isEmpty()) {
	        query.append(" AND CUSTOMER_NAME LIKE ?");
	        parameters.add("%" + name + "%");
	    }
	    
	    // Thêm điều kiện tìm kiếm theo giới tính nếu giới tính nếu có
	    if (sex != null && !sex.isEmpty()) {
	        query.append(" AND SEX = ?");
	        parameters.add(sex);
	    }
	    
	    // Thêm điều kiện tìm kiếm theo ngày sinh bắt đầu nếu có
	    if (birthdayFrom != null && !birthdayFrom.isEmpty()) {
	        query.append(" AND BIRTHDAY >= ?");
	        parameters.add(birthdayFrom);
	    }
	    
	    // Thêm điều kiện tìm kiếm theo ngày sinh kết thúc nếu có
	    if (birthdayTo != null && !birthdayTo.isEmpty()) {
	        query.append(" AND BIRTHDAY <= ?");
	        parameters.add(birthdayTo);
	    }
		
	    // Sắp xếp kết quả theo CUSTOMER_ID
	    query.append(" ORDER BY CUSTOMER_ID");
	    
	    // Thực hiện truy vấn SQL và trả về danh sách khách hàng
		return query(query.toString(), new T002Mapper(), parameters.toArray());
	}

	@Override
	public List<mstcustomer> deleteData(String[] selecValue) {
		List<mstcustomer> listDelete = new ArrayList<mstcustomer>();
	    try {
	        String query = "UPDATE MSTCUSTOMER "
	                     + "SET Delete_YMD = CURRENT_TIMESTAMP "
	                     + "WHERE customer_Id IN (";
	        for (int i = 0; i < selecValue.length; i++) {
	            String[] ids = selecValue[i].split(",");
	            for (int j = 0; j < ids.length; j++) {
	                query += "?,";
	            }
	        }
	        query = query.substring(0, query.length() - 1) + ")";
	        
	        // Gọi hàm chung update để thực hiện truy vấn cập nhật
	        update(query, (Object[]) selecValue);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listDelete;
	}
	
}
