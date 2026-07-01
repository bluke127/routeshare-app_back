package com.routeshare.server.repository;

import com.routeshare.server.entity.RouteRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RouteRoomRepository extends JpaRepository<RouteRoom, Long> {

    List<RouteRoom> findByDriverName(String driverName);

    Optional<RouteRoom> findByTitle(String title);

    List<RouteRoom> findByDestinationContaining(String destination);

    List<RouteRoom> findByDepartureContaining(String departure);

}