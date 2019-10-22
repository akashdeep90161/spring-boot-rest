package com.akash.springboot.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Hello {
    @RequestMapping("/hello")
    public String sayHello()
    {
        return "Hello World "+ new Date();
    }
}


/*

Judge a man by his questions rather than by his answers.
One man’s constant is another man’s variable.
You can kill a man but you can’t kill an idea.
Real programmers can write assembly code in any language.
If there is no struggle, there is no progress.
If the facts don´t fit the theory, change the facts.
*
* */