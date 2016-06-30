package me.bunao.www.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		DOMTest test=new DOMTest();
		test.xmlParser();
//		test.createXML();
	}
	public DocumentBuilder getDocumentBuilder(){
		// ����һ��DocumentBuilderFactory�Ķ���
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// ����һ��DocumentBuilder����
		DocumentBuilder db=null ;
		try {
			 db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return db;
	}
	/**
	 * ����xml�ļ�
	 */
	public void xmlParser() {
		try {
			// ����document���󣬵���w3c�µİ�
			// ͨ��DocumentBuilder�����parse��������book.xml�ļ�����ǰ��Ŀ��
			// ����·��Ĭ������Եģ�Ҳ�����Ǿ��Ե�
			Document document = getDocumentBuilder().parse("book.xml");
			// ��ȡ����book�ڵ�ļ���
			NodeList bookList = document.getElementsByTagName("book");
			// ͨ��nodelist��getLength()�������Ի�ȡbookList�ĳ���
			// System.out.println("һ����"+bookList.getLength()+"����");
			for (int i = 0; i < bookList.getLength(); i++) {
				// �ڲ�֪���ж��ٸ����Լ�������ʱ
				/*
				 * //ͨ��item�������һ��book�ڵ�note Node book = bookList.item(i);
				 * //��ȡbook������ͨ��.getAttributes�������NamedNodeMap���� NamedNodeMap
				 * attrs=book.getAttributes(); //
				 * System.out.println("��"+(i+1)+"���鹲��"+attrs.getLength()+"������");
				 * for (int j = 0; j < attrs.getLength(); j++) {
				 * //ͨ��item������ȡbook�ڵ��ĳһ������ Node attr=attrs.item(j); //��ȡ������
				 * attr.getNodeName(); //��ȡ����ֵ attr.getNodeValue();
				 * 
				 * }
				 */
				// ��֪��������������ʱ��Ҫ��ȡ����ֵ
				// ����Ԫ�ؽڵ�
				Element book = (Element) bookList.item(i);
				// ͨ��Ԫ�ص�get
				String attrValue = book.getAttribute("id");
				// System.out.println("id������ֵ��"+attrValue);

				// ����book�ڵ�������ӽڵ� Element��Text(�հ׻���Ҳ��)��
				NodeList childNodes = book.getChildNodes();
				 System.out.println("��"+(i+1)+"������"+childNodes.getLength()+"�ӽڵ�");
				// ����
				for (int k = 0; k < childNodes.getLength(); k++) {
					// ���ֳ�Text���͵�node�Լ�element���͵�node;Text�ڵ���Ϊ#text
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// ��ȡelement���ͽڵ�Ľڵ���
						// System.out.println(childNodes.item(k).getNodeName());
						// ��ȡ�������ı��ӽڵ��ֵ Ԫ�ؽڵ��ڵ��ı����������ı��ӽڵ�
						// ����һ ��һ���ڵ����ı��ڵ�ʱ
						// System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
						// ������ Ԫ�ر�ǩ�ڵ������ı�����
						System.out.println(childNodes.item(k).getTextContent());

					}

				}

			}
		}catch (SAXException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	/**
	 * ����xml
	 */
	public void createXML(){
		DocumentBuilder db=getDocumentBuilder();
		//�����µ�xml�ļ�
		Document document=db.newDocument();
		//�����ɵ�xml�ļ���һ�е�standalone��������Ϊtrue(Ĭ�ϣ�����ʾ)
		document.setXmlStandalone(true);
		//�������ڵ�
		Element bookstore = document.createElement("bookStore");
		//�������ڵ���ӽڵ�
		Element book = document.createElement("book");
		//����book���ӽڵ㣬�����ӵ�book�ڵ���
		Element name = document.createElement("name");
		//Ϊname�ڵ������ı��ڵ�
		name.setTextContent("С����");
		book.appendChild(name);
		
		//����bookԪ�ص�����
		book.setAttribute("id", "1");
		//��book�ӽڵ����ӵ�bookstore�ڵ���
		bookstore.appendChild(book);
		//��bookstore�ڵ㣨��ʱ�Ѿ�������book�ڵ㣩���ӵ�dom����
		document.appendChild(bookstore);
		
		//�����洴����ת����xml�ļ�
		//����TransformerFactory����
		TransformerFactory tff=TransformerFactory.newInstance();
		try {
			//����Transformer����
			Transformer tf = tff.newTransformer();
			//���ӻ���
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//����xml�ļ���Ĭ�ϵ����λ�ã��ļ���Ϊbook1.xml
			tf.transform(new DOMSource(document), new StreamResult(new File("book1.xml")));
		} catch (TransformerConfigurationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}