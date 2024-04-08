package Utilitarios;

import java.lang.reflect.ParameterizedType;
import java.util.List;



public abstract class TestadorDeTipo<T> {

    private Class<T> classe;

    TestadorDeTipo(List<T> list) {
        // Obtém o tipo genérico da superclasse
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getClasse() {
        return classe;
    }
}
