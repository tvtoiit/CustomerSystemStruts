package fjs.cs.dao.impl;

import java.util.List;
import fjs.cs.dao.IT001Dao;
import fjs.cs.dto.mstuser;
import fjs.cs.rowmapper.MstUserMapper;
import fjs.cs.rowmapper.T001Mapper;

public class T001DaoImpl extends AbstractDao<mstuser> implements IT001Dao{

	@Override
	public int checkLogin(String user, String pass) {
		String sql = "SELECT COUNT(*) AS CNT FROM MSTUSER WHERE DELETE_YMD IS NULL AND USERID = ? AND PASSWORD = ?";
		List<Integer> counts  = query(sql, new T001Mapper(), user, pass);
		if (counts != null && !counts.isEmpty()) {
			 return counts.get(0);
		}
		return -1;
	}

	@Override
	public mstuser getUserInfo(String userId, String passWord) {
		String query = "SELECT * FROM MSTUSER WHERE DELETE_YMD IS NULL AND USERID = ? AND PASSWORD = ?";
	    List<mstuser> results = query(query, new MstUserMapper(), userId, passWord);
		if (!results.isEmpty()) {
			return results.get(0);
		}else {
			return null;
		}
	}
}
