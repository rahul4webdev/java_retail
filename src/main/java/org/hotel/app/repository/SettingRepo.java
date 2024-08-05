package org.hotel.app.repository;

import org.hotel.app.dto.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepo extends JpaRepository<Setting, Integer>
{

}
