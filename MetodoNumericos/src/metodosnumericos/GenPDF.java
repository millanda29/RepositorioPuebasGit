package metodosnumericos;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Document;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;


/**
 *
 * @author fing.labcom
 */
public class GenPDF {
    public void generar(String nombre, String valor, String Signo, String exBin, String Mantiza, String valDeci) throws FileNotFoundException, DocumentException{
        
        if(!(nombre.isEmpty()||valor.isEmpty()||Signo.isEmpty()||exBin.isEmpty()||Mantiza.isEmpty()||valDeci.isEmpty())){
            
            FileOutputStream archivo = new FileOutputStream(nombre+".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            
            Paragraph parrafo = new Paragraph("Punto fijo y flotante");
            parrafo.setAlignment(1);
            documento.add(parrafo);
            
            documento.add(new Paragraph("Los valores son:"));
            documento.add(new Paragraph("Valor: "+valor));
            documento.add(new Paragraph("Signo: "+Signo));
            documento.add(new Paragraph("Valor Hexadedcimal: "+exBin));
            documento.add(new Paragraph("Mantiza: "+Mantiza));
            documento.add(new Paragraph("Valor Decimal: "+valDeci));
            documento.close();
            JOptionPane.showMessageDialog(null, "Archivo Creado");
            
        }else{
            JOptionPane.showMessageDialog(null, "Archivo No Creado");
        }
        
    }
}