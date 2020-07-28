package com.friend.frendsApp.Repositories;

import com.friend.frendsApp.Model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
