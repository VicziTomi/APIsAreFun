package hu.flowacademy.FeriSaidSo.repository;

import hu.flowacademy.FeriSaidSo.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
