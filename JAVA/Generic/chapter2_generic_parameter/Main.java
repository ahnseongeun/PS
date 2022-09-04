
package JAVA.Generic.chapter2_generic_parameter;
public class Main {
    public static void main(String[] args) {
        Product<Integer, String> product = new Product<>();
        Product<String, Integer> product1 = new Product<>();

        product.setKind(5);
        product.setModel("TEST");

        product1.setKind("TESTCASE");
        product1.setModel(100);

        System.out.println(product.getModel() + " " + product.getKind());
        System.out.println(product1.getModel() + " " + product1.getKind());
    }
}
