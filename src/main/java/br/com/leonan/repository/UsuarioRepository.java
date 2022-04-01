package br.com.leonan.repository;

import javax.enterprise.context.RequestScoped;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.leonan.entity.Usuario;

@RequestScoped
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

	default Specification<Usuario> comIdIgual(Long id) {
		if (id == null) {
			return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.conjunction();
		}
		return (root, criteriaQuery, criteriaBuilder) -> {
			Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
			return criteriaBuilder.equal(usuario.get("id"), id);
		};
	}
}
