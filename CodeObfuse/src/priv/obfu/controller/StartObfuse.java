
/**
 * 
 */
package priv.obfu.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import priv.obfu.chaosFunComp.TwoTentUniformityComp2;
import priv.obfu.model.MainFrameSource;

/**
 * @author Jim
 * @date 2016年6月7日
 *
 */
public class StartObfuse {
	//混沌映射
	private String chaos;		
	//二次映射
	private String second;	
	//是否数据混淆
	private Boolean date;		
	//是否不透明谓词混淆
	private Boolean predicate;	
	//是否压扁控制流混淆
	private Boolean flatten;	
	//原代码目录
	private String sourcePath = "";
	//原代码文件名称
	private String sourceName;
	//读取的原代码
	private byte[] input;
	//源代码未分行
	private String source;
	//源代码分行
	private List<String> sourceLine;
	//
	private String obfuCode = "";
	
	public String getObfuCode() {
		return obfuCode;
	}
	public void setObfuCode(String obfuCode) {
		this.obfuCode = obfuCode;
	}
	public List<String> getSourceLine() {
		return sourceLine;
	}
	public String getSource() {
		return source;
	}
	public void setSourceLine(List<String> sourceLine) {
		this.sourceLine = sourceLine;
	}

	public StartObfuse(String sourcePath){
		this.sourcePath = sourcePath;
	}
	
	/**
	 * 读取原代码
	 */
	public void setSource(){
		try {
		    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.sourcePath));
		    this.input = new byte[bufferedInputStream.available()];
	            bufferedInputStream.read(this.input); 
	            bufferedInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.source = new String(this.input);
	}
	
	public String getObfuFunction() {
		String str = null;
		if(chaos == "Henon映射")
		{
			if(second == "comp_2映射")
			{
				str = TwoTentUniformityComp2.getObfuFunction();
			}
		}
		else if(chaos == "一维帐篷映射")
		{
			if(second == "comp_2映射")
			{
				str = TwoTentUniformityComp2.getObfuFunction();
			}
		}
		else if(chaos == "二维帐篷映射")
		{
			if(second == "comp_2映射")
			{
				str = TwoTentUniformityComp2.getObfuFunction();
			}
		}
		else if(chaos == "TDER-CS映射")
		{
			if(second == "comp_2映射")
			{
				str = TwoTentUniformityComp2.getObfuFunction();
			}
		}
		else if(chaos == "Arnold映射")
		{
			if(second == "comp_2映射")
			{
				str = TwoTentUniformityComp2.getObfuFunction();
			}
		}
		else if(chaos == "Logistic映射")
		{
			if(second == "comp_2映射")
			{
				str = TwoTentUniformityComp2.getObfuFunction();
			}
		}
		return str;
	}
	/**
	 * 运行
	 */
	public void Run(MainFrameSource frameSource){
		chaos = frameSource.getChaos();
		second = frameSource.getSecond();
        date = frameSource.getDate();
        predicate = frameSource.getPredicate();
        flatten = frameSource.getFlatten();
		sourceLine=new ArrayList<String>();
		String str = "";
		for(int i = 0;i<source.length();i++)
		{
			str+=source.charAt(i);
			if(source.charAt(i)=='\n')
			{
				sourceLine.add(str);
				str = "";
			}
		}
		
		List<String> str_obfu=new ArrayList<String>();//存储混淆后的代码
		for(int i=0; i<sourceLine.size(); i++)
		{
			String s = (String) sourceLine.get(i);
			str_obfu.add(s);
			if(s.indexOf("class ") != -1)
			{
				String obfuFunction = getObfuFunction();
				String str1 = "    ";
				for(int j = 0;j<obfuFunction.length();j++)
				{
					str1 += obfuFunction.charAt(j);
					if(obfuFunction.charAt(j)=='\n')
					{
						str_obfu.add(str1);
						str1 = "    ";
					}
				}
			}
			if(date)
			{
				
			}
			String[] strSpilt = s.split(" ");
			for(int j=0;j<strSpilt.length;j++)
			{
				try{
	                int num = Integer.parseInt(strSpilt[j]);
	                
	            }catch (Exception e) {
	                
	            }

			}
			
		}
		for(int i=0; i<str_obfu.size(); i++)
		{
			obfuCode += (String) str_obfu.get(i);
		}
		/*while (!str.equals("end")) {
			str=input.nextLine();
			str_list.add(str);
			cxdm.append(str+'\n');
			
			for(int i=0;i <source.length();i++) 
			{ 
			  if(source.charAt(i)=='{')
			  {
				 pos++;
				 head[pos]=row;
			  }
			  if(source.charAt(i)=='}')
			  {
				
				 tail[head[pos]]=row;
				 pos--;
			  }
			}
			row++;
		}*/
		sourceName = sourcePath.substring(sourcePath.lastIndexOf(File.separator)+1, sourcePath.lastIndexOf("."));
		System.out.println(sourceName);
		
	}
	

}
