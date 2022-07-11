package berich.repository;

import berich.DTO.OrderlistDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAOrderlistRepository extends JpaRepository<OrderlistDTO, Integer> {

    @Override
    OrderlistDTO save(OrderlistDTO orderlist);

    @Override
    List<OrderlistDTO> findAllById(Iterable id);
}
