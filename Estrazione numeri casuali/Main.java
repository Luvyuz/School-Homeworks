public class Main {
    public static void main(String[] args) {
        int min = 0;
        int max = 10;
        NumberGenerator numGen = new NumberGenerator(min, max);

        for(int i = 0; i < 15; i ++){
            System.out.println(numGen.randomGeneration());
        }
    }
}