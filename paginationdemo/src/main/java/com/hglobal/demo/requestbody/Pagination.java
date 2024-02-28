package com.hglobal.demo.requestbody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
	public int pageNo;
	public int pageSize;
	public String sort;
	public String sortDirection;
	public boolean export;
}
