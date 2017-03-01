/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6uf1nf3duala1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

/**
 *
 * @author ALUMNEDAM
 */
public abstract class ClaseAbstracta {
     protected File fitxerXML;

    public ClaseAbstracta(String rutaDocument) throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        this.fitxerXML = new File(rutaDocument);

    }

    public abstract Document ActualitzarDOM();

    public abstract void GuardarEstatDom(Document dom);

    public abstract void AfegirElementDom(Producte p,Document dom);

    public abstract Producte obtindreElementPerCodi(Document doc, int codigo);

    public abstract ArrayList<Producte> obtindreLlistaElements(Document doc);

    public abstract boolean modificarElementDom(Document doc, int codigo, String nombre, double precio, int cantidad);

    public abstract boolean eliminarElementDom(Document doc, int codigo);

}
