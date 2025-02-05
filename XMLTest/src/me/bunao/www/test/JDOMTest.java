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
		// TODO 自动生成的方法存根
		JDOMTest test=new JDOMTest();
		test.parseXML();
//		test.createXML();
	}
	//生成xml的方法
	public void parseXML() {
		// 进行对book.xml文件的JDOM解析
		// 准备工作
		// 1、创建SAXBuilder的对象
		SAXBuilder saxBuilder = new SAXBuilder();

		// 创建一个输入流
		InputStream in;
		try {
			// 创建一个输入流
			in = new FileInputStream("book.xml");
			/**
			 * 遇到乱码时的解决方法1、修改xml文件中的encoding为支持中文的UTF-8 2、设置输入流的格式
			 * InputStreamReader isr=new InputStreamReader(in,"utf-8");
			 * 将isr传入.build方法
			 */

			// 将输入流加载到saxBuilder中
			Document document = saxBuilder.build(in);
			// 通过document对象获取xml文件的根节点
			Element rootElement = document.getRootElement();
			// 获取根节点下的子节点的list集合
			List<Element> bookList = rootElement.getChildren();

			// 进行解析
			for (Element book : bookList) {
				Book bookEntity = new Book();

				System.out.println("========开始解析第" + (bookList.indexOf(book) + "本书====================="));
				// 解析book的属性集合,(在不知道有多少个属性和属性名时)
				List<Attribute> attrList = book.getAttributes();
				for (Attribute attribute : attrList) {
					// 获取属性name
					String attrName = attribute.getName();
					// 获取属性值
					String attrValue = attribute.getValue();
					System.out.println("属性名" + attrName + "-----属性值" + attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				// 对book的子节点名及子节点值进行遍历
				List<Element> bookChilds = book.getChildren();
				for (Element element : bookChilds) {
					System.out.println("节点名：" + element.getName() + "---节点值" + element.getValue());
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
				bookEntity = null;// 可以释放资源

				System.out.println("========结束解析第" + (bookList.indexOf(book) + "本书====================="));
				// 如果知道属性名,获取属性值
				// book.getAttributeValue("id");

			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(bookListA.size());
		System.out.println(bookListA.get(1).getId());
		System.out.println(bookListA.get(1).getName());
	}
	//创建xml的方法
	private void createXML(){
		//生成一个根节点
		Element rss = new Element("rss");
		//为节点添加属性
		rss.setAttribute("version", "2.0");
		//生成一个document对象
		Document document = new Document(rss);
		
		//添加子节点
		//生成子节点
		Element channel = new Element("channel");
		//添加到根节点
		rss.addContent(channel);
		Element title=new Element("title");
		title.setText("国内最新新闻");
		channel.addContent(title);
		
		//创建format对象设置输出格式
		Format format = Format.getCompactFormat();
		//设置换行输出
		format.setIndent("");
		//创建XMLOutputter对象
		XMLOutputter outputer = new XMLOutputter();
		//利用outputer将document对象转换成xml文档
		try {
			outputer.output(document, new FileOutputStream(new File("rssbook1.xml")));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
