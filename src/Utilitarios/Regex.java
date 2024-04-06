package Utilitarios;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
	
	private String padrao;

	public String getPadrao() {
		return padrao; //Precisa seguir regras do regex. Peça a IA para gerar seu padrão e divirta-se!
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

        if (matcher.find()) {
           return true;	//contém o padrão
        } else {
            return false; //Não contém o padrão especificado
        }
		
	}
	

}
