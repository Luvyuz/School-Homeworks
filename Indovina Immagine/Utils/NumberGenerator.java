package Utils;
/*
 * Random number generator
 * without duplicates
 */
public class NumberGenerator {
    
    private int min,max;
    private boolean[] extracted;
    public NumberGenerator(int min, int max){
        this.min = min;
        this.max = max;
        extracted = new boolean[max];
        reset();
    }

    public int randomGeneration(){
        //reset();
        int x = -1;
        if(canExtract()){
            do{
                x = (int) (Math.random() * (max - min) + min);
            }while(extracted[x]);
            extracted[x] = true;
            //System.out.println(x);
        }
        return x;
    }
    private boolean canExtract(){
        boolean extract = true;

        for(int i = 0; i < max; i++){
            extract = extract && extracted[i];
        }
        return !extract;
    }

    private void reset(){
        for(int i = 0; i < extracted.length; i++){
            extracted[i] = false;
        }
    }
}
