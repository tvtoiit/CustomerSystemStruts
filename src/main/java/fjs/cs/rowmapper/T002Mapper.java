package fjs.cs.rowmapper;

import java.sql.ResultSet;

import fjs.cs.dto.mstcustomer;

public class T002Mapper implements RowMapper<mstcustomer> {

	@Override
	public mstcustomer mapRow(ResultSet resultSet) {
		try {
			mstcustomer t002Dto = new mstcustomer();
			t002Dto.setCustomerId(resultSet.getBigDecimal("CUSTOMER_ID"));
			t002Dto.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
			t002Dto.setSex(resultSet.getString("SEX"));
			t002Dto.setBirthDay(resultSet.getString("BIRTHDAY"));
			t002Dto.setAddress(resultSet.getString("ADDRESS"));
			return t002Dto;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
