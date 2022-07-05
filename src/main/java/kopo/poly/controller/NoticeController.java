package kopo.poly.controller;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class NoticeController {

    @Resource(name = "NoticeService")
    private INoticeService noticeService;

    @GetMapping(value = "index")
    public String indexPage() throws Exception {
        log.info(this.getClass().getName() + " .indexPage Start !!");
        log.info(this.getClass().getName() + " .indexPage End !!");

        return "index";
    }

    @GetMapping(value = "noticeInfo")
    public String noticeInfo() throws Exception {
        log.info(this.getClass().getName() + " .indexPage Start !!");
        log.info(this.getClass().getName() + " .indexPage End !!");

        return "form";
    }

    @RequestMapping(value = "getNoticeData", method = {RequestMethod.GET, RequestMethod.POST})
    public String getNoticeData(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + ".getNoticeData Start !!");
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));
        String reg_id = CmmUtil.nvl(request.getParameter("red_id"));


        log.info("title : " + title);
        log.info("content : " + contents);
        log.info("reg_id" + reg_id);

        model.addAttribute("title", title);
        model.addAttribute("contents", contents);
        model.addAttribute("reg_id", reg_id);

        log.info(this.getClass().getName() + " .getNoticeData End !!");
        return "getNoticeData";

    }

    @RequestMapping(value = "getInsertNotice")
    public String getInsertNotice(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + ".getNoticeData Start !!");
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));


        log.info("title : " + title);
        log.info("content : " + contents);
        log.info("reg_id : " + reg_id);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setTitle(title);
        pDTO.setContents(contents);
        pDTO.setReg_id(reg_id);

        int res = noticeService.InsertNoticeInfo(pDTO);
        //저장되면 1의 값을 안되면 0의 값을 가짐
        String msg;
        String url = "/getNoticeList";

        if (res > 0) {
            msg = "등록에 성공하셨습니다.";
        } else {
            msg = "등록에 실패하셨습니다.";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + " .getNoticeData End !!");
        return "Redirect";

    }
    /*@RequestMapping(value = "getNoticeList")
    public String getNoticeList(HttpServletrequest request, Model model) throws Exception{
        log.info(this);
    }*/



}


