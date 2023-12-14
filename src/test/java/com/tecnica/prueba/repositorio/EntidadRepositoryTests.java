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

import com.tecnica.prueba.model.Entidad;
import com.tecnica.prueba.model.TipoContribuyente;
import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.repository.IEntidadRepository;
import com.tecnica.prueba.repository.ITipoContribuyenteRepository;
import com.tecnica.prueba.repository.ITipoDocumentoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EntidadRepositoryTests 
{
	@Autowired
	private IEntidadRepository entidadRepository;
	
	@Autowired
	private ITipoContribuyenteRepository contribuyenteRepository;
	
	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;
	
	private Entidad entidad1;
	
	private TipoContribuyente contribuyente;
	
	private TipoDocumento documento;
	
	
	@BeforeEach
	void setUp()
	{
		contribuyente = new TipoContribuyente();
		contribuyente.setNombre("Juridico");
		contribuyente.setEstado(1);
		
		documento = new TipoDocumento();
		documento.setNombre("DNI");
		documento.setDescripcion("Documento Nacional de Identidad");
		documento.setCodigo("465");
		documento.setEstado(1);
		
		entidad1 = new Entidad();
		entidad1.setDireccion("Miraflores");
		entidad1.setEstado(1);
		entidad1.setNombreComercial("Prueba Test");
		entidad1.setNroDocumento("987654321");
		entidad1.setObjTipoContribuyente(this.contribuyenteRepository.save(contribuyente));
		entidad1.setObjTipoDocumento(this.tipoDocumentoRepository.save(documento));
		entidad1.setRazonSocial("Razon de Prueba");
		entidad1.setTelefono("57863245");
	}
	
	@DisplayName("Test de Registro de Entidad")
	@Test
	void testRegistrarEntidadCorrecto() 
	{
		this.entidadRepository.save(entidad1);
		Optional<Entidad> entidad = this.entidadRepository.findById(entidad1.getId());
		
		assertThat(entidad).isNotEmpty();
		assertThat(entidad.get().getId()).isGreaterThan(0);
	}
	
	@DisplayName("Test de Listado de Entidad")
	@Test
	void testListadoEntidadRetornaCorrecto()
	{
	
		Entidad entidad2 = new Entidad();
		entidad2.setDireccion("Miraflores");
		entidad2.setEstado(1);
		entidad2.setNombreComercial("Prueba Test");
		entidad2.setNroDocumento("987654321");
		entidad2.setObjTipoContribuyente(contribuyente);
		entidad2.setObjTipoDocumento(documento);
		entidad2.setRazonSocial("Razon de Prueba");
		entidad2.setTelefono("57863245");
		
		this.entidadRepository.save(entidad1);
		this.entidadRepository.save(entidad2);
		
		List<Entidad> lstEntidad = this.entidadRepository.findAll();
		
		assertThat(lstEntidad).isNotEmpty();
		assertThat(lstEntidad.size()).isEqualTo(2);
		
	}
	
	
	@DisplayName("Test de Actualización de una Entidad")
	@Test
	void testActualizarEntidadRetornaCorrecto()
	{
		this.entidadRepository.save(entidad1);
		
		entidad1.setDireccion("Lima");
		entidad1.setEstado(0);
		entidad1.setNombreComercial("Casita");
		entidad1.setNroDocumento("45783215");
		
		this.entidadRepository.save(entidad1);
		
		assertThat(entidad1.getDireccion()).isEqualTo("Lima");
		assertThat(entidad1.getEstado()).isEqualTo(0);
		assertThat(entidad1.getNombreComercial()).isEqualTo("Casita");
		assertThat(entidad1.getNroDocumento()).isEqualTo("45783215");
	}
	
	@DisplayName("Test de Eliminación de una Entidad")
	@Test
	void testEliminarEntidadRetornaCorrecto() 
	{
		this.entidadRepository.save(entidad1);
		
		this.entidadRepository.delete(entidad1);
		
		Optional<Entidad> entidad = this.entidadRepository.findById(entidad1.getId());
		
		assertThat(entidad).isEmpty();
	}
	
	@DisplayName("Test de Buscar Por Id de una Entidad")
	@Test
	void testBuscarPorIdEntidadRetornaCorrecto()
	{
		this.entidadRepository.save(entidad1);
		
		Optional<Entidad> entidad = this.entidadRepository.findById(entidad1.getId());
		
		assertThat(entidad).isNotEmpty();
	}
}
