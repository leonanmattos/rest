package br.com.leonan.resource.config;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		List<LocalConstraintViolation> response = exception.getConstraintViolations()
				.stream()
				.map(LocalConstraintViolation::new)
				.collect(Collectors.toList());

		return Response.status(Status.BAD_REQUEST)
				.entity(response)
				.build();
	}

}
