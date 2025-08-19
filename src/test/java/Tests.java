import edu.uca.Producto;
import edu.uca.Ropa;
import edu.uca.Electrodomesticos;
import edu.uca.Tienda;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

    @Test
    public void productToStringTest(){
        Producto ropa = new Ropa(1, "producto de prueba", 200);
        System.out.println(ropa);
        Producto electrodomestico = new Electrodomesticos(1, "producto de prueba", 200, 6);
        System.out.println(electrodomestico);
    }

    @Test
    public void tiendaAgregarProductoTest(){
        Tienda tienda = new Tienda();
        Producto producto = new Ropa(1, "producto de prueba", 200);
        tienda.agregarProducto(producto);
        Assert.assertEquals(tienda.getSize(), 1);
    }

    @Test
    public void mostrarInventarioTest(){
        Tienda tienda = new Tienda();
        Producto producto = new Ropa(1, "producto de prueba", 200);
        tienda.agregarProducto(producto);
        tienda.mostrarInventario();
    }

    @Test
    public void createElectrodomesticoTest(){
        Producto producto = new Electrodomesticos(1, "producto de prueba", 200, 6);
        System.out.println(producto);
    }
}
