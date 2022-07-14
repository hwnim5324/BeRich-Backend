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

    public Optional<UserDTO> readById(int id){
        return jpauserrepository.findById(id);
    }

    public Optional<UserDTO> readByUserId(String id){
        return jpauserrepository.findByUserId(id);
    }

    public int login(String id, String pw){
        UserDTO user = readByUserId(id).get();
        if(user.getUserId()==null){
            return 1;   //id doesn't exist
        }
        else {
            if (user.getPassword().equals(pw)) {
                return 0;   //success
            } else {
                return -1;  //pw different
            }
        }
    }

    public UserDTO update(int usercode, String pw){
        UserDTO user = readById(usercode).get();
        user.setPassword(pw);
        return jpauserrepository.save(user);
    }

    public void delete(int id){
        jpauserrepository.deleteById(id);
    }

}
