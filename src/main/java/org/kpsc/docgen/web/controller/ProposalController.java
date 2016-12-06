package org.kpsc.docgen.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.kpsc.docgen.dto.Employee;
import org.kpsc.docgen.dto.ProposalBody;
import org.kpsc.docgen.dto.ProposalData;
import org.kpsc.docgen.dto.ProposalFooter;
import org.kpsc.docgen.dto.ProposalHeader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ProposalController {

	@GetMapping(path = "/")
	public String welcome() {
		System.out.println("Received request for welcome page.");
		return "home";
	}
	
	@PostMapping(path = "/processRequest", consumes = "application/json")
	public ModelAndView processRequest(@RequestBody String inputData) {
		System.out.println("Received request with JSON input data for Employee object.");
		
		Employee emp = new Employee();
		ObjectMapper mapper = new ObjectMapper();
		
		if(isJSONValid(inputData)) {
			try {
				emp = mapper.readValue(inputData, Employee.class);
				
				System.out.println("Employee recived: "+ emp);
				
			} catch(JsonGenerationException je) {
				je.printStackTrace();
			} catch(JsonMappingException jm) {
				jm.printStackTrace();
			} catch(IOException io) {
				io.printStackTrace();
			}
		} else {
			System.out.println("Invalid JSON input data received. Please review and send back.");
			return new ModelAndView("error", "error", inputData);
		}
		
		return new ModelAndView("employee", "employee", emp); // (View JSP, Object Name, Value)
		
	}
	
	public static boolean isJSONValid(String jsonInString ) {
	    try {
	       final ObjectMapper mapper = new ObjectMapper();
	       mapper.readTree(jsonInString);
	       return true;
	    } catch (IOException e) {
	       return false;
	    }
	  }


	@RequestMapping(path = "/showProposal", method = RequestMethod.GET)
	public ModelAndView displayProposal() {
		System.out.println("Received request for displaying proposal pdf page.");

		ProposalHeader headerData = new ProposalHeader();
		ProposalBody bodyData = new ProposalBody();
		ProposalFooter footerData = new ProposalFooter();
		ProposalData pdfData = new ProposalData();

		// Set Proposal PDF Header
		headerData = createProposalHeader(headerData);
		// Set Proposal PDF Body
		bodyData = createProposalBody(bodyData);
		// Set Proposal PDF Footer
		footerData = createProposalFooter(footerData);

		pdfData.setHeader(headerData);
		pdfData.setBody(bodyData);
		pdfData.setFooter(footerData);

		return new ModelAndView("pdfView", "proposalData", pdfData);
	}

	private ProposalHeader createProposalHeader(ProposalHeader header) {
		
		header.setHeaderLeftText("Left Header Data");
		header.setHeaderCenterText("Center Header Data");
		header.setHeaderRightText("Right Header Data");
		return header;
	}

	private ProposalBody createProposalBody(ProposalBody body) {
		body.setTopBodySection("Top Body Data");
		body.setMiddleBodySection("Middle Body Data");
		body.setDownBodySection("Down Body Data");
		
		Map<String, String> otherBodyData = new HashMap<String, String>();
		otherBodyData.put("section1", "Section One Data");
		otherBodyData.put("section2", "Section Two Data");
		otherBodyData.put("section3", "Section Three Data");
		body.setBodyData(otherBodyData);
		
		return body;
	}

	private ProposalFooter createProposalFooter(ProposalFooter footer) {
		footer.setFooterLeftText("Left Footer Data");
		footer.setFooterCenterText("Center Footer Data");
		footer.setFooterRightText("Right Footer Data");
		return footer;
	}

}
