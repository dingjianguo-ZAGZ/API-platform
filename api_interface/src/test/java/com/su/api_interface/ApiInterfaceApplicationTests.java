package com.su.api_interface;

import com.su.apiclientsdk.client.ApiClient;
import com.su.apiclientsdk.model.User;
/*import jakarta.annotation.Resource;*/
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {
    @Resource()
    private ApiClient apiClient;
    /*@Test
    public void test(){
        String res1 = apiClient.getNameByGet("xiaosu");
        System.out.println(res1);
        User user = new User();
        user.setUsername("xiaosu");
        String res2 = apiClient.getUserName(user);
        System.out.println(res2);
    }*/
}
