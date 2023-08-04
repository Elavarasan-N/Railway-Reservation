package com.edubridge.service;

import com.edubridge.entity.Card;

public interface CardService 
{
	Card addCard(Card card);
	Card getCardById(long cardId);
}
