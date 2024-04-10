package Recepcao;

import Modelos.ModeloLista.*;
import Modelos.ModelosPessoa.Cliente;

public class GerenciarFila {

    public static Fila<Cliente> filaNormal = new Fila<Cliente>();
    public static Fila<Cliente> filaPreferencial = new Fila<Cliente>();
    public static Fila<Cliente> filaVIP = new Fila<Cliente>();

}
