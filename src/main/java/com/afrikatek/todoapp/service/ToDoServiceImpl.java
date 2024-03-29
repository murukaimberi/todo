package com.afrikatek.todoapp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.afrikatek.todoapp.model.ToDo;
import com.afrikatek.todoapp.repository.ToDoRepository;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;
	
	@Override
	public List<ToDo> findAll() {
		return toDoRepository.findAll();
	}

	@Override
	public Page<ToDo> findAll(Pageable pageable) {
		return toDoRepository.findAll(pageable);
	}

	@Override
	public ToDo findById(Long id) {
		return toDoRepository.getOne(id);
	}

	@Override
	public List<ToDo> findByPostedBefore(Date datePosted) {
		return toDoRepository.findByDatePostedBefore(datePosted);
	}

	@Override
	public List<ToDo> findByPostedAfter(Date datePosted) {
		return toDoRepository.findByDatePostedAfter(datePosted);
	}

	@Override
	public List<ToDo> findByDueBefore(Date date) {
		return toDoRepository.findByDateDueBefore(date);
	}

	@Override
	public ToDo addToDo(ToDo toDo) {
		return toDoRepository.save(toDo);
	}

	@Override
	public ToDo updateToDo(ToDo toDo) {
		return toDoRepository.save(toDo);
	}

	@Override
	public boolean deleteToDoById(Long id) {
		try {
			toDoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteToDo(ToDo toDo) {
		try {
			toDoRepository.delete(toDo);
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Date convertStringToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		Date dateString = null;
		try {
			dateString = formatter.parse(date);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

}
