package br.com.leonan.resource.config;

import java.io.Serializable;

import javax.validation.ConstraintViolation;

public class LocalConstraintViolation implements Serializable {

	private static final long serialVersionUID = -8732537161973841912L;
	
	private String mensagem;

	public LocalConstraintViolation(ConstraintViolation<?> cv) {
		mensagem = cv.getMessage();
	}

	public String getMensagem() {
		return mensagem;
	}
}
