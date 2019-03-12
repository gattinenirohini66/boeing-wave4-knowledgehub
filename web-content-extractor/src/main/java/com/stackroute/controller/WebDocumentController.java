package com.stackroute.controller;

import com.stackroute.domain.SearchDocument;
import com.stackroute.domain.WebDocument;
import com.stackroute.service.WebDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "api/v1")
public class WebDocumentController {
    private WebDocumentService webDocumentService;
    private SearchDocument searchDocument1;
    @Autowired
    public WebDocumentController(WebDocumentService webDocumentService){
        this.webDocumentService = webDocumentService;
    }

    @PostMapping("/searchdoc")
    public ResponseEntity<String> postSearchDoc(@RequestBody SearchDocument searchDoc){
        ResponseEntity responseEntity;
        try{
            this.searchDocument1=new SearchDocument();
            searchDocument1.setId(searchDoc.getId());
            searchDocument1.setConceptName(searchDoc.getConceptName());
            searchDocument1.setDomain(searchDoc.getDomain());
            searchDocument1.setLink(searchDoc.getLink());
            webDocumentService.sendSearchdoc(searchDocument1);
            responseEntity = new ResponseEntity<String>("Successfully posted", HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("webdoc")
    public ResponseEntity<?> getWebDoc(){
        ResponseEntity responseEntity;
        try {
//            webDocumentService.extractWebContent(searchDocument1);
            webDocumentService.extractTitle(searchDocument1);
//            webDocumentService.extractMetadata(searchDocument1);
            webDocumentService.extractDescription(searchDocument1);
            webDocumentService.extractKeywords(searchDocument1);
            webDocumentService.extractImageCount(searchDocument1);
            webDocumentService.extractCodePercentage(searchDocument1);
            responseEntity= new ResponseEntity<WebDocument>(webDocumentService.getContentExtractorResults(), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}


