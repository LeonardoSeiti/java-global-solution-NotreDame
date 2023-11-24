package br.com.fiap.global.controller;

import java.util.ArrayList;

import br.com.fiap.global.model.entity.Consulta;
import br.com.fiap.global.model.repository.ConsultaRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/consulta")
public class ConsultaResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Consulta> resposta = ConsultaRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Consulta consulta) {
		Consulta resposta = ConsultaRepository.save(consulta);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);//Created - 201 
		} else {
			response = Response.status(400);//Bad Request - 400
		}
		response.entity(resposta);
		return response.build();
	}

}
