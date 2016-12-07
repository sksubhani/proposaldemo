package org.kpsc.docgen.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kpsc.docgen.dto.Employee;
import org.kpsc.docgen.dto.ProposalBody;
import org.kpsc.docgen.dto.ProposalData;
import org.kpsc.docgen.dto.ProposalFooter;
import org.kpsc.docgen.dto.ProposalHeader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	private static List<Employee> empList = new ArrayList<Employee>();

	//Initialize the list with some data for index screen
	static {
		empList.add(new Employee(101, "Bill Gates", 1000.00, "D100"));
		empList.add(new Employee(102, "Steve Jobs", 2000.00, "D100"));
		empList.add(new Employee(103, "Larry Page", 3000.00, "D200"));
		empList.add(new Employee(104, "Sergey Brin", 4000.00, "D200"));
		empList.add(new Employee(105, "Larry Ellison", 4000.00, "D300"));
	}
	
	
	@GetMapping(path = "/")
	public String welcome() {
		System.out.println("Received request for welcome page.");
		return "home";
	}
	
	@GetMapping(path = "/assumptions")
	public String showAssumptions(@ModelAttribute("model") ModelMap model) {

		model.addAttribute("empList", empList);

		return "assumptions";
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
