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




    // Body 부분에 data 가 name=Robbie&age=95 이렇게 들어왔을 때, 객체로 처리할 수 있는 방법이 있다. 그것이
    // @ModelAttribute annotation . 이걸 사용하면 이 Body 부분에 들어온 Query String 방식의 데이터를
    // 이 객체에 Mapping 해서 가지고 올 수 있다.
    // [Request sample]
    // POST http://localhost:8080/hello/request/form/model
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }



    // Query String 방식(Request Param 방식) 으로 넘어온 데이터도 @ModelAttribute 로 받을 수 있다.
    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // @RequestBdoy annotation 을 통해 json to Object
    // 즉, HTTP Body 부분에 JSON 형식으로 데이터가 넘어왔을 때에
    // 이를 처리하기 위한 class 를 만들어서 파라미터를 넣어주고, 그 앞에 @Request Body를
    // 꼭, 반드시!! 넣어줘야 한다.
    // [Request sample]
    // POST http://localhost:8080/hello/request/form/json
    // Header
    //  Content type: application/json
    // Body
    //  {"name":"Robbie","age":"95"}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}
