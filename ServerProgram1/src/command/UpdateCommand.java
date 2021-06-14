package command;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateCommand implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String name=request.getParameter("name");
		long point=Long.parseLong( request.getParameter("point"));
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setPoint(point);
		dto.setNo(loginDTO.getNo());
		System.out.println(name);
		System.out.println(point);
		int result = MemberDAO.getInstance().updateMember(dto);
		
		ModelAndView mav=null;
		
		try {
			if (result > 0) {
				loginDTO.setPoint(point);
				loginDTO.setName(name);
				mav=new ModelAndView("/ServerProgram1/member/manager.jsp", true);
			} else {
				mav=new ModelAndView("/ServerProgram1/member/manager.jsp", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
