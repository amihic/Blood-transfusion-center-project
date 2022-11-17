package com.example.ISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ISA.model.MedCenter;
import com.example.ISA.model.QuestionsForDonnor;
import com.example.ISA.repository.QuestionsForDonnorRepository;

@Service
public class QuestionsForDonnorService {
	
	@Autowired
	private QuestionsForDonnorRepository questionsForDonnorRepository;

	public QuestionsForDonnor save(QuestionsForDonnor respondedQuestionsForDonnor) throws Exception{
		List<QuestionsForDonnor> listOfAll = this.questionsForDonnorRepository.findAll();
        Long id=(long) 0;
        for ( QuestionsForDonnor qfd:listOfAll) {
            id=qfd.getId();
        }
        id=id+1;
        respondedQuestionsForDonnor.setId(id);
        
        return this.questionsForDonnorRepository.save(respondedQuestionsForDonnor);
	}
	
	
	
}
