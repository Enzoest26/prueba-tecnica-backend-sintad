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

import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.repository.ITipoDocumentoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TipoDocumentoRepositoryTests
{
	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;
	
	private TipoDocumento tipoDocumento;
	
	@BeforeEach
	void setUp()
	{
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("DNI");
		tipoDocumento.setDescripcion("Documento Nacional de Identidad");
		tipoDocumento.setCodigo("465");
		tipoDocumento.setEstado(1);
	}
	
	@DisplayName("Test de Registro de un Tipo Documento")
	@Test
	void testRegistrarTipoDocumentoRetornaCorrecto()
	{
		this.tipoDocumentoRepository.save(tipoDocumento);
		
		Optional<TipoDocumento> documento = this.tipoDocumentoRepository.findById(tipoDocumento.getId());
		
		assertThat(documento).isNotEmpty();
		assertThat(documento.get().getId()).isGreaterThan(1);
	}
	
	@DisplayName("Test de Actualización de un Tipo Documento")
	@Test
	void testActualizarTipoDocumentoRetornaCorrecto()
	{
		this.tipoDocumentoRepository.save(tipoDocumento);
		
		tipoDocumento.setCodigo("999");
		tipoDocumento.setDescripcion("Pasaporte");
		tipoDocumento.setEstado(0);
		tipoDocumento.setNombre("PASS");
		
		Optional<TipoDocumento> documento = this.tipoDocumentoRepository.findById(tipoDocumento.getId());
		
		assertThat(documento).isNotEmpty();
		assertThat(documento.get().getCodigo()).isEqualTo("999");
		assertThat(documento.get().getDescripcion()).isEqualTo("Pasaporte");
		assertThat(documento.get().getEstado()).isEqualTo(0);
		assertThat(documento.get().getNombre()).isEqualTo("PASS");
	}
	
	@DisplayName("Test de Listado de Tipo Documento")
	@Test
	void testListadoTipoDocumentoRetornaCorrecto()
	{
		this.tipoDocumentoRepository.save(tipoDocumento);
		
		TipoDocumento documento = new TipoDocumento();
		documento.setCodigo("999");
		documento.setDescripcion("Pasaporte");
		documento.setEstado(0);
		documento.setNombre("PASS");
		
		this.tipoDocumentoRepository.save(documento);
		
		List<TipoDocumento> lstTipoDocumento = this.tipoDocumentoRepository.findAll();
		
		assertThat(lstTipoDocumento).isNotEmpty();
		assertThat(lstTipoDocumento.size()).isEqualTo(2);
	}
	
	@DisplayName("Test de Eliminación de un Tipo Documento")
	@Test
	void testEliminarTipoDocumentoRetornaCorrecto() 
	{
		this.tipoDocumentoRepository.save(tipoDocumento);
		
		this.tipoDocumentoRepository.delete(tipoDocumento);
		
		Optional<TipoDocumento> documento = this.tipoDocumentoRepository.findById(tipoDocumento.getId());
		
		assertThat(documento).isEmpty();
	}
	
	@DisplayName("Test de Buscar Por Id de un Tipo Documento")
	@Test
	void testBuscarPorIdTipoDocumentoRetornaCorrecto()
	{
		this.tipoDocumentoRepository.save(tipoDocumento);
		
		Optional<TipoDocumento> documento = this.tipoDocumentoRepository.findById(tipoDocumento.getId());
		
		assertThat(documento).isNotEmpty();
	}
}
