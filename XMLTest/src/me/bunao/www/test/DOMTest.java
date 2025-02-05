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
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder对象
		DocumentBuilder db=null ;
		try {
			 db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return db;
	}
	/**
	 * 解析xml文件
	 */
	public void xmlParser() {
		try {
			// 创建document对象，导入w3c下的包
			// 通过DocumentBuilder对象的parse方法加载book.xml文件到当前项目下
			// 传入路径默认是相对的，也可以是绝对的
			Document document = getDocumentBuilder().parse("book.xml");
			// 获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			// 通过nodelist的getLength()方法可以获取bookList的长度
			// System.out.println("一共有"+bookList.getLength()+"本书");
			for (int i = 0; i < bookList.getLength(); i++) {
				// 在不知道有多少个属性及属性名时
				/*
				 * //通过item方法获得一个book节点note Node book = bookList.item(i);
				 * //获取book的属性通过.getAttributes方法获得NamedNodeMap集合 NamedNodeMap
				 * attrs=book.getAttributes(); //
				 * System.out.println("第"+(i+1)+"本书共有"+attrs.getLength()+"个属性");
				 * for (int j = 0; j < attrs.getLength(); j++) {
				 * //通过item方法获取book节点的某一个属性 Node attr=attrs.item(j); //获取属性名
				 * attr.getNodeName(); //获取属性值 attr.getNodeValue();
				 * 
				 * }
				 */
				// 在知道属性名及个数时，要获取属性值
				// 创建元素节点
				Element book = (Element) bookList.item(i);
				// 通过元素的get
				String attrValue = book.getAttribute("id");
				// System.out.println("id的属性值是"+attrValue);

				// 解析book节点的所有子节点 Element、Text(空白换行也是)、
				NodeList childNodes = book.getChildNodes();
				 System.out.println("第"+(i+1)+"本书有"+childNodes.getLength()+"子节点");
				// 遍历
				for (int k = 0; k < childNodes.getLength(); k++) {
					// 区分出Text类型的node以及element类型的node;Text节点名为#text
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// 获取element类型节点的节点名
						// System.out.println(childNodes.item(k).getNodeName());
						// 获取包含的文本子节点的值 元素节点内的文本属于他的文本子节点
						// 方法一 第一个节点是文本节点时
						// System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
						// 方法二 元素标签内的所有文本内容
						System.out.println(childNodes.item(k).getTextContent());

					}

				}

			}
		}catch (SAXException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成xml
	 */
	public void createXML(){
		DocumentBuilder db=getDocumentBuilder();
		//创建新的xml文件
		Document document=db.newDocument();
		//将生成的xml文件第一行的standalone属性设置为true(默认，不显示)
		document.setXmlStandalone(true);
		//创建根节点
		Element bookstore = document.createElement("bookStore");
		//创建根节点的子节点
		Element book = document.createElement("book");
		//创建book的子节点，并添加到book节点中
		Element name = document.createElement("name");
		//为name节点添加文本节点
		name.setTextContent("小王子");
		book.appendChild(name);
		
		//创建book元素的属性
		book.setAttribute("id", "1");
		//将book子节点添加到bookstore节点下
		bookstore.appendChild(book);
		//将bookstore节点（此时已经包含了book节点）添加到dom树中
		document.appendChild(bookstore);
		
		//将上面创建的转换成xml文件
		//创建TransformerFactory对象
		TransformerFactory tff=TransformerFactory.newInstance();
		try {
			//创建Transformer对象
			Transformer tf = tff.newTransformer();
			//添加换行
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//创建xml文件在默认的相对位置，文件名为book1.xml
			tf.transform(new DOMSource(document), new StreamResult(new File("book1.xml")));
		} catch (TransformerConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
