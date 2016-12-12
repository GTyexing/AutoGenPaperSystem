package cn.edu.zjnu.AutoGenPaperSystem.controller;

import cn.edu.zjnu.AutoGenPaperSystem.service.QuestionsService;
import cn.edu.zjnu.AutoGenPaperSystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by zseapeng on 2016/11/2.
 */
@Controller
@RequestMapping(value = "/api/question")
@ResponseBody
public class QuestionController {
    @Resource
    private UserService userServiceImpl;
    @Resource
    private QuestionsService questionsServiceImpl;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map AddQuestion(Integer userid, String qid, int k) {
        return userServiceImpl.updateByUserId(qid, userid, k);

    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Map RemoveQuestion(Integer userid, String qid, int k) {
        return userServiceImpl.updateByUserId(qid, userid, k);
    }

    @RequestMapping(value = "/allremove", method = RequestMethod.POST)
    public int AllRemove(Integer userid) {
        return userServiceImpl.allremove(userid);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map SaveQuestion(Integer userid, String qid, int k) {
        return userServiceImpl.updateCollectByUserId(qid, userid, k);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map DeleteQuestion(Integer userid, String qid, int k) {
        return userServiceImpl.updateCollectByUserId(qid, userid, k);

    }
}
