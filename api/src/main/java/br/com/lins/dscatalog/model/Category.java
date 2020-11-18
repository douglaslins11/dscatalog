package br.com.lins.dscatalog.model;

import java.io.Serializable;

public class Category implements Serializable{
	
	private Long idLong;
	private String nameString;
	
	public Long getIdLong() {
		return idLong;
	}
	public void setIdLong(Long idLong) {
		this.idLong = idLong;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (idLong == null) {
			if (other.idLong != null)
				return false;
		} else if (!idLong.equals(other.idLong))
			return false;
		return true;
	}
}
