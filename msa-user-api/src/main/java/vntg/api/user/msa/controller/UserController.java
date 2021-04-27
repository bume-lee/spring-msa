package vntg.api.user.msa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vntg.api.user.msa.component.MessageProducer;
import vntg.api.user.msa.model.User;
import vntg.api.user.msa.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {
	@Autowired
	MessageProducer.JoinSource joinSource;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/")
	public String getUser() {
		return "user Information";
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public String setJoin() {
		// set new join
		joinSource.join().send(MessageBuilder.withPayload("{seq : 13322}").build());
		return "join after";
	}

	@RequestMapping("/getList")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	@RequestMapping("/get/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userRepo.findById(id).get();
	}

}
