package lt.salon.booking.userservice.repository;

import lt.salon.booking.userservice.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
