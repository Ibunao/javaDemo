package me.bunao.www.handle;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import me.bunao.www.test.Book;
/**
 * DefaultHandler的解析是一步一步自动往下执行的
 *执行顺序startDocument开始解析文档--》startElement（遇到标签的开头时执行）--》
 *characters（遇到文本节点（包括空格和换行符）执行）--》startElement--》characters--》
 *endElement（遇到标签的结尾时执行）--》startElement……这样循环下去
 */
public class SAXparseHandler extends DefaultHandler {
	/**
	 * 用来遍历xml文件的开始标签
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
	//通过全局变量来确定遍历到第几个book
	int bookIndex=0;
	//读的是元素标签
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO 自动生成的方法存根
		super.startElement(uri, localName, qName, attributes);
		//开始解析book元素的属性
		if (qName.equals("book")) {
			bookIndex++;//来确定走到了第几本书
			//创建一个book对象
			book=new Book();
			//如果走到了book标签，解析属性值
/*			//已知book元素下属性的名称，根据属性名获取属性值
			String value=attributes.getValue("id");
			System.out.println(value);*/
			//不知道book元素下属性的名称及个数
			int num=attributes.getLength();
			for (int i = 0; i <num; i++) {
				System.out.print("book元素的第"+(i+1)+"个属性名是"+attributes.getQName(i));
				//可以通过属性名获取相应的值，也可以通过索引
				System.out.println("---属性值是"+attributes.getValue(i));
				if (attributes.getQName(i)=="id") {
					book.setId(attributes.getValue(i));
				}
				
			}
		}else if(!qName.equals("bookstore")){
			System.out.println("节点名是："+qName);
		}
	}
	/**
	 * 用来遍历xml文件中的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO 自动生成的方法存根
		super.endElement(uri, localName, qName);
		//判断是否针对一本书已经结束
		if (qName.equals("book")) {
			bookList.add(book);
//			book=null;
			System.out.println("第"+bookIndex+"本书已经结束了");
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
	 * 解析的是text节点，会把空格和换行符也当做text节点
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO 自动生成的方法存根
		super.characters(ch, start, length);
		value=new String(ch, start, length);
//		System.out.println(value);
		//输出去掉空格和换行符的内容
		if (!value.trim().equals("")) {
			System.out.println(value);
		}
	}
	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO 自动生成的方法存根
		super.startDocument();
		System.out.println("SAX解析开始");
	}
	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO 自动生成的方法存根
		super.endDocument();
		System.out.println("SAX解析结束");
	}
}
