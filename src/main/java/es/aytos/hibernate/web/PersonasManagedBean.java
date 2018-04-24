package es.aytos.hibernate.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;

@ManagedBean
@RequestScoped
public class PersonasManagedBean implements Serializable{

	private List<Persona> personas;
	
	public PersonasManagedBean() {
	}
	
	@PostConstruct
	public void inicializar() {
		this.personas = RepositorioPersona.consultar("", "", "", null);
	}
	
	public void eliminar(final Persona persona) {
		RepositorioPersona.eliminarPersona(persona.getIdUsuario());
	}

	public List<Persona> getPersonas() {
		return personas;
	}
}
