package cn.edu.zjnu.AutoGenPaperSystem.controller;

import cn.edu.zjnu.AutoGenPaperSystem.service.QuestionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zseapeng on 2016/10/28.
 */
@Controller
@RequestMapping(value = "/api/updateinfo")
//@SessionAttributes("userid")
@ResponseBody
public class updateInfoController {
    @Resource
    private QuestionsService questionsServiceImpl;


    @RequestMapping(value = "/{date}/{subjectName}/question", method = RequestMethod.GET)
    public Map getUpdateQuestion(@PathVariable String date,
                                 @PathVariable String subjectName,
                                 @RequestParam int page,
                                 HttpServletRequest servletRequest) {
        HttpSession session = servletRequest.getSession();
        int userid;
        try {
            userid = (Integer) session.getAttribute("userid");
        } catch (Exception e) {
            userid = -1;
        }
        date = getDateForm(date);
        int subId = getSubId(subjectName);
        //记得改userid!!!!!!!!!!!!!!!!!!!!!!!
        Map map = questionsServiceImpl.selectQuestionByTime(subId, date, page, userid);
        return map;

    }


    private String getDateForm(String date) {
        String newDate = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        return newDate;
    }

    private int getSubId(String subjectName) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(subjectName);
        int subId = Integer.parseInt(matcher.replaceAll("").trim());
        return subId;
    }

}
