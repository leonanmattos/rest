package br.com.leonan.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import br.com.leonan.entity.Usuario;
import br.com.leonan.repository.UsuarioRepository;
import br.com.leonan.resource.request.CreateUserRequest;

@RequestScoped
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService() {
	}

	@Inject
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	/**
	 * Método responsável por obter usuário por ID
	 * 
	 * @param id
	 * @throws NotFoundException
	 * @return Usuario
	 */
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	/**
	 * Método responsável por salvar usuario
	 * 
	 * @param usuario : Usuario
	 * @return Usuario
	 */
	public Usuario create(CreateUserRequest createUserRequest) {
		return usuarioRepository
				.save(new Usuario(createUserRequest.getCpf(), createUserRequest.getNome(), createUserRequest.getEmail(), createUserRequest.getNumTelefone()));
	}
	
	/**
	 * Método responsável por alterar usuario
	 * 
	 * @param usuario : Usuario
	 * @return Usuario
	 */
	public Usuario update(Usuario usuario) {
		return usuarioRepository
				.save(usuario);
	}
}
