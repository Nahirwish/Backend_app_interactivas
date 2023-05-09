package Repositories;
import Models.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <ProductoDTO, Integer> {
}
