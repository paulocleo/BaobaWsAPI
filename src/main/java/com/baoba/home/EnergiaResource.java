package com.baoba.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@RestController
@RequestMapping(value = "/energias")
public class EnergiaResource {

	public static final String URL = "https://baoba-home.firebaseio.com/Energia.json?auth=RLiDBgOkvvXml0sIEVhYBMCI5FgUkNzeLeAeNSsY";

	JSONObject dadosEnergiaOriginalJson;
	JSONArray listaNomes;
	List<Energia> listaEnergias;
	
	@RequestMapping(method = RequestMethod.GET)
	public String obterEnergias() {
		
		listaEnergias = new ArrayList<Energia>();
		listaNomes = new JSONArray();
		
		try {
			
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(URL).build();
			Response response = client.newCall(request).execute();
			
			dadosEnergiaOriginalJson = new JSONObject(response.body().string());
						
			listaNomes = dadosEnergiaOriginalJson.names();
			
			for(int i=0; i < listaNomes.length(); i++)
			{
				String nome = listaNomes.get(i).toString();
				
				JSONObject dadosUnit = dadosEnergiaOriginalJson.getJSONObject(nome);
				
				Energia energia = new Energia(
						dadosUnit.getString("medidaKwh"), 						
						dadosUnit.getString("dataMedida"), 
						dadosUnit.getBoolean("flagConta"), 
						dadosUnit.getLong("ordem"));
				
				listaEnergias.add(energia);
			}
			
			String energiaConvertida = new Gson().toJson(listaEnergias).toString();
			
//			System.out.println(energiaConvertida);
									
			return energiaConvertida;
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Rest esta funcionando";
	}
}
