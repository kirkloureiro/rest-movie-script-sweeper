package br.com.starwars.sweeper.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.starwars.sweeper.exception.AbstractAppException;
import br.com.starwars.sweeper.exception.NoResultException;
import br.com.starwars.sweeper.exception.ScriptAlreadyReceivedException;
import br.com.starwars.sweeper.rest.MovieScriptReaderRest;
import br.com.starwars.sweeper.service.MovieScriptReaderService;

@Component
@Path("/movie")
public class MovieScriptReaderRestImpl implements MovieScriptReaderRest {

	public Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public MovieScriptReaderService movieScriptReaderService;

	@POST
	@Path("/script")
	@Consumes("text/plain; charset=UTF-8")
	@Override
	public Response postMovieScript(final String movieScriptText) {

		try {
			String entityMessage = movieScriptReaderService.postMovieScript(movieScriptText);
			return Response.status(Response.Status.OK).entity(entityMessage).build();

		} catch (ScriptAlreadyReceivedException e) {
			logger.error(e.getMessage(), e);
			return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
		} catch (AbstractAppException e) {
			logger.error(e.getMessage(), e);
			return Response.status(000).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/settings")
	@Override
	public Response getMovieSettings() {

		try {
			String entityMessage = movieScriptReaderService.getMovieSettings();
			return Response.status(Response.Status.OK).entity(entityMessage).build();

		} catch (AbstractAppException e) {
			logger.error(e.getMessage(), e);
			return Response.status(000).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/settings/{id}")
	@Override
	public Response getMovieSettingsById(@PathParam("id") final String id) {

		try {
			String entityMessage = movieScriptReaderService.getMovieSettingsById(id);
			return Response.status(Response.Status.OK).entity(entityMessage).build();

		} catch (NoResultException e) {
			logger.error(e.getMessage(), e);
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		} catch (AbstractAppException e) {
			logger.error(e.getMessage(), e);
			return Response.status(000).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/characters")
	@Override
	public Response getMovieCharacters() {

		try {
			String entityMessage = movieScriptReaderService.getMovieCharacters();
			return Response.status(Response.Status.OK).entity(entityMessage).build();

		} catch (AbstractAppException e) {
			logger.error(e.getMessage(), e);
			return Response.status(000).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/characters/{id}")
	@Override
	public Response getMovieCharactersById(@PathParam("id") final String id) {

		try {
			String entityMessage = movieScriptReaderService.getMovieCharactersById(id);
			return Response.status(Response.Status.OK).entity(entityMessage).build();

		} catch (NoResultException e) {
			logger.error(e.getMessage(), e);
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		} catch (AbstractAppException e) {
			logger.error(e.getMessage(), e);
			return Response.status(000).entity(e.getMessage()).build();
		}
	}
}
