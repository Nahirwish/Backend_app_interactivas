package Models;

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

public class Producto {
    @Id
    private Integer idProducto;
    @NonNull
    private String nombre;
    @NonNull
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}
