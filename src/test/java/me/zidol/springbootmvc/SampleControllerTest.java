package me.zidol.springbootmvc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {


//    @Autowired
//    MockMvc mockMvc;

    //MockMvc랑 같이 사용 가능
    @Autowired
    WebClient webClient;

//    @Test
//    public void hello() throws Exception {
//         요청 "/hello"
//         응답
//         - 모델 name : zidol
//         - 뷰 이름 : hello
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(view().name("hello"))
//                .andExpect(model().attribute("name", "zidol"))
//                .andExpect(content().string(containsString("zidol")));
//    }

    //html 테스트
    @Test
    public void hello() throws Exception {
        HtmlPage page = webClient.getPage("/hello");
        HtmlHeading1 h1 =  page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("zidol");
    }
}