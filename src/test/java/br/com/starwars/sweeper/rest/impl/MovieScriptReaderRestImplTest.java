package br.com.starwars.sweeper.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import br.com.starwars.sweeper.AbstractClassTest;
import br.com.starwars.sweeper.exception.ScriptAlreadyReceivedException;
import br.com.starwars.sweeper.service.MovieScriptReaderService;

public class MovieScriptReaderRestImplTest extends AbstractClassTest<MovieScriptReaderRestImpl> {

	private MovieScriptReaderService mockMovieScriptReaderService;
	private Logger mockLogger;

	@Override
	public MovieScriptReaderRestImpl criarObjetoParaTestar() {

		MovieScriptReaderRestImpl testObject = new MovieScriptReaderRestImpl();
		testObject.movieScriptReaderService = mockMovieScriptReaderService;
		testObject.logger = mockLogger;

		return testObject;
	}

	@Override
	public void startUp() {
		mockMovieScriptReaderService = createStrictMock(MovieScriptReaderService.class);
		mockLogger = createNiceMock(Logger.class);
	}

	@Test
	public void postMovieScriptSucessfullyTest() throws Exception {

		// Mock data to return
		String movieScriptText = "Abc";
		String returnMessage = "Just a test";

		// Expects
		EasyMock.expect(mockMovieScriptReaderService.postMovieScript(movieScriptText)).andReturn(returnMessage);

		// ReplayAll
		replayAll();

		// Do Test
		MovieScriptReaderRestImpl objectTest = criarObjetoParaTestar();
		Response returnResponse = objectTest.postMovieScript(movieScriptText);

		// VerifyAll
		verifyAll();

		// Asserts
		Assert.assertNotNull(returnResponse);
		Assert.assertEquals(returnMessage, returnResponse.getEntity());
		Assert.assertEquals(Response.Status.OK.getStatusCode(), returnResponse.getStatus());
	}

	@Test
	public void postMovieScriptAlreadySentTest() throws Exception {

		// Mock data to return
		String movieScriptText = "Abc";
		String returnMessage = "Just a test";

		// Expects
		EasyMock.expect(mockMovieScriptReaderService.postMovieScript(movieScriptText))
				.andThrow(new ScriptAlreadyReceivedException(returnMessage));

		// ReplayAll
		replayAll();

		// Do Test
		MovieScriptReaderRestImpl objectTest = criarObjetoParaTestar();
		Response returnResponse = objectTest.postMovieScript(movieScriptText);

		// VerifyAll
		verifyAll();

		// Asserts
		Assert.assertNotNull(returnResponse);
		Assert.assertEquals(returnMessage, returnResponse.getEntity());
		Assert.assertEquals(Response.Status.FORBIDDEN.getStatusCode(), returnResponse.getStatus());
	}

	@Test
	public void getMovieSettingsSucessfullyTest() throws Exception {

		// Mock data to return
		String returnMessage = "Just a test";

		// Expects
		EasyMock.expect(mockMovieScriptReaderService.getMovieSettings()).andReturn(returnMessage);

		// ReplayAll
		replayAll();

		// Do Test
		MovieScriptReaderRestImpl objectTest = criarObjetoParaTestar();
		Response returnResponse = objectTest.getMovieSettings();

		// VerifyAll
		verifyAll();

		// Asserts
		Assert.assertNotNull(returnResponse);
		Assert.assertEquals(returnMessage, returnResponse.getEntity());
		Assert.assertEquals(Response.Status.OK.getStatusCode(), returnResponse.getStatus());
	}

	@Test
	public void getMovieCharactersSucessfullyTest() throws Exception {

		// Mock data to return
		String returnMessage = "Just a test";

		// Expects
		EasyMock.expect(mockMovieScriptReaderService.getMovieCharacters()).andReturn(returnMessage);

		// ReplayAll
		replayAll();

		// Do Test
		MovieScriptReaderRestImpl objectTest = criarObjetoParaTestar();
		Response returnResponse = objectTest.getMovieCharacters();

		// VerifyAll
		verifyAll();

		// Asserts
		Assert.assertNotNull(returnResponse);
		Assert.assertEquals(returnMessage, returnResponse.getEntity());
		Assert.assertEquals(Response.Status.OK.getStatusCode(), returnResponse.getStatus());
	}
}
