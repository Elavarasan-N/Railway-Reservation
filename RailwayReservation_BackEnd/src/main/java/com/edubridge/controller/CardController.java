package com.edubridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.Card;
import com.edubridge.service.CardService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/card")
public class CardController 
{
	@Autowired
	private CardService cardService;
	
	@PostMapping("/addCard")
	public ResponseEntity<Card> addCard(@RequestBody  Card card)
	{
		return new ResponseEntity<Card>(cardService.addCard(card),HttpStatus.CREATED);
	}
	
	@GetMapping("{cardId}")
	public ResponseEntity<Card> getCardById(@PathVariable("cardId") long cardId)
	{
		return new ResponseEntity<Card>(cardService.getCardById(cardId),HttpStatus.OK);
	}
	
}
