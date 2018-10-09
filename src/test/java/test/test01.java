package test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.UserDAO;
import entity.Member;
import entity.User;
import entity.UserInfo;
import mapper.MemberMapper;
import mapper.UserInfoMapper;
import tools.MD5SaltUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*" })
public class test01 {
	@Autowired
	private UserDAO userDao;

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

	int num = 0;
	int s = 0;
	

	/**
	 * 理顺userinfo,使用前请先备份
	 */
	@Test
	public void updateTest1() {
		List<UserInfo> allUserinfo = userInfoMapper.getAllUserinfo();
		int size = allUserinfo.size();
		for (int i = 1; i < size; i++) {
			allUserinfo = userInfoMapper.getAllUserinfo();
			// 取到需要与前面对比的userinfo
			UserInfo userInfo = allUserinfo.get(i);
			// 获取到所有比取到需要与前面对比的userinfo小的userinfo
			List<UserInfo> UserinfoLtId = userInfoMapper.getAllUserinfoLtId(userInfo);

			
			
			for (int j = 0; j < UserinfoLtId.size(); j++) {
				
				int x = UserinfoLtId.get(j).getUid();// 获取到需要跟本身比较的uid
				int d = userInfo.getUid();// 获取比较者的uid
				if (x > d) {
					//如果比比较者大，就交换位子
					UserInfo userInfoByUidx = userInfoMapper.getUserInfoByUid(x);
					UserInfo userInfoByUidd = userInfoMapper.getUserInfoByUid(d);
					
					 UserInfo userxInfo = new UserInfo();
					 
					 userxInfo.setId(userInfoByUidd.getId());
					 userxInfo.setUid(userInfoByUidx.getUid());
					 userxInfo.setIdNo(userInfoByUidx.getIdNo());
					 userxInfo.setQqNo(userInfoByUidx.getQqNo());
					 userxInfo.setPayAccount(userInfoByUidx.getPayAccount());
					 userxInfo.setContactName(userInfoByUidx.getContactName());
					 userxInfo.setContactMobile(userInfoByUidx.getContactMobile());
					 userxInfo.setRelation(userInfoByUidx.getRelation());
					 userxInfo.setAddress(userInfoByUidx.getAddress());
					 userInfoMapper.updateUserinfoById(userxInfo);
					 
					 UserInfo userxInfox = new UserInfo();
					 userxInfox.setId(userInfoByUidx.getId());
					 userxInfox.setUid(userInfoByUidd.getUid());
					 userxInfox.setIdNo(userInfoByUidd.getIdNo());
					 userxInfox.setQqNo(userInfoByUidd.getQqNo());
					 userxInfox.setPayAccount(userInfoByUidd.getPayAccount());
					 userxInfox.setContactName(userInfoByUidd.getContactName());
					 userxInfox.setContactMobile(userInfoByUidd.getContactMobile());
					 userxInfox.setRelation(userInfoByUidd.getRelation());
					 userxInfox.setAddress(userInfoByUidd.getAddress());
					 userInfoMapper.updateUserinfoById(userxInfox);
					 
					 
					 System.out.println("正在修改了"+ ++s);
					 System.out.println("我修改的uid是"+x+"和"+d);
					 
					 i--;
					 num++;
					 break;
				}
				
			}

		}
		System.out.println("一共执行了"+num+"次修改");
	}

