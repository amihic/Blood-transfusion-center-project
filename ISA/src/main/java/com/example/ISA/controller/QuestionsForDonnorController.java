package com.example.ISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISA.model.QuestionsForDonnor;
import com.example.ISA.model.User;
import com.example.ISA.repository.QuestionsForDonnorRepository;
import com.example.ISA.service.QuestionsForDonnorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/QuestionsForDonnor")
public class QuestionsForDonnorController {
	
	@Autowired
	private QuestionsForDonnorService questionsForDonnorService;
	
	@Autowired
	private QuestionsForDonnorRepository questionsForDonnorRepository;
	
	@RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<QuestionsForDonnor> save(@RequestBody QuestionsForDonnor respondedQuestionsForDonnor) throws Exception{
		QuestionsForDonnor newRespondedQuestionsForDonnor = this.questionsForDonnorService.save(respondedQuestionsForDonnor);
		if(newRespondedQuestionsForDonnor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newRespondedQuestionsForDonnor, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/all",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<QuestionsForDonnor>> findAll(){
		List<QuestionsForDonnor> allQuestionsForDonnor = this.questionsForDonnorRepository.findAll();
		return new ResponseEntity<>(allQuestionsForDonnor, HttpStatus.OK);
	}
	
	
}
