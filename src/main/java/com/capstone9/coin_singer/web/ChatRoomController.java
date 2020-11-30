//package com.capstone9.coin_singer.web;
//
//import com.capstone9.coin_singer.domain.chat.ChatRoom;
//import com.capstone9.coin_singer.domain.chat.ChatRoomRepository;
//import com.capstone9.coin_singer.domain.chat.LoginInfo;
////import com.capstone9.coin_singer.domain.user.User;
//import com.capstone9.coin_singer.service.JwtTokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/chat")
//public class ChatRoomController {
//
//    private final ChatRoomRepository chatRoomRepository;
//    private final JwtTokenProvider jwtTokenProvider;
//
////    @GetMapping("/room")
////    public String rooms() {
////        return "/room";
////    }
//    @GetMapping("/room")
//    public String rooms(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        model.addAttribute("membername", name);
//        return "/room";
//    }
//
//    @GetMapping("/rooms")
//    @ResponseBody
//    public List<ChatRoom> room() {
//        List<ChatRoom> chatRooms = chatRoomRepository.findAllRoom();
//        chatRooms.stream().forEach(room -> room.setUserCount(chatRoomRepository.getUserCount(room.getRoomId())));
//        return chatRooms;
//    }
//
//    @PostMapping("/room")
//    @ResponseBody
//    public ChatRoom createRoom(@RequestParam String name) {
//        return chatRoomRepository.createChatRoom(name);
//    }
//
//    @GetMapping("/room/enter/{roomId}")
//    public String roomDetail(Model model, @PathVariable String roomId) {
//        model.addAttribute("roomId", roomId);
//        return "/roomdetail";
//    }
//
//    @GetMapping("/room/{roomId}")
//    @ResponseBody
//    public ChatRoom roomInfo(@PathVariable String roomId) {
//        return chatRoomRepository.findRoomById(roomId);
//    }
//
//    @GetMapping("/user")
//    @ResponseBody
//    public LoginInfo getUserInfo() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        return LoginInfo.builder().name(name).token(jwtTokenProvider.generateToken(name)).build();
//    }
////    @GetMapping("/user")
////    @ResponseBody
////    public User getUserInfo() {
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////        String name = auth.getName();
////        return User.builder().name(name).token(jwtTokenProvider.generateToken(name)).build();
////    }
//}
