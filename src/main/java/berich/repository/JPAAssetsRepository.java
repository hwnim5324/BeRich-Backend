package berich.repository;

import berich.DTO.AssetsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAAssetsRepository extends JpaRepository<AssetsDTO, Integer> {

    @Override
    AssetsDTO save(AssetsDTO assets);

    @Override
    Optional<AssetsDTO> findById(Integer id);
}
