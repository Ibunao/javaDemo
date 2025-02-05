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

	// 解析XML方法
	public void parseXML() {
		// 解析book.xml文件
		// 创建SAXReader的对象reader
		SAXReader reader = new SAXReader();

		try {
			// 通过reader对象的read方法加载book.xml文件，获取document对象
			Document document = reader.read(new File("book.xml"));
			// 获取根节点
			Element bookStore = document.getRootElement();
			// 通过element对象的elementIterator方法获取迭代器
			Iterator it = bookStore.elementIterator();
			// 遍历迭代器，获取根节点中的信息(书籍)
			while (it.hasNext()) {
				// 获取book节点
				Element book = (Element) it.next();
				// 获取book的属性名和属性值
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attribute : bookAttrs) {
					System.out.println("属性名" + attribute.getName() + "---值:" + attribute.getValue());
				}
				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					// 获取属性名及包含的文字值
					System.out.println("节点名：" + bookChild.getName() + "--节点值" + bookChild.getStringValue());
				}
			}
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	//生成xml    创建RSS型
	private void createXML(){
		//创建document对象，代表整个xml文档
		Document document = DocumentHelper.createDocument();
		//创建根节点rss
		Element rss = document.addElement("rss");
		//向rss节点添加version属性
		rss.addAttribute("version", "2.0");
		//生成子节点及节点内容    向rss节点添加channel节点
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		//向标签里添加文本内容
		title.setText("<title>");
		//设置生成xml的格式
		OutputFormat format=OutputFormat.createPrettyPrint();
		//生成xml文件
		//创建输出流
		File file=new File("rssnews.xml");
		XMLWriter writer;
		try {
			//设置写入文件地址和输出样式
			writer=new XMLWriter(new FileOutputStream(file),format);
			//设置是否转义
			writer.setEscapeText(false);
			//生成
			writer.write(document);
			//关闭
			writer.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
