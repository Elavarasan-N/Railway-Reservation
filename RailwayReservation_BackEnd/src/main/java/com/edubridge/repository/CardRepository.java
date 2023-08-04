package com.edubridge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Long>
{
	public Card findById(long CardId);
}
