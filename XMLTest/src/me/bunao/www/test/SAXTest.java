package me.bunao.www.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Handler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import me.bunao.www.handle.SAXparseHandler;

public class SAXTest {

	public static void main(String[] args) {
		SAXTest test=new SAXTest();
		test.createXML();
	}

	// ����XML�ķ���
	public ArrayList<Book> parseXML() {
		//// ��ȡһ��SAXParserFactory��ʵ��
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// ͨ��factory��ȡSAXParserʵ��
		SAXparseHandler handler = null;
		try {
			SAXParser parser = factory.newSAXParser();
			// �����̳���DefaultHandler���Խ���SAXparseHandler����
			handler = new SAXparseHandler();
			parser.parse("book.xml", handler);
			System.out.println("����" + handler.getBookList().size() + "����");
			for (Book book : handler.getBookList()) {
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getAuthor());
				System.out.println(book.getYear());
				System.out.println(book.getPrice());
				System.out.println(book.getLanguage());
			}
		} catch (ParserConfigurationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return handler.getBookList();
	}

	// ����XML
	public void createXML() {
		// ͨ������������xml������xml
		ArrayList<Book> bookList = parseXML();
		// ����xml
		// ����һ��SAXTransformerFactory
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			//ͨ��SAXTransformerFactory����TransformerHandler����
			TransformerHandler handler = tff.newTransformerHandler();
			//ͨ��handler����һ��Transformer����
			Transformer tr = handler.getTransformer();
			//ͨ��Transformer��������ɵ�xml�ļ���������,���ò��ܷ���setResult֮��
			//���ñ���
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			//���û���
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			//����һ��result����
			//����Ҫ�����ļ������Ƽ�λ��
			File f = new File("newbooks.xml");
			//����ļ��������򴴽�һ��
			if(!f.exists()){
				f.createNewFile();
			}
			//����result����ʹ����handler����,setResult����Ҫ����startDocument����֮ǰ
			StreamResult result = new StreamResult(new FileOutputStream(f));
			handler.setResult(result);
			
			//�������Ϳ�������handler�������xml�ļ����ݵı�д
			//��document
			handler.startDocument();
			//�������Զ���
			AttributesImpl atts = new AttributesImpl();
			//bookstore��ʼ��ǩ
			handler.startElement("", "", "bookstore", atts);
			//ͨ��forѭ������xml��ȡ����bookд���½���xml��
			for (Book book : bookList) {
				//�������
				atts.clear();
				//����idΪ1������
				atts.addAttribute("", "", "id", "", book.getId());
				handler.startElement("", "", "book", atts);
				atts.clear();
				handler.startElement("", "", "name", atts);
				//��name��ǩ������ı���Ϣ
				handler.characters(book.getName().toCharArray(), 0, book.getName().length());
				handler.endElement("", "", "name");
				handler.endElement("", "", "book");
				
			}
			//bookstore������ǩ
			handler.endElement("", "", "bookstore");
			//�ر�document
			handler.endDocument();
		} catch (TransformerConfigurationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