	/**
	 * 理顺user和member表，使用前请先备份
	 */
	@Test
	public void updateTest2() {
		List<User> allUser = userDao.getAllUser();
		int size = allUser.size();// user表的总个数

		// stary=从第几行开始
		for (int stary = 1; stary < size; stary++) {
			User user = allUser.get(stary);// 获取所有需要检测的User对象
			List<User> userLtName = userDao.getUserLtId(user.getId());// 获得比需要检测的userId小的user

			// 使用需要检测的对象对比自己编号小的对象进行对比
			for (int j = 0; j < userLtName.size(); j++) {
				User userx = userLtName.get(j);
				int passive = Integer.parseInt(userx.getName());// 大user
				int nowUserName = Integer.parseInt(user.getName());// 小user


			if (passive > nowUserName) {// 表示应该比当前userName小的却大,把当前user对象与比本身大的user对象交换位子，id不变
					
					User smallUser = new User();// 小user
					smallUser.setId(userx.getId());// 因为根据是要修改大user的id所以一定要是大user的id,其余都是小user的
					smallUser.setName(user.getName());
					smallUser.setPwd(user.getPwd());
					smallUser.setSalt(user.getSalt());
					smallUser.setTime(user.getTime());
					smallUser.setRoot(user.getRoot());
					userDao.updateUserById(smallUser);

					User BigUser = new User();// 大user
					BigUser.setId(user.getId());// 因为根据是要修改小user的id所以一定要是小user的id,其余都是大user的
					BigUser.setName(userx.getName());
					BigUser.setPwd(userx.getPwd());
					BigUser.setSalt(userx.getSalt());
					BigUser.setTime(userx.getTime());
					BigUser.setRoot(userx.getRoot());
					userDao.updateUserById(BigUser);

					List<Member> userxMember = memberMapper.getByUid(userx.getId());// 大member
					List<Member> userMember = memberMapper.getByUid(user.getId());// 小member
					
					Member xmember = new Member();
					xmember.setId(userMember.get(0).getId());
					xmember.setUid(userxMember.get(0).getUid());
					xmember.setName(userxMember.get(0).getName());
					xmember.setSex(userxMember.get(0).getSex());
					xmember.setSchool(userxMember.get(0).getSchool());
					if (userxMember.get(0).getCompany() == null) {
						xmember.setCompany("无");
					} else {
						xmember.setCompany(userxMember.get(0).getCompany());
					}
					xmember.setMobile(userxMember.get(0).getMobile());
					xmember.setStudent(userxMember.get(0).getStudent());
					xmember.setGraduateDate(userxMember.get(0).getGraduateDate());
					xmember.setTime(userxMember.get(0).getTime());
					xmember.setAbnormal(userxMember.get(0).isAbnormal());
					xmember.setProvid(userxMember.get(0).getProvid());
					xmember.setFlag(userxMember.get(0).isFlag());
					xmember.setAlog(userxMember.get(0).getAlog());
					xmember.setRestAmount(userxMember.get(0).getRestAmount());
					xmember.setRestInterest(userxMember.get(0).getRestInterest());
					xmember.setFee(userxMember.get(0).isFee());
					xmember.setAid(userxMember.get(0).getAid());
					xmember.setEid(userxMember.get(0).getEid());
					xmember.setSummaryflag(userxMember.get(0).isSummaryflag());
					xmember.setSeat_provid(userxMember.get(0).getSeat_provid());
					xmember.setPeriodStatus(userxMember.get(0).getPeriodStatus());
					xmember.setSchProId(userxMember.get(0).getSchProId());
					memberMapper.updateMemberById(xmember);

					Member dmember = new Member();
					xmember.setId(userxMember.get(0).getId());
					xmember.setUid(userMember.get(0).getUid());
					xmember.setName(userMember.get(0).getName());
					xmember.setSex(userMember.get(0).getSex());
					xmember.setSchool(userMember.get(0).getSchool());
					if (userMember.get(0).getCompany() == null) {
						xmember.setCompany("无");
					} else {
						xmember.setCompany(userMember.get(0).getCompany());
					}
					xmember.setMobile(userMember.get(0).getMobile());
					xmember.setStudent(userMember.get(0).getStudent());
					xmember.setGraduateDate(userMember.get(0).getGraduateDate());
					xmember.setTime(userMember.get(0).getTime());
					xmember.setAbnormal(userMember.get(0).isAbnormal());
					xmember.setProvid(userMember.get(0).getProvid());
					xmember.setFlag(userMember.get(0).isFlag());
					xmember.setAlog(userMember.get(0).getAlog());
					xmember.setRestAmount(userMember.get(0).getRestAmount());
					xmember.setRestInterest(userMember.get(0).getRestInterest());
					xmember.setFee(userMember.get(0).isFee());
					xmember.setAid(userMember.get(0).getAid());
					xmember.setEid(userMember.get(0).getEid());
					xmember.setSummaryflag(userMember.get(0).isSummaryflag());
					xmember.setSeat_provid(userMember.get(0).getSeat_provid());
					xmember.setPeriodStatus(userMember.get(0).getPeriodStatus());
					xmember.setSchProId(userMember.get(0).getSchProId());
					memberMapper.updateMemberById(dmember);


					
						
					++num;
					System.out.println("执行了" + num + "次更改,uid分别为" + userx.getId() + "," + user.getId());
					stary--;
					break;
				}
			}

		}
		System.out.println("执行完成");
	}

	@Test
	public void test3() {
		PageHelper.startPage(1, 5);
		
		List<UserInfo> allUserinfo = userInfoMapper.getAllUserinfo();
		PageInfo<UserInfo> pageInfo = new PageInfo<>(allUserinfo);
		
		System.out.println(pageInfo);
		for (UserInfo userInfo : allUserinfo) {
			System.out.println(userInfo);
		}
		System.out.println(pageInfo.getSize()+":pageInfo");
		System.out.println(pageInfo.getTotal()+":getTotal");
		System.out.println(pageInfo.getLastPage()+":getLastPage");
		System.out.println(pageInfo.getFirstPage()+":getFirstPage");
	}
}
