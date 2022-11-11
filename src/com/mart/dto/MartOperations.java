package com.mart.dto;

public enum MartOperations {

	ShowAll,Create,Delete,SearchByCode;
	
	@Override
	public String toString() {
		return String.format("%d. %s", ordinal()+1,name());
	}
}

