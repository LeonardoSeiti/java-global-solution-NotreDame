package br.com.fiap.global.controller;

import java.util.ArrayList;

import br.com.fiap.global.model.entity.Cadastro;
import br.com.fiap.global.model.repository.CadastroRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/cadastro")
public class CadastroResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Cadastro> resposta = CadastroRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Cadastro cadastro) {
		Cadastro resposta = CadastroRepository.save(cadastro);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); //Created - 201 
		} else {
			response = Response.status(400); //Bad Request - 400
		}
		response.entity(resposta);
		return response.build();
	}
	@DELETE
	@Path("/{NR_ID_CADASTRO}")
	public Response delete(@PathParam("NR_ID_CADASTRO") Long idCadastro) {
		if (CadastroRepository.delete(idCadastro)) {
			ResponseBuilder response = Response.noContent();//No content - 204
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404);// Not Found - 404
			return response.build();
		}
	}
	@PUT
	@Path("/{NR_ID_CADASTRO}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Valid Cadastro cadastro, @PathParam("NR_ID_CADASTRO") Long idCadastro) {
		Cadastro resposta = CadastroRepository.update(cadastro, idCadastro);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); //Created - 201
		} else {
			response = Response.status(400); //Bad Request - 400
		}
		response.entity(resposta);
		return response.build();
	}
}
