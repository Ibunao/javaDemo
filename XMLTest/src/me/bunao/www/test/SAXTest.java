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

	// 解析XML的方法
	public ArrayList<Book> parseXML() {
		//// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 通过factory获取SAXParser实例
		SAXparseHandler handler = null;
		try {
			SAXParser parser = factory.newSAXParser();
			// 创建继承与DefaultHandler的自建的SAXparseHandler对象
			handler = new SAXparseHandler();
			parser.parse("book.xml", handler);
			System.out.println("共有" + handler.getBookList().size() + "本书");
			for (Book book : handler.getBookList()) {
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getAuthor());
				System.out.println(book.getYear());
				System.out.println(book.getPrice());
				System.out.println(book.getLanguage());
			}
		} catch (ParserConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return handler.getBookList();
	}

	// 生成XML
	public void createXML() {
		// 通过解析的来的xml来生成xml
		ArrayList<Book> bookList = parseXML();
		// 生成xml
		// 创建一个SAXTransformerFactory
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			//通过SAXTransformerFactory创建TransformerHandler对象
			TransformerHandler handler = tff.newTransformerHandler();
			//通过handler创建一个Transformer对象
			Transformer tr = handler.getTransformer();
			//通过Transformer对象对生成的xml文件进行设置,设置不能放在setResult之后
			//设置编码
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			//设置换行
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			//创建一个result对象
			//设置要生成文件的名称及位置
			File f = new File("newbooks.xml");
			//如果文件不存在则创建一个
			if(!f.exists()){
				f.createNewFile();
			}
			//创建result对象并使其与handler关联,setResult方法要放在startDocument方法之前
			StreamResult result = new StreamResult(new FileOutputStream(f));
			handler.setResult(result);
			
			//接下来就可以利用handler对象进行xml文件内容的编写
			//打开document
			handler.startDocument();
			//创建属性对象
			AttributesImpl atts = new AttributesImpl();
			//bookstore开始标签
			handler.startElement("", "", "bookstore", atts);
			//通过for循环将从xml获取到的book写到新建的xml中
			for (Book book : bookList) {
				//清空属性
				atts.clear();
				//设置id为1的属性
				atts.addAttribute("", "", "id", "", book.getId());
				handler.startElement("", "", "book", atts);
				atts.clear();
				handler.startElement("", "", "name", atts);
				//向name标签中添加文本信息
				handler.characters(book.getName().toCharArray(), 0, book.getName().length());
				handler.endElement("", "", "name");
				handler.endElement("", "", "book");
				
			}
			//bookstore结束标签
			handler.endElement("", "", "bookstore");
			//关闭document
			handler.endDocument();
		} catch (TransformerConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
