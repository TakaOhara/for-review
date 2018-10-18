package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.InstructorForm;
import com.example.demo.TaskForm;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskService service;
	
	//INDEX
	@GetMapping
	public ModelAndView task(
			//@ModelAttributeでInstructorFormは自動的にインスタンス化される　
			//htmlに反映させるにはmav.addObjectが必須
			@ModelAttribute("taskForm") TaskForm taskForm,
			ModelAndView mav) {

		//instructorForm.setNewInstructor(true);
		//mav.addObject("instructorForm", instructorForm);
		taskForm.setNewTask(true);
		List<Task> list = service.findAll();
		mav.addObject("taskForm", taskForm);
		mav.addObject("list", list);
		mav.addObject("title", "タスク一覧");

		mav.setViewName("task");
		return mav;
	}
	
	//INSERT
	@PostMapping
	@Transactional(readOnly = false)
	public ModelAndView insert(
			@Validated TaskForm taskForm,//ヴァリデーションはフォームクラスに対して行う
			BindingResult result,
			ModelAndView mav) {
		System.out.println(taskForm);
		Task task = makeTask(taskForm);
		//redirect、失敗したらそのままHTML表示
		if(!result.hasErrors()) {
			service.save(task);
			mav.setViewName("redirect:/task");
		}else {
			taskForm.setNewTask(true);
			mav.addObject("taskForm", taskForm);
			List<Task> list = service.findAll();
			mav.addObject("list", list);
			mav.addObject("title", "タスク一覧 afterInsert");
			mav.setViewName("task");
		}
		return mav;
	}
	
	//Before UPDATE
	@GetMapping(value = "/{id}")//編集ページ
	public ModelAndView showUpdate(
			@ModelAttribute("taskForm") TaskForm taskForm,
			@PathVariable Integer id,
			ModelAndView mav) {
		
		Optional<TaskForm> form = service.getTaskForm(id);
		
		if(!form.isPresent()) {
			mav.setViewName("redirect:/task");
			return mav;
			//return new ModelAndView("redirect:/test")
		}
		
		mav.addObject("taskId", id);
		mav.addObject("taskForm", form.get());
		List<Task> list = service.findAll();
		mav.addObject("list", list);
		mav.addObject("title", "更新フォーム");

		mav.setViewName("task");
		return mav;
	}
	
	//UPDATE
	@PostMapping("/update/{id}")
	@Transactional(readOnly = false)
	public ModelAndView update(
			@PathVariable Integer id,
			@ModelAttribute("taskForm") TaskForm taskForm,
			ModelAndView mav) {
		Task task = makeTask(id, taskForm);
		service.save(task);
		mav.setViewName("redirect:/task/" + id + "/?complete");
		return mav;
	}
	
	//DELETE
	@PostMapping("/delete/{id}")
	@Transactional(readOnly = false)//削除の場合必須
	public ModelAndView delete(
			@PathVariable Integer id,
			ModelAndView mav) {
		service.deleteById(id);
		mav.setViewName("redirect:/task");
		return mav;
	}

	private Task makeTask(TaskForm taskForm) {
		Task task = new Task(taskForm.getTypeId(), taskForm.getTitle(), taskForm.getDetail(), taskForm.getDeadline());
		return task;
	}
	
	private Task makeTask(int id, TaskForm taskForm) {
		Task task = new Task(id, taskForm.getTypeId(), taskForm.getTitle(), taskForm.getDetail(), taskForm.getDeadline());
		return task;
	}
	

}
