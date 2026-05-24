public class Main {
    public static void main(String[] args) {
        InventarioLetras inv1 = new InventarioLetras("Alan Touring");
        InventarioLetras inv2 = new InventarioLetras("Ada Lovelace");
        InventarioLetras suma = inv1.add(inv2);
        System.out.println(suma);
    }
}
