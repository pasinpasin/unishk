package com.unishk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Department not found")
public class DepartmentNotFoundRestException extends Exception {


	

}
