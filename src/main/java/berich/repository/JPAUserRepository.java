package berich.repository;

import berich.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAUserRepository extends JpaRepository<UserDTO, Integer> {

    @Override
    UserDTO save(UserDTO user);

    @Override
    Optional<UserDTO> findById(Integer id);

    @Override
    void deleteById(Integer id);
}
