package br.com.fiap.global.controller;

import java.util.ArrayList;

import br.com.fiap.global.model.entity.Tarefa;
import br.com.fiap.global.model.repository.TarefaRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/tarefa")
public class TarefaResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Tarefa> resposta = TarefaRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Tarefa tarefa) {
		Tarefa resposta = TarefaRepository.save(tarefa);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}

}
