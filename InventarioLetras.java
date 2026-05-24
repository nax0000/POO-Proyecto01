public class InventarioLetras {
    private int[] inventario;
    private int totalCount;
    private int nonZeroCount;

    // constructor
    public InventarioLetras(String recuento) {
        inventario = new int[26];
        totalCount = 0;
        nonZeroCount = 0;
        recuento = recuento.toLowerCase();

        for (int i = 0; i < recuento.length(); i++) {
            char c = recuento.charAt(i);
            if (c >= 'a' && c <='z') {
                int indice = c-'a';
                if (inventario[indice] == 0) {
                    nonZeroCount++;
                }
                inventario[indice]++;
                totalCount++;
            }
        }
    }

    // constructor privado
    private InventarioLetras(int[] nuevoInventario) {
        this.inventario = nuevoInventario;
        this.totalCount = 0;
        this.nonZeroCount = 0;
        for (int count : nuevoInventario) {
            if (count > 0) {
                this.nonZeroCount++;
                this.totalCount += count;
            }
        }
    }
    //2-3
    // desplazamiento 3 posiciones
    public char encriptarCesar(char letra) {
        if (letra >= 'a' && letra <= 'z') {
            return (char)('a'+(letra-'a'+3)% 26);
        } else if (letra >= 'A' && letra <= 'Z') {
            return (char)('A'+(letra-'A'+3)% 26);
        }
        return letra;
    }
    // retrocede 3
    public char desencriptarCesar(char letra) {
        if (letra >= 'a' && letra <= 'z') {
            return (char)('a'+(letra-'a'-3+26)% 26);
        } else if (letra >= 'A' && letra <= 'Z') {
            return (char)('A'+(letra-'A'-3+26)% 26);
        }
        return letra;
    }
    //4-5
    public String encriptarPalabra(String palabra, int desplazamiento) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra >='a' && letra <='z') {
                sb.append((char)('a'+(letra-'a'+desplazamiento)% 26));
            } else if (letra >='A' && letra <='Z') {
                sb.append((char)('A'+(letra-'A'+desplazamiento)% 26));
            } else {
                sb.append(letra);
            }
        }
        return sb.toString();
    }
    public String desencriptarPalabra(String palabra, int desplazamiento) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra >='a' && letra <='z') {
                sb.append((char)('a'+(letra-'a'-desplazamiento+26)% 26));
            } else if (letra >= 'A' && letra <= 'Z') {
                sb.append((char)('A'+(letra-'A'-desplazamiento+26)% 26));
            } else {
                sb.append(letra);
            }
        }
        return sb.toString();
    }
    //6
    public int get(char letra) {
        letra = Character.toLowerCase(letra);
        if (letra<'a' || letra>'z') {
            throw new IllegalArgumentException("Carácter no es alfabético.");
        }
        return inventario[letra-'a'];
    }
    //7
    public void set(char letra, int valor) {
        letra = Character.toLowerCase(letra);
        if (letra < 'a' || letra > 'z' || valor < 0) {
            throw new IllegalArgumentException("Carácter inválido o valor negativo.");
        }
        int indice = letra-'a';
        int valorAnterior = inventario[indice];

        inventario[indice] = valor;
        totalCount += (valor-valorAnterior);

        if (valorAnterior == 0 && valor >0) {
            nonZeroCount++;
        } else if (valorAnterior>0 && valor==0) {
            nonZeroCount--;
        }
    }
    //8
    public int size() {
        return totalCount;
    }
    //9
    public boolean isEmpty() {
        return nonZeroCount == 0;
    }
    //10 con override para reemplazar metodo padre
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < inventario[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        sb.append("]");
        return sb.toString();
    }
    //11
    public InventarioLetras add(InventarioLetras otro) {
        int[] nuevoInventario = new int[26];
        for (int i = 0; i < 26; i++) {
            nuevoInventario[i] = this.inventario[i] + otro.inventario[i];
        }
        return new InventarioLetras(nuevoInventario);
    }
    //12
    public InventarioLetras amplifies(int n) {
        int[] nuevoInventario = new int[26];
        for (int i = 0; i < 26; i++) {
            nuevoInventario[i] = this.inventario[i] * n;
        }
        return new InventarioLetras(nuevoInventario);
    }
    //13
    public InventarioLetras subtract(InventarioLetras otro) {
        int[] nuevoInventario = new int[26];
        for (int i = 0; i < 26; i++) {
            int resta = this.inventario[i] - otro.inventario[i];
            if (resta < 0) {
                return null;
            }
            nuevoInventario[i] = resta;
        }
        return new InventarioLetras(nuevoInventario);
    }
}