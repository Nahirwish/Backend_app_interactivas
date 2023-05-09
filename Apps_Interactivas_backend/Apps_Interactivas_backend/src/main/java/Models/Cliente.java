package Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Cliente {
    @Id
    private Integer idCliente;
    @NonNull
    private String nombre;

    @OneToMany(mappedBy = "Cliente")
    @JsonIgnore
    private List<Producto> productos;


}

