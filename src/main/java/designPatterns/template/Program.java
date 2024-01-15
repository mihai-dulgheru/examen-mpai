package designPatterns.template;

public class Program {
    public static void main(String[] args) {
        AEvaluareDaune evaluareDauneBucatarie = new EvaluareDauneBucatarie();
        System.out.println("Procedura evaluare daune");
        evaluareDauneBucatarie.proceduraEvaluareDaune();
    }
}
