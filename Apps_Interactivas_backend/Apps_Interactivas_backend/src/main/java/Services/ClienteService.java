package Services;
import Models.Cliente;
import Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service


public class ClienteService {
    private final ClienteRepository cr;

    @Autowired
    public ClienteService(ClienteRepository cr){
        this.cr = cr;

    }

    public List<Cliente> getAll(){
        return cr.findAll();
    }


    public ResponseEntity update(int id, Cliente clienteNuevo) {
        try {
            Cliente cl = cr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "OBJETO NO ENCONTRADO"));
            cl.setNombre(clienteNuevo.getNombre());
            cl.setIdCliente(clienteNuevo.getIdCliente());
            cr.save(cl);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity addCliente(Cliente c){
        try {
            cr.save(c);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }


    public Cliente getCliente(Integer id){

        return cr.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, "OBJETO NO ENCONTRADO"));


    }

    public ResponseEntity delete (Integer id){
        cr.deleteById(id);
        return ResponseEntity.status(OK).build();



    }


}
