package Services;

import Models.Producto;
import Models.ProductoDTO;
import Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.springframework.http.HttpStatus.CREATED;

@Service
public class ProductoService {
    private final ProductoRepository pr;

    @Autowired
    public ProductoService(ProductoRepository pr){
        this.pr = pr;
    }

    public List<ProductoDTO> getAll(){
        return pr.findAll();
    }

    public ResponseEntity update(Integer id, Producto nuevoProducto){
        Producto p = pr.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, "OBJETO NO ENCONTRADO"));
        p.setNombre(nuevoProducto.getNombre());
        p.setDescripcion(nuevoProducto.getDescripcion());
        p.save(p);
        return ResponseEntity.status(OK).build();
    }


    public ResponseEntity addProducto(Producto p){
        pr.save(p);
        return ResponseEntity.status(CREATED).build();
    }

    public Producto getProducto(Integer id){
        return pr.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, "PRODUCTO NO ENCONTRADO"));
    }

    public ResponseEntity delete(Integer id){
        pr.deleteById(id);
        return ResponseEntity.status(OK).build();
    }
}
