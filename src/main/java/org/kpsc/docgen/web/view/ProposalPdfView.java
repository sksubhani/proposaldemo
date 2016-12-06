package org.kpsc.docgen.web.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kpsc.docgen.dto.ProposalBody;
import org.kpsc.docgen.dto.ProposalData;
import org.kpsc.docgen.dto.ProposalFooter;
import org.kpsc.docgen.dto.ProposalHeader;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ProposalPdfView extends AbstractProposalPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProposalData pdfData = new ProposalData();
		pdfData = (ProposalData) model.get("proposalData");
		ProposalHeader header = pdfData.getHeader();
		ProposalBody body = pdfData.getBody();
		ProposalFooter footer = pdfData.getFooter();
				
		doc.add(new Paragraph("Here is your Kaiser proposal plan"));

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 3.0f, 2.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("Benefit", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan1", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan2", font));
		table.addCell(cell);

		table.addCell(header.getHeaderLeftText());
		table.addCell(body.getTopBodySection());
		table.addCell(footer.getFooterLeftText());

		doc.add(table);

	}
}
