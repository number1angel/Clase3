import edu.uca.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    @Test
    public void productToStringTest(){
        Producto ropa = new Ropa(1, "producto de prueba", 200, Sizes.S, Materiales.ALGODON);
        System.out.println(ropa);
    }

    @Test
    public void tiendaAgregarProductoTest(){
        Tienda tienda = new Tienda();
        Producto producto = new Ropa(1, "producto de prueba", 200, Sizes.S, Materiales.ALGODON);
        tienda.agregarProducto(producto);
        Assert.assertEquals(tienda.getSize(), 1);
    }

    @Test
    public void mostrarInventarioTest(){
        Tienda tienda = new Tienda();
        Producto producto = new Ropa(1, "producto de prueba", 200, Sizes.S, Materiales.ALGODON);
        tienda.agregarProducto(producto);
        tienda.mostrarInventario();
    }

    @Test
    public void crearElectrodomesticoTest(){
        Producto producto = new Electrodomesticos(1, "producto de prueba", 200, 6);
        System.out.println(producto);
    }
}
