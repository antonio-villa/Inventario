package com.inventario.Controller;

import com.inventario.DTO.DTOActualizar;
import com.inventario.DTO.DTOCarrito;
import com.inventario.DTO.DTOFerreteria;
import com.inventario.DTO.DTORespuesta;
import com.inventario.Entity.*;
import com.inventario.repository.RepositoryFerreteria;
import com.inventario.repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class Controller {
    private final LogicaCarrito logicaCarrito = new LogicaCarrito();
    private RepositoryProducto repositoryProducto;

    @Autowired
    private RepositoryFerreteria ferreteriaRepo;
    @Autowired
    public Controller(RepositoryProducto repositoryProducto) {
        this.repositoryProducto = repositoryProducto;
    }


    @PostMapping("/crear")
    public ResponseEntity<?> SaveProduct(@RequestBody Materiales materiales) {
        if (repositoryProducto.existsByNombrep(materiales.getNombrep())) {
            return new ResponseEntity<>("el producto ya existe pendejo", HttpStatus.OK);
        }
        repositoryProducto.save(materiales);
        return new ResponseEntity<>("producto guardado", HttpStatus.OK);
    }



    @GetMapping("/listar")
    public List<Materiales> listar() {
        return repositoryProducto.findAll();
    }

    @GetMapping("/buscador")
    public List<Materiales> buscador(@RequestParam("q") String nombrep) {
        //posdata agregar un condicion para ver si existe el producto que se busca
        return repositoryProducto.findByNombrepContainingIgnoreCase(nombrep);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestParam("q") String nombrep) {
        if (repositoryProducto.existsByNombrep(nombrep)) {
            return new ResponseEntity<>("el producto a sido eliminado", HttpStatus.OK);
        }
        return new ResponseEntity<>("el producto no existe wey", HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?>actualizar(@RequestBody DTOActualizar actualizar){



        return null;}


    @PostMapping("/ventas")
    public ResponseEntity<?> vantas(@RequestBody DTOCarrito dtoCarrito) {
        CarritoCompra compra = new CarritoCompra();
        if (repositoryProducto.existsByNombrep(dtoCarrito.getNombre())) {
            Materiales datos = repositoryProducto.findByNombrep(dtoCarrito.getNombre()).get();
            compra.setNombrep(datos.getNombrep());
            if (dtoCarrito.getCantidad() > datos.getCantidad()) {
                return new ResponseEntity<>("no hay suficiente stok en almacen", HttpStatus.OK);
            }
            compra.setCantidad(dtoCarrito.getCantidad());
            compra.setPrecio(datos.getPrecio());
            var SumaTotal = datos.getPrecio() * dtoCarrito.getCantidad();
            compra.setTotal(SumaTotal);

            logicaCarrito.agregarProducto(compra);

            List<CarritoCompra> pro = logicaCarrito.mostrarProductos();
            double total = logicaCarrito.mosstrarCarrito();
            DTORespuesta respuesta = new DTORespuesta(pro, total);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);

//actualizar en la base de datos la cantidad de productos que se van agregando en el carrito de compra
        }
        return new ResponseEntity<>("el producto que buscas no existe", HttpStatus.OK);
    }

    @PostMapping("/limpiarCarrito")
    public List<CarritoCompra> LimpiarCarrito(){
        List<CarritoCompra> mause =logicaCarrito.mostrarProductos();
        mause.clear();
        return mause;
    }

    @PostMapping("/ferre")
    public ResponseEntity<?>ferreteria(@RequestBody DTOFerreteria Dtoferreteria){
        Ferreteria ferreteria = new Ferreteria();
        if(ferreteriaRepo.existsByCodigo(Dtoferreteria.getCodigo())){
            return ResponseEntity.ok("El producto ya esta en la base de datos");
        }
        ferreteria.setNombrep(Dtoferreteria.getNombrep());
        ferreteria.setCantidad(Dtoferreteria.getCantidad());
        ferreteria.setPrecio(Dtoferreteria.getPrecio());
        ferreteria.setCodigo(Dtoferreteria.getCodigo());
        ferreteria.setTotal(Dtoferreteria.getPrecio() * Dtoferreteria.getCantidad());
        ferreteriaRepo.save(ferreteria);
        return ResponseEntity.ok("producto guaradado ");
    }

    /*@GetMapping("/listarFerre")
    public List<Ferreteria> listarFerre() {
        return ferreteriaRepo.findAll();
    }*/
}