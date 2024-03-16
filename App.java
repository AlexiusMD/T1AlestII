public class App{
    public static void main(String[] args) {
        MapNav mn = new MapNav("testes/casoA2000.txt");
        int total = mn.navigateMap();
        System.out.println("O valor total obtido foi: " + total);
    }
}