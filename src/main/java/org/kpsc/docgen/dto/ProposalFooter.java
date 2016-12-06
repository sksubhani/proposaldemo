package org.kpsc.docgen.dto;

import java.io.Serializable;
import java.util.Map;

public class ProposalFooter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String footerLeftText;
	private String footerCenterText;
	private String footerRightText;
	private Map<String, String> footerOtherData;

	public ProposalFooter() {
		
	}

	public ProposalFooter(String footerLeftText, String footerCenterText, String footerRightText,
			Map<String, String> footerOtherData) {
		super();
		this.footerLeftText = footerLeftText;
		this.footerCenterText = footerCenterText;
		this.footerRightText = footerRightText;
		this.footerOtherData = footerOtherData;
	}

	public String getFooterLeftText() {
		return footerLeftText;
	}

	public void setFooterLeftText(String footerLeftText) {
		this.footerLeftText = footerLeftText;
	}

	public String getFooterCenterText() {
		return footerCenterText;
	}

	public void setFooterCenterText(String footerCenterText) {
		this.footerCenterText = footerCenterText;
	}

	public String getFooterRightText() {
		return footerRightText;
	}

	public void setFooterRightText(String footerRightText) {
		this.footerRightText = footerRightText;
	}

	public Map<String, String> getFooterOtherData() {
		return footerOtherData;
	}

	public void setFooterOtherData(Map<String, String> footerOtherData) {
		this.footerOtherData = footerOtherData;
	}
	
	
	

}
