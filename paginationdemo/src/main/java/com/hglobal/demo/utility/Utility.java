package com.hglobal.demo.utility;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class Utility {
	public static final String successMessage = "Successful";
	public static final String empty = "No records found";
	public static final String error = "something went wrong";
	
	public  static Result createResultFromList(List<?> list) {
	    Result result;
	    if (!list.isEmpty()) {
	        result = new Result(HttpStatus.OK.value(), Utility.successMessage, list);
	    } else {
	        result = new Result(HttpStatus.NOT_FOUND.value(), Utility.empty, list);
	    }
	    return result;
	}

}
