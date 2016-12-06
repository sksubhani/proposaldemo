package org.kpsc.docgen.dto;

import java.io.Serializable;
import java.util.Map;

public class ProposalBody implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String topBodySection;
	private String middleBodySection;
	private String downBodySection;
	private Map<String, String> bodyData;
	public ProposalBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProposalBody(String topBodySection, String middleBodySection, String downBodySection,
			Map<String, String> bodyData) {
		super();
		this.topBodySection = topBodySection;
		this.middleBodySection = middleBodySection;
		this.downBodySection = downBodySection;
		this.bodyData = bodyData;
	}
	public String getTopBodySection() {
		return topBodySection;
	}
	public void setTopBodySection(String topBodySection) {
		this.topBodySection = topBodySection;
	}
	public String getMiddleBodySection() {
		return middleBodySection;
	}
	public void setMiddleBodySection(String middleBodySection) {
		this.middleBodySection = middleBodySection;
	}
	public String getDownBodySection() {
		return downBodySection;
	}
	public void setDownBodySection(String downBodySection) {
		this.downBodySection = downBodySection;
	}
	public Map<String, String> getBodyData() {
		return bodyData;
	}
	public void setBodyData(Map<String, String> bodyData) {
		this.bodyData = bodyData;
	}
	
}
