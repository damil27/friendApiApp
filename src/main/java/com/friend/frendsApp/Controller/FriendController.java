package com.friend.frendsApp.Controller;


import com.friend.frendsApp.Model.Friend;
import com.friend.frendsApp.Repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
public class FriendController {

    @Autowired private FriendRepository friendRepository;

    @GetMapping("/friend/api")
    public List<Friend> showfriends(){
        return friendRepository.findAll();
    }
    @GetMapping
    @RequestMapping("/friend/api/{id}")
    public Optional<Friend> getfriendById(@PathVariable Long id){
        return friendRepository.findById(id);
    }

    @PostMapping("/friend/api")
    public Friend create(@RequestBody final Friend friend) throws ValidationException {
        if (friend.getFriend_id() == null && friend.getFirstName() != null && friend.getLastName() != null)
            return friendRepository.save(friend);
         else throw new ValidationException("friend can not be created" );
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> exceptionHandler(ValidationException e){
        return new ResponseEntity( e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("friend/api")
    public Friend update(@RequestBody final Friend friend){
        return friendRepository.save(friend);
    }

    @DeleteMapping("/friend/api/{id}")
    public void deletefunct( @PathVariable Long id){
        friendRepository.deleteById(id);
    }



}
