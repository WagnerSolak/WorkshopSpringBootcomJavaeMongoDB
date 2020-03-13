package com.solak.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
//	{ a classe StandardError será utilizada para tratar o JSON de erro abaixo: fazendo com que o erro retorne ao usuário 404 e não 500.
//    "timestamp": "2020-03-12T12:16:35.579+0000",
//    "status": 500,
//    "error": "Internal Server Error",
//    "message": "Usuário não encontrado!",
//    "path": "/users/5e6a27ab04f3f74e0e85c8a5dcvdfgvefrv"
//}
	
	
	public StandardError() {
	}

	public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
