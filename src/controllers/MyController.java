package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jdbc.JdbcDao;

@Controller

public class MyController {
	private JdbcDao JdbcDao = new JdbcDao();

	@RequestMapping("process.do")
	public ModelAndView processData(@RequestParam("data") String s) throws ClassNotFoundException, SQLException {
		ArrayList<ArrayList<String>> table=JdbcDao.Readit(s);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view.jsp");
		mv.addObject("result", table);
		return mv;
	}
	@RequestMapping("write.do")
	public ModelAndView writeData(@RequestParam("write") String s) throws ClassNotFoundException, SQLException {
			int update = JdbcDao.Writeit(s);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Query.jsp");
			mv.addObject("writen", update);
			return mv;
	}
}
