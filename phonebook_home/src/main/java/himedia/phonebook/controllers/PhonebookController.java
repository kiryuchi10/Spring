package himedia.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.phonebook.repositories.vo.PhonebookVo;
import himedia.phonebook.services.PhonebookService;

@Controller("/")
public class PhonebookController {
	@Autowired
	private PhonebookService phonebookService;
	
	@GetMapping("")
	public String phonebookView(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword, Model model) {
		if ("".equals(keyword))
			model.addAttribute("list", phonebookService.getList());
		else
			model.addAttribute("list", phonebookService.searchListByNameKeyword(keyword));
		
		return "list";
	}
	
	@GetMapping("/add")
	public String phonebookAddView() {
		return "addform";
	}
	
	@PostMapping("/add")
	public String phonebookAddAction(@ModelAttribute PhonebookVo phonebookVo, RedirectAttributes redirectAttributes) {
		if (phonebookVo.getName().isBlank() || phonebookVo.getHp().isBlank() || phonebookVo.getTel().isBlank()) {
			redirectAttributes.addFlashAttribute("errorMsg", "빈칸을 두지 마세요");
			return "redirect:/add";
		} else if (phonebookVo.getName().length() > 10 || phonebookVo.getHp().length() > 20 || phonebookVo.getTel().length() > 20) {
			redirectAttributes.addFlashAttribute("errorMsg", "너무길어요 [이름 10자, hp 10자, tel 10자");
			return "redirect:/add";
		}
		phonebookService.addNewPhonebookRow(phonebookVo);	
		return "redirect:/";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteButton(@PathVariable("id") Long id) {
		
		PhonebookVo vo = phonebookService.getOne(id);
		if (vo != null)
			phonebookService.deletePhonebookRow(vo);
		
		return "redirect:/";
	}
	
	/*
	 * @RequestMapping("/addsuccess") public String addSuccess() { return
	 * "phonebook/addsuccess"; }
	 */
	
}
