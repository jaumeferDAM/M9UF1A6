/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6uf1nf3duala1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author ALUMNEDAM
 */
public class ClaseGenerica extends ClaseAbstracta{

    private final String file = "ficherito.xml";
    DocumentBuilder documentBuilder;
    Document doc;
    Transformer trns;
    StreamResult result;
    DOMSource source;

    public ClaseGenerica(DocumentBuilder documentBuilder, Document doc, Transformer trns, StreamResult result, DOMSource source, String rutaDocument) throws ParserConfigurationException, SAXException, IOException {
        super(rutaDocument);
        this.documentBuilder = documentBuilder;
        this.doc = doc;
        this.trns = trns;
        this.result = result;
        this.source = source;
    }

    
    public void transformar() throws TransformerException {
        trns.transform(source, result);
    }

    public void GuardarEstatDom(Document dom) {
        try {

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            StreamResult result = new StreamResult(file);
            DOMSource source = new DOMSource(dom);
            trans.transform(source, result);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ClaseGenerica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ClaseGenerica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

    @Override
    public Document ActualitzarDOM() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fitxerXML);
            doc.normalizeDocument();
            return doc;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ClaseGenerica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ClaseGenerica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClaseGenerica.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
}

    @Override
    public void AfegirElementDom(Producte p,Document dom) {
//tag producte
         Element producteEle = dom.createElement("Producte");

        Element codiEle = dom.createElement("codi");
        Text codi = dom.createTextNode(p.getCodi() + "");

        Element nomEle = dom.createElement("nom");
        Text nom = dom.createTextNode(p.getNom());

        Element preuEle = dom.createElement("preu");
        Text preu = dom.createTextNode(p.getPreu() + "");

        Element unitatsEle = dom.createElement("unitats");
        Text unitats = dom.createTextNode(p.getUnitats() + "");

//////////        codiEle.appendChild(nomEle);
        dom.getDocumentElement().appendChild(producteEle);
        producteEle.appendChild(codiEle);
        codiEle.appendChild(codi);

        producteEle.appendChild(nomEle);
        nomEle.appendChild(nom);

        producteEle.appendChild(preuEle);
        preuEle.appendChild(preu);

        producteEle.appendChild(unitatsEle);
        unitatsEle.appendChild(unitats);
    }

    @Override
    public Producte obtindreElementPerCodi(Document doc, int codigo) {
        NodeList listaElementos = doc.getElementsByTagName("Producte");

        for (int i = 0; i < listaElementos.getLength(); i++) {
            NodeList nodesFill = listaElementos.item(i).getChildNodes();

            int codi = Integer.parseInt(nodesFill.item(0).getTextContent());

            if (codi == codigo) {

                String nombre = nodesFill.item(1).getTextContent();
                double precio = Double.parseDouble(nodesFill.item(2).getTextContent());
                int cantidad = Integer.parseInt(nodesFill.item(3).getTextContent());
                return new Producte(codi, nombre, precio, cantidad);

            }
        }
        return null;
    }

    @Override
    public ArrayList<Producte> obtindreLlistaElements(Document doc) {
        ArrayList<Producte> listaProductos = new ArrayList<>();
        NodeList llistaElements = doc.getElementsByTagName("Producte");

        for (int i = 0; i < llistaElements.getLength(); i++) {
            NodeList nodesFill = llistaElements.item(i).getChildNodes();

            int codi = Integer.parseInt(nodesFill.item(0).getTextContent());
            String nom = nodesFill.item(1).getTextContent();
            double preu = Double.parseDouble(nodesFill.item(2).getTextContent());
            int unitats = Integer.parseInt(nodesFill.item(3).getTextContent());

            listaProductos.add(new Producte(codi, nom, preu, unitats));
        }

return listaProductos;    }

    @Override
    public boolean modificarElementDom(Document doc, int codigo, String nombre, double precio, int cantidad) {
         NodeList listaElementos = doc.getElementsByTagName("Producto");

        for (int i = 0; i < listaElementos.getLength(); i++) {
            NodeList nodesFill = listaElementos.item(i).getChildNodes();
            System.out.println(nodesFill.item(0).getTextContent());
            int codi = Integer.parseInt(nodesFill.item(0).getTextContent());
            if (codi == codigo) {

                Element element = (Element) nodesFill;
                element.getChildNodes().item(1).setTextContent(nombre);
                element.getChildNodes().item(2).setTextContent(precio + "");
                element.getChildNodes().item(3).setTextContent(cantidad + "");

                return true;
            }
        }
            return false;
    }

    @Override
    public boolean eliminarElementDom(Document doc, int codigo) {
NodeList llistaElements = doc.getElementsByTagName("Producto");

        for (int i = 0; i < llistaElements.getLength(); i++) {

            if (Integer.parseInt(llistaElements.item(i).getChildNodes().item(0).getTextContent())
                    == codigo) {

                Element elementoABorrar = (Element) llistaElements.item(i);
                elementoABorrar.getParentNode().removeChild(elementoABorrar);
                return true;
            }
        }
        return false;
    }    
}
