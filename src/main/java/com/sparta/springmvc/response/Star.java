package com.sparta.springmvc.response;
import lombok.Getter;

@Getter
public class Star {
    String name;
    int age;

    public Star(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 클래스로부터 오버로딩된 생성자.
    // @ModelAttribute 를 사용해서 객체로 데이터를 받아올 때는
    // Setter, 혹은 이렇게 오버로딩된 생성자가 꼭 필요하다.
    // 이렇게 꼭 만들어줘야 한다.
    // 오버로딩된 생성자 만드는 간단한 조작키
    // Star 에 커멘드 N -> Constructor -> 만들거 선택후 생성

    public Star() {}
}