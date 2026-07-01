package com.routeshare.server.controller;

import com.routeshare.server.entity.RouteRoom;
import com.routeshare.server.service.RouteRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
@Tag(name = "RouteRoom API", description = "카풀 방 관리 API")
public class RouteRoomController {

    private final RouteRoomService routeRoomService;

    // 방 생성
    @Operation(summary = "방 생성")
    @PostMapping
    public RouteRoom createRoom(
            @Valid
            @RequestBody
            RouteRoom room){

        return routeRoomService.createRoom(room);

    }

    // 전체 조회
    @Operation(summary = "방 목록")
    @GetMapping
    public List<RouteRoom> getRoomList(){

        return routeRoomService.getRoomList();

    }

    // 상세 조회
    @Operation(summary = "방 상세 조회")
    @GetMapping("/{id}")
    public RouteRoom getRoom(
            @PathVariable Long id){

        return routeRoomService.getRoom(id);

    }

    // 수정
    @Operation(summary = "방 수정")
    @PutMapping("/{id}")
    public RouteRoom updateRoom(
            @PathVariable Long id,
            @Valid
            @RequestBody RouteRoom room){

        return routeRoomService.updateRoom(id, room);

    }

    // 삭제
    @Operation(summary = "방 삭제")
    @DeleteMapping("/{id}")
    public String deleteRoom(
            @PathVariable Long id){

        routeRoomService.deleteRoom(id);

        return "삭제 완료";

    }

    // 운전자 이름 검색
    @Operation(summary = "운전자 검색")
    @GetMapping("/driver")
    public List<RouteRoom> findDriver(
            @RequestParam String driverName){

        return routeRoomService.findDriver(driverName);

    }

    // 목적지 검색
    @Operation(summary = "목적지 검색")
    @GetMapping("/destination")
    public List<RouteRoom> searchDestination(
            @RequestParam String destination){

        return routeRoomService.searchDestination(destination);

    }

}