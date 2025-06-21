package Week1.HandsOn_DesignPatternsAndPrinciples.FactoryMethodPattern;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document.");
    }
}
