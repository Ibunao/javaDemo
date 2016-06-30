package me.bunao.www.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * 
 *
 */
public class JDOMTest {
	private static ArrayList<Book> bookListA = new ArrayList<Book>();

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		JDOMTest test=new JDOMTest();
		test.parseXML();
//		test.createXML();
	}
	//����xml�ķ���
	public void parseXML() {
		// ���ж�book.xml�ļ���JDOM����
		// ׼������
		// 1������SAXBuilder�Ķ���
		SAXBuilder saxBuilder = new SAXBuilder();

		// ����һ��������
		InputStream in;
		try {
			// ����һ��������
			in = new FileInputStream("book.xml");
			/**
			 * ��������ʱ�Ľ������1���޸�xml�ļ��е�encodingΪ֧�����ĵ�UTF-8 2�������������ĸ�ʽ
			 * InputStreamReader isr=new InputStreamReader(in,"utf-8");
			 * ��isr����.build����
			 */

			// �����������ص�saxBuilder��
			Document document = saxBuilder.build(in);
			// ͨ��document�����ȡxml�ļ��ĸ��ڵ�
			Element rootElement = document.getRootElement();
			// ��ȡ���ڵ��µ��ӽڵ��list����
			List<Element> bookList = rootElement.getChildren();

			// ���н���
			for (Element book : bookList) {
				Book bookEntity = new Book();

				System.out.println("========��ʼ������" + (bookList.indexOf(book) + "����====================="));
				// ����book�����Լ���,(�ڲ�֪���ж��ٸ����Ժ�������ʱ)
				List<Attribute> attrList = book.getAttributes();
				for (Attribute attribute : attrList) {
					// ��ȡ����name
					String attrName = attribute.getName();
					// ��ȡ����ֵ
					String attrValue = attribute.getValue();
					System.out.println("������" + attrName + "-----����ֵ" + attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				// ��book���ӽڵ������ӽڵ�ֵ���б���
				List<Element> bookChilds = book.getChildren();
				for (Element element : bookChilds) {
					System.out.println("�ڵ�����" + element.getName() + "---�ڵ�ֵ" + element.getValue());
					if (element.getName().equals("name")) {
						bookEntity.setName(element.getValue());
					} else if (element.getName().equals("author")) {
						bookEntity.setAuthor(element.getValue());
					} else if (element.getName().equals("year")) {
						bookEntity.setYear(element.getValue());
					} else if (element.getName().equals("price")) {
						bookEntity.setPrice(element.getValue());
					} else if (element.getName().equals("language")) {
						bookEntity.setLanguage(element.getValue());
					}
				}
				bookListA.add(bookEntity);
				bookEntity = null;// �����ͷ���Դ

				System.out.println("========����������" + (bookList.indexOf(book) + "����====================="));
				// ���֪��������,��ȡ����ֵ
				// book.getAttributeValue("id");

			}
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(bookListA.size());
		System.out.println(bookListA.get(1).getId());
		System.out.println(bookListA.get(1).getName());
	}
	//����xml�ķ���
	private void createXML(){
		//����һ�����ڵ�
		Element rss = new Element("rss");
		//Ϊ�ڵ���������
		rss.setAttribute("version", "2.0");
		//����һ��document����
		Document document = new Document(rss);
		
		//�����ӽڵ�
		//�����ӽڵ�
		Element channel = new Element("channel");
		//���ӵ����ڵ�
		rss.addContent(channel);
		Element title=new Element("title");
		title.setText("������������");
		channel.addContent(title);
		
		//����format�������������ʽ
		Format format = Format.getCompactFormat();
		//���û������
		format.setIndent("");
		//����XMLOutputter����
		XMLOutputter outputer = new XMLOutputter();
		//����outputer��document����ת����xml�ĵ�
		try {
			outputer.output(document, new FileOutputStream(new File("rssbook1.xml")));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}