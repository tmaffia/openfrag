package com.openfrag.repository;

import com.openfrag.entity.User;
import com.openfrag.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tmaffia on 4/8/16.
 */

@Repository
public interface UserImageRepository extends JpaRepository<UserImage, Long> {

    UserImage findByUser(User user);
}
