package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.InstructorForm;
import com.example.demo.entity.Instructor;
import com.example.demo.repositories.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorRepository repository;
	
	@Override
	public List<Instructor> findAll() {
		List<Instructor> list = repository.findAll();
		return list;
	}

	@Override
	public Optional<InstructorForm> getInstructorForm(int id) {
		Optional<Instructor> inst = repository.findById(id);
		if(!inst.isPresent()) {
			return Optional.ofNullable(null);
		}
		InstructorForm form = new InstructorForm(
				inst.get().getFirstName(),
				inst.get().getLastName(),
				inst.get().getEmail(),
				inst.get().getInstructorDetail().getYoutubeChannel(),
				inst.get().getInstructorDetail().getHobby(),
				false);
		return Optional.ofNullable(form);
	}

	@Override
	public void save(Instructor instructor) {
		repository.saveAndFlush(instructor);

	}

	@Override
	public void deleteById(int id) {
		Optional<Instructor> inst =  repository.findById(id);
		System.out.println(inst.isPresent());
		if(inst.isPresent()) {
			repository.deleteById(id);
		}

	}

}
