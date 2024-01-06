package com.tecnica.prueba.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecnica.prueba.controller.rest.TipoDocumentoRestController;
import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.model.request.TipoDocumentoRequest;
import com.tecnica.prueba.security.login.ILoginService;
import com.tecnica.prueba.security.service.JwtService;
import com.tecnica.prueba.service.IEntidadService;
import com.tecnica.prueba.service.ITipoContribuyenteService;
import com.tecnica.prueba.service.ITipoDocumentoService;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(controllers = TipoDocumentoRestController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class TipoDocumentoRestControllerTests 
{
	@MockBean
	private ITipoDocumentoService tipoDocumentoService;
	
	@MockBean
	private IEntidadService entidadService;
	
	@MockBean
	private ITipoContribuyenteService tipoContribuyenteService;
	
	@MockBean
	private ILoginService loginService;
	
	@MockBean 
	JwtService jwtService;
	
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;

	
	private TipoDocumento tipoDocumento;
	
	//private  request;
	
	
	@BeforeEach
	void setUp()
	{
		
		tipoDocumento = new TipoDocumento();
		tipoDocumento.setId(1L);
		tipoDocumento.setCodigo("999");
		tipoDocumento.setDescripcion("Documento Nacional de Identidad");
		tipoDocumento.setEstado(0);
		tipoDocumento.setNombre("DNI");
		
		
	}
	
	@Test
	void testRegistrarTipoDocumentoRetornaCorrecto() throws Exception
	{
		TipoDocumentoRequest request = new TipoDocumentoRequest();
		
		request.setCodigo("999");
		request.setDescripcion("Documento Nacional de Identidad");
		request.setEstado(0);
		request.setNombre("DNI");
		//given(this.tipoDocumentoService.registrarTipoDocumento(any(TipoDocumentoRequest.class))).willAnswer((invocation) -> invocation.getArgument(0));
		
		ResultActions response = this.mockMvc.perform(post("/api/tipos-documentos").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)));
		
		response.andExpect(status().isCreated())
			.andExpect(jsonPath("$.id", is(tipoDocumento.getId())))
			.andExpect(jsonPath("$.codigo", is(tipoDocumento.getCodigo())))
			.andExpect(jsonPath("$.nombre", is(tipoDocumento.getNombre())))
			.andExpect(jsonPath("$.descripcion", is(tipoDocumento.getDescripcion())))
			.andExpect(jsonPath("$.estado", is(tipoDocumento.getEstado())));
		
	}
	
}
