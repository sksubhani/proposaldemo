package org.kpsc.docgen.dto;

public class ProposalData {
	
	private ProposalHeader header;
	private ProposalBody body;
	private ProposalFooter footer;
	
	public ProposalHeader getHeader() {
		return header;
	}
	public void setHeader(ProposalHeader header) {
		this.header = header;
	}
	public ProposalBody getBody() {
		return body;
	}
	public void setBody(ProposalBody body) {
		this.body = body;
	}
	public ProposalFooter getFooter() {
		return footer;
	}
	public void setFooter(ProposalFooter footer) {
		this.footer = footer;
	}
	

}
