package fjs.cs.dao;

import java.util.List;

import fjs.cs.dto.mstcustomer;

public interface IT002Dao {
	List<mstcustomer> getData();
	List<mstcustomer> getDataSearch(String name, String sex, String birthdayFrom, String birthdayTo);
	List<mstcustomer> deleteData(String[] selecValue);
}
