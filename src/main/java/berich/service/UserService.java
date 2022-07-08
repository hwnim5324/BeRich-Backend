package berich.service;

import berich.DTO.UserDTO;
import berich.repository.JPAUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private JPAUserRepository jpauserrepository;

    @Autowired
    public UserService(JPAUserRepository jpauserrepository) {
        this.jpauserrepository = jpauserrepository;
    }

    public UserDTO create(UserDTO user){
        return jpauserrepository.save(user);
    }

    public Optional<UserDTO> read(int id){
        return jpauserrepository.findById(id);
    }

    public UserDTO update(int id, String pw){
        UserDTO user = read(id).get();
        user.setPassword(pw);
        return jpauserrepository.save(user);
    }

    public void delete(int id){
        jpauserrepository.deleteById(id);
    }

}
