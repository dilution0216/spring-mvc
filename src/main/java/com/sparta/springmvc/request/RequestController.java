package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // PathVariable
    // [Request sample]
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")
    // 필요한 데이터 부분에 {} 중괄호 하고, 변수명을 담는다. 이는 @PathVariable 에 들어갈 것 여기선 name, age
    @ResponseBody
    public String helloRequestPath(@PathVariable(required = false) String name, @PathVariable int age) // 들어간 곳
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }



    // request param = ( Query String 방식 )
    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    // & 로 데이터 구분
    // @RequestParam에 (required = false) 를 넣으면 값이 필수로 요구되지않고, 안들어온건 null로 들어간다.
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam(required = false) String name,  int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }



    // form 태그 방식으로 POST 보내기
    // [Request sample]
    // POST http://localhost:8080/hello/request/form/param
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }
}
