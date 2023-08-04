package com.edubridge.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Card;
import com.edubridge.repository.CardRepository;
import com.edubridge.service.CardService;

@Service
public class CardServiceImpl implements CardService 
{
	@Autowired
	private CardRepository cardRepository;

	@Override
	public Card addCard(Card card) 
	{
		return cardRepository.save(card);
	}

	@Override
	public Card getCardById(long cardId) 
	{
		return cardRepository.findById(cardId);
	}

}
