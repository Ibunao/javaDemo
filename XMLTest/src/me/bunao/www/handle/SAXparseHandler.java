package me.bunao.www.handle;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import me.bunao.www.test.Book;
/**
 * DefaultHandler�Ľ�����һ��һ���Զ�����ִ�е�
 *ִ��˳��startDocument��ʼ�����ĵ�--��startElement��������ǩ�Ŀ�ͷʱִ�У�--��
 *characters�������ı��ڵ㣨�����ո�ͻ��з���ִ�У�--��startElement--��characters--��
 *endElement��������ǩ�Ľ�βʱִ�У�--��startElement��������ѭ����ȥ
 */
public class SAXparseHandler extends DefaultHandler {
	/**
	 * ��������xml�ļ��Ŀ�ʼ��ǩ
	 */
	private Book book;
	private String value;
	private ArrayList<Book>bookList=new ArrayList<>();
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	//ͨ��ȫ�ֱ�����ȷ���������ڼ���book
	int bookIndex=0;
	//������Ԫ�ر�ǩ
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO �Զ����ɵķ������
		super.startElement(uri, localName, qName, attributes);
		//��ʼ����bookԪ�ص�����
		if (qName.equals("book")) {
			bookIndex++;//��ȷ���ߵ��˵ڼ�����
			//����һ��book����
			book=new Book();
			//����ߵ���book��ǩ����������ֵ
/*			//��֪bookԪ�������Ե����ƣ�������������ȡ����ֵ
			String value=attributes.getValue("id");
			System.out.println(value);*/
			//��֪��bookԪ�������Ե����Ƽ�����
			int num=attributes.getLength();
			for (int i = 0; i <num; i++) {
				System.out.print("bookԪ�صĵ�"+(i+1)+"����������"+attributes.getQName(i));
				//����ͨ����������ȡ��Ӧ��ֵ��Ҳ����ͨ������
				System.out.println("---����ֵ��"+attributes.getValue(i));
				if (attributes.getQName(i)=="id") {
					book.setId(attributes.getValue(i));
				}
				
			}
		}else if(!qName.equals("bookstore")){
			System.out.println("�ڵ����ǣ�"+qName);
		}
	}
	/**
	 * ��������xml�ļ��еĽ�����ǩ
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO �Զ����ɵķ������
		super.endElement(uri, localName, qName);
		//�ж��Ƿ����һ�����Ѿ�����
		if (qName.equals("book")) {
			bookList.add(book);
//			book=null;
			System.out.println("��"+bookIndex+"�����Ѿ�������");
		}else if (qName.equals("name")) {
			book.setName(value);
		}else if (qName.equals("author")) {
			book.setAuthor(value);
		}else if (qName.equals("year")) {
			book.setYear(value);
		}else if (qName.equals("price")) {
			book.setPrice(value);
		}else if (qName.equals("language")) {
			book.setLanguage(value);
		}
	}
	/**
	 * ��������text�ڵ㣬��ѿո�ͻ��з�Ҳ����text�ڵ�
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO �Զ����ɵķ������
		super.characters(ch, start, length);
		value=new String(ch, start, length);
//		System.out.println(value);
		//���ȥ���ո�ͻ��з�������
		if (!value.trim().equals("")) {
			System.out.println(value);
		}
	}
	/**
	 * ������ʶ������ʼ
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO �Զ����ɵķ������
		super.startDocument();
		System.out.println("SAX������ʼ");
	}
	/**
	 * ������ʶ��������
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO �Զ����ɵķ������
		super.endDocument();
		System.out.println("SAX��������");
	}
}
