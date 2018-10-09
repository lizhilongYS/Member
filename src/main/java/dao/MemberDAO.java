package dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dto.CostDTO;
import dto.SchoolDTO;
import dto.SummaryDTO;
import entity.Clue;
import entity.MemAndExpBase;
import entity.Member;
import entity.Period;
import entity.Picture;
import entity.Province;
import entity.ResultType;
import entity.Summary;
import entity.User;
import entity.UserMessage;
import mapper.MemberMapper;
import mapper.PeriodMapper;
import tools.FeePayFileExcel;
import tools.Result;

@Service
public class MemberDAO {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PeriodMapper periodMapper;

	public List<Member> getByUid(int uid) {
		return memberMapper.getByUid(uid);
	}

	public void updateRest(Member member) {
		memberMapper.updateRest(member);
	}

	public void update(Member member) {
		memberMapper.update(member);
	}

	public List<Member> getAll() {
		return memberMapper.getAll();
	}
	
	public List<Member> getAllIdAndName(){
		return memberMapper.getAllIdAndName();
	}

	public List<Summary> getSumAll(Summary summary) {
		return memberMapper.getSumAll(summary);
	}

	public Member getMemById(int id) {
		return memberMapper.getMemById(id);
	}

	public ResultType getSex() {
		return memberMapper.getSex();
	}

	public ResultType getStudent() {
		return memberMapper.getStudent();
	}

	public ResultType getAge() {
		return memberMapper.getAge();
	}

	public int getCount() {
		return memberMapper.getCount();
	}

	public List<Province> getProvinces() {
		return memberMapper.getProvinces();
	}

	public List<Province> getProvince() {
		return memberMapper.getProvince();
	}

	public List<Province> getBornProvince() {
		return memberMapper.getBornProvince();
	}

	public Member getMemByName(String name) {
		return memberMapper.getMemByName(name);
	}

	public int getIdByName(String name) {
		return memberMapper.getIdByName(name);
	}
	
	public Member getMemByMobile(String mobile) {
		return memberMapper.getMemByMobile(mobile);
	}

	public ArrayList<User> samePro(int provid) {
		return (ArrayList<User>) memberMapper.samePro(provid);
	}

	public List<User> getMemDetails(int id) {
		return memberMapper.getMemDetails(id);
	}

	public Province getProvByProvId(int provid) {
		return memberMapper.getProvByProvId(provid);
	}

	public ArrayList<User> sameScho(String school) {
		return (ArrayList<User>) memberMapper.sameScho(school);
	}

	public ArrayList<User> sameAge(String idNo) {
		return (ArrayList<User>) memberMapper.sameAge(idNo);
	}

	public Picture getCover(int uid) {
		return memberMapper.getCover(uid);
	}

	public void add(Member member) {
		memberMapper.add(member);
	}

	// 获取会员编号
	public String getMemNum(int mid) {
		return memberMapper.getUnameByMid(mid);
	}

	public void print(String[] headers, String path, String title) throws IOException {
		FeePayFileExcel ef = new FeePayFileExcel();
		ef.exportExcel(title, headers, memberMapper.getMemberCost(0), path);
	}

	public List<String> getAllSchoolByPage(SchoolDTO schoolDTO) {
		return memberMapper.getAllSchoolByPage(schoolDTO);
	}

	public int getSchoolMemberCount(String school) {
		return memberMapper.getSchoolMemberCount(school);
	}

	public void setcustomPay(ArrayList<Period> list, Member member) {
		for (Period period : list) {
			periodMapper.add(period);
		}
		memberMapper.update(member);
	}
	
	public Result getMemberCost(int type, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<CostDTO> list = memberMapper.getMemberCost(type);
		PageInfo<CostDTO> pageInfo = new PageInfo<>(list);
		return Result.ok(list, pageInfo.getPageNum(), pageInfo.getPages());
	}
	
	public List<String> getSchoolByPage(SchoolDTO schoolDTO) {
//		PageHelper.startPage(page, rows);
//		List<String> list = memberMapper.getSchoolByProvice(province);
//		PageInfo<String> pageInfo = new PageInfo<>(list);
//		return Result.ok(list, pageInfo.getPageNum(), pageInfo.getPages());
		return memberMapper.getSchoolByPage(schoolDTO);
	}	
	public User getMemberInfoByName(String mname){
		System.out.println(memberMapper.getMemberInfoByName(mname));
		return memberMapper.getMemberInfoByName(mname);
	}
	
	public List<MemAndExpBase>getNoSummaryMembersByPage(SummaryDTO summaryDTO){
		return memberMapper.getNoSummaryMembersByPage(summaryDTO);
	}
	
	public void setSummaryFlag(String usertype,Integer id,Integer flag){
		Map paramMap = new HashMap<>();
		paramMap.put("usertype", usertype);
		paramMap.put("id", id);
		paramMap.put("flag", flag);
		memberMapper.setSummaryFlag(paramMap);
	}
}
