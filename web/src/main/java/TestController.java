import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mr.f on 2016/10/20.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static final Logger logger= LoggerFactory.getLogger(TestController.class);

    @Autowired
//    NumTestMapper numTestMapper;

    @RequestMapping("/list")
    public String selectListByExample(Model view){

        try {
//            List<NumTest> list = numTestMapper.selectAll();
//            view.addAttribute("list",list);
        }catch (Exception e){
            logger.error("错误",e);
        }
        return "test/list";
    }
    @RequestMapping("/info")
    public String selectInfoById(
            @RequestParam(value = "id",defaultValue="1") Integer id,
            Model view){
        try {

        }catch (Exception e){
            logger.error("错误",e);
        }
        return "test/info";
    }

}
