package fjs.cs.dao;

import java.util.List;

import fjs.cs.rowmapper.RowMapper;
public interface GennericDao<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters );
	void update(String sql, Object... parammeters);
	int insert(String sql, Object... parammeters);
}
