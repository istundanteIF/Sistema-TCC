package br.edu.ifgoiano.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import br.edu.ifgoiano.entidade.Dados;

public class DataPDFExporter {
	private Dados dados;
	
	public DataPDFExporter(Dados dados) {
		this.dados = dados;
	}
	
	public void export(HttpServletResponse response, Dados dados) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		//font.setStyle(bold);
		font.setSize(12);
		
		Paragraph titulo = new Paragraph(this.dados.getTitulo(), font);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		
		Paragraph resumo = new Paragraph(this.dados.getResumo(), font);
		
		document.add(titulo);
		document.add(resumo);
		document.close();
	}
}
