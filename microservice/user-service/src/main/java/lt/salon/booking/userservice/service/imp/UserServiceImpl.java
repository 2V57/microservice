package lt.salon.booking.userservice.service.imp;

import lombok.RequiredArgsConstructor;
import lt.salon.booking.userservice.exception.UserException;
import lt.salon.booking.userservice.modal.User;
import lt.salon.booking.userservice.repository.UserRepository;
import lt.salon.booking.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User creaeUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new UserException("User not found with id - " + id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new UserException("User not exist with id " + id);
        }
        userRepository.deleteById(optionalUser.get().getId());
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new UserException("User not found with id - " + id);
        }

        User existingUser = optionalUser.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setPhone(user.getPhone());
        existingUser.setUsername(user.getUsername());

        return userRepository.save(existingUser);
    }
}
