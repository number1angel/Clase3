package edu.uca;

public class Ropa extends Producto{

    protected Sizes size;
    protected Materiales material;
    public Ropa(int id, String nombre, double precio, Sizes size, Materiales material) {
        super(id, nombre, precio);
        this.size = size;
        this.material = material;
    }

    public Materiales getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Ropa{id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", size='" + size + "', ,material='" + material + "'}";
    }
}
