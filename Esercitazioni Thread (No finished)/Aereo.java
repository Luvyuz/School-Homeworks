public class Aereo {
    private int id;
    private String nome;
    public Aereo(String nome){
        this.nome = nome;
        id = (int)(Math.random() * 10000 + 1);
    }
    public Aereo(){
        id = (int)(Math.random() * 10000 + 1);
    }
    public String getNome(){
        return nome;
    }
    public int getID(){
        return id;
    }
}
