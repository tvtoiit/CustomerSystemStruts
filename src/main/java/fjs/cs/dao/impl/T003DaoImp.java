package fjs.cs.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import fjs.cs.dao.IT003Dao;
import fjs.cs.dto.mstcustomer;
import fjs.cs.rowmapper.T003Mapper;

public class T003DaoImp extends AbstractDao<mstcustomer> implements IT003Dao{

	@Override
	public int save(mstcustomer ms, BigDecimal loggedInPsnCd) {
		StringBuilder sql = new StringBuilder("INSERT INTO MSTCUSTOMER (CUSTOMER_NAME, SEX, BIRTHDAY, EMAIL, ADDRESS, DELETE_YMD, INSERT_YMD, INSERT_PSN_CD, UPDATE_YMD, UPDATE_PSN_CD)");
	    sql.append(" VALUES (?, ?, ?, ?, ?, NULL, CURRENT_TIMESTAMP, ?, CURRENT_TIMESTAMP, ?)");
	    return insert(sql.toString(), ms.getCustomerName(), ms.getSex(), ms.getBirthDay(), ms.getEmail(), ms.getAddress(), loggedInPsnCd, loggedInPsnCd);
	}

	@Override
	public mstcustomer getCustomerById(Integer id) {
		String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, SEX, BIRTHDAY, EMAIL, ADDRESS FROM mstcustomer WHERE CUSTOMER_ID = ?";
		List<mstcustomer> resultCustomerId = query(sql, new T003Mapper(), id);
		return resultCustomerId.get(0);
	}

	@Override
	public void update(mstcustomer ms) {
		String sql = "UPDATE MSTCUSTOMER SET CUSTOMER_NAME = ?, SEX = ?, BIRTHDAY = ?, EMAIL = ?, ADDRESS = ?, DELETE_YMD = NULL, UPDATE_YMD = CURRENT_TIMESTAMP WHERE CUSTOMER_ID = ?";
		update(sql, ms.getCustomerName(), ms.getSex(), ms.getBirthDay(), ms.getEmail(), ms.getAddress(), ms.getCustomerId());
	}

}
