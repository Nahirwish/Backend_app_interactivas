package Controllers;

import Models.Cliente;
import Services.ClienteService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService cs;

    @PostMapping("")
    public ResponseEntity addCliente(@RequestBody final Cliente cl ){
        return cs.addCliente(cl);
    }

    @PostMapping("/{id}/update") //URL
    public ResponseEntity updateCliente(@PathVariable final  @NonNull Integer id, @RequestBody final @NonNull Cliente cl){
        return cs.update(cl, id);

    }

    @GetMapping("/(id)")
    public Cliente getCliente(@PathVariable final @NonNull Integer id){
        return cs.getCliente(id);

    }

    @PostMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable final  @NonNull Integer id){
        return cs.delete(id);
    }

    @GetMapping("")
    public List<Cliente> getAll(){
        return cs.getAll();
    }






}
