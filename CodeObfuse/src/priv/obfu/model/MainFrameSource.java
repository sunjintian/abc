package priv.obfu.model;

public class MainFrameSource {
	
	private String sourcePath;	//程序源代码
	private String chaos;		//混沌映射
	private String second;		//二次映射
	private Boolean date;		//数据混淆
	private Boolean predicate;	//不透明谓词混淆
	private Boolean flatten;	//压扁控制流混淆
	
	public String getSourcePath() {
		return sourcePath;
	}
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	public String getChaos() {
		return chaos;
	}
	public void setChaos(String chaos) {
		this.chaos = chaos;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public Boolean getDate() {
		return date;
	}
	public void setDate(Boolean date) {
		this.date = date;
	}
	public Boolean getPredicate() {
		return predicate;
	}
	public void setPredicate(Boolean predicate) {
		this.predicate = predicate;
	}
	public Boolean getFlatten() {
		return flatten;
	}
	public void setFlatten(Boolean flatten) {
		this.flatten = flatten;
	}
}
