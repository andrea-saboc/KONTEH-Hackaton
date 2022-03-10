package com.example.hackaton.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hackaton.dto.CreatingDeskDTO;
import com.example.hackaton.model.Desk;
import com.example.hackaton.model.Room;
import com.example.hackaton.repository.DeskRepository;
import com.example.hackaton.repository.RoomRepository;

@Service
public class DeskService {

	@Autowired
	private DeskRepository deskRepository;
	@Autowired
	private RoomRepository roomRepository;

	public List<com.example.hackaton.model.Desk> getAll() {
		// TODO Auto-generated method stub
		return deskRepository.findAll();
	}

	public List<Desk> getByRoom(String room) {
		// TODO Auto-generated method stub
		return new ArrayList<Desk>(roomRepository.findById(room).get().getDesks());
	}

	public Desk save(CreatingDeskDTO desk) {
		// TODO Auto-generated method stub
		Desk newDesk = null;
		try {

			newDesk = saveNewDesk(desk);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return newDesk;
	}

	private Desk saveNewDesk(CreatingDeskDTO desk) {
		// TODO Auto-generated method stub
		Room room = roomRepository.getById(desk.roomId);
		Desk newDesk = new Desk(generateRandomAlphanumericString(), getMaxOrder(room));
		deskRepository.save(newDesk);
		
		ArrayList<Desk> roomsDesks = new ArrayList<Desk>(room.getDesks());
		roomsDesks.add(newDesk);
		room.setDesks(new HashSet<Desk>(roomsDesks));
		return null;
	}

	private int getMaxOrder(Room room) {
		int maxOrder = -1;
		for (Desk desk : room.getDesks()) {
			if (maxOrder < desk.getOrder())
				maxOrder = desk.getOrder();
		}
		return maxOrder + 1;
	}

	public String generateRandomAlphanumericString() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 24;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

	public void deleteDesk(String id) {
		// TODO Auto-generated method stub
		for (Room room : roomRepository.findAll()) {
			for (Desk desk : room.getDesks()) {
				if (desk.getId().equals(id)) {
					room.getDesks().remove(desk);
					roomRepository.save(room);
					return;
				}
			}
		}
	}

}
