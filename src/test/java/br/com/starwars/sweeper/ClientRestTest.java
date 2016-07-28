package br.com.starwars.sweeper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Ignore
public class ClientRestTest extends AbstractClassTest<Object> {

	@Override
	public Object criarObjetoParaTestar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startUp() {
		// TODO Auto-generated method stub

	}

	@Test
	public void clientSendScriptTest() throws Exception {

		String uri = "http://localhost:8080/sweeper/rest/movie/script";

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("screenplay_(2).txt").getFile());
		BufferedReader in = new BufferedReader(new FileReader(file));
		String scriptData = "";
		String line = "";
		while ((line = in.readLine()) != null) {
			scriptData += line + "\n";
		}
		in.close();

		long startTime = System.currentTimeMillis();

		Client client = Client.create();
		WebResource resource = client.resource(uri);
		ClientResponse response = resource.post(ClientResponse.class, scriptData);
		System.out.println("Passei: " + response);
		System.out.println(response.getEntity(String.class));

		long diff = System.currentTimeMillis() - startTime;

		String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(diff),
				TimeUnit.MILLISECONDS.toMinutes(diff) % TimeUnit.HOURS.toMinutes(1),
				TimeUnit.MILLISECONDS.toSeconds(diff) % TimeUnit.MINUTES.toSeconds(1));

		System.out.println("Elapsed time: " + String.valueOf(hms));
	}

	@Test
	public void getSettingsScriptTest() throws Exception {

		Client client = Client.create();
		String uri = "http://localhost:8080/sweeper/rest/movie/settings";
		WebResource resource = client.resource(uri);
		ClientResponse response = resource.get(ClientResponse.class);
		System.out.println("Passei: " + response);
	}
}
