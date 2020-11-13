package co.kr.cmmn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.cmmn.BoardVo;
import co.kr.cmmn.Criteria;
import co.kr.cmmn.PageMaker;
import co.kr.cmmn.service.impl.CmmnMapper;

@Controller
public class CmmnController {
	@Autowired
	private CmmnMapper service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model m) {
		m.addAttribute("list", service.getList());
		return "home";
	}
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public String info(Model m, @PathVariable int id) {
		m.addAttribute("boardVo", service.info(id));
		return "/info";
	}
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "/write";
	}
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVo boardVo) {
		service.write(boardVo);
		return "redirect:/";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model m, @PathVariable int id) {
		BoardVo boardVo = service.info(id);
		m.addAttribute("boardVo", boardVo);
		return "/edit";
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(BoardVo boardVo) {
		service.edit(boardVo);
		return "redirect:/";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(Model m, @PathVariable int id) {
		BoardVo boardVo = service.info(id);
		m.addAttribute("boardVo", boardVo);
		return "/delete";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVo boardVo) {
		service.delete(boardVo);
		return "redirect:/";
	}
//	@RequestMapping(value = "/boardList")
//	public String boardList(PagingVo pvo, Model m, @RequestParam(value = "nowPage", required = false)String nowPage, @RequestParam(value = "cntPerPage", required = false)String cntPerPage) {
//		int total = service.countBoard();
//		if (nowPage == null && cntPerPage == null) {
//			nowPage = "1";
//			cntPerPage = "1";
//		} else if (nowPage == null) {
//			nowPage = "1";
//		} else if (cntPerPage == null) {
//			cntPerPage = "1";
//		}
//		pvo = new PagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
//		m.addAttribute("paging", pvo);
//		m.addAttribute("list", service.selectBoard(pvo));
//		return "/boardPaging";
//	}
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public void page(@ModelAttribute("cri") Criteria cri, Model m) {
		m.addAttribute("list", service.page(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.count(cri));
		m.addAttribute("pageMaker", pageMaker);
	}
}