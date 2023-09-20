import java.util.LinkedList;

class MutacaoDNA {
    public static LinkedList<Character> realizarMutacao(LinkedList<Character> lista) {

        int i = 0;

        while (i + 1 < lista.size()) {
            if (lista.get(i) !=lista.get(i + 1)) {
                char letraMutada = getLetraFaltante(lista.get(i), lista.get(i + 1));
                lista.remove(i);
                lista.remove(i);
                lista.addLast(letraMutada);
                i = 0;
            } else{
                i++;
            }
        }

        return lista;
    }

    private static char getLetraFaltante(char letra1, char letra2) {
        if (letra1 != 'D' && letra2 != 'D') {
            return 'D';
        } else if (letra1 != 'N' && letra2 != 'N') {
            return 'N';
        } else {
            return 'A';
        }
    }
}
