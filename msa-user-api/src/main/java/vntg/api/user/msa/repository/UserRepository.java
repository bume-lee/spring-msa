package vntg.api.user.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vntg.api.user.msa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
