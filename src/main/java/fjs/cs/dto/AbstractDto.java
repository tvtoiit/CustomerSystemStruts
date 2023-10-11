package fjs.cs.dto;

import java.security.Timestamp;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class AbstractDto<T> extends ActionForm  {
	private static final long serialVersionUID = 1L;
	private Timestamp deleteYmd;
	private Timestamp insertYmd;
	private Integer insertPsnCd;
	private Timestamp updateYmd;
	private Integer updatePsnCd;
	private List<T> pageData;
	private Integer page;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public Timestamp getDeleteYmd() {
		return deleteYmd;
	}

	public void setDeleteYmd(Timestamp deleteYmd) {
		this.deleteYmd = deleteYmd;
	}

	public Timestamp getInsertYmd() {
		return insertYmd;
	}

	public void setInsertYmd(Timestamp insertYmd) {
		this.insertYmd = insertYmd;
	}

	public Integer getInsertPsnCd() {
		return insertPsnCd;
	}

	public void setInsertPsnCd(Integer insertPsnCd) {
		this.insertPsnCd = insertPsnCd;
	}

	public Timestamp getUpdateYmd() {
		return updateYmd;
	}

	public void setUpdateYmd(Timestamp updateYmd) {
		this.updateYmd = updateYmd;
	}

	public Integer getUpdatePsnCd() {
		return updatePsnCd;
	}

	public void setUpdatePsnCd(Integer updatePsnCd) {
		this.updatePsnCd = updatePsnCd;
	}
}
