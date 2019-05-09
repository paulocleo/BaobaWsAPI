package com.baoba.home;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/addfeira")
public class FeiraAddResource {
	
	public static final String URL = "https://baoba-home.firebaseio.com/Feira.json?auth=RLiDBgOkvvXml0sIEVhYBMCI5FgUkNzeLeAeNSsY";

	JSONObject dadosFeiraOriginalJson;
	JSONArray listaFeiraNomes;
	List<Feira> listaFeira;
	
	@RequestMapping(method = RequestMethod.GET)
	public String adicionarFeira(
			@RequestParam(value = "barras", required = true) String barras,
			@RequestParam(value = "data", required = true) String data,
			@RequestParam(value = "nome", required = true) String nome,
			@RequestParam(value = "preco", required = true) String preco,
			@RequestParam(value = "quantidade", required = true) int quantidade,
			@RequestParam(value = "fastTime", required = true) Long fastTime) {
		
		Feira feira = new Feira(barras, nome, preco, quantidade, data, fastTime);
		
		Firebase.addProduto(feira);
		
		return "Post AddFeira esta funcionando " + barras;
	}

}
