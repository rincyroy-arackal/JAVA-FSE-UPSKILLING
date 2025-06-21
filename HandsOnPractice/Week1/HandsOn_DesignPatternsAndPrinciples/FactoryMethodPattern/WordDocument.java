package Week1.HandsOn_DesignPatternsAndPrinciples.FactoryMethodPattern;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document.");
    }
}
