package org.kpsc.docgen.dto;

import java.io.Serializable;
import java.util.Map;

public class ProposalHeader implements Serializable {

	private static final long serialVersionUID = 1L;

	private String headerLeftText;
	private String headerCenterText;
	private String headerRightText;
	private Map<String, String> headerOtherText;
	
	public ProposalHeader() {
		
	}

	public ProposalHeader(String headerLeftText, String headerCenterText, String headerRightText,
			Map<String, String> headerOtherText) {
		super();
		this.headerLeftText = headerLeftText;
		this.headerCenterText = headerCenterText;
		this.headerRightText = headerRightText;
		this.headerOtherText = headerOtherText;
	}

	public String getHeaderLeftText() {
		return headerLeftText;
	}

	public void setHeaderLeftText(String headerLeftText) {
		this.headerLeftText = headerLeftText;
	}

	public String getHeaderCenterText() {
		return headerCenterText;
	}

	public void setHeaderCenterText(String headerCenterText) {
		this.headerCenterText = headerCenterText;
	}

	public String getHeaderRightText() {
		return headerRightText;
	}

	public void setHeaderRightText(String headerRightText) {
		this.headerRightText = headerRightText;
	}

	public Map<String, String> getHeaderOtherText() {
		return headerOtherText;
	}

	public void setHeaderOtherText(Map<String, String> headerOtherText) {
		this.headerOtherText = headerOtherText;
	}

	
}
