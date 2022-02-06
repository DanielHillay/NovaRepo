package com.spearhead.nova.service; 

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spearhead.nova.model.Faq;
import com.spearhead.nova.model.StandardResponse;

public interface FaqService {

public ResponseEntity<StandardResponse> saveFaq(Faq faq);

public List<Faq> fetchFaq();

public ResponseEntity<StandardResponse> updateFaq(Long faqId, Faq faq);

public void deletefaq(Long faqId);

	

}
