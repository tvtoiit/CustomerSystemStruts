package fjs.cs.dao;

import fjs.cs.dto.mstuser;

public interface IT001Dao {
	int checkLogin(String user, String pass);
	mstuser getUserInfo(String userId, String passWord);
}
