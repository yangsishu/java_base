package docx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocxToHtml {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Word2007ToHtml();
	}
	
	
    public static void Word2007ToHtml() throws Exception {
        String filepath = "/Users/sishuyss/Documents/tet22/";
        String fileName = "in.docx";
        String htmlName = "in1.html";
        final String file = filepath + fileName;
        File f = new File(file);  
        if (!f.exists()) {  
            System.out.println("Sorry File does not Exists!");  
        } else {  
            if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {  
                  
                // 1) 加载word文档生成 XWPFDocument对象  
                InputStream in = new FileInputStream(f);  
                XWPFDocument document = new XWPFDocument(in);  
  
                // 2) 解析 XHTML配置 (这里设置IURIResolver来设置图片存放的目录)  
                File imageFolderFile = new File(filepath);  
                XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(imageFolderFile));  
                options.setExtractor(new FileImageExtractor(imageFolderFile));  
                options.setIgnoreStylesIfUnused(false);  
                options.setFragment(true);  
                  
                // 3) 将 XWPFDocument转换成XHTML  
                OutputStream out = new FileOutputStream(new File(filepath + htmlName));  
                XHTMLConverter.getInstance().convert(document, out, options);  
                
                //也可以使用字符数组流获取解析的内容
//                ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
//                XHTMLConverter.getInstance().convert(document, baos, options);  
//                String content = baos.toString();
//                System.out.println(content);
//                 baos.close();
            } else {  
                System.out.println("Enter only MS Office 2007+ files");  
            }  
        }  
    } 

}