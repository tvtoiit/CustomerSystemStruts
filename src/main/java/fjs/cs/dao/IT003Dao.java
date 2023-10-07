package fjs.cs.dao;

import java.math.BigDecimal;

import fjs.cs.dto.mstcustomer;

public interface IT003Dao {
	int save(mstcustomer ms, BigDecimal loggedInPsnCd );
	mstcustomer getCustomerById(Integer id);
	void update(mstcustomer ms);
}
