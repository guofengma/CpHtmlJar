package cn.yiyang.book.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 三峡大学校友会信息登记表
 * 
 * @author wangyiyang
 * @email 1023097289@qq.com
 * @date 2018-10-23 12:55:28
 */
@TableName("book_register")
public class BookRegisterEntity implements Serializable {
//	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String bookId;
	/**
	 * 
	 */
	private String bookName;
	/**
	 * 
	 */
	private String bookAge;
	/**
	 * 
	 */
	private String bookPhone;
	/**
	 * 
	 */
	private String bookStartTime;
	/**
	 * 
	 */
	private String bookDep;
	/**
	 * 
	 */
	private String bookMajor;
	/**
	 * 
	 */
	private String bookClass;
	/**
	 * 
	 */
	private String bookEndTime;
	/**
	 * 
	 */
	private String bookCity;
	/**
	 * 
	 */
	private String bookWorkUnit;
	/**
	 * 
	 */
	private String bookWorkTitle;
	/**
	 * 
	 */
	private String bookEmail;
	/**
	 * 
	 */
	private String bookWeixin;
	/**
	 * 
	 */
	private String bookSex;
	/**
	 * 
	 */
	private String bookRemark01;
	/**
	 * 
	 */
	private String bookRemark02;
	/**
	 * 
	 */
	private String bookRemark03;
	/**
	 * 
	 */
	private String bookRemark04;
	/**
	 * 
	 */
	private String bookRemark05;
	/**
	 * 
	 */
	private String bookRemark06;
	/**
	 * 
	 */
	private String bookRemark07;
	/**
	 * 
	 */
	private String bookRemark08;
	/**
	 * 
	 */
	private String bookRemark09;
	/**
	 * 
	 */
	private String bookRemark10;

