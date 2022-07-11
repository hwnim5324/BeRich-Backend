package berich.service;

import berich.DTO.AssetsDTO;
import berich.repository.JPAAssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {
    private JPAAssetsRepository jpaassetsrepository;

    @Autowired
    public AssetsService(JPAAssetsRepository jpaassetsrepository) {
        this.jpaassetsrepository = jpaassetsrepository;
    }
}
