package berich.service;

import berich.DTO.OrderlistDTO;
import berich.DTO.UserDTO;
import berich.repository.JPAOrderlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderlistService {
    private JPAOrderlistRepository jpaorderlistrepository;

    @Autowired
    public OrderlistService(JPAOrderlistRepository jpaorderlistrepository) {
        this.jpaorderlistrepository = jpaorderlistrepository;
    }

    public OrderlistDTO create(OrderlistDTO orderlist){
        return jpaorderlistrepository.save(orderlist);
    }

    public Optional<OrderlistDTO> read(int usercode){
        return jpaorderlistrepository.findById(usercode);
    }

    public OrderlistDTO update(OrderlistDTO orderlist){
        return jpaorderlistrepository.save(orderlist);
    }
}
