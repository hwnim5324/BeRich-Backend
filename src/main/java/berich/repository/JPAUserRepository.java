package berich.repository;

import berich.DTO.UserDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface JPAUserRepository extends JpaRepository<UserDTO, Integer> {

    @Override
    UserDTO save(UserDTO user);

    @Override
    Optional<UserDTO> findById(Integer id);

    @Override
    void deleteById(Integer id);


    @Override
    <S extends UserDTO, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