	/**
	 * 设置：
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	/**
	 * 获取：
	 */
	public String getBookId() {
		return bookId;
	}
	/**
	 * 设置：
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * 获取：
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * 设置：
	 */
	public void setBookAge(String bookAge) {
		this.bookAge = bookAge;
	}
	/**
	 * 获取：
	 */
	public String getBookAge() {
		return bookAge;
	}
	/**
	 * 设置：
	 */
	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}
	/**
	 * 获取：
	 */
	public String getBookPhone() {
		return bookPhone;
	}
	/**
	 * 设置：
	 */
	public void setBookStartTime(String bookStartTime) {
		this.bookStartTime = bookStartTime;
	}
	/**
	 * 获取：
	 */
	public String getBookStartTime() {
		return bookStartTime;
	}
	/**
	 * 设置：
	 */
	public void setBookDep(String bookDep) {
		this.bookDep = bookDep;
	}
	/**
	 * 获取：
	 */
	public String getBookDep() {
		return bookDep;
	}
	/**
	 * 设置：
	 */
	public void setBookMajor(String bookMajor) {
		this.bookMajor = bookMajor;
	}
	/**
	 * 获取：
	 */
	public String getBookMajor() {
		return bookMajor;
	}
	/**
	 * 设置：
	 */
	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}
	/**
	 * 获取：
	 */
	public String getBookClass() {
		return bookClass;
	}
	/**
	 * 设置：
	 */
	public void setBookEndTime(String bookEndTime) {
		this.bookEndTime = bookEndTime;
	}
	/**
	 * 获取：
	 */
	public String getBookEndTime() {
		return bookEndTime;
	}
	/**
	 * 设置：
	 */
	public void setBookCity(String bookCity) {
		this.bookCity = bookCity;
	}
	/**
	 * 获取：
	 */
	public String getBookCity() {
		return bookCity;
	}
	/**
	 * 设置：
	 */
	public void setBookWorkUnit(String bookWorkUnit) {
		this.bookWorkUnit = bookWorkUnit;
	}
	/**
	 * 获取：
	 */
	public String getBookWorkUnit() {
		return bookWorkUnit;
	}
	/**
	 * 设置：
	 */
	public void setBookWorkTitle(String bookWorkTitle) {
		this.bookWorkTitle = bookWorkTitle;
	}
	/**
	 * 获取：
	 */
	public String getBookWorkTitle() {
		return bookWorkTitle;
	}
	/**
	 * 设置：
	 */
	public void setBookEmail(String bookEmail) {
		this.bookEmail = bookEmail;
	}
	/**
	 * 获取：
	 */
	public String getBookEmail() {
		return bookEmail;
	}
	/**
	 * 设置：
	 */
	public void setBookWeixin(String bookWeixin) {
		this.bookWeixin = bookWeixin;
	}
	/**
	 * 获取：
	 */
	public String getBookWeixin() {
		return bookWeixin;
	}
	/**
	 * 设置：
	 */
	public void setBookSex(String bookSex) {
		this.bookSex = bookSex;
	}
	/**
	 * 获取：
	 */
	public String getBookSex() {
		return bookSex;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark01(String bookRemark01) {
		this.bookRemark01 = bookRemark01;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark01() {
		return bookRemark01;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark02(String bookRemark02) {
		this.bookRemark02 = bookRemark02;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark02() {
		return bookRemark02;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark03(String bookRemark03) {
		this.bookRemark03 = bookRemark03;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark03() {
		return bookRemark03;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark04(String bookRemark04) {
		this.bookRemark04 = bookRemark04;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark04() {
		return bookRemark04;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark05(String bookRemark05) {
		this.bookRemark05 = bookRemark05;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark05() {
		return bookRemark05;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark06(String bookRemark06) {
		this.bookRemark06 = bookRemark06;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark06() {
		return bookRemark06;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark07(String bookRemark07) {
		this.bookRemark07 = bookRemark07;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark07() {
		return bookRemark07;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark08(String bookRemark08) {
		this.bookRemark08 = bookRemark08;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark08() {
		return bookRemark08;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark09(String bookRemark09) {
		this.bookRemark09 = bookRemark09;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark09() {
		return bookRemark09;
	}
	/**
	 * 设置：
	 */
	public void setBookRemark10(String bookRemark10) {
		this.bookRemark10 = bookRemark10;
	}
	/**
	 * 获取：
	 */
	public String getBookRemark10() {
		return bookRemark10;
	}

	@Override
	public String toString() {
		return "BookRegisterEntity{" +
				"bookId='" + bookId + '\'' +
				", bookName='" + bookName + '\'' +
				", bookAge='" + bookAge + '\'' +
				", bookPhone='" + bookPhone + '\'' +
				", bookStartTime='" + bookStartTime + '\'' +
				", bookDep='" + bookDep + '\'' +
				", bookMajor='" + bookMajor + '\'' +
				", bookClass='" + bookClass + '\'' +
				", bookEndTime='" + bookEndTime + '\'' +
				", bookCity='" + bookCity + '\'' +
				", bookWorkUnit='" + bookWorkUnit + '\'' +
				", bookWorkTitle='" + bookWorkTitle + '\'' +
				", bookEmail='" + bookEmail + '\'' +
				", bookWeixin='" + bookWeixin + '\'' +
				", bookSex='" + bookSex + '\'' +
				", bookRemark01='" + bookRemark01 + '\'' +
				", bookRemark02='" + bookRemark02 + '\'' +
				", bookRemark03='" + bookRemark03 + '\'' +
				", bookRemark04='" + bookRemark04 + '\'' +
				", bookRemark05='" + bookRemark05 + '\'' +
				", bookRemark06='" + bookRemark06 + '\'' +
				", bookRemark07='" + bookRemark07 + '\'' +
				", bookRemark08='" + bookRemark08 + '\'' +
				", bookRemark09='" + bookRemark09 + '\'' +
				", bookRemark10='" + bookRemark10 + '\'' +
				'}';
	}
}
