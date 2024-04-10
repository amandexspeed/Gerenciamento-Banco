package Utilitarios;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {

	private String padrao;

	public String getPadrao() {
		return padrao;
	}

	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}

	public Regex(String padrao) {
		this.padrao = padrao;
	}

	public boolean teste(String texto) {
		Pattern padraoRegex = Pattern.compile(this.padrao);
		Matcher matcher = padraoRegex.matcher(texto);

		return matcher.find(); // Retorna true se encontrar o padrão no texto
	}
}
