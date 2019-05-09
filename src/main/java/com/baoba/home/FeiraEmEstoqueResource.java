package com.baoba.home;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping(value = "/feiraestoque")
public class FeiraEmEstoqueResource {

	public static final String URL = "https://baoba-home.firebaseio.com/Feira.json?auth=RLiDBgOkvvXml0sIEVhYBMCI5FgUkNzeLeAeNSsY";

	JSONObject dadosFeiraOriginalJson;
	JSONArray listaFeiraNomes;
	List<Feira> listaFeira;

	@RequestMapping(method = RequestMethod.GET)
	public String obterProdutosFeira() {

		listaFeira = new ArrayList<Feira>();
		listaFeiraNomes = new JSONArray();

		try {
			
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(URL).build();
			Response response = client.newCall(request).execute();

			dadosFeiraOriginalJson = new JSONObject(response.body().string());

			listaFeiraNomes = dadosFeiraOriginalJson.names();

			for (int i = 0; i < listaFeiraNomes.length(); i++) {
				String nome = listaFeiraNomes.get(i).toString();

				JSONObject dadosUnit = dadosFeiraOriginalJson.getJSONObject(nome);

				if (dadosUnit.getInt("quantidade") > 0) {
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					Date data = formato.parse(dadosUnit.getString("dataVencimento").replace("\"", ""));

					Feira feira = new Feira(
							dadosUnit.getString("codigoBarras"), 
							dadosUnit.getString("nomeProduto"),
							dadosUnit.getString("preco"), 
							dadosUnit.getInt("quantidade"),
							dadosUnit.getString("dataVencimento"), 
							data.getTime());

					listaFeira.add(feira);
				}
			}
			
//			Firebase.addProduto(listaFeira.get(0));

			listaFeira.sort(java.util.Comparator.comparing(Feira::getFastTimeData));

			String feiraConvertida = new Gson().toJson(listaFeira).toString();

			return feiraConvertida;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "Rest Feira em estoque esta funcionando";
	}

}
