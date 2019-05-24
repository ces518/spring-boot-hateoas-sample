package me.june.springboothateoas;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-05-24
 * Time: 23:27
 **/
@RestController
public class SampleController {

    @GetMapping("/hello")
    public Resource hello () {
        Hello hello = new Hello();
        hello.setPrefix("Hello");
        hello.setName("juneYoung");

        /**
         * spring-boot-start-hateoas 에서 제공하는 링크를 제공하는방법중하나
         * 방법은 다양함..
         * hateoas 패키지에서 제공하는 메서드들을 활용
         */
        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());
        return helloResource;
    }
}
