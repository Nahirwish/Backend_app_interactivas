package Controllers;

import Models.Cliente;
import Models.Producto;
import Models.ProductoDTO;
import Services.ProductoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping
public class ProductoController {

    @Autowired
    private ProductoService ps;

    @PostMapping("")
    public ResponseEntity addProducto(@RequestBody final Producto prod){
        return ps.addProducto(prod);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateMateria(@PathVariable final @NonNull Integer id, @RequestBody final Producto p){
        return ps.update(id, p);
    }

    @GetMapping("/(id)")
    public Producto getProducto(@PathVariable final @NonNull Integer id){
        return ps.getProducto(id);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable final @NonNull Integer id){
        return ps.delete(id);
    }

    @GetMapping("")
    public List<ProductoDTO> getAll(){
        return ps.getAll();
    }




}
