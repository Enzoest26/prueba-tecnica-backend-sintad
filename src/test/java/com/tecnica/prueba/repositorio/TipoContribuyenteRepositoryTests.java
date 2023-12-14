package com.tecnica.prueba.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tecnica.prueba.model.TipoContribuyente;
import com.tecnica.prueba.repository.ITipoContribuyenteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TipoContribuyenteRepositoryTests
{
	@Autowired
	private ITipoContribuyenteRepository contribuyenteRepository;
	
	private TipoContribuyente tipoContribuyente;
	
	
	@BeforeEach
	void setUp()
	{
		tipoContribuyente = new TipoContribuyente();
		tipoContribuyente.setEstado(1);
		tipoContribuyente.setNombre("Juridica");
	}
	
	@DisplayName("Test de Registro de un Tipo Contribuyente")
	@Test
	void testRegistrarTipoContribuyenteRetornaCorrecto()
	{
		this.contribuyenteRepository.save(tipoContribuyente);
		Optional<TipoContribuyente> contribuyente = this.contribuyenteRepository.findById(tipoContribuyente.getId());
		
		assertThat(contribuyente).isNotEmpty();
		assertThat(contribuyente.get().getId()).isGreaterThan(0);
	}
	
	@DisplayName("Test de Actualización de un Tipo Contribuyente")
	@Test
	void testActualizarTipoContribuyenteRetornaCorrecto()
	{
		this.contribuyenteRepository.save(tipoContribuyente);
		
		tipoContribuyente.setEstado(0);
		tipoContribuyente.setNombre("Test");
		this.contribuyenteRepository.save(tipoContribuyente);
		
		Optional<TipoContribuyente> contribuyente = this.contribuyenteRepository.findById(tipoContribuyente.getId());
		
		assertThat(contribuyente).isNotEmpty();
		assertThat(contribuyente.get().getNombre()).isEqualTo("Test");
		assertThat(contribuyente.get().getEstado()).isEqualTo(0);
	}
	
	@DisplayName("Test de Listado de Tipos Contribuyentes")
	@Test
	void testListadoTipoContribuyenteRetornaCorrecto()
	{
		this.contribuyenteRepository.save(tipoContribuyente);
		
		TipoContribuyente contribuyente = new TipoContribuyente();
		contribuyente.setEstado(1);
		contribuyente.setNombre("test2");
		
		this.contribuyenteRepository.save(contribuyente);
		
		List<TipoContribuyente> lstTipoContribuyente = this.contribuyenteRepository.findAll();
		
		assertThat(lstTipoContribuyente).isNotEmpty();
		assertThat(lstTipoContribuyente.size()).isEqualTo(2);
	}
	
	@DisplayName("Test de Eliminación de un Tipo Contribuyente")
	@Test
	void testEliminarTipoContribuyente()
	{
		this.contribuyenteRepository.save(tipoContribuyente);
		
		this.contribuyenteRepository.deleteById(tipoContribuyente.getId());
		
		Optional<TipoContribuyente> contribuyente = this.contribuyenteRepository.findById(tipoContribuyente.getId());
		
		assertThat(contribuyente).isEmpty();
		
	}
	
	@DisplayName("Test de Buscar por Id de un Tipo Contribuyente")
	@Test
	void testBuscarPorIdRetornaCorrecto()
	{
		this.contribuyenteRepository.save(tipoContribuyente);
		
		Optional<TipoContribuyente> contribuyente = this.contribuyenteRepository.findById(tipoContribuyente.getId());
		
		assertThat(contribuyente).isNotEmpty();
	}
}
