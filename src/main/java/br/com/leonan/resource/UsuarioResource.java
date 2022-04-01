package br.com.leonan.resource;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.leonan.entity.Usuario;
import br.com.leonan.resource.request.CreateUserRequest;
import br.com.leonan.resource.request.UpdateUserRequest;
import br.com.leonan.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Path("/usuario")
public class UsuarioResource {
	
	private UsuarioService usuarioService;
	
	public UsuarioResource() {}
	
	@Inject
	public UsuarioResource(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Operation(description = "Obter Usuário por Identificador")
	@ApiResponse(responseCode = "200", description = "Usuário encontrado")
	@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
	@Produces(APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		Usuario usuario = usuarioService.findById(id);
		return Response.ok(usuario).build();
	}
	
	@POST
	@Operation(description = "Criar Usuário")
	@ApiResponse(responseCode = "201", description = "Usuário criado")
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	@Transactional
	public Response create(@Valid CreateUserRequest createUserRequest) {
		Usuario user = usuarioService.create(createUserRequest);
		
		URI uri = UriBuilder.fromResource(UsuarioResource.class)
				.path(valueOf(user.getId()))
				.build();

		return Response.created(uri).entity(user).build();
	}
	
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Operation(description = "Alterar Usuário")
	@ApiResponse(responseCode = "200", description = "Usuário alterado")
	@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	@Transactional
	public Response update(@PathParam("id") Long id, UpdateUserRequest updateUserRequest) {
		Usuario user = usuarioService.findById(id);
		
		if(updateUserRequest.getNome() != null) user.setNome(updateUserRequest.getNome());
		if(updateUserRequest.getCpf() != null) user.setCpf(updateUserRequest.getCpf());
		if(updateUserRequest.getEmail() != null) user.setEmail(updateUserRequest.getEmail());
		if(updateUserRequest.getNumTelefone() != null) user.setNumTelefone(updateUserRequest.getNumTelefone());
		if(updateUserRequest.getSituacao() != null) user.setSituacao(updateUserRequest.getSituacao());
		
		user = usuarioService.update(user);

		return Response.ok(user).build();
	}

}
