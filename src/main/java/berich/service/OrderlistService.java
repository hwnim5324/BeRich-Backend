package berich.service;

import berich.repository.JPAOrderlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderlistService {
    private JPAOrderlistRepository jpaorderlistrepository;

    @Autowired
    public OrderlistService(JPAOrderlistRepository jpaorderlistrepository) {
        this.jpaorderlistrepository = jpaorderlistrepository;



    }
}
