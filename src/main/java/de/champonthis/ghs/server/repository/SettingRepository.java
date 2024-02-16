package de.champonthis.ghs.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.champonthis.ghs.server.entity.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {

}
