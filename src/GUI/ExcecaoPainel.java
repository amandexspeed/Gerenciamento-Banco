package GUI;
import javax.swing.JOptionPane;

public class ExcecaoPainel {
    public static void exibirExcecao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

