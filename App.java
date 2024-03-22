public class App{
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        MapNav mn = new MapNav("testes/casoA2000.txt");
        int total = mn.navigateMap();
        System.out.println("O valor total obtido foi: " + total);
        long end = System.currentTimeMillis();
        double elapsed = (end - start);
        double elapsedSeconds = elapsed / 1000;
        System.out.println("Time elapsed: " + elapsedSeconds);
    }
}