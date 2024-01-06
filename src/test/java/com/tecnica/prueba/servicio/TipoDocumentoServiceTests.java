package com.tecnica.prueba.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;

import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.model.request.TipoDocumentoRequest;
import com.tecnica.prueba.repository.ITipoDocumentoRepository;
import com.tecnica.prueba.service.impl.TipoDocumentoService;

@ExtendWith(MockitoExtension.class)
public class TipoDocumentoServiceTests
{
	
	@Mock
	private ITipoDocumentoRepository tipoDocumentoRepository;
	
	@InjectMocks
	private TipoDocumentoService tipoDocumentoService;
	
	private TipoDocumento tipoDocumento;
	
	private TipoDocumentoRequest tipoDocumentoRequest;
	
	@BeforeEach
	void setUp()
	{
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("DNI");
		tipoDocumento.setDescripcion("Documento Nacional de Identidad");
		tipoDocumento.setCodigo("465");
		tipoDocumento.setEstado(1);
		
		tipoDocumentoRequest = new TipoDocumentoRequest();
		tipoDocumentoRequest.setNombre("DNI");
		tipoDocumentoRequest.setDescripcion("Documento Nacional de Identidad");
		tipoDocumentoRequest.setCodigo("465");
		tipoDocumentoRequest.setEstado(1);
	}
	
	@DisplayName("Test de Registro de un Tipo Documento")
	@Test
	void testRegistrarTipoDocumentoRetornaCorrecto()
	{
		given(this.tipoDocumentoRepository.save(tipoDocumento)).willReturn(tipoDocumento);
		
		//TipoDocumento tipoDocumento2 = this.tipoDocumentoService.registrarTipoDocumento(tipoDocumentoRequest);
		
		//assertThat(tipoDocumento2).isNotNull();
	}
	
	@DisplayName("Test de Actualización de un Tipo Documento")
	@Test
	void testActualizarTipoDocumentoRetornaCorrecto()
	{
		Long id = 1L;
		
		given(this.tipoDocumentoRepository.save(tipoDocumento)).willReturn(tipoDocumento);
		given(tipoDocumentoRepository.findById(id)).willReturn(Optional.of(tipoDocumento));
        
		tipoDocumentoRequest.setCodigo("999");
		tipoDocumentoRequest.setDescripcion("Pasaporte");
		tipoDocumentoRequest.setEstado(0);
		tipoDocumentoRequest.setNombre("PASS");
		//this.tipoDocumentoService.actualizarTipoDocumento(id, tipoDocumentoRequest);
		Optional<TipoDocumento> documento = this.tipoDocumentoService.buscarPorId(id);
		assertThat(documento).isNotEmpty();
		assertThat(documento.get().getCodigo()).isEqualTo("999");
		assertThat(documento.get().getDescripcion()).isEqualTo("Pasaporte");
		assertThat(documento.get().getEstado()).isEqualTo(0);
		assertThat(documento.get().getNombre()).isEqualTo("PASS");
	}
	
	@DisplayName("Test de Eliminación de un Tipo Documento")
	@Test
	void testEliminarTipoDocumentoRetornaCorrecto() 
	{
		
		willDoNothing().given(tipoDocumentoRepository).deleteById(tipoDocumento.getId());
		this.tipoDocumentoRepository.save(tipoDocumento);
		
		//this.tipoDocumentoService.eliminarTipoDocumento(tipoDocumento.getId());
		
		Optional<TipoDocumento> documento = this.tipoDocumentoService.buscarPorId(tipoDocumento.getId());
		
		assertThat(documento).isEmpty();
	}
	
}
