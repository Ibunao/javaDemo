package me.bunao.www.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4JTest {

	public static void main(String[] args) {
		DOM4JTest test=new DOM4JTest();
		test.createXML();
	}

	// ����XML����
	public void parseXML() {
		// ����book.xml�ļ�
		// ����SAXReader�Ķ���reader
		SAXReader reader = new SAXReader();

		try {
			// ͨ��reader�����read��������book.xml�ļ�����ȡdocument����
			Document document = reader.read(new File("book.xml"));
			// ��ȡ���ڵ�
			Element bookStore = document.getRootElement();
			// ͨ��element�����elementIterator������ȡ������
			Iterator it = bookStore.elementIterator();
			// ��������������ȡ���ڵ��е���Ϣ(�鼮)
			while (it.hasNext()) {
				// ��ȡbook�ڵ�
				Element book = (Element) it.next();
				// ��ȡbook��������������ֵ
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attribute : bookAttrs) {
					System.out.println("������" + attribute.getName() + "---ֵ:" + attribute.getValue());
				}
				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					// ��ȡ������������������ֵ
					System.out.println("�ڵ�����" + bookChild.getName() + "--�ڵ�ֵ" + bookChild.getStringValue());
				}
			}
		} catch (DocumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	//����xml    ����RSS��
	private void createXML(){
		//����document���󣬴�������xml�ĵ�
		Document document = DocumentHelper.createDocument();
		//�������ڵ�rss
		Element rss = document.addElement("rss");
		//��rss�ڵ�����version����
		rss.addAttribute("version", "2.0");
		//�����ӽڵ㼰�ڵ�����    ��rss�ڵ�����channel�ڵ�
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		//���ǩ�������ı�����
		title.setText("<title>");
		//��������xml�ĸ�ʽ
		OutputFormat format=OutputFormat.createPrettyPrint();
		//����xml�ļ�
		//���������
		File file=new File("rssnews.xml");
		XMLWriter writer;
		try {
			//����д���ļ���ַ�������ʽ
			writer=new XMLWriter(new FileOutputStream(file),format);
			//�����Ƿ�ת��
			writer.setEscapeText(false);
			//����
			writer.write(document);
			//�ر�
			writer.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}