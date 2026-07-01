package com.routeshare.server.service;

import com.routeshare.server.entity.RouteRoom;
import com.routeshare.server.repository.RouteRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteRoomService {

    private final RouteRoomRepository roomRepository;

    // 방 생성
    public RouteRoom createRoom(RouteRoom room) {
        return roomRepository.save(room);
    }

    // 전체 조회
    public List<RouteRoom> getRoomList() {
        return roomRepository.findAll();
    }

    // 상세 조회
    public RouteRoom getRoom(Long id) {

        return roomRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("존재하지 않는 방입니다."));
    }

    // 수정
    public RouteRoom updateRoom(Long id, RouteRoom updateRoom) {

        RouteRoom room = roomRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("존재하지 않는 방입니다."));

        room.setTitle(updateRoom.getTitle());
        room.setDriverName(updateRoom.getDriverName());
        room.setDeparture(updateRoom.getDeparture());
        room.setDestination(updateRoom.getDestination());
        room.setSeatCount(updateRoom.getSeatCount());
        room.setActiveCount(updateRoom.getActiveCount());

        return roomRepository.save(room);
    }

    // 삭제
    public void deleteRoom(Long id) {

        roomRepository.deleteById(id);

    }

    // 운전자 검색
    public List<RouteRoom> findDriver(String driverName) {

        return roomRepository.findByDriverName(driverName);

    }

    // 목적지 검색
    public List<RouteRoom> searchDestination(String destination) {

        return roomRepository.findByDestinationContaining(destination);

    }

}