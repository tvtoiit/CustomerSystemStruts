package fjs.cs.rowmapper;

import java.sql.ResultSet;

import fjs.cs.dto.mstcustomer;

public class T003Mapper implements RowMapper<mstcustomer> {

	@Override
	public mstcustomer mapRow(ResultSet resultSet) {
		try {
			mstcustomer t003Dto = new mstcustomer();
			t003Dto.setCustomerId(resultSet.getBigDecimal("CUSTOMER_ID"));
			t003Dto.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
			t003Dto.setSex(resultSet.getString("SEX"));
			t003Dto.setBirthDay(resultSet.getString("BIRTHDAY"));
			t003Dto.setEmail(resultSet.getString("EMAIL"));
			t003Dto.setAddress(resultSet.getString("ADDRESS"));
			return t003Dto;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
