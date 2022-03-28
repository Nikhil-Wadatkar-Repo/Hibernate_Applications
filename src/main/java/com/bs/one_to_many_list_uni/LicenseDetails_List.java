package com.bs.one_to_many_list_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LicenseDetails_List")
public class LicenseDetails_List  {
	@Id
	private int lId;
	private String name;

	public LicenseDetails_List(int lId, String name) {
		super();
		this.lId = lId;
		this.name = name;
	}

	public LicenseDetails_List() {
		super();
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LicenseDetails_List [lId=" + lId + ", name=" + name + "]";
	}

	

}
