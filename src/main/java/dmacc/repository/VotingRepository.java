package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Voter;

@Repository
public interface VotingRepository extends JpaRepository<Voter, Long> {
	
}
