package proxyPatternExample;

public class Test {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded and displayed
        image1.display();
        System.out.println();

        // Image is already loaded, so display is immediate
        image1.display();
        System.out.println();

        // Image will be loaded and displayed
        image2.display();
    }

}
