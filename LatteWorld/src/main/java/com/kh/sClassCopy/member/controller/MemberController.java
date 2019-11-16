package com.kh.sClassCopy.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.sClassCopy.member.model.service.MemberService;
import com.kh.sClassCopy.member.model.vo.Member;

@Controller	// 다음과 같이 Controller 타입의 어노테이션을 붙여주면 빈 스캐닝을 통해 자동으로 등록(자동으로 Controller로 인식)
public class MemberController {

		// 다음과 같이 Autowired 타입의 어노테이션을 붙여주면 new로 생성할 필요 없이
	    // 변수 선언만 해도 빈 스캐닝을 통해 아래의 'mService'의 이름을 가지고 있는 빈을 찾아서 자동으로 생성해 준다.
	    // MemberServiceImpl 객체를 스프링 컨테이너에게 위임해야(MemberServiceImpl에도 어노테이션 및 id를 줘야)
	    // 컨테이너가 알아서 의존성 주입을 해준다.
		@Autowired
		private MemberService mService;
		
	/* @RequestMapping(value = "login.do", method = RequestMethod.POST) 
	 * @RequestMapping 타입의 어노테이션을 붙여줌으로써 handlerMapping 등록
	 * 
	 * *@RequestMapping의 속성
	 * 여러 개의 속성을 명시 할 때는 "value="를 명시해야 하고
	 * value만 명시해야 되는 경우 바로 @RequsetMapping("value") 요롷게 생략 가능
	 * Default는 get방식임
	 * 
	 * post 방식으로 넘어온 것을 받으려면,
	 * (value ="", method="")와 같이 매핑 조건을 부여하고 전달 하는 method 방식을 지정해 줘야 한다.
	 */	
		
		// 파라미터를 전송 받는 방법
		/*
		 * 1. HttpServletRequest를 통한 전송 받기(기존 jsp Servlet 때 쓰던 방식)
		 *		메소드의 매개변수로 HttpServletReuqest를 작성하면 메소드 실행 시 스프링 컨테이너가 자동으로
		 *		객체를 인자로 주입해준다.
		 */
	/*
	 * @RequestMapping(value = "login.do", method = RequestMethod.POST) public
	 * String memberLogin(HttpServletRequest request) { String id =
	 * request.getParameter("id"); String pwd = request.getParameter("pwd");
	 * 
	 * System.out.println("ID : " + id); System.out.println("PWD : " + pwd);
	 * 
	 * return "home"; }
	 */
		
		/*
		 * 2. @RequestParam 어노테이션 방식
		 * 
		 *		스프링에서는 조금 더 간단하게 파라미터를 받아올 수 있는 방법을 제공해준다.
		 *		HttpServlet과 비슷하게 request 객체를 이용하여 데이터를 전송하는 바업ㅂ
		 *
		 *		파라미터 value 속성에 없는 값이 넘어오는 겨웅 ""이기 때문에 에러는 안남
		 *		이 때 기본적으로 설정한 defaultValue는 적용되지 않음 --> "" 값이 넘어오기 때문(required 기본 값은 true이기 때문)
		 *		하지만 required를 false로 설정한 경우는 값이 넘어오게 되면 defaultValue가 적용 됨
		 * 
		 */
	/*
	 * @RequestMapping(value = "login.do", method = RequestMethod.POST) public
	 * String memberLogin(@RequestParam("id") String id,
	 * 
	 * @RequestParam("pwd") String pwd) {
	 * 
	 * System.out.println("ID : " + id); System.out.println("PWD : " + pwd);
	 * 
	 * return "home"; }
	 */
		
		/*
		 * 3. @RequestParam 어노테이션 생략
		 * 		위의 어노테이션을 생격해도 파라미터 값을 가져와서 변수에 저장할 수 있다.
		 * 		(단, 매개변수를 view에서 넘겨준 값과 동일하게 해야 자동으로 값이 주입됨.
		 * 
		 * 		없는 값일 경우 null이 넘어 옴
		 * 
		 */
		
		/*
//		@RequestMapping(value = "login.do", method = RequestMethod.POST)
		public String memberLogin(String id, String pwd) {
			System.out.println("ID : " + id);
			System.out.println("PWD : " + pwd);
			return "home";
		}
		*/
		
		/*
		 * 4. @ModelAttribute를 이용한 값 전달 방법
		 * 		요청 파라미터가 많은 경우 객체 타입으로 넘겨받게 된다.
		 * 		--> 기본 생성자와 setter를 이용한 주입 방식이기 때문에 둘 중 하나라도 없으면 에러 발생
		 * 			기본 생성자 주석 하면 에러 발생하는 것 확인 가능
		 * 		이를 커맨드 방식이라고도 하는데 
		 * 		스프링 컨테니어가 기본 생성자를 통해 Member 객체를 생성하고
		 * 		setter 메소드로 꺼낸 파라미터들로 값을 변경 후에
		 * 		현재 이 메소드를 호출 할 때 인자로 전달하며 호출하는 방식으로 주입을 해 준다.
		 * 		(주의 : 반드시 name 속성의 값과 필드명 동일 해야 됨, setter 작성하는 규칙에 맞게 작성해야 됨)
		*/
	/*
	 * @RequestMapping(value = "login.do", method = RequestMethod.POST) public
	 * String memberLogin(@ModelAttribute Member m) { System.out.println("ID : " +
	 * m.getId()); System.out.println("PWD : " + m.getPwd()); return "home"; }
	 */
		
		/*
		 *  결론 : 즉, primitive 타입(기본 자료형)은 ReuqestParam으로 받고 객체 타입은 modelAttribute로 받자 
		 */
		
		//	이제는! 전달 받는 것에 대한게 아니라 요청 후 전달하고자 하는 데이터가 있을 경우에 대한 방법
		/*
		 * 1. Model 객체를 사용하는 방법
		 * 		Model을 사용하게 되면 뷰로 전달하고 자하는 데이터를 맵 형식(key, value)로 담을 수 있다.
		 * 		scope는 request이다. 서블릿에서 사용하던 requestScope라고 생각하면 됨
		 * 
		 */
		@RequestMapping(value = "login.do", method = RequestMethod.POST)
		public String memberLogin(Member m, Model model, HttpSession session) {
			Member loginUser = mService.loginMember(m);
			System.out.println(loginUser);
			if(loginUser != null) {
				session.setAttribute("loginUser", loginUser);
				
				return "home";
			}else {
				model.addAttribute("msg","로그인 실패");
				
				return "common/errorPage";
			}
		}
		
}
